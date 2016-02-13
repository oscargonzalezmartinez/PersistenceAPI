package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.conditions.SQLBetweenCondition;

/**
 * <p>Genera el código SQL para un BETWEEN entre fechas</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class BetweenConditionRender extends AbstractRender implements IConditionRender {

	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.conditions.renderer.AbstractRenderer#draw(es.caser.po2008.dao.sql.SQLCondition, java.lang.StringBuilder)
	 */
	public boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
		SQLBetweenCondition con = (SQLBetweenCondition)condition;
		ModelDefinition model = modelManager.getModel(condition.getClazz());
		String column = model.getAttributeToColumn(con.getField());
		String column2 = model.getAttributeToColumn(con.getField2());

		if (con.getFecha() == null){
			sqlBuffer.append(SQLConstants.SYSDATE);
		}
		else{
			sqlBuffer.append(SQLConstants.QUESTION_MARK);
		}
		sqlBuffer.append(SQLConstants.BETWEEN)
		.append( model.getTable())
		.append(SQLConstants.DOT)
		.append(column)
		.append(SQLConstants.AND)
		.append( model.getTable())
		.append(SQLConstants.DOT)
		.append(column2)
		.append(SQLConstants.BLANK);

		return con.getFecha()!=null;
	}

}
