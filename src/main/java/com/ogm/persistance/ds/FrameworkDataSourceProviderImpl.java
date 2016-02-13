package com.ogm.persistance.ds;

import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.caser.archit.utils.beanfactories.BeanFactory;

/**
 * <p>Este provider obtiene la referencia mediante un bean de Spring.</p>
 * <p>El nombre del bean de Spring se configura mediante la entrada <b>datasource.provider.ds.bean.name</b></p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public class FrameworkDataSourceProviderImpl extends AbstractDataSourceProvider implements DataSourceProvider{
	private static Log log = LogFactory.getLog(FrameworkDataSourceProviderImpl.class);
	/**
	 * 
	 */
	private static final String DATASOURCE_PROVIDER_DS_BEAN_NAME = "datasource.provider.ds.bean.name";

	public FrameworkDataSourceProviderImpl() {
		parametersList = Arrays.asList(DATASOURCE_PROVIDER_DS_BEAN_NAME);
	}
	/* (non-Javadoc)
	 * @see es.caser.persistance.ds.DataSourceProvider#getDataSource()
	 */
	public DataSource getDataSource() {
		return (DataSource) BeanFactory.getServerSpringBean(parameters.get(DATASOURCE_PROVIDER_DS_BEAN_NAME));
	}

	/* (non-Javadoc)
	 * @see es.caser.persistance.ds.DataSourceProvider#getParametersNames()
	 */
	public List<String> getParametersNames() {
		return parametersList;
	}

	/* (non-Javadoc)
	 * @see es.caser.persistance.ds.DataSourceProvider#init()
	 */
	public void init() {
		log.info("Spring bean " + parameters.get(DATASOURCE_PROVIDER_DS_BEAN_NAME));
	}


}
