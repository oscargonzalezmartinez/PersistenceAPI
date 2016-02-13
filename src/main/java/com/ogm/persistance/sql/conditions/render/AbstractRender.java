package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.conditions.SQLBracket;
/**
 * <p>Clase base para los renderers de SQL.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 * 
 */
public abstract class AbstractRender implements IConditionRender{
	

	
	/**
	 * <p>M�todo encargado de generar la sql de la condici�n.</p>
	 * @param condition
	 * @param sqlBuffer
	 * @return true si hay par�metros generados, es decir, si se genera "?".
	 */
	public boolean render(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer){
		preProcess(condition,sqlBuffer);
		boolean result = draw(modelManager,condition,sqlBuffer);
		postProcess(condition,sqlBuffer);
		return result;
	}
	
	
	/**
	 * <p>M�todo para generar la SQL de la condici�n. Aqu� es donde las subclases han de generar el SQL </p>
	 * <p>Devuelve true si hay alg�n par�metro de sustituci�n</p>
	 * <p>Este m�todo no ha de generar el operador (AND, OR,etc).</p>
	 * @param condition
	 * @param sqlBuffer
	 * @return
	 */
	protected abstract boolean draw(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer);
	
	/**
	 * <p>M�todo invocado para generar el inicio de la SQLCondition, es decir, generar el operador (AND, OR,etc) y
	 * los par�ntesis.</p>
	 * @param condition
	 * @param sqlBuffer
	 * @return Sio hay par�tesis
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
	 * <p>M�todo invocado al final de la generaci�n del SQL.</p>
	 * <p>Esta implementaci�n se encarga de cerrar los par�ntesis, si los hubiese.</p>
	 * @param condition
	 * @param sqlBuffer
	 * @return true si hay par�ntesis.
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
