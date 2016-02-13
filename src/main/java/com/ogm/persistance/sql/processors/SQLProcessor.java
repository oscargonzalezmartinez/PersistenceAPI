package com.ogm.persistance.sql.processors;

import com.ogm.persistance.model.ModelManager;
/**
 * <p>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public interface SQLProcessor {

	/**
	 * <p>.</p>
	 * @param modelManager
	 */
	public void setModelManager(ModelManager modelManager);
}
