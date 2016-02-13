package com.ogm.persistance.sql.processors;

/**
 * <p>Interfaz que define los métodos para las clases encargadas de generar las inserts.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public interface SQLInsertProcessor extends SQLProcessor{
	
	/**
	 * <p>Inserta una nueva fila en la tabla representada por el objeto <code>toInsert</code></p>.
	 * @param toInsert Objeto a insertar.
	 * @return toInsert con el campo clave informado.
	 */
	public Object insert(Object toInsert);
	/**
	 * <p>Inserta el objeto toInsert y todos los objetos relacionados.</p>
	 * @param toInsert
	 * @return toInsert con el campo clave informado.
	 */
	public Object insertComplete(Object toInsert);
	
}
