package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;

/**
 * <p>Genera la representación sql de los paréntesis</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 * 
 */
public class BracketConditionRender implements IConditionRender{

	public boolean render(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
		return false;
	}

}
