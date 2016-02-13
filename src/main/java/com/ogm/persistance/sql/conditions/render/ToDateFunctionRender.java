package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.SQLField;
import com.ogm.persistance.sql.functions.SQLToDateFunction;
/**
 * <p>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
@Deprecated
public class ToDateFunctionRender extends AbstractRender implements IFunctionRender {
	
	/**
	 * Este método es invocado para generar la funcíon en la parte where de la select:<br>
	 * select field from table where todate(field,format) = sysdate 
	 * @see com.ogm.persistance.sql.conditions.render.BasicFunctionRender#draw(com.ogm.persistance.model.ModelManager, com.ogm.persistance.sql.SQLCondition, java.lang.StringBuilder)
	 */
	public boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
		SQLToDateFunction function = (SQLToDateFunction) condition.getFunction();
		
		ModelDefinition model = modelManager.getModel(condition.getClazz());
		String column = model.getAttributeToColumn(condition.getField());
		sqlBuffer.append(SQLConstants.BLANK)
		.append(function.getFunction())
		.append(SQLConstants.OPEN_BRACKET)

		.append( model.getTable())
		.append(SQLConstants.DOT)
		.append(column)
		.append(SQLConstants.COMMA)
		.append(SQLConstants.QUOTE)
		.append(function.getPattern())
		.append(SQLConstants.QUOTE)
		.append(SQLConstants.CLOSE_BRACKET)
		.append(condition.getExpresion().getExpresion())
		.append(SQLConstants.QUESTION_MARK);
		return true;
		
	}
	
	/** 
	 * <p>Este método es invocacdo para generar la función en el from de la select:<br>
	 * select todate(filed1,format) as synonym from ....</p>
	 * @see com.ogm.persistance.sql.conditions.render.BasicFunctionRender#render(com.ogm.persistance.model.ModelManager, com.ogm.persistance.sql.SQLField, java.lang.StringBuilder)
	 */
	public boolean render(ModelManager modelManager,SQLField field, StringBuilder sqlBuffer) {
		SQLToDateFunction function = (SQLToDateFunction) field.getFunction();
		
		ModelDefinition model = modelManager.getModel(field.getClazz());
		String column =model.getAttributeToColumn(field.getField());
		sqlBuffer.append(SQLConstants.BLANK)
		.append(function.getFunction())
		.append(SQLConstants.OPEN_BRACKET)
		.append( model.getTable())
		.append(SQLConstants.DOT)
		.append(column)
		.append(SQLConstants.COMMA)
		.append(SQLConstants.QUOTE)
		.append(function.getPattern())
		.append(SQLConstants.QUOTE)
		.append(SQLConstants.CLOSE_BRACKET);
		
		if (field.getSqlSynonym()!=null){
			sqlBuffer.append(SQLConstants.BLANK)
			.append(SQLConstants.DOUBLE_QUOTE)
			.append(field.getSqlSynonym())
			.append(SQLConstants.DOUBLE_QUOTE);
		}
		return false;
	}
}
