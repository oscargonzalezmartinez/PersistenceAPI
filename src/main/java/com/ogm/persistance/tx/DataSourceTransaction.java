package com.ogm.persistance.tx;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ogm.persistance.ds.DataSourceProvider;

/**
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class DataSourceTransaction implements ITransaction{
	private static Log log = LogFactory.getLog(ITransaction.class);
	/**
	 * 
	 * */
	private PlatformTransactionManager transactionManager = null;
	
	private ThreadLocal<TransactionStatus> tl = new ThreadLocal<TransactionStatus>();
	
	public void setDatasourceProvider(DataSourceProvider dsp){
		DataSourceTransactionManager dstm = new org.springframework.jdbc.datasource.DataSourceTransactionManager();
		dstm.setDataSource(dsp.getDataSource());
		transactionManager = dstm;
	}

	public void begin() {
		log.debug("tx begin");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		tl.set(status);
	}

	public void commit() {
		log.debug("tx commit");
		transactionManager.commit(tl.get());
		
	}

	public void rollback() {
		log.debug("tx rollback");
		transactionManager.rollback(tl.get());
	}
	
}
