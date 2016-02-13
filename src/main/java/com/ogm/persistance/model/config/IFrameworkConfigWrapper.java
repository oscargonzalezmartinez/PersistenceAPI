package com.ogm.persistance.model.config;
/**
 * <p>Interfaz con la configuraci�n del framework Caser.</p>
 * <p>Intentamos evitar dependencias en tiempo de ejecuci�n con Framework Caser</>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public interface IFrameworkConfigWrapper {

	/**
	 * <p>.</p>
	 * @param section
	 * @param entry
	 * @param defaultValue
	 * @return
	 */
	public String getValue(String section, String entry, String defaultValue);
}
