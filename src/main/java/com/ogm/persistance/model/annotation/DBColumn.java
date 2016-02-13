package com.ogm.persistance.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Anotación usada en la persistencia de objetos. Define el mapeo de un atributo a una columna 
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DBColumn {
	String column();
	boolean pk() default false; 
	/**
	 * <p>Si el campo es ficticio, creado para recuperar el valor de alguna consulta.</p>
	 * @return "true" si es un campo ficticio
	 */
	boolean isTransient() default false; 
}
