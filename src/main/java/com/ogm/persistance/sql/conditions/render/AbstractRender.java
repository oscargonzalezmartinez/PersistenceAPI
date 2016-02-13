package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.conditions.SQLBracket;
/**
 * <p>Clase base para los renderers de SQL.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 * 
 */
public abstract class AbstractRender implements IConditionRender{
	

	
	/**
	 * <p>Método encargado de generar la sql de la condición.</p>
	 * @param condition
	 * @param sqlBuffer
	 * @return true si hay parámetros generados, es decir, si se genera "?".
	 */
	public boolean render(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer){
		preProcess(condition,sqlBuffer);
		boolean result = draw(modelManager,condition,sqlBuffer);
		postProcess(condition,sqlBuffer);
		return result;
	}
	
	
	/**
	 * <p>Método para generar la SQL de la condición. Aquí es donde las subclases han de generar el SQL </p>
	 * <p>Devuelve true si hay algún parámetro de sustitución</p>
	 * <p>Este método no ha de generar el operador (AND, OR,etc).</p>
	 * @param condition
	 * @param sqlBuffer
	 * @return
	 */
	protected abstract boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer);
	
	/**
	 * <p>Método invocado para generar el inicio de la SQLCondition, es decir, generar el operador (AND, OR,etc) y
	 * los paréntesis.</p>
	 * @param condition
	 * @param sqlBuffer
	 * @return Sio hay parétesis
	 */
	protected boolean preProcess(SQLCondition condition, StringBuilder sqlBuffer) {
		SQLBracket bracket = condition.getBracket();
		sqlBuffer.append(condition.getOperator());
		if (bracket!=null){
			if (bracket.isOpen()){
				sqlBuffer.append(bracket.getSymbol());
			}
			
			return true;
		}
		return false;
	}
	
	/**
	 * <p>Método invocado al final de la generación del SQL.</p>
	 * <p>Esta implementación se encarga de cerrar los paréntesis, si los hubiese.</p>
	 * @param condition
	 * @param sqlBuffer
	 * @return true si hay paréntesis.
	 */
	protected boolean postProcess(SQLCondition condition, StringBuilder sqlBuffer) {
		SQLBracket bracket = condition.getBracket();

		if (bracket!=null){
			if (bracket.isClose()){
				sqlBuffer.append(bracket.getSymbol());
			}
			return true;
		}
		return false;
	}

}
