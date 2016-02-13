package com.ogm.persistance.model;

/**
 * <p>Clase que define la relación entre una tabla padre y una tabla hija.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class Relationship {
	/**
	 * Campo de la tabla padre 
	 */
	private String field = null;
	/**
	 * Clase con la que se tien la relación
	 */
	private Class targetClass = null;
	/**
	 * Campo de la clase hija que sirve de unión
	 */
	private String targetField = null;
	
	/**
	 * true si esta relación es de solo lectura
	 */
	private Boolean readOnly = null;
	
	/**
	 * Si se carga bajo demanda.
	 */
	private Boolean lazy = null;
	/**
	 * 
	 */
	public Relationship(){}
	/**
	 * @param newField
	 * @param newTargetClass
	 * @param newTargetField
	 * @param newReadOnly
	 */
	public Relationship(String newField, Class newTargetClass, String newTargetField, Boolean newReadOnly, Boolean newLazy ) {
		super();
		field = newField;
		targetClass = newTargetClass;
		targetField = newTargetField;
		readOnly = newReadOnly;
		lazy = newLazy;
	}
	public String getField() {
		return field;
	}
//	public void setField(String newField) {
//		this.field = newField;
//	}
	public Class getTargetClass() {
		return targetClass;
	}
//	public void setTargetClass(Class newTargetClass) {
//		this.targetClass = newTargetClass;
//	}
	public String getTargetField() {
		return targetField;
	}
//	public void setTargetField(String newTargetField) {
//		this.targetField = newTargetField;
//	}
	public Boolean isReadOnly() {
		return readOnly;
	}
//	public void setReadOnly(Boolean newReadOnly) {
//		this.readOnly = newReadOnly;
//	}
	
	public Boolean isLazy() {
		return lazy;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("; Field [").append(field).append("] ");
		sb.append("TargetClass [").append(targetClass).append("] ");
		sb.append("TargetField [").append(targetField).append("] ");
		sb.append("ReadOnly [").append(readOnly).append("] ");
		sb.append("Lazy [").append(lazy).append("] ");		
		return sb.toString();
	}
}
