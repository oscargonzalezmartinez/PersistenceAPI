package com.ogm.persistance.sql.processors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.model.Field;
import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.Relationship;
import com.ogm.persistance.model.ValidationEnum;
import com.ogm.persistance.model.validators.Validator;
import com.ogm.persistance.model.validators.impl.ValidatorsFactory;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.processors.SQLInsertProcessor;
import com.ogm.persistance.util.ClassUtil;
/**
 * <p>Implementación de SQLInsertProcessor.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class DefaultInsertProcessorImpl extends SQLProcessorImpl implements SQLInsertProcessor{

	
	public DefaultInsertProcessorImpl() {

	}
	/**
	 * @param model
	 * @return
	 * @throws PersistanceException
	 */
	private Long nextPKValue(ModelDefinition model,Object toInsert){
		sqlLog.info(" nextPKValue ");

		Long secuenciaValue = model.getPrimaryKeyGenerator().generate(modelManager,model);
		if (sqlLog.isDebugEnabled()){
			sqlLog.debug(" nextPKValue = "+secuenciaValue);
		}
		
		return secuenciaValue;
	}
	/**
	 * <p>Inserta una nueva fila en la tabla representada por el objeto <code>toInsert</code></p>.
	 * @param toInsert Objeto a insertar.
	 * @return toInsert con el campo clave informado.
	 */
	public Object insert(Object toInsert){
		
		ModelDefinition model = getModel(toInsert);
		StringBuilder sql = new StringBuilder(SQLConstants.INSERT_INTO);

		sql.append(model.getFullTableName())
		.append(SQLConstants.OPEN_BRACKET);
		List<String> list = model.getColumnNames();
		Map<String,Field> attSql =  model.getColumnToAttribute();
		List params = new ArrayList();
		for (String column : list) {
			Field field = attSql.get(column);
			if (field.isTransient()){
				//estos campos son ficticios
				continue;
			}
			Object value = null;
		//	boolean isPrimaryKey = column.equals(model.getPrimaryKey());
			if (field.isPrimaryKey()
				&& // si hay un generador de claves primarias lo utilizamos
				model.getPrimaryKeyGenerator()!=null ){
					
					value = nextPKValue(model,toInsert);
					//fijamos el valor de la primary key as� cuando retornemos el objeto
					// al método que nos ha invocado lo tendrá disponible
					setFieldValueToObject(toInsert, field.getAttribute(), value);

			}
			else{
				value = ClassUtil.getFieldValueFromObject(toInsert, field.getAttribute());
			}
			if (value!=null){
				sql.append(column).append(SQLConstants.COMMA);
				params.add(value);
			}
			
			ValidationEnum validation = field.getValidation();
			if (validation!=null){
				Validator validator =  ValidatorsFactory.getValidator(validation);
				//si no pasa la validación lanza una excepción
				validator.validate(toInsert, field);
			}
		}
		
		if (!params.isEmpty()){
			sql = sql.deleteCharAt(sql.length()-1);
		}
		
		sql.append(SQLConstants.CLOSE_VALUES_OPEN );
		for (int i = 0; i < params.size(); i++) {
			sql.append(SQLConstants.QUESTION_MARK_COMMA);
		}
		
		if (!params.isEmpty()){
			sql = sql.deleteCharAt(sql.length()-1);
		}
		
		sql.append(SQLConstants.CLOSE_BRACKET );

		executeUpdate(sql.toString(), params);
		return toInsert;
	}
	
	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.processors.SQLInsertProcessor#insertComplete(java.lang.Object)
	 */
	public Object insertComplete(Object toInsert){
		ModelDefinition model = getModel(toInsert);
		toInsert = insert(toInsert);
		Map<String,Relationship> relations =model.getRelations();
		if (relations ==null || relations.isEmpty()){
			return toInsert;
		}
		
		for (Iterator<String> it = relations.keySet().iterator(); it.hasNext();){
			String field = it.next();
			Relationship relationship = relations.get(field);
			if (relationship.isReadOnly()){
				continue;
			}
			Object fk = ClassUtil.getFieldValueFromObject(toInsert, relationship.getField());
			Object sons = ClassUtil.getFieldValueFromObject(toInsert, field);
			if (sons == null){
				continue;
			}
			if (sons instanceof Collection) {
				Collection collection = (Collection) sons;
				for (Object son : collection) {
					setFieldValueToObject(son, relationship.getTargetField(), fk);
					insert(son);
				}
				
			}
			else{
				Object son = sons;
				setFieldValueToObject(son, relationship.getTargetField(), fk);
				insertComplete(son);
			}
			
		}
		return toInsert;
	}

}
