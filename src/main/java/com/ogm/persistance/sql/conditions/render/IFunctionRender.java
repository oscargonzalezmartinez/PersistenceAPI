package com.ogm.persistance.sql.conditions.render;

import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLField;

/**
 * <p>Interfaz para las clases encargadas de generar el sql de las funciones sql.</p>
 * <p>Las implementaciones de ese interface han de ser thread save, ya que van a aser usados como singletons.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public interface IFunctionRender extends IConditionRender{

	/**
	 * <p>Renderiza el sql cuando la funci�n est� en un campo.</p>
	 * @param modelManager model manager en el que se ejecuta la funci�n, es el contexto.
	 * @param field
	 * @param sqlBuffer
	 * @return true si hay par�metros de sustituci�n
	 */
	public boolean render(ModelManager modelManager, SQLField field, StringBuilder sqlBuffer );
}
