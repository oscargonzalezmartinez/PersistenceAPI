package com.ogm.persistance.model.util;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.annotation.DBColumn;


/**
 * <p>Clase para devolver valores escalares</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public  class ScalarResult {
	public static final String SCALAR_RESULT = "_SCALAR_RESULT";
	private static ModelDefinition model = ModelDefinition.newModel(ScalarResult.class);

	public ScalarResult(){}

	public static ModelDefinition getModel(){
		return model;
	}
	
	/**
	 * Valor.
	 */
	@DBColumn(column="_SCALAR_RESULT")//no se puede poner la constante definida
	private Long value = null;
	/**
	 * constructor.
	 */

	/**
	 * <p>Devuelve el atributo value.</p>
	 * @return atributo value
	 */
	public Long getValue() {
		return value;
	}
	/**
	 * <p>Fija el valor del atributo value.</p>
	 * @param newValue valor del atributo value.
	 */
	public void setValue(Long newValue) {
		this.value = newValue;
	}
	
	
}