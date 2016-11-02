package com.ogm.persistance.sql.antlr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.model.NamedQuery;

/**
 * <p>Clase de apoyo al procesado de la gram�tica.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 10 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class GrammarUtil {
	private Log log = LogFactory.getLog(GrammarUtil.class);
	private StringBuilder buf = new StringBuilder();
	private List<Operation> operations = new ArrayList<Operation>();
	private List<String> attributes = null;
	private Map<String, ModelDefinition> models = new HashMap<String, ModelDefinition>();
	private ModelManager modelManager = null;
	public GrammarUtil(){
	}
	/**
	 * <p>Procesa el String .</p>
	 * @param newModelManager
	 */
	public NamedQuery getOut( ModelManager newModelManager ) {
		modelManager = newModelManager;
		NamedQuery namedQuey = new NamedQuery();
		if (log.isDebugEnabled()){
			log.debug("Operaciones " + operations);
		}
		// Procesamos primero las tablas
		for (Iterator<Operation> iterator = operations.iterator(); iterator.hasNext();) {
			Operation op = iterator.next();
			if (op.getType().equals(OperationType.TABLE)) {
				loadModel(op.payLoad);
			}
		}
		List<Operation> lastOp = new ArrayList<Operation>();
		for (Iterator<Operation> iterator = operations.iterator(); iterator.hasNext();) {
			Operation op =  iterator.next();
			String payload = op.getPayLoad();
			switch (op.getType()) {
			case SCHEMA:
				buf.append(modelManager.getSchemaName());
				break;
			case TABLE:
				ModelDefinition md = getModel(payload);
				//Si la NamedQuery no tiene modelo, se lo asignamos
				if (namedQuey.getModel() == null){
					namedQuey.setModel(md.getClassName()); 
				}
				buf.append(md.getFullTableName());
				break;
			case FIELD:
				buf.append(getFieldName(payload, lastOp));
				break;
			case ALIAS:	
				buf.append(getAlias(payload));
				break;
			default:
				buf.append(payload);
				break;
			}

			lastOp.add(op);
		}

		namedQuey.setQuery(buf.toString());
		return namedQuey;
	}

	//operaciones invocables desde ANTLRN
	public void out(String s) {
		operations.add(new Operation(s, OperationType.PUT));
	}

	public void tableName(String s) {
		operations.add(new Operation(s, OperationType.TABLE));
	}

	public void fieldName(String s) {
		operations.add(new Operation(s, OperationType.FIELD));
	}

	public void schema() {
		operations.add(new Operation(null, OperationType.SCHEMA));
	}

	public void attributeAccess(String attribute) {
		operations.add(new Operation("?", OperationType.PUT));
		if (attributes == null){
			attributes = new ArrayList<String>();
		}
		attributes.add(attribute);

	}
	
	public void alias(String s){
		operations.add(new Operation(s, OperationType.ALIAS));
	}
	//fin operaciones invocables desde ANTLRN
	
	private ModelDefinition getModel(String className) {
		if (log.isDebugEnabled()){
			log.debug("getTableName "+className);
		}		
		return loadModel(className);
	}

	private ModelDefinition loadModel(String className) {
		if (log.isDebugEnabled()){
			log.debug("load model "+className);
		}
		ModelDefinition md = models.get(className);
		if (md == null) {
			if (log.isDebugEnabled()){
				log.debug("loadModel getModelFromSimpleName "+className);
			}	
			md = modelManager.getModelFromSimpleName(className);
			if (log.isDebugEnabled()){
				log.debug("loadModel getModelFromSimpleName "+md);
			}				
			models.put(className, md);
		}
		return md;
	}

	private String getFieldName(String fieldName, List<Operation> lastOp) {

		List<String> tables = new ArrayList<String>();
		for (Iterator<ModelDefinition> it = models.values().iterator(); it
				.hasNext();) {
			//comprobamos si est� fullqualified
			if (lastOp!=null && lastOp.size() > 2){
					//normalemnte estamos as� tabla.nombre (procesando nombre)
					Operation op = lastOp.get(lastOp.size() - 2);
					if (op.type == OperationType.TABLE){
						String sqlName = getModel(op.getPayLoad()).getAttributeToColumn(fieldName);
						if (sqlName!=null){
							return sqlName;
						}
					}
			}
			
			ModelDefinition md = it.next();
			tables.add(md.getClassName());
			String sqlName = null;
			try {
				sqlName = md.getAttributeToColumn(fieldName);
			} catch (RuntimeException rte) {
				log.warn("No hay mapeo al campo ["+fieldName+"] en ["+md.getClassName()+"] .");
			}
			if (sqlName != null) {
				return sqlName;
			}
		}
		
		if (log.isInfoEnabled()){
			log.info("No hay mapeo al campo ["+fieldName+"] en ninguna de las clases ["+tables+"] de la query.");
		}
		//throw new RuntimeException("No hay mapeo al campo ["+fieldName+"] en ninguna de las clases ["+tables+"] de la query.");
		//entendemos que es un alias
		return  getAlias(fieldName);

	}


	public String getAlias(String name){
		return new StringBuilder(" \"").append(name).append("\"").toString();
	}

	public List getAttributes() {
		return attributes;
	}
	public void setModelManager(ModelManager newModelManager) {
		this.modelManager = newModelManager;
	}
}
