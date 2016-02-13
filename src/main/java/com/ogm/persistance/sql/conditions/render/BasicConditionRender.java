package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;

/**
 * <p>Genera la representación sql de una condición básica. Son del tipo columna condición ?</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 * 
 */
public class BasicConditionRender  extends AbstractRender implements IConditionRender{

	
	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.conditions.renderer.AbstractRenderer#draw(es.caser.po2008.dao.sql.SQLCondition, java.lang.StringBuilder)
	 */
	public boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
		
		ModelDefinition model =modelManager.getModel(condition.getClazz());
		String column = model.getAttributeToColumn(condition.getField());


		sqlBuffer.append(SQLConstants.BLANK)
		.append( model.getTable())
		.append(SQLConstants.DOT)
		.append(column);

		sqlBuffer.append(condition.getExpresion().getExpresion());
		sqlBuffer.append(SQLConstants.QUESTION_MARK);

		return true;
	}

}
