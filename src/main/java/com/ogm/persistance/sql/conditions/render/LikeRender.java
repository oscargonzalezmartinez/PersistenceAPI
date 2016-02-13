package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.SQLFunction;

/**
 * <p>Renderer utilizado por la función <code>LIKE</code>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @see BasicFunctionRender
 */
public class LikeRender extends BasicFunctionRender {

	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.conditions.renderer.BasicFunctionRenderer#draw(es.caser.po2008.dao.sql.SQLCondition, java.lang.StringBuilder)
	 */
	public boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
		SQLFunction function = condition.getFunction();
		
		ModelDefinition model = modelManager.getModel(condition.getClazz());
		String column = model.getAttributeToColumn(condition.getField());

		sqlBuffer.append(SQLConstants.BLANK)
		.append( model.getTable())
		.append(SQLConstants.DOT)
		.append(column)
		.append(SQLConstants.BLANK)
		.append(function.getFunction())
		.append(BASIC_ARG);

		return true;
	}

}
