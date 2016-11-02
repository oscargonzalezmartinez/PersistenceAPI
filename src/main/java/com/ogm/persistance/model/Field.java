package com.ogm.persistance.model;
/**
 * <p>Objeto que representa un atributo.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public class Field {
	/**
	 * <p>Nombre del atributo.</p>
	 */
	private String attribute = null;
	/**
	 * <p>Columna de base de datos</p>
	 */
	private String column = null;
	/**
	 * <p>Indica si el campo ser� persistido.</p>
	 */
	private Boolean mTransient = null;
	/**
	 * <p>si es clave primaria</p>
	 */
	private Boolean primaryKey = Boolean.FALSE;
	/**
	 * 
	 */
	private ValidationEnum validation = null;
	/**
	 * <p>Información necesaria para un validador.</p>
	 */
	private String validationData = null;
	
	/**
	 * @param newAttribute
	 * @param newColumn
	 * @param newTransient
	 * @param newPrimaryKey
	 */
	public Field(String newAttribute, String newColumn, Boolean newTransient, Boolean newPrimaryKey) {
		super();
		this.attribute = newAttribute;
		this.column = newColumn;
		mTransient = newTransient;
		primaryKey =newPrimaryKey;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getAttribute() {
		return attribute;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getColumn() {
		return column;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public Boolean isTransient() {
		return mTransient;
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public Boolean isPrimaryKey() {
		return primaryKey;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public ValidationEnum getValidation() {
		return validation;
	}
	/**
	 * <p>.</p>
	 * @param newValidation
	 */
	public void setValidation(ValidationEnum newValidation) {
		this.validation = newValidation;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getValidationData() {
		return validationData;
	}
	/**
	 * <p>.</p>
	 * @param newValidationData
	 */
	public void setValidationData(String newValidationData) {
		this.validationData = newValidationData;
	}
}
