package com.ogm.persistance.sql.conditions;

import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.util.RenderFactory;

/**
 * <p>Permite generar joins entre tablas.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLJoinCondition extends SQLCondition {

	/**
	 * Primera tabla del join.
	 */
	private Class table1 = null;
	/**
	 * Campo de la primera tabla para hacer el join.
	 */
	private String field1 = null;
	/**
	 * Segunda tabla de join
	 */
	private Class table2 = null;

	/**
	 * Campo de la segunda tabla para hacer el join.
	 */
	private String field2 = null;
	
	/**
	 * Indica si es un outer join 
	 */
	private Boolean outerJoin = Boolean.FALSE;
	/**
	 * @param expresion
	 * @param newTable1
	 * @param newField1
	 * @param newTable2
	 * @param newField2
	 */
	public SQLJoinCondition(String newOperator, Class newTable1, String newField1, Class newTable2, String newField2) {
		super();
		//fijamos la tabla como modelo original de la condición.
		clazz = newTable1;
		operator = newOperator;
		this.table1 = newTable1;
		this.field1 = newField1;
		this.table2 = newTable2;
		this.field2 = newField2;
		render = RenderFactory.getConditionRenderer(SQLJoinCondition.class);
	}
	
	/**
	 * @param newTable1
	 * @param newField1
	 * @param newTable2
	 * @param newField2
	 */
	public SQLJoinCondition( Class newTable1, String newField1, Class newTable2, String newField2) {
		this(SQLConstants.AND,newTable1,newField1,newTable2,newField2);
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getField1() {
		return field1;
	}
	/**
	 * <p>.</p>
	 * @param newField1
	 */
	public void setField1(String newField1) {
		this.field1 = newField1;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getField2() {
		return field2;
	}
	/**
	 * <p>.</p>
	 * @param newField2
	 */
	public void setField2(String newField2) {
		this.field2 = newField2;
	}
	public Class getTable1() {
		return table1;
	}
	public void setTable1(Class newTable1) {
		this.table1 = newTable1;
	}
	public Class getTable2() {
		return table2;
	}
	public void setTable2(Class newTable2) {
		this.table2 = newTable2;
	}

	public Boolean getOuterJoin() {
		return outerJoin;
	}

	public void setOuterJoin(Boolean newOuterJoin) {
		this.outerJoin = newOuterJoin;
	}
}
