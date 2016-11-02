package com.ogm.persistance.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ogm.persistance.model.ValidationEnum;

/**
 * <p>Anotación para indicar una validación ha realizar sobre un campo, en la inserci�n o actualizaci�n.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DBValidation {
	ValidationEnum validation() default ValidationEnum.MANDATORY;
	String value()  default "null";//chungo
}
