package com.ogm.persistance.sql.pk;

import com.ogm.persistance.model.annotation.DBColumn;

/**
 * <p>clase resultado para el valor de las secuencias.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class SequenceResult {
	/**
	 * Valor.
	 */
	@DBColumn(column=PrimaryKeyGenerator.SEQUENCE)
	private Long value = null;
	/**
	 * constructor.
	 */
	public SequenceResult(){}
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
