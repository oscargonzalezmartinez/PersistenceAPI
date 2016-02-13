package com.ogm.persistance.model;

/**
 * <p>Enumerado con los tipos de generadores de claves.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public enum KeyGeneratorEnum {
	/**
	 * No hay generador.
	 */
	NONE,
	/**
	 * Generador basado en secuencia.
	 */
	SEQUENCE,
	/**
	 * Valor máximo de un campo.
	 */
	MAX,
	/**
	 * Generador automático de JDBC
	 */
	JDBC;
}
