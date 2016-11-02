package com.ogm.persistance.sql;

import com.ogm.persistance.sql.conditions.render.IFunctionRender;
import com.ogm.persistance.sql.util.RenderFactory;

/**
 * <p>Clase que permite definir funciones sql como <code>UPPER</code>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLFunction {
	/**
	 * 
	 */
	protected String function = null;

	/**
	 * 
	 */
	public static final SQLFunction UPPER 	= new SQLFunction("UPPER");
	public static final SQLFunction LOWER 	= new SQLFunction("LOWER");
	public static final SQLFunction LIKE 	= new SQLFunction("LIKE");
	public static final SQLFunction IN 		= new SQLFunction("IN");
	public static final SQLFunction NOT_IN 	= new SQLFunction("NOT IN");
	
	/*
	 * Aggregate
    *  AVG() - Returns the average value
    * COUNT() - Returns the number of rows
    * FIRST() - Returns the first value
    * LAST() - Returns the last value
    * MAX() - Returns the largest value
    * MIN() - Returns the smallest value
    * SUM() - Returns the sum
 */
	public static final SQLFunction AVG 	= new SQLFunction("AVG");
	public static final SQLFunction COUNT 	= new SQLFunction("COUNT");
	public static final SQLFunction FIRST 	= new SQLFunction("FIRST");
	public static final SQLFunction LAST 	= new SQLFunction("LAST");
	public static final SQLFunction MAX 	= new SQLFunction("MAX");
	public static final SQLFunction MIN 	= new SQLFunction("MIN");
	public static final SQLFunction SUM 	= new SQLFunction("SUM");

	
	/**
	 * 
	 */
	protected IFunctionRender render = null;
	/**
	 * @return
	 */
	public String getFunction() {
		return function;
	}

	public SQLFunction() {
		super();
	}
	/**
	 * @param newFunction
	 */
	public SQLFunction(String newFunction) {
		super();
		function = newFunction;
		render = RenderFactory.getFunctionRenderer(this);
	}

	public IFunctionRender getRender() {
		return render;
	}
}
