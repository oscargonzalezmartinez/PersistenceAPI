package com.ogm.persistance.sql.processors.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ogm.persistance.exceptions.ModelPersistanceException;
import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.model.Relationship;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.SQLSelect;
import com.ogm.persistance.sql.SQLWhere;
import com.ogm.persistance.sql.conditions.SQLBracket;
import com.ogm.persistance.sql.processors.SQLProcessor;
import com.ogm.persistance.sql.processors.impl.proxy.ProxyLazyImpl;
import com.ogm.persistance.util.ClassUtil;
import com.ogm.persistance.util.ErrorMessageID;

/**
 * <p>Clase base para los procesadores sql.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public class SQLProcessorImpl implements SQLProcessor{

	protected static final Log sqlLog =  LogFactory.getLog("es.caser.persistance.SQL");
	/**
	 * Model manager sobre el que realizar la ejecución.
	 */
	protected ModelManager modelManager = null;
	
	/**
	 * Constructor.
	 */
	public SQLProcessorImpl() {
		super();
	}


	/**
	 * @param model
	 * @param sql
	 * @param params
	 * @return
	 */
	protected List execute(ModelDefinition model, String sql, List params){

			List result = new ArrayList();
			List<Map> resultMap = SQLExecutor.execute(modelManager,sql,convertParams(params));
			
			if (resultMap == null || resultMap.size() == 0){
				return null;
			}
			
			int len = resultMap.size();
			sqlLog.info("Numero de filas " + len );
			if (model == null){
				sqlLog.warn("No hay un modelo de salida definido.");
				return resultMap;
			}
			
			Map<String, Relationship> relations = model.getRelations();
			long ini = System.currentTimeMillis();
			for (int index = 0; index < len; index++) {
				Map rowMap = resultMap.get(index);
				//TODO dejar esto un poco más presentable
				Object row = null;
					if (model.hasLazyRelations()){
						//tiene relaciones, se devuelve un proxy para los lazies
						row = ProxyLazyImpl.newProxyLazy(modelManager,ClassUtil.getClass(model.getClassName()));
					}
					else{
						row = ClassUtil.newInstance(model.getClassName());
					}//if (model.hasLazyRelations())
						
					List<String> columns = model.getColumnNames();
					for (String column : columns) {
						Object value = rowMap.get(column);
						String field = model.getColumnToAttribute(column);
						setFieldValueToObject(row, field, value);
					}//for (String column
					
					
					//cargamos relaciones eager
					if (relations!=null){
						//cargamos los eager
						for (Iterator<String> it = relations.keySet().iterator(); it.hasNext();){
							String field = it.next();
							Relationship r = relations.get(field);
							if (!r.isLazy()){
								Object relationResult =  modelManager.getSelectProcessor().loadRelation(row, field);
								if (relationResult!=null){//Buscamos un listado?
									setFieldValueToObject(row, field, relationResult);
								}
								
							}//if (!r.isLazy())	
						}//	Iterator<Relationship> it	
					}//if (relations!=null
						
					result.add(row);
				
			}//for (int index = 0

			if (sqlLog.isDebugEnabled()){
				sqlLog.debug("Tiempo en generar salida (ms) " + (System.currentTimeMillis() - ini));
			}
			
			return result;
			

	}
	
	
	/**
	 * <p>.</p>
	 * @param sql
	 * @param params
	 * @return
	 */
	protected int executeUpdate(String sql, List params){

		List newParams = convertParams(params);

		return SQLExecutor.executeUpdate(modelManager,sql,newParams);
	}

	/**
	 * <p>.</p>
	 * @param params
	 * @return
	 */
	private List convertParams(List params) {
		List newParams = new ArrayList();
		if (params!=null){
			for (Iterator iter = params.iterator(); iter.hasNext();) {
				Object element = iter.next();
				if (element instanceof Collection){
					for (Iterator iterator = ((Collection)element).iterator(); iterator.hasNext();) {
						Object collectionObject = (Object) iterator.next();
						newParams.add(convertValueToBBDD(collectionObject));
					}
				}
				else{
					newParams.add(convertValueToBBDD(element));
				}
			}
		}
		
		return newParams;
	}
	

	
	/**
	 * Invoca al método setfield sobre el objeto <code>obj</code> con el valor <code>value</code>.
	 * @param obj Objeto.
	 * @param field Atributo.
	 * @param value Valor.
	 */
	protected void setFieldValueToObject(Object obj, String field, Object value){

		try {
			if (obj == null || value == null){
				return;
			}
			
			Object realValue = convertValueFromBBDD(value);

			BeanUtils.setProperty(obj, field, realValue);
		} catch (IllegalAccessException e) {
			throw new  ModelPersistanceException(ErrorMessageID.PE_00022,e,field,obj.getClass());
		} catch (InvocationTargetException e) {
			throw new  ModelPersistanceException(ErrorMessageID.PE_00022,e,field,obj.getClass());
		} 
	}
	
	/**
	 * Convierte el valor proveniente de base de datos a un objeto java.
	 * <p>Esta implementación transforma los java.sql.Date y java.sql.Timestamp en java.util.Date.</p>
	 * @param value Valor.
	 * @return valor proveniente de base de datos a un objeto java
	 */
	private Object convertValueFromBBDD(Object value){

		if (value instanceof java.sql.Date) {
			return new java.util.Date( ((java.sql.Date) value).getTime());
		}

		if (value instanceof java.sql.Timestamp) {
			return new java.util.Date( ((java.sql.Timestamp) value).getTime());
		}
		
		return value;		
	}
	/**
	 * <p>Convierte el valor <code>value</code> en un valor adecuado para base de datos.</p>
	 * <p>Esta implementación transforma los java.util.Date en java.sql.Timestamp.</p>
	 * @param value valor a convertir a base de datos.
	 * @return Objeto convertido para la base de datos.
	 */
	private Object convertValueToBBDD(Object value){

		if (value instanceof java.util.Date) {
			return new java.sql.Timestamp( ((java.util.Date) value).getTime());
		}
		
		return value;
	}
	
	/**
	 * @param clazz
	 * @param where
	 * @param sql
	 * @param params
	 */
	protected void processWhere(SQLSelect select, StringBuilder sql, List params) {
		SQLWhere where = select.getWhere();
		if (where!= null && where.getConditions()!=null){
			Class clazz = null;
			if (select.getFrom().getTables().size() == 1){
				//Si tiene sólo una tabla indicamos esta como el from para las condiciones en las que no se ha indicado.
				//Si hya más de una tabla y la condición no ha indicado a que objeto se refiere dejamos que el 
				//método falle, ya que no podemos decidir. 
				clazz = select.getFrom().getTables().get(0);
			}
			processWhere(clazz, where, sql, params);
		}
	}
	
	/**
	 * @param clazz
	 * @param where
	 * @param sql
	 * @param params
	 */
	protected void processWhere(Class clazz, SQLWhere where, StringBuilder sql, List params) {
		List<SQLCondition> conditions = where.getConditions();
		if (conditions==null || conditions.size() == 0){
			return;
		}

		sql.append(SQLConstants.WHERE_1_1);

		int size = conditions.size();
		List<SQLCondition> finalConditions = new ArrayList<SQLCondition>();
		for (int i = 0; i<size; i++) {
			SQLCondition condition = conditions.get(i);
			if ( condition instanceof SQLBracket){
				SQLBracket bracket = (SQLBracket)condition;
				if (bracket.isOpen()){
					findUp(conditions,i).setBracket(bracket);
				}
				else if (bracket.isClose()){
					findDown(conditions,i).setBracket(bracket);
				}
			}
			else{
				finalConditions.add(condition);
			}
		}	
		
		for (SQLCondition condition : finalConditions) {
			if (condition.getClazz() == null){
				//no tiene clase. Comprobamos si hay una para toda la query.
				if (clazz == null){
					sqlLog.error(condition);
					//La condición para el atributo {0} no tiene indicado la clase a la que pertenece.
					throw new PersistanceException(ErrorMessageID.PE_00021 , condition.getField());
				}
				condition.setClazz(clazz);
			}
			
			if (conditionToSQL(condition, sql)){
				params.add(condition.getValue());
			}

		}
	}
	
	/**
	 * <p>.</p>
	 * @param conditions
	 * @param current
	 * @return
	 */
	private SQLCondition findDown(List<SQLCondition> conditions, int current){
		for (int i = current -1 ; i >=0; i--){
			SQLCondition condition = conditions.get(i);
			if (!( condition instanceof SQLBracket)){
				return condition;
			}

		}
		
		return null;
	}
	
	/**
	 * <p>.</p>
	 * @param conditions
	 * @param current
	 * @return
	 */
	private SQLCondition findUp(List<SQLCondition> conditions, int current){
		for (int i = current + 1 ; i < conditions.size(); i++){
			SQLCondition condition = conditions.get(i);
			if (!( condition instanceof SQLBracket)){
				return condition;
			}

		}
		
		return null;
	}
	
	
	
	
	/**
	 * <p>Lanza una excepción de código <code>ErrorMessageID.PE_00008</code> si no está
	 * informada la clave primaria del objeto <code>tiUpdate</code>.</p>
	 * @param model Modelo que representa el objeto a actualizar.
	 * @param toUpdate Objeto a actualizar
	 * @param pkf
	 * @return Clave primaria.
	 * @see ErrorMessageID#PE_00008
	 */
	protected Object checkPK(ModelDefinition model,Object toUpdate ,String pkf){
		
		Object pkValue = ClassUtil.getFieldValueFromObject(toUpdate, pkf);
		if (pkValue == null){
			throw new PersistanceException(ErrorMessageID.PE_00008 , model.getClassName(), pkf);
		}
		
		return pkValue;
	}

	/**
	 * <p>Añade los valores de clave primaria a <code>where</code>.</p>
	 * @param where Where al que añadir las restricciones de clave primaria
	 * @param model Modelo que representa el objeto a actualizar.
	 * @param toUpdate Objeto a actualizar
	 * @param pkf
	 * @return
	 */
	protected SQLWhere addPK(SQLWhere where, ModelDefinition model,Object toUpdate ,String pkf){
		Object pkValue =checkPK(model, toUpdate, pkf);
		where.add(SQLCondition.getAND(toUpdate.getClass(), pkf, pkValue));
		return where;
	}
	
	/**
	 * @param condition
	 * @param sql
	 * @return
	 */
	protected boolean conditionToSQL(SQLCondition condition,StringBuilder sql) {
		return condition.getRender().render(modelManager,condition, sql);
	}


	/**
	 * <p>.</p>
	 * @return
	 */
	public ModelManager getModelManager() {
		return modelManager;
	}


	/* (non-Javadoc)
	 * @see es.caser.persistance.sql.processors.SQLProcessor#setModelManager(es.caser.persistance.model.ModelManager)
	 */
	public void setModelManager(ModelManager newModelManager) {
		this.modelManager = newModelManager;
	}
	
	/**
	 * <p>.</p>
	 * @param clazz
	 * @return
	 */
	public ModelDefinition getModel(Class clazz){
		return modelManager.getModel(clazz);
	}

	/**
	 * <p>.</p>
	 * @param object
	 * @return
	 */
	public ModelDefinition getModel(Object object){
		return modelManager.getModel(object);
	}
	
	/**
	 * <p>.</p>
	 * @param clazz
	 * @return
	 */
	public ModelDefinition getModel(String clazz){
		return modelManager.getModel(clazz);
	}
	
}
