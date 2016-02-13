package com.ogm.persistance.sql.processors;

import com.ogm.persistance.sql.SQLWhere;
/**
 * <p>Interfaz que define los métodos para las clases encargadas de generar los deletes.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public interface SQLDeleteProcessor  extends SQLProcessor{
	/**
	 * <p>Borrar el objeto <code>toDelete</code>.</p>
	 * @param toDelete Objeto a borrar.
	 * @return true si se ha borrado.
	 */
	public boolean delete(Object toDelete);
	/**
	 * <p>Borrar el objeto de tipo <code>clazzToDelete</code> cuyo id es <code>id</code>.</p>
	 * @param clazzToDelete Clase del objeto a borrar.
	 * @param id identificador del objeto a borrar.
	 * @return true si se ha borrado.
	 */
	public boolean delete(Class clazzToDelete, Object id);
	
	/**
	 * <p>Borrar los objetos de tipo <code>toDelete</code> que cumplen las condiciones indicadas en <code>where</code>.</p>
	 * @param toDelete Tipo del objeto a borrar.
	 * @param where Condiciones de borrado.
	 * @return true si se han eliminado objetos.
	 */
	public boolean delete(Object toDelete , SQLWhere where);
}
