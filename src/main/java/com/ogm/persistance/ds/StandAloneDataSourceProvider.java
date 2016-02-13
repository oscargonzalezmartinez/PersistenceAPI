package com.ogm.persistance.ds;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>Este provider cea un data source mediante un objeto BasicDataSource del projecti common-dbcp .</p>
 * <p>Los parámetros necesarios son:.</p>
 * <ul>
 * <li><b>datasource.provider.url : url de acceso a la bbdd. Dependiente del driver</li>
 * <li><b>datasource.provider.driver: driver de acceso.</li>
 * <li><b>datasource.provider.user: usuario de conexión</li>
 * <li><b>datasource.provider.password: contraseña</li>
 * </ul>
 * 
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public class StandAloneDataSourceProvider extends AbstractDataSourceProvider implements DataSourceProvider{


	private static Log log = LogFactory.getLog(StandAloneDataSourceProvider.class);
	
	/**
	 * 
	 */
	private DataSource ds = null;
	
	public StandAloneDataSourceProvider(){
		parametersList = Arrays.asList(DATASOURCE_PROVIDER_URL,
				DATASOURCE_PROVIDER_DRIVER,
				DATASOURCE_PROVIDER_USER,
				DATASOURCE_PROVIDER_PASSWORD);
	}
	
	/* (non-Javadoc)
	 * @see es.caser.persistance.ds.DataSourceProvider#getDataSource()
	 */
	public DataSource getDataSource() {
			return ds;
	}



	/* (non-Javadoc)
	 * @see es.caser.persistance.ds.DataSourceProvider#init()
	 */
	public void init() {
		log.info("Class Driver " + parameters.get(DATASOURCE_PROVIDER_DRIVER));
		String jdbcUrl = parameters.get(DATASOURCE_PROVIDER_URL);
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(parameters.get(DATASOURCE_PROVIDER_DRIVER));
//        ds.setUrl(jdbcUrl);
//        ds.setUsername(parameters.get(DATASOURCE_PROVIDER_USER));
//        ds.setPassword(parameters.get(DATASOURCE_PROVIDER_PASSWORD));
        
        BasicDataSource basicds = new BasicDataSource();
      
        basicds.setDriverClassName(parameters.get(DATASOURCE_PROVIDER_DRIVER));
        basicds.setUsername(parameters.get(DATASOURCE_PROVIDER_USER));
        basicds.setPassword(parameters.get(DATASOURCE_PROVIDER_PASSWORD));
        basicds.setDefaultAutoCommit(false);  
        basicds.setUrl(jdbcUrl);
		ds = basicds;
	}

	/**
     * Cerramos el data source
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		((BasicDataSource)ds).close();
	}
}
