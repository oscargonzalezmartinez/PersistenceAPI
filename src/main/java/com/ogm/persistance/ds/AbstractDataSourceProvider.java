package com.ogm.persistance.ds;

import java.util.List;
import java.util.Map;


/**
 * <p>Clase base para los DataSourceProvider.</p>
 * <p>Básicamente proporciona el alamacenamiento de la configuración y constantes para definir 
 * las entradas de la misma.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public abstract class AbstractDataSourceProvider {

	/**
	 * Mapa apra almacenar los parámetros de configuración
	 */
	protected Map<String, String> parameters = null;

	
	protected List<String> parametersList = null;
	/**
	 * <p>Entrada de configuración para indicar la contrase�a.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_PASSWORD = "datasource.provider.password";
	/**
	 * <p>Entrada de configuración�n para indicar el usuario.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_USER = "datasource.provider.user";
	/**
	 * <p>Entrada de configuración�n para indicar el driver.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_DRIVER = "datasource.provider.driver";
	/**
	 * <p>Entrada de configuración�n para indicar la url de acceso.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_URL = "datasource.provider.url";
	/**
	 * <p>Entrada de configuración�n para indicar la clave jndi.</p>
	 */
	protected static final String DATASOURCE_PROVIDER_JNDI = "datasource.provider.jndi";
	
	/**
	 * Constructor vacío.
	 */
	public AbstractDataSourceProvider() {
	}

	/* (non-Javadoc)
	 * @see com.ogm.persistance.ds.DataSourceProvider#getParametersNames()
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