package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.SQLField;
import com.ogm.persistance.sql.SQLFunction;

/**
 * <p>Implementación básica de {@link IFunctionRender}.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public class BasicFunctionRender extends AbstractRender implements IFunctionRender {

	protected static final String BASIC_ARG = SQLConstants.OPEN_BRACKET + SQLConstants.QUESTION_MARK + SQLConstants.CLOSE_BRACKET;

	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.conditions.renderer.IFunctionRenderer#render(es.caser.po2008.dao.sql.SQLCondition, java.lang.StringBuilder)
	 */
	public boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer) {
	
		SQLFunction function = condition.getFunction();
		
		ModelDefinition model = modelManager.getModel(condition.getClazz());
		String column = model.getAttributeToColumn(condition.getField());

		sqlBuffer.append(SQLConstants.BLANK);
		render(function,model,column,sqlBuffer);

		sqlBuffer.append(condition.getExpresion().getExpresion());
		sqlBuffer.append(SQLConstants.QUESTION_MARK);

		return true;
	}

	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.conditions.renderer.IFunctionRenderer#render(es.caser.po2008.dao.sql.SQLField, java.lang.StringBuilder)
	 */
	public boolean render(ModelManager modelManager,SQLField field, StringBuilder sqlBuffer) {
		SQLFunction function = field.getFunction();
		ModelDefinition model = modelManager.getModel(field.getClazz());
		render(function,model,model.getAttributeToColumn(field.getField()),sqlBuffer);
	
		if (field.getSqlSynonym()!=null){
			sqlBuffer.append(SQLConstants.BLANK)
			.append(SQLConstants.DOUBLE_QUOTE)
			.append(field.getSqlSynonym())
			.append(SQLConstants.DOUBLE_QUOTE);
		}
		return false;
	}
	
	private void render(SQLFunction function, ModelDefinition model , String funcArg, StringBuilder sqlBuffer){
		sqlBuffer.append(function.getFunction()).append(SQLConstants.OPEN_BRACKET);
		if (!SQLConstants.ASTERISK.equals(funcArg)){
			sqlBuffer.append( model.getTable())
			.append(SQLConstants.DOT);
		}
		sqlBuffer.append(funcArg)
		.append(SQLConstants.CLOSE_BRACKET);
	}

}
