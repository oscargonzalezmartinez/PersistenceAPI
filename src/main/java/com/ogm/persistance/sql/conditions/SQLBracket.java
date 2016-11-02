package com.ogm.persistance.sql.conditions;

import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.util.RenderFactory;
/**
 * <p>Esta condición se utiliza para abrir y cerrar paréntesis y así agrupar condiciones.
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public final class SQLBracket extends SQLCondition{

	private String symbol = null;
	private Boolean open = Boolean.TRUE;
	
	/**
	 * @param newSymbol
	 * @param newOpen
	 */
	private SQLBracket(String newSymbol,Boolean newOpen){
		symbol = newSymbol;
		open = newOpen;
		render = RenderFactory.getConditionRenderer(SQLBracket.class);
	}
	
	/**
	 * Representa un paréntesis abierto.
	 */
	public static final SQLBracket OPEN = new SQLBracket(SQLConstants.OPEN_BRACKET, Boolean.TRUE);
	/**
	 * Representa un paréntesis cerrado
	 */
	public static final SQLBracket CLOSE = new SQLBracket(SQLConstants.CLOSE_BRACKET, Boolean.FALSE);
	
	public String getSymbol() {
		return symbol;
	} 
	
	public Boolean isOpen(){
		return open;
	}
	
	public Boolean isClose(){
		return !open;
	}
}
