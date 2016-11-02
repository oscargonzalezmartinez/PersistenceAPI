package com.ogm.persistance.sql.processors.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.SQLWhere;
import com.ogm.persistance.sql.processors.SQLDeleteProcessor;
import com.ogm.persistance.util.ClassUtil;
/**
 * <p>Implementación de SQLDeleteProcessor.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class DefaultDeleteProcessorImpl extends SQLProcessorImpl implements SQLDeleteProcessor {

	public DefaultDeleteProcessorImpl() {
	}

	public boolean delete(Object toDelete){
		SQLWhere where = new SQLWhere();
		ModelDefinition model = getModel(toDelete);
		//recorremos todos los campos que forman la clave primaria para asignarlos al where.
		//en la mayor�a de los casos será un único campo
		for (Iterator<String> iterator = model.getPrimaryKeysIterator(); iterator.hasNext();) {
			String pkf = iterator.next();
			addPK(where,model, toDelete, pkf);
		}

		return delete(toDelete,where);
	}

	/**
	 * @param clazzToDelete
	 * @param id
	 * @return
	 */
	public boolean delete(Class clazzToDelete, Object id){
		
		ModelDefinition model = getModel(clazzToDelete);
		Object toDelete = ClassUtil.newInstance(model.getClassName());
		
		String primaryKeyField = model.getPrimaryKeyField();
		setFieldValueToObject(toDelete, primaryKeyField, id);

		return delete(toDelete);
	}
	
	/**
	 * @param toDelete
	 * @param where
	 * @return
	 */
	public boolean delete(Object toDelete , SQLWhere where){
		
		ModelDefinition model = getModel(toDelete);
		StringBuilder sql = new StringBuilder(SQLConstants.DELETE_FROM);

		sql.append(model.getFullTableName());
		
		List params = new ArrayList();

		processWhere(toDelete.getClass(), where, sql, params);	

		
		long rowsAffected = executeUpdate(sql.toString(), params);
		return rowsAffected > 0;
	}
}
