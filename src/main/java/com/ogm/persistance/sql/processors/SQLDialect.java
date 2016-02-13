package com.ogm.persistance.sql.processors;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;

/**
 * <p>Interfaz que define los métodos para las clases encargadas de .</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public interface SQLDialect {

	/**
	 * <p>Paginación de la query.</p>
	 * @param sql
	 * @param ini
	 * @param max
	 */
	public void pagination(StringBuilder sql, long ini, long max);
	
	public Long getSequenceValue(ModelManager modelManager, ModelDefinition model);
}
