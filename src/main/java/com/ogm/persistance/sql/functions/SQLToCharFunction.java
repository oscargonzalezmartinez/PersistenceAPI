package com.ogm.persistance.sql.functions;

/**
 * <p>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public class SQLToCharFunction extends SQLPatternFunction {
	/**
	 * 
	 */
	private static final String FUNCTION = "TO_CHAR";
	public SQLToCharFunction(String newPattern) {
		super(FUNCTION,newPattern);
	}
}
