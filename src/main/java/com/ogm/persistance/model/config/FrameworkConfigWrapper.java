package com.ogm.persistance.model.config;

import es.caser.archit.utils.Configuration;


/**
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public  class FrameworkConfigWrapper implements IFrameworkConfigWrapper{

	public String getValue(String section, String entry, String defaultValue) {
		return Configuration.getStringValue(section, entry, defaultValue);
	}

}
