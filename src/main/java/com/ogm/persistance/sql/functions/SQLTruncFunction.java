package com.ogm.persistance.sql.functions;

/**
 * <p>Función TO_DATE.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public class SQLTruncFunction extends SQLPatternFunction {
	/**
	 * String de la función.
	 */
	private static final String FUNCTION = "TRUNC";
	/**
	 * Valor de la fecha.
	 */
	private Object value = null;
	
	public SQLTruncFunction() {
		super(FUNCTION,null);
	}
	/**
	 * Constructor.
	 * @param newPattern nuevo formato.
	 */
	public SQLTruncFunction(String newPattern) {
		super(FUNCTION,newPattern);
	}
	/**
	 * @param newDate  nueva fecha.
	 * @param newPattern nuevo formato.
	 */
	public SQLTruncFunction(Object newValue,String newPattern) {
		this(newPattern);
		value = newValue;
	}

}
