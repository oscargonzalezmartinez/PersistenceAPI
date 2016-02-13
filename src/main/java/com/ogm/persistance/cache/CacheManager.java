package com.ogm.persistance.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>Clase encargada de gestionar las caches definidas en la aplicaci�n</p>
 * <p>Al crearse una instancia de cache se registra en este CacheManager para poder gestionarlas</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class CacheManager {
	/**
	 * log.
	 */
	private Log log = LogFactory.getLog(CacheManager.class);
	/**
	 * alamacen de caches.
	 */
	private Map<Serializable, ICache> caches = new HashMap<Serializable, ICache>();
	/**
	 * <p>Registra una cache.</p>
	 * @param cache Cach� a almacenar.
	 */
	public void registry(ICache cache){
		log.info("registrando cache con nombre " + cache.getName());
		caches.put(cache.getName(), cache);
	}
	
	/**
	 * Invoca al m�todo <code>expire</code> en todas las caches registradas en este cache manager.
	 */
	public void expire(){

		for (ICache cache : caches.values()) {
			log.info("Eliminado info de cache " + cache.getName());
			cache.expire();
		}
	}
}
