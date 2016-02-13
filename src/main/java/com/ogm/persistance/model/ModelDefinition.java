package com.ogm.persistance.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ogm.persistance.exceptions.ModelPersistanceException;
import com.ogm.persistance.sql.pk.PrimaryKeyGenerator;

/**
 * <p>Definición de un modelo de clase que representa una tabla de la BBDD.</p>
 * <p>Esta clase proporciona métodos para convertir nombre de atributos de la clase en 
 * nombre de columnas de la BBDD y viceversa.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public class ModelDefinition {

	
	/**
	 * 
	 */
	private static final String ASTERISK = "*";
	/**
	 * Clase java que repressenta este modelo.
	 */
	private String className = null;
	/**
	 * Tabla de BBDD a la que se mapea.
	 */
	private String table = null;
	/**
	 * Propiedad de la clase que representa la clave primaria.
	 */
	private String primaryKey = null;
	/**
	 * Campo de la BBDD que es la clave primaria de la tabla.
	 */
	private String primaryKeyField = null;

	/**
	 * Indica como se generan las claves, por sequence, auto o user.
	 */
	private String keyGenerator = null;
	/**
	 * Nombre de la secuencia de BBDD para la inserción de nuevos objetos.
	 */
	private String sequence = null;
	
	/**
	 * Select sql.
	 */
	private String sqlSelect = null;
	
	/**
	 * Cadena que contine el esquema concatenado con el nombre de la tabla.
	 * Si no hay indicado esquema se devuelve nombre de la tabla.
	 */
	private String fullTableName = null;
	
	/**
	 * Esquema base de datos.
	 */
	private String schema = null;
	/**
	 * Clase a la que mapea este modelo.
	 */
	private Class clazz = null;
	/**
	 * Nombres de las columnas de BBDD.
	 */
	private List<String> columnNames = new ArrayList<String>();
	/**
	 * Mapa cuyas claves son las columnas de BBDD y los valores
	 * las propiedades de la clase java a la que mapea.
	 */
	private Map<String,Field> columnToAttribute = new HashMap<String, Field>();
	/**
	 * Mapa cuyas claves son las propiedades de la clase y los valores
	 * las columnas de BBDD a la que mapea.
	 */
	private Map<String,Field> attributeToColumn = new HashMap<String, Field>();
	
	private Map<String,Relationship> relations = new HashMap<String, Relationship>();
	private Boolean bLazyRelations = Boolean.FALSE;
	
	/**
	 * Clase encargada de generar las claves primarias para este modelo
	 */
	private PrimaryKeyGenerator primaryKeyGenerator = null;
	
	/**
	 * Campos que componen una clave primaria. solo utilizado si hay más de un campo
	 */
	private Map<String,String> primaryKeys = null;
	

	/**
	 * @param newClassName
	 * @param newTable
	 * @param newPrimaryKey
	 */
	public ModelDefinition(String newClassName, String newTable, String newPrimaryKey) {
		super();
		this.className = newClassName;
		this.table = newTable;
		this.primaryKey = newPrimaryKey;
	}
	/**
	 * <p>Devuelve el mapeo de los atributos a las columnas.</>
	 * @return mapeo de los atributos a las columnas.
	 */
	public Map<String, Field> getAttributeToColumn() {
		return attributeToColumn;
	}

	
	/**
	 * <p>Añade un nuevo campo al modelo.</p>
	 * @param newField campo a añadir.
	 */
	public void addField(Field newField){
		attributeToColumn.put(newField.getAttribute(), newField);
		columnToAttribute.put(newField.getColumn(),newField);
		addColumnName(newField.getColumn());
	}
	
	/**
	 * <p>Devuelve la columna a la que mapea el atributo <code>attribute</code>.</p>
	 * <p>Se lanza una RuntimeException si no existe mapeo para la propiedad  <code>attribute</code>.</p>
	 * @param attribute Nombre de la propiedad.
	 * @return La columna a la que mapea el atributo <code>attribute</code>.
	 */
	public String getAttributeToColumn(String attribute) {
		if (ASTERISK.equals(attribute)){
			return attribute;
		}
		Field field = attributeToColumn.get(attribute);
		if (field == null){
			throw new ModelPersistanceException("El atributo ["+attribute+"] de la clase ["+className+"] no está mapeado.");
		}
		return field.getColumn();
	}
	
	/**
	 * <p>Devuelve el nombre de la clase.</p>
	 * @return nombre de la clase.
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param newClassName
	 */
	public void setClassName(String newClassName) {
		this.className = newClassName;
	}
	/**
	 * @return
	 */
	public List<String> getColumnNames() {
		return columnNames;
	}
	/**
	 * @param newColumnNames
	 */
	public void setColumnNames(List<String> newColumnNames) {
		this.columnNames = newColumnNames;
	}
	/**
	 * @param columnName
	 */
	private void addColumnName(String columnName) {
		columnNames.add(columnName);
	}
	
	/**
	 * @return
	 */
	public Map<String, Field> getColumnToAttribute() {
		return columnToAttribute;
	}
	
	/**
	 * <p>Devuelve el atributo de la clase a la que se mapea la columna <code>column</code>.</p>
	 * </p>Se lanza una RuntimeException si no existe mapeo para la columna  <code>column</code>.</p>
	 * @param column Nombre de la columna de BBDD.
	 * @return El atributo de la clase a la que se mapea la columna <code>column</code>.
	 */
	public String getColumnToAttribute(String column) {
		Field field = columnToAttribute.get(column);
		if (field == null){
			throw new ModelPersistanceException("la columna ["+column+"] no está mapeado para la clase clase ["+className+"] .");
		}
		
		return field.getAttribute();
	}

	/**
	 * @return
	 */
	public String getPrimaryKey() {
		return primaryKey;
	}
	/**
	 * @param newPrimaryKey
	 */
	public void setPrimaryKey(String newPrimaryKey) {
		this.primaryKey = newPrimaryKey;
	}
	/**
	 * @return
	 */
	public String getTable() {
		return table;
	}
	/**
	 * @param newTable
	 */
	public void setTable(String newTable) {
		this.table = newTable;
	}
	/**
	 * @return
	 */
	public String getPrimaryKeyField() {
		return primaryKeyField;
	}
	/**
	 * @param newPrimaryKeyField
	 */
	public void setPrimaryKeyField(String newPrimaryKeyField) {
		this.primaryKeyField = newPrimaryKeyField;
	}
	/**
	 * @return
	 */
	public String getSequence() {
		return sequence;
	}
	/**
	 * @param newSequence
	 */
	public void setSequence(String newSequence) {
		this.sequence = newSequence;
	}
	/**
	 * @return
	 */
	public String getKeyGenerator() {
		return keyGenerator;
	}
	/**
	 * @param newKeyGenerator
	 */
	public void setKeyGenerator(String newKeyGenerator) {
		this.keyGenerator = newKeyGenerator;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public Map<String, Relationship> getRelations() {
		return relations;
	}
	

	/**
	 * <p>.</p>
	 * @param newRelations
	 */
	public void setRelations(Map<String, Relationship> newRelations) {
		relations = newRelations;
		if (relations!=null){
			for (Iterator<Relationship> it =relations.values().iterator(); it.hasNext();) {
				Relationship r = it.next();
				if (r.isLazy()){
					bLazyRelations = Boolean.TRUE;
					break;
				}
			}
		}
	}
	
	public Boolean hasLazyRelations(){
		return bLazyRelations;
	}
	/**
	 * <p>Devuele el nombre de la tabla con el esquema, si se ha definido uno.</p>
	 * @return nombre de la tabla con el esquema, si se ha definido uno.
	 */
	public String getFullTableName(){
		if (fullTableName!=null){
			return fullTableName;
		}
		if (schema == null){
			return getTable();
		}
		
		fullTableName = (new StringBuilder(schema)).append(".").append(getTable()).toString();
		return fullTableName;
	}
	
	/**
	 * <p>Devuelve la definición del modelo de la clase <code>clazz</code>.</p>
	 * <p>Este método se utiliza para clases que no mapean a ninguna tabla, pero que se quieren utilizar como
	 * resultado de alguna sentencia.</p>
	 * @param clazz Clase de la que obtenr el modelo.
	 * @return definición del modelo de la clase <code>clazz</code>.
	 */
	public static ModelDefinition newModel(Class clazz){
		return ModelManager.loadFromAnnotatedClass(clazz);
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getSqlSelect() {
		return sqlSelect;
	}
	
	/**
	 * <p>.</p>
	 * @param newSqlSelect
	 */
	public void setSqlSelect(String newSqlSelect) {
		this.sqlSelect = newSqlSelect;
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public PrimaryKeyGenerator getPrimaryKeyGenerator() {
		return primaryKeyGenerator;
	}
	
	/**
	 * <p>.</p>
	 * @param newPrimaryKeyGenerator
	 */
	public void setPrimaryKeyGenerator(PrimaryKeyGenerator newPrimaryKeyGenerator) {
		this.primaryKeyGenerator = newPrimaryKeyGenerator;
	}
	
	/**
	 * <p>Clase del modelo.</p>
	 * @return clase del modelo.
	 */
	public Class getClazz() {
		return clazz;
	}
	
	/**
	 * <p>Establece clase del modelo.</p>
	 * @param newClazz clase del modelo.
	 */
	public void setClazz(Class newClazz) {
		this.clazz = newClazz;
	}
	
	/**
	 * <p>.</p>
	 * @param field
	 */
	public void addPrimaryKeyField(String field){
		if (primaryKeys == null){
			primaryKeys = new HashMap<String,String>();
		}
		primaryKeys.put(field,field);
	}
	
	/**
	 * <p>Devuelve un iterador sobre los campos que forman la clave primaria de este modelo.</p>
	 * @return iterador sobre los campos que forman la clave primaria de este modelo.
	 */
	public Iterator<String> getPrimaryKeysIterator() {
		if (primaryKeys == null){
			return null;
		}
		return primaryKeys.keySet().iterator();
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public boolean isCompoundPrimaryKey(){
		//sólo es clave compuesta si tiene más de un campo
		return primaryKeys!=null && primaryKeys.size() > 1; 
	}
	
	/**
	 * <p>.</p>
	 * @param field
	 * @return
	 */
	public boolean isPrimaryKeyField(String field){
		if (primaryKeys == null){
			return false;
		}
		return primaryKeys.containsKey(field);
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getSchema() {
		return schema;
	}
	/**
	 * <p>.</p>
	 * @param newSchema
	 */
	public void setSchema(String newSchema) {
		this.schema = newSchema;
	}
}
