package com.ogm.persistance.sql.antlr;
/**
 * <p>Tipos de operaciones a realizar.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 10 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public enum OperationType {
	SCHEMA,
	PUT, //escribir en la salida
	TABLE,//procesar nombre de tabla
	FIELD,//procesar nomber de campo
	ALIAS;
}
