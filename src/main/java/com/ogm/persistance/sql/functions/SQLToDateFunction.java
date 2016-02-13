package com.ogm.persistance.sql.functions;

import java.util.Date;
/**
 * <p>Función TO_DATE.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public class SQLToDateFunction extends SQLPatternFunction {
	/**
	 * String de la función.
	 */
	private static final String FUNCTION = "TO_DATE";
	/**
	 * Valor de la fecha.
	 */
	private Date date = null;
	
	/**
	 * Constructor.
	 * @param newPattern nuevo formato.
	 */
	public SQLToDateFunction(String newPattern) {
		super(FUNCTION,newPattern);
	}
	/**
	 * @param newDate  nueva fecha.
	 * @param newPattern nuevo formato.
	 */
	public SQLToDateFunction(Date newDate,String newPattern) {
		this(newPattern);
		date = newDate;
	}
	
	/**
	 * <p>Establece la fecha.</p>
	 * @param newDate nueva fecha.
	 */
	public void setDate(Date newDate) {
		this.date = newDate;
	}	
	/**
	 * <p>Devuelve la fecha.</p>
	 * @return fecha.
	 */
	public Date getDate() {
		return date;
	}
}
