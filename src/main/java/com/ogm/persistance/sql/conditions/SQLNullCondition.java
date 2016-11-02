package com.ogm.persistance.sql.conditions;

import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLExpresion;
import com.ogm.persistance.sql.util.RenderFactory;

/**
 * <p>Condición para <code>IS NULL</code> e <code>IS NOT NULL</code> </p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLNullCondition extends SQLCondition {
	/**
	 * @param clazz
	 * @param field
	 * @param operator
	 * @param newExpresion
	 */
	public SQLNullCondition(Class clazz,String field,String operator,SQLExpresion newExpresion){
		super(clazz,field,null,operator,newExpresion);
		render = RenderFactory.getConditionRenderer(SQLNullCondition.class);
	}
}
