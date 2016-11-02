package com.ogm.persistance.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Agrupación de condiciones SQL.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLWhere {
	/**
	 * Lista de condiciones.
	 */
	private List<SQLCondition> conditions = new ArrayList<SQLCondition>();
	/**
	 * <p>Añade la condición <code>condition</code> al listado de condiciones.</p>
	 * @param condition Condición a añadir.
	 * @return devuevel el objeto where sobre el que se opera
	 */
	public SQLWhere add(SQLCondition condition){
		conditions.add(condition);
		return this;
	}
	/**
	 * <p>Devuelve todas las condiciones añadidas a este where.</p>
	 * @return todas las condiciones añadidas a este where.
	 */
	public List<SQLCondition> getConditions() {
		return conditions;
	}
	/**
	 * <p>Fija todas las condiciones a este where, descartando las añadidas anteriormente.</p>
	 * @param newConditions nuevas condiciones.
	 */
	public void setConditions(List<SQLCondition> newConditions) {
		this.conditions = newConditions;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return conditions.toString();
	}
}
