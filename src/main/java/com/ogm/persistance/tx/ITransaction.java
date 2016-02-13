package com.ogm.persistance.tx;

import com.ogm.persistance.ds.DataSourceProvider;

/**
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public interface ITransaction {
	public void setDatasourceProvider(DataSourceProvider dsp);
	public void begin();
	public void commit();
	public void rollback();
}
