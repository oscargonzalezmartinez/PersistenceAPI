package com.ogm.persistance.ds;

import java.util.List;
import java.util.Map;


/**
 * <p>Clase base para los DataSourceProvider.</p>
 * <p>B�sicamente proporciona el alamacenamiento de la configuraci�n y constantes para definir 
 * las entradas de la misma.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public abstract class AbstractDataSourceProvider {

	/**
	 * Mapa apra almacenar los par�metros de configuraci�n
	 */
	protected Map<String, String> parameters = null;
	//par�metros b�sicos
	
	protected List<String> parametersList = null;
	/**
	 * <p>Entrada de configuraci�n para indicar la contrase�a.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_PASSWORD = "datasource.provider.password";
	/**
	 * <p>Entrada de configuraci�n para indicar el usuario.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_USER = "datasource.provider.user";
	/**
	 * <p>Entrada de configuraci�n para indicar el driver.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_DRIVER = "datasource.provider.driver";
	/**
	 * <p>Entrada de configuraci�n para indicar la url de acceso.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_URL = "datasource.provider.url";
	/**
	 * <p>Entrada de configuraci�n para indicar la clave jndi.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_JNDI = "datasource.provider.jndi";
	
	/**
	 * Constructor vac�o.
	 */
	public AbstractDataSourceProvider() {
	}

	/* (non-Javadoc)
	 * @see es.caser.persistance.ds.DataSourceProvider#getParametersNames()
	 */
	public List<String> getParametersNames() {
		return parametersList;
	}

	/**
	 * <p>.</p>
	 * @param newParameters
	 */
	public void setParameters(Map<String, String> newParameters) {
		parameters = newParameters;
	}

}