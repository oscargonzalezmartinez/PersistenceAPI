package com.ogm.persistance.sql;

/**
 * <p>Cl�usula HAVING.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
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
	 * @param newCondition condici�n del having.
	 */
	public SQLHaving(SQLCondition newCondition){
		condition = newCondition;
	}
	/**
	 * <p>Devuelve condici�n.</p>
	 * @return condici�n
	 */
	public SQLCondition getCondition() {
		return condition;
	}
	/**
	 * <p>Establece la condici�n.</p>
	 * @param newCondition condici�n.
	 */
	public void setCondition(SQLCondition newCondition) {
		this.condition = newCondition;
	}
}
