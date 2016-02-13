package com.ogm.persistance.model.validators.impl;

import com.ogm.persistance.exceptions.ValidationException;
import com.ogm.persistance.model.Field;
import com.ogm.persistance.model.validators.Validator;
import com.ogm.persistance.util.ClassUtil;
import com.ogm.persistance.util.ErrorMessageID;

/**
 * <p>Validador de longitud máxima.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class MaxLengthValidator implements Validator {
	/**
	 * <p>Lanza una excepción <b>ValidationException</b> con código <b>ErrorMessageID.VA_00001</b>
	 * si el campo <b>field</b> del objeto <b>object</b> es nulo.</p>
	 * @param object Objeto a validar.
	 * @param field Información del campo a validar.
	 */
	public void validate(Object object, Field field) {
		String attribute = field.getAttribute();
		Object value = ClassUtil.getFieldValueFromObject(object, attribute);
		//comprobar esto
		Integer maxLength = Integer.valueOf(field.getValidationData());
		
		if (value != null && String.valueOf(value).length() > maxLength){
			throw new ValidationException(ErrorMessageID.VA_00002,attribute,object.getClass().getName(),maxLength,object);
		}

	}

}
