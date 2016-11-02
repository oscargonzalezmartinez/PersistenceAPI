package com.ogm.persistance.ds;

import java.util.Arrays;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ogm.persistance.exceptions.ModelPersistanceException;
import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.util.ErrorMessageID;

/**
 * <p>Este provider obtine la referencia mediante una búsqueda en la contexto jndi local.</p>
 * <p>La entrada JNDI se configura con el parámetro <b>datasource.provider.jndi</b>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public class JNDIDataSourceProvider extends AbstractDataSourceProvider implements DataSourceProvider {

	/**
	 * Contexto incial para acceder a JNDI. Sólo accesos locales.
	 */
	private InitialContext ic = null;
	
	public JNDIDataSourceProvider() {
		parametersList = Arrays.asList(DATASOURCE_PROVIDER_JNDI);
	}
	/**
     * <p>Si se produce un error lanza la excepción de código ErrorMessageID.PE_00003</p>
	 * @see com.ogm.persistance.ds.DataSourceProvider#getDataSource()
	 */
	public DataSource getDataSource() {
		try {
			return (DataSource) ic.lookup(parameters.get(DATASOURCE_PROVIDER_JNDI));
		} catch (NamingException e) {
			throw new PersistanceException(ErrorMessageID.PE_00003, e , parameters.get(DATASOURCE_PROVIDER_JNDI));
		}
	}


	/* (non-Javadoc)
	 * @see com.ogm.persistance.ds.DataSourceProvider#getParametersNames()
	 */
	public List<String> getParametersNames() {
		return parametersList;
	}

	/** 
	 * <p>Crea un nuevo contexto JNDI</p>
	 * <p>Si se produce un error lanza la excepci�n de c�digo ErrorMessageID.PE_00004</p>
	 */
	public void init() {
		try {
			ic = new InitialContext();
		} catch (NamingException e) {
			throw new ModelPersistanceException(ErrorMessageID.PE_00004, e , parameters.get(DATASOURCE_PROVIDER_JNDI));
		}
		
	}

}
