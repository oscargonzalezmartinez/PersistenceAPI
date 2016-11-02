package com.ogm.persistance.model.validators;

import com.ogm.persistance.model.Field;

/**
 * <p>Las implementaciones han de ser thread safe.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 * @see ValidationException
 */
public interface Validator {

	/**
	 * <p>Método de validación.</p>
	 * <p>Si no se valida la excepción se ha de lanzar una ValidationException</p>
	 * @param object Objeto a validar
	 * @param field Información del campo a validar
	 * @see ValidationException
	 */
	public void validate(Object object, Field field);
}
