package com.ogm.persistance.sql;

/**
 * <p>Representa las expresiones de las condiciones sql, es decir, 
 * =, <, >, <=, >=, IS NULL e IS NOT NULL </p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public class SQLExpresion {
	private String  expresion = null;

	private static final String S_EQUALS = " = ";
	private static final String S_NOT_EQUAL = " <> ";	
	private static final String S_LOWER= " < ";
	private static final String S_GREATER = " > ";
	private static final String S_LOWER_EQUALS = " <= ";
	private static final String S_GREATER_EQUALS = " >= ";
	private static final String S_IS_NULL = " IS NULL ";
	private static final String S_IS_NOT_NULL = " IS NOT NULL ";
	

	public static final SQLExpresion EQUALS = new SQLExpresion(S_EQUALS);
	public static final SQLExpresion NOT_EQUALS = new SQLExpresion(S_NOT_EQUAL);
	public static final SQLExpresion LOWER = new SQLExpresion(S_LOWER);
	public static final SQLExpresion GREATER = new SQLExpresion(S_GREATER);
	public static final SQLExpresion LOWER_EQUALS = new SQLExpresion(S_LOWER_EQUALS);
	public static final SQLExpresion GREATER_EQUALS = new SQLExpresion(S_GREATER_EQUALS);
	public static final SQLExpresion IS_NULL = new SQLExpresion(S_IS_NULL);
	public static final SQLExpresion IS_NOT_NULL = new SQLExpresion(S_IS_NOT_NULL);
	
	
	/**
	 * @param newOperator
	 */
	public SQLExpresion(String newOperator) {
		this.expresion = newOperator;
	}

	public String getExpresion() {
		return expresion;
	}

	public void setExpresion(String newExpresion) {
		this.expresion = newExpresion;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
		return sb.append("[").append(expresion).append(" ]").toString();
	}
}
