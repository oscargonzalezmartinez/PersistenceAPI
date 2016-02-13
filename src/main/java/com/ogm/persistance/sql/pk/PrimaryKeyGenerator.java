package com.ogm.persistance.sql.pk;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;

/**
 * <p>Interfaz para definir un generador de claves primarias.</p>
 * <p>La clase que implemente este interfaz debe ser thread safe ya que se creará una única instancia
 * por tabla mapeada, pudiendo ser utilizada concurrentemente por varios hilos de inserción sobre
 * la misma tabla.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public interface PrimaryKeyGenerator {
	public static final String SEQUENCE = "SEQUENCE_ALIAS";
	/**
	 * <p>.</p>
	 * @param modelManager
	 * @param model
	 * @return
	 */
	public Long generate(ModelManager modelManager, ModelDefinition model);
}
