package com.ogm.persistance.sql.conditions.render;

import java.util.ArrayList;
import java.util.Collection;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.SQLFunction;

/**
 * <p>Renderer para "IN".</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public class InRender extends BasicFunctionRender {

	public boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
		SQLFunction function = condition.getFunction();
		
		ModelDefinition model = modelManager.getModel(condition.getClazz());
		Object value =  condition.getValue();
		Collection collection = null;
		if (value instanceof Collection){
			collection = (Collection)value;
		}
		else{
			collection = new ArrayList(1);
			collection.add(value);
		}

		String column = model.getAttributeToColumn(condition.getField());
		sqlBuffer.append(SQLConstants.BLANK)
		.append( model.getTable())
		.append(SQLConstants.DOT)
		.append(column)
		.append(SQLConstants.BLANK)
		.append(function.getFunction())//Siempre es "IN" o "NOT IN"
		.append(SQLConstants.OPEN_BRACKET);
		for(int i = 0; i < collection.size()-1; i++){
			sqlBuffer.append(SQLConstants.QUESTION_MARK_COMMA);
		}
		sqlBuffer.append(SQLConstants.QUESTION_MARK);
		sqlBuffer.append(SQLConstants.CLOSE_BRACKET);

		return true;
	}
}
