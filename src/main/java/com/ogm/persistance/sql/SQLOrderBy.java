package com.ogm.persistance.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Esta clase representa la clausula <b>order by</b>.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLOrderBy {
	/**
	 * Ordenaci�n ascendente.
	 */
	public static final String ASC = " ASC ";
	/**
	 * Ordenaci�n descendente.
	 */
	public static final String DESC = " DESC ";
	/**
	 * Listado de campos por los que ordenar.
	 */
	private List<SQLField> fields = new ArrayList<SQLField>();
	/**
	 * Por defecto el orden es ascendente
	 */
	private String order = ASC;
	/**
	 * Constructor.
	 */
	public SQLOrderBy(){}
	
	/**
	 * <p>A�ade un nuevo campo de ordenaci�n.</p>
	 * @param newSQLField Campo a a�adir.
	 * @return this.
	 */
	public SQLOrderBy addField(SQLField newSQLField){
		fields.add(newSQLField);
		return this;
	}
	
	
	/**
	 * <p>A�ade un nuevo campo de ordenaci�n.</p>
	 * @param clazz Clase del objeto
	 * @param field Campo por el que ordenar
	 * @return this.
	 */
	public SQLOrderBy addField(Class clazz , String field){
		fields.add(new SQLField(clazz,field));
		return this;
	}
	
	/**
	 * <p>A�ade un nuevo campo de ordenaci�n.</p>
	 * @param object Objeto
	 * @param field Campo
	 * @return this.
	 */
	public SQLOrderBy addField(Object object , String field){
		return addField(object.getClass(), field);
	}
	
	/**
	 * <p>Ordenaci�n ascendente.</p>
	 * @return this.
	 */
	public SQLOrderBy setAsc(){
		order = ASC;
		return this;
	}
	
	/**
	 * <p>Ordenaci�n descendente.</p>
	 * @return this.
	 */
	public SQLOrderBy setDesc(){
		order = DESC;
		return this;
	}

	/**
	 * <p>Devuelve el tipo de ordenaci�n.</p>
	 * @return Tipo de ordenaci�n.
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * <p>Devuelve los campos por los que realizar la ordenaci�n.</p>
	 * @return   campos por los que realizar la ordenaci�n.
	 */
	public List<SQLField> getFields() {
		return fields;
	}
}
