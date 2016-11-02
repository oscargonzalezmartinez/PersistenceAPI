package com.ogm.persistance.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>Implementación del interfaz ICache</p>.
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class CacheImpl implements ICache{

	/**
	 * Valor m�ximo por defecto para el número de elmentos en la caché.
	 */
	private static final int DEFAULT_MAX_CAPACITY_5000 = 5000;

	/**
	 * log.
	 */
	private Log log = LogFactory.getLog(CacheImpl.class);
	
	/**
	 * Para pasar de segundos a milisegundos. 
	 */
	private static final int TO_MILLI = 1000;

	/**
	 * Tiempo máximo que puede permanecer activo un objeto en caché antes de ser invalidado.
	 */
	private long expireTime = -1;
	
	/**
	 * Número máximo de elementos en la cache.
	 */
	private long maxCapacity   = DEFAULT_MAX_CAPACITY_5000;
	/**
	 * Objeto para la sincronización.
	 */
	private Object lock = new Object();
	/**
	 * Gestor de caches.
	 */
	protected CacheManager cacheManager = null;
	/**
	 * Mapa para lamacenar los datos.
	 */
	protected Map<Serializable,CacheEntry> cache = new HashMap<Serializable,CacheEntry>(); 
	/**
	 * Constructor por defecto.
	 */
	public CacheImpl(){}
	
	/* (non-Javadoc)
	 * @see com.ogm.persistance.cache.ICache#addEntry(java.io.Serializable, java.lang.Object)
	 */
	public void addEntry(Serializable key, Object value) {
		log.info("A�adiendo objeto a la cache key ["+key+"] tipo " + (value == null?null:value.getClass()));
		synchronized (lock) {
			if (cache.containsKey(key)){
				cache.remove(key);
			}
			if (cache.size() >= maxCapacity){
				capacityExceeded();
			}
			CacheEntry cacheEntry = new CacheEntry(key,value);
			cache.put(key, cacheEntry);			
		}
	}

	/**
	 * Elimina todos los elementos de la cache.
	 * @see com.ogm.persistance.cache.ICache#expire()
	 */
	public void expire() {
		cache.clear();
	}

	/**
	 * Elimina de la caché el objeto con clave <b>key</b>.
	 * @return el objeto a eliminar si existe.
	 * @see com.ogm.persistance.cache.ICache#expireEntry(java.io.Serializable)
	 */
	public Object expireEntry(Serializable key) {
		return cache.remove(key);
	}

	/**
	 * <p>Devuelve el objeto de la cache cuya clave es <code>key</code></p>.
	 * <p>Si el objeto lleva vivo en la caché más que <b>expireTime</b>, se 
	 * invoca a expireEntry y se retorna null.</p>
	 * <p>Sólo se raliza esta comprobación si expireTime es -1.</p>
	 * @param key Clave del objeto a buscar en la cache.
	 * @return objeto de la cache cuya clave es <code>key</code>.
	 * @see com.ogm.persistance.cache.ICache#getEntry(java.io.Serializable)
	 */
	public Object getEntry(Serializable key) {
		CacheEntry cacheEntry = cache.get(key);
		if (cacheEntry == null){
			return null;
		}
		//si no hay definido tiempo m�ximo se devuelve directamente
		if (expireTime == -1){
			return cacheEntry.getPayload();
		}
		
		//si ha pasado el tiempo indicado para la expiración lo eliminamos
		//y devolvemos nulo, as� no se devuelve información incorrecta
		long aliveTime = System.currentTimeMillis() - cacheEntry.getCreationTime();
		if (aliveTime > expireTime ){
			log.info("Eliminando entrada ["+key+"] por tiempo m�ximo excedido");
			expireEntry(cacheEntry.getKey());
			return null;
		}
		return cacheEntry.getPayload();
	}

	/**
	 * <p>.</p>
	 */
	private void capacityExceeded(){
		log.info("capacityExceeded");
		//eliminamos el más antiguo
		long creationTime = Long.MAX_VALUE;
		Serializable keyToDelete = null;
		for (Iterator<Serializable> iterator = cache.keySet().iterator(); iterator.hasNext();) {
			Serializable key = (Serializable) iterator.next();
			CacheEntry entry = cache.get(key);
			if (entry.getCreationTime() < creationTime){
				creationTime = entry.getCreationTime();
				keyToDelete = key;
			}
		}
		
		if (keyToDelete!=null){
			log.info("capacityExceeded. Removing ["+keyToDelete+"}");
			cache.remove(keyToDelete);
		}

	}
	
	/**
	 * Nombre por la que se referencia esta cache.
	 * @see com.ogm.persistance.cache.cache.ICache#getName()
	 */
	public String getName() {
		return this.toString();
	}

	/**
	 * Devuelve Gestor de caches.
	 * @return Gestor de caches.
	 */
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	/**
	 * <p>Fija la referencia al gestor de cachés</p>.
	 * @param newCacheManager Gestor de caches.
	 */
	public void setCacheManager(CacheManager newCacheManager) {
		this.cacheManager = newCacheManager;
		this.cacheManager.registry(this);
	}

	/**
	 * <p>Devuelve el tiempo máximo que puede permanecer activo un objeto en caché.</p>
	 * @return tiempo máximo que puede permanecer activo un objeto en caché.
	 */
	public long getExpireTime() {
		return expireTime;
	}

	/**
	 * <p>Tiempo de expiración de objetos en caché indicado en segundos.</p>
	 * @param newExpireTime tiempo de expiraci�n de objetos en caché indicado en segundos 
	 */
	public void setExpireTime(long newExpireTime) {
		this.expireTime = newExpireTime*TO_MILLI;//se nos indica en segundos, lo pasamos a milisegundos
	}

	/**
	 * <p>Devuelve el número máximo de elementos que puede contener la caché.</p>
	 * @return número máximo de elementos que puede contener la caché.
	 */
	public long getMaxCapacity() {
		return maxCapacity;
	}

	/**
	 * <p>Establece elnúmero máximo de elementos que puede contener la caché.</p>
	 * @param newMaxCapacity número máximo de elementos que puede contener la caché.
	 */
	public void setMaxCapacity(long newMaxCapacity) {
		this.maxCapacity = newMaxCapacity;
	}

}
