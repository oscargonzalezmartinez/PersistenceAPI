package com.ogm.persistance.cache;

import java.io.Serializable;

/**
 * <p>Elemento que representa una entrada en al cache.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public class CacheEntry {
	/**
	 * Instante de creaci�n del objeto en la cach�.
	 */
	private long creationTime = 0;
	/**
	 * Clave por la que se identifica el objeto.
	 */
	private Serializable key = null;
	/**
	 * Informaci�n a almacenar.
	 */
	private Object payload = null;
	
	/**
	 * Constructor.
	 */
	public CacheEntry(){}

	/**
	 * <p>construye una nueva entrada de la cache.</p>
	 * @param newKey Clave.
	 * @param newPayload valor.
	 */
	public CacheEntry(Serializable newKey, Object newPayload) {
		super();
		this.creationTime = System.currentTimeMillis();
		this.key = newKey;
		this.payload = newPayload;
	}

	/**
	 * <p>Devuelve el instante de creación del objeto en la caché.</p>
	 * @return instante de creación del objeto en la caché.
	 */
	public long getCreationTime() {
		return creationTime;
	}

	/**
	 * <p>Nuevo creation time.</p>
	 * @param newCreationTime creation time
	 */
	public void setCreationTime(long newCreationTime) {
		this.creationTime = newCreationTime;
	}

	/**
	 * <p>Devuelve clave por la que se identifica el objeto.</p>
	 * @return clave por la que se identifica el objeto.
	 */
	public Serializable getKey() {
		return key;
	}

	/**
	 * <p>Nueva clave.</p>
	 * @param newKey Nueva clave.
	 */
	public void setKey(Serializable newKey) {
		this.key = newKey;
	}

	/**
	 * <p>Devuelve información a almacenar.</p>
	 * @return información a almacenar.
	 */
	public Object getPayload() {
		return payload;
	}

	/**
	 * <p>Nuevo payload.</p>
	 * @param newPayload Nuevo payload.
	 */
	public void setPayload(Object newPayload) {
		this.payload = newPayload;
	}
	
}
