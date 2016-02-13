package com.ogm.persistance.sql;

/**
 * <p>Constantes de SQL.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public interface SQLConstants {
	public static final String ASTERISK = "*";
	public static final String AND = " AND ";
	public static final String OR = " OR ";
	public static final String BLANK = " ";
	public static final String DOT = ".";
	public static final String COMMA = ",";
	public static final String QUOTE = "'";
	public static final String DOUBLE_QUOTE = "\"";
	public static final String QUESTION_MARK = " ? ";
	public static final String QUESTION_MARK_COMMA = QUESTION_MARK+COMMA;	


	public static final String CLOSE_BRACKET = " ) ";
	public static final String OPEN_BRACKET = " ( ";


	public static final String EQUAL  = " = ";
	public static final String EQUAL_QUESTION_MARK = EQUAL + QUESTION_MARK ;
	public static final String CLOSE_VALUES_OPEN = CLOSE_BRACKET +" VALUES " + OPEN_BRACKET;
	public static final String EQUAL_QUESTION_MARK_COMMA = EQUAL_QUESTION_MARK + COMMA;
	
	public static final String SELECT = " SELECT ";
	public static final String UPDATE = " UPDATE ";
	public static final String INSERT_INTO = "INSERT INTO ";
	
	public static final String SET = " SET ";
	public static final String FROM = " FROM ";
	public static final String WHERE = " WHERE ";
	public static final String _1_1 = " (1=1) ";
	public static final String WHERE_1_1 = WHERE + _1_1;
	public static final String ORDER_BY = " ORDER BY ";
	public static final String GROUP_BY = " GROUP BY ";
	
	public static final String DELETE_FROM = " DELETE " + FROM;
	public static final String SEQUENCE = "SEQUENCE";
	
	public static final String BETWEEN = " BETWEEN ";
	public static final String SYSDATE = " SYSDATE ";
	
	public static final String ON = " ON ";
	public static final String INNER_JOIN = " INNER JOIN ";
	public static final String HAVING = " HAVING ";

}
