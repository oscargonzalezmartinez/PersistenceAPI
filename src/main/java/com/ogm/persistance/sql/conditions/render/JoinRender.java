package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.conditions.SQLJoinCondition;

/**
 * <p>Genera la representación sql de una join entre dos tablas.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 * @see SQLJoinCondition
 */
public class JoinRender extends AbstractRender implements IConditionRender {

	private static final String OUTER_JOIN = "(+)";

	/**
	 * <p>Genera la representación sql de una join entre dos tablas.</p>
	 * <p>La operació no tiene por que ser con =, las tablas y la condición estarán definidas en
	 * <code>condition</code> que será de tipo SQLJoinCondition </p>
	 * @param condition condición SQL de tipo <code>SQLJoinCondition</code>
	 * @param sqlBuffer buffer donde generar la sql
	 * @see SQLJoinCondition
	 */
	public boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
		SQLJoinCondition join = (SQLJoinCondition) condition;
		ModelDefinition model1 = modelManager.getModel(join.getTable1());
		ModelDefinition model2 = modelManager.getModel(join.getTable2());
		String column1 = model1.getAttributeToColumn(join.getField1());
		String column2 = model2.getAttributeToColumn(join.getField2());
		

		sqlBuffer.append(SQLConstants.BLANK)
		.append( model1.getTable())
		.append(SQLConstants.DOT)
		.append(column1)
		.append(condition.getExpresion().getExpresion())
		.append(model2.getTable())
		.append(SQLConstants.DOT)
		.append(column2);
		if (join.getOuterJoin()){
			sqlBuffer.append(OUTER_JOIN);
		}
		sqlBuffer.append(SQLConstants.BLANK);
		return false;
	}

}
