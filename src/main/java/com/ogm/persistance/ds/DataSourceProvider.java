package com.ogm.persistance.ds;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
/**
 * <p>Interfaz para definir el acceso al data source.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public interface DataSourceProvider {

	/**
	 * <p>Devuevel el data source.</p>
	 * @return data source
	 */
	public DataSource getDataSource();

	/**
	 * <p>Devuelve un Listado de nombres de parámetros de la configuración.</p>
	 * @return Listado de nombres de parámetros de la configuración.
	 */
	public List<String> getParametersNames();
	
	/**
	 * <p>Fija los valores de configuración con las claves indicadas por lo devuelto
	 * a la invocación de <code>getParametersNames()</code>.</p>
	 * @param parameters parámetros de configuración.
	 */
	public void setParameters(Map<String,String> parameters);
	
	/**
	 * <p>M�todo invocado para la inicialización del provider.
	 * <Se llama una vez fijados todos los par�metros de configuración, con lo
	 * que están disponibles para la inicialización.</p>
	 */
	public void init();
}
