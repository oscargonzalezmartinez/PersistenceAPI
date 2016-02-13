package com.ogm.persistance.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>SQL inner join</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class SQLInnerJoin {
	/**
	 * 
	 */
	private Class sourceTable = null;
	/**
	 * 
	 */
	private Class targetTable = null;
	/**
	 * Campo de la primera tabla para hacer el join.
	 */
	private String sourceField = null;
	/**
	 * Campo de la segunda tabla para hacer el join.
	 */
	private String targetField = null;
	
	private List<SQLCondition> conditions = null;

	public SQLInnerJoin(Class newSourceTable, Class newTargetTable, String newSourceField,
			String newTargetField) {
		sourceTable =newSourceTable;
		targetTable = newTargetTable;
		sourceField = newSourceField;
		targetField = newTargetField;
	}
	public Class getTargetTable() {
		return targetTable;
	}
	/**
	 * <p>.</p>
	 * @param newTargetTable
	 */
	public void setTargetTable(Class newTargetTable) {
		this.targetTable = newTargetTable;
	}

	/**
	 * <p>.</p>
	 * @param newSourceField
	 */
	public void setSourceField(String newSourceField) {
		this.sourceField = newSourceField;
	}
	public String getSourceField() {
		return sourceField;
	}
	public void setTargetField(String newTargetField) {
		this.targetField = newTargetField;
	}
	
	public String getTargetField() {
		return targetField;
	}
	public Class getSourceTable() {
		return sourceTable;
	}
	/**
	 * <p>.</p>
	 * @param newSourceTable
	 */
	public void setSourceTable(Class newSourceTable) {
		this.sourceTable = newSourceTable;
	}
	
	/**
	 * <p>.</p>
	 * @param newCondition
	 * @return
	 */
	public SQLInnerJoin addCondition(SQLCondition newCondition){
		if (conditions == null){
			conditions = new ArrayList<SQLCondition>();
		}
		
		conditions.add(newCondition);
		return this;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public List<SQLCondition> getConditions() {
		return conditions;
	}
	/**
	 * <p>.</p>
	 * @param newConditions
	 */
	public void setConditions(List<SQLCondition> newConditions) {
		this.conditions = newConditions;
	}
}
