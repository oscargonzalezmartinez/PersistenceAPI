package com.ogm.persistance.ds;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
/**
 * <p>Interfaz para definir el acceso al data source.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
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
	 * <p>Devuelve un Listado de nombres de par�metros de la configuraci�n.</p>
	 * @return Listado de nombres de par�metros de la configuraci�n.
	 */
	public List<String> getParametersNames();
	
	/**
	 * <p>Fija los valores de configuraci�n con las claves indicadas por lo devuelto
	 * a la invocaci�n de <code>getParametersNames()</code>.</p>
	 * @param parameters par�metros de configuraci�n.
	 */
	public void setParameters(Map<String,String> parameters);
	
	/**
	 * <p>M�todo invocado para la inicializaci�n del provider.
	 * <Se llama una vez fijados todos los par�metros de configuraci�n, con lo
	 * que est�n disponibles para la inicializaci�n.</p>
	 */
	public void init();
}
