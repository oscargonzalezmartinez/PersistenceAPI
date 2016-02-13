package com.ogm.persistance.sql;


/**
 * <p>Campo de una sql.</p>
 * <p>Contiene la definición del modelo de un campo de un objeto java determinado.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLField{
	
	private Class clazz = null;

	/**
	 * Nombre del campo del objeto o clase.
	 */
	private String field = null;
	/**
	 * Sinónimo sql que le asigna el usario. No confundir con nombre de campo.
	 */
	private String sqlSynonym = null;
	/**
	 * Función a aplicar sobre el campo
	 */
	protected SQLFunction function = null;
	/**
	 * <p>Constructor en el que se indica una instancia de un objeto y su atributo.</p>
	 * @param obj Instancia de objeto.
	 * @param newField atributo del objeto.
	 */
	public SQLField(Object obj, String newField) {
		this(obj.getClass(),newField);
	}

	/**
	 * @param obj
	 * @param newField
	 * @param newSqlSynonym
	 */
	public SQLField(Object obj, String newField,String newSqlSynonym) {
		this(obj.getClass(),newField,newSqlSynonym);
	}
	/**
	 * <p>Constructor en el que se indica la clase y su atributo.</p>
	 * @param newClazz Clase 
	 * @param newField atributo de la clase
	 */
	public SQLField(Class newClazz, String newField) {
		super();
		this.field = newField;
		this.clazz = newClazz;
		//model = ModelManager.getModelManager(clazz).getModel(clazz);
	}

	/**
	 * @param newClazz
	 * @param newField
	 * @param newSqlSynonym
	 */
	public SQLField(Class newClazz, String newField,String newSqlSynonym) {
		this(newClazz,newField);
		this.sqlSynonym = newSqlSynonym;
	}
	
	/**
	 * @param newClazz
	 * @param newField
	 * @param newFunction
	 */
	public SQLField(Class newClazz, String newField, SQLFunction newFunction) {
		this(newClazz,newField);
		function = newFunction;
	}
	
	/**
	 * @param obj
	 * @param newField
	 * @param newFunction
	 */
	public SQLField(Object obj, String newField, SQLFunction newFunction) {
		this(obj.getClass(),newField,newFunction);
	}
	
	/**
	 * @param newClazz
	 * @param newField
	 * @param newFunction
	 * @param newSqlSynonym
	 */
	public SQLField(Class newClazz, String newField, SQLFunction newFunction,String newSqlSynonym) {
		this(newClazz,newField,newFunction);
		this.sqlSynonym = newSqlSynonym;
	}
	
	/**
	 * @param obj
	 * @param newField
	 * @param newFunction
	 * @param newSqlSynonym
	 */
	public SQLField(Object obj, String newField, SQLFunction newFunction,String newSqlSynonym) {
		this(obj.getClass(),newField,newFunction,newSqlSynonym);
	}	


	/**
	 * <p>Devuelve el atributo al que mapea este campo sql.</p>
	 * @return atributo al que mapea este campo sql.
	 */
	public String getField() {
		return field;
	}

	/**
	 * <p>.</p>
	 * @return
	 */
	public SQLFunction getFunction() {
		return function;
	}

	/**
	 * <p>.</p>
	 * @param newFunction
	 */
	public void setFunction(SQLFunction newFunction) {
		this.function = newFunction;
	}

	/**
	 * <p>.</p>
	 * @return
	 */
	public String getSqlSynonym() {
		return sqlSynonym;
	}

	/**
	 * <p>.</p>
	 * @param newSqlSynonym
	 */
	public void setSqlSynonym(String newSqlSynonym) {
		this.sqlSynonym = newSqlSynonym;
	}

	/**
	 * <p>.</p>
	 * @return
	 */
	public Class getClazz() {
		return clazz;
	}

	/**
	 * <p>.</p>
	 * @param newClazz
	 */
	public void setClazz(Class newClazz) {
		this.clazz = newClazz;
	}

}
