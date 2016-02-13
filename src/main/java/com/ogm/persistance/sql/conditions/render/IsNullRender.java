package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;

/**
 * <p>Genera la representaci�n sql de una condici�n "IS NULL".</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 * 
 */
public class IsNullRender extends AbstractRender implements IConditionRender {

	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.conditions.renderer.AbstractRenderer#draw(es.caser.po2008.dao.sql.SQLCondition, java.lang.StringBuilder)
	 */
	public boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
		ModelDefinition model = modelManager.getModel(condition.getClazz());
		String column = model.getAttributeToColumn(condition.getField());

		sqlBuffer.append(SQLConstants.BLANK)
		.append( model.getTable())
		.append(SQLConstants.DOT)
		.append(column)
		.append(condition.getExpresion().getExpresion())
		.append(SQLConstants.BLANK);
		return false;
	}

}
