package com.ogm.persistance.model.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ogm.persistance.model.KeyGeneratorEnum;
/**
 * <p>Anotación usada en la persistencia de objetos.
 * <p>Define la tabla a la que se mapea el objeto así como la clave primaria y su enerador de claves, si existe. 
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DBTable {
	/**
	 * <p>Tabla de base de datos.</p>
	 * @return Tabla de base de datos.
	 */
	String table();
	/**
	 * <p>Clave primaria.</p>
	 * @return Clave primaria.
	 */
	String pk() default "null";
	/**
	 * <p>Tipo del generador de claves primarias.</p>
	 * @return Tipo del generador de claves primarias.
	 * @see KeyGeneratorEnum
	 */
	KeyGeneratorEnum keyGenerator() default KeyGeneratorEnum.NONE;
}
