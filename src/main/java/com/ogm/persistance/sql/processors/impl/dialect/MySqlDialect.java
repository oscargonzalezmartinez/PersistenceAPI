package com.ogm.persistance.sql.processors.impl.dialect;

import com.ogm.persistance.sql.processors.SQLDialect;
import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
/**
 * <p>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class MySqlDialect implements SQLDialect {

	private static final String OFFSET = " OFFSET ";
	private static final String LIMIT = " LIMIT ";

	/* (non-Javadoc)
	 * @see com.ogm.persistance.sql.processors.SQLDialect#pagination(java.lang.StringBuilder, long, long)
	 */
	public void pagination(StringBuilder sql, long min, long max) {
		//LIMIT row_count OFFSET offset
		long rowCount = max - min;
		long offset = min;
		sql.append(LIMIT).append(rowCount).append(OFFSET).append(offset);

	}

	public Long getSequenceValue(ModelManager modelManager, ModelDefinition model) {
		if (true)throw new com.ogm.persistance.exceptions.PersistanceException("Not supported");
		return null;
	}	
}
