package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;

/**
 * <p>Interfaz para realizar la conversión de una <code>SQLCondition</code> en su representación sql</p>
 * <p>Las implementaciones de ese interface han de ser thread save, ya que van a aser usados como singletons.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 * @see  SQLCondition
 */
public interface IConditionRender {

	/**
	 * <p>Genera la representación SQL de la condicion <code>condition</code></p>
	 * <p>Ha de devolver true si hay parámetros sutituibles, es decir, si se genera un "?"
	 * @param modelManager Modelo sobre le que se realizan las operaciones
	 * @param condition Condición a transformar en SQL
	 * @param sqlBuffer Buffer para escribir el sql
	 * @return true si hay que incluir parámetros en la sql, es decir, si se ha generado algún "?"
	 */
	public boolean render(ModelManager modelManager,SQLCondition condition, StringBuilder sqlBuffer); 
}
