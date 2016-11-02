package com.ogm.persistance.sql;

/**
 * <p>Cláusula HAVING.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
  */
public class SQLHaving {

	/**
	 * condici�n del having.
	 */
	private SQLCondition condition = null;
	/**
	 * Constructor.
	 * @param newCondition condición del having.
	 */
	public SQLHaving(SQLCondition newCondition){
		condition = newCondition;
	}
	/**
	 * <p>Devuelve condición.</p>
	 * @return condición
	 */
	public SQLCondition getCondition() {
		return condition;
	}
	/**
	 * <p>Establece la condición</p>
	 * @param newCondition condición
	 */
	public void setCondition(SQLCondition newCondition) {
		this.condition = newCondition;
	}
}
