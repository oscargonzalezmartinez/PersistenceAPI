package com.ogm.persistance.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * <p>Anotaci�n usada en la persistencia de objetos. Define la relaci�n entre dos tablas.</p> 
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DBRelacion {
	/**
	 * <p>Campo de la tabla origen.</p>
	 * @return Campo de la tabla origen
	 */
	String field();
	/**
	 * <p>Clase destino.</p>
	 * @return Clase destino.
	 */
	Class targetClass();
	/**
	 * <p>Campo de la tabla destino.</p>
	 * @return Campo de la tabla destino.
	 */
	String targetField();
	/**
	 * <p>si la relaci�n es de solo lectura.</p>
	 * @return true si es de solo lectura
	 */
	boolean readOnly() default true; 
	
	/**
	 * <p>Indica que la relaci�n se cargar� bajo demanda.</p>
	 * @return true si la relaci�n se cargar� bajo demanda.
	 */
	boolean lazy() default true;
}
