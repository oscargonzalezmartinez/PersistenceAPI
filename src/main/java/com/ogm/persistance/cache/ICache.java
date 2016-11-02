package com.ogm.persistance.cache;

import java.io.Serializable;

/**
 * <p>Interfaz que define el contrato de una cache de objetos</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public interface ICache {

	/**
	 * <p>Devuelve el nombre de la cache</p>
	 * @return nombre de la cache
	 */
	public String getName();
	/**
	 * <p>Añaade una entrada a la cache</p>
	 * @param key Clave del objeto a insertar
	 * @param value Valor a insertar en la cache
	 */
	public void addEntry(Serializable key, Object value);
	/**
	 * <p>Devuelve el objeto de la cache cuya clave es <code>key</code></p>
	 * @param key Clave del objeto a buscar en la cache
	 * @return objeto de la cache cuya clave es <code>key</code>
	 */
	public Object getEntry(Serializable key);
	/**
	 * <p>Elimina la entrada de la cache  cuya clave es <code>key</code></p>
	 * @param key Clave del objeto a eliminar de  la cache
	 * @return objeto de la cache cuya clave es <code>key</code>
	 */
	public Object expireEntry(Serializable key);
	/**
	 * <p>Elimina todos los objetos de la cache</p>
	 */
	public void expire();
}
