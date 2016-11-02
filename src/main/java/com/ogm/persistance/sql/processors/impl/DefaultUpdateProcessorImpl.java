package com.ogm.persistance.sql.processors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.model.Field;
import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.Relationship;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.SQLWhere;
import com.ogm.persistance.sql.processors.SQLUpdateProcessor;
import com.ogm.persistance.util.ClassUtil;
import com.ogm.persistance.util.ErrorMessageID;

/**
 * <p>Implementación de SQLUpdateProcessor.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class DefaultUpdateProcessorImpl extends SQLProcessorImpl implements SQLUpdateProcessor{

	public DefaultUpdateProcessorImpl() {
	}


	/**
	 * <p>Actualiza objeto por primary key</p>.
	 * @param toUpdate objeto a actualizar.
	 * @return Si se ha visto afectado alg�n registro.
	 * 
	 */
	public long update(Object toUpdate){
		
		SQLWhere where = new SQLWhere();
		ModelDefinition model = getModel(toUpdate);

		for (Iterator<String> iterator = model.getPrimaryKeysIterator(); iterator.hasNext();) {
			String pkf = iterator.next();
			addPK(where,model, toUpdate, pkf);
		}
		

		return update(toUpdate,where);
	}


	/**
	 * <p>Devuelve true si el campo está contenido en el where.</p>
	 * @param field Campo
	 * @param where condiciones
	 * @return true si el campo está contenido en el where.
	 */
	private boolean isFieldInWhere(Field field, SQLWhere where){
		List<SQLCondition> conditions =  where.getConditions();
		if (conditions == null || conditions.isEmpty()){
			return false;
		}
		
		for (SQLCondition sqlCondition : conditions) {
			if (field.getAttribute().equals( sqlCondition.getField())){
				return true;
			}
		}
		return false;
	}
	/**
	 * <p>Actualiza la tabla representada por  <code>toUpdate</code> con los datos contenidos en le objeto
	 * y seleccionando los registro que cumplan las restricciones indicadas en <code>where</code>.
	 * @param toUpdate Nuevos datos.
	 * @param where Restricciones de selección de registros a actualizar.
	 * @return Si se ha visto afectado algún registro.
	 */
	public long update(Object toUpdate , SQLWhere where){
		
		ModelDefinition model = getModel(toUpdate);
		StringBuilder sql = new StringBuilder(SQLConstants.UPDATE);

		sql.append(model.getFullTableName());
		
		List<String> list = model.getColumnNames();
		Map<String,Field> attSql =  model.getColumnToAttribute();
		List params = new ArrayList();
		boolean setAppend = false;

		for (String column : list) {
			Field field = attSql.get(column);
	//		boolean isPrimaryKey = model.isPrimaryKeyField(column);// column.equals(model.getPrimaryKey());
			//en la parte SET no se incluye ni las primary key ni los campos indicados en el where
			if (!field.isPrimaryKey() && !isFieldInWhere(field,where)){
				Object value = ClassUtil.getFieldValueFromObject(toUpdate, field.getAttribute());
				if (value!=null){
					if (!setAppend){
						sql.append(SQLConstants.SET);
						setAppend = true;
					}
					
						sql.append(column)
						.append(SQLConstants.EQUAL_QUESTION_MARK_COMMA );
					params.add(value);
				}
			}
		}
		
		//Si no hay parametros lanzamos excepción
		//El objeto de tipo {0}, con clave primaria {1} no tiene informado ning�n campo, por lo tanto no se va a ejecutar el UPDATE din�mico.
		if (params.isEmpty()){
			Object pkValue = ClassUtil.getFieldValueFromObject(toUpdate, model.getPrimaryKeyField());
			throw new PersistanceException(ErrorMessageID.PE_00009,toUpdate.getClass(),pkValue);
		}

		sql = sql.deleteCharAt(sql.length()-1);
		
		processWhere(toUpdate.getClass(), where, sql, params);	

		long rowsAffected = executeUpdate(sql.toString(), params);
		if (sqlLog.isDebugEnabled()){
			sqlLog.debug("N�mero de filas afectadas : " + rowsAffected);
		}
		return  rowsAffected;
	}
	
	public boolean updateComplete(Object toUpdate){
		long result = update(toUpdate);
		ModelDefinition model = getModel(toUpdate.getClass());
		Map<String,Relationship> relations =model.getRelations();
		if (relations ==null || relations.isEmpty()){
			return result!=0;
		}
		
		for (Iterator<String> it = relations.keySet().iterator(); it.hasNext();){
	
			String field = it.next();
			Object sons = ClassUtil.getFieldValueFromObject(toUpdate, field);
			if (sons == null){
				continue;
			}
			if (sons instanceof List) {
				List list = (List) sons;
				for (Object son : list) {
					updateComplete(son);
				}
				
			}
			else{
				Object son = sons;
				updateComplete(son);
			}
		}
		return result!=0;
	}
}
