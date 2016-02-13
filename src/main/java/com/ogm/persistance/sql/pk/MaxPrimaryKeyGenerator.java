package com.ogm.persistance.sql.pk;

import java.util.List;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLField;
import com.ogm.persistance.sql.SQLFrom;
import com.ogm.persistance.sql.SQLFunction;
import com.ogm.persistance.sql.SQLSelect;

/**
* <p>Generador de claves primarias basado en select max.</p>
* @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
* @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
* @since 2.0
*/
public class MaxPrimaryKeyGenerator implements PrimaryKeyGenerator {

	/**
	 * Modelo para la salida de la query.
	 */
	private static final ModelDefinition OUT_MODEL = ModelDefinition.newModel(SequenceResult.class);
	/**
	 * Último valor devuelto.
	 */
	private Long lastValue = null;
	
	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.pk.PrimaryKeyGenerator#generate(java.lang.Object)
	 */
	public Long generate(ModelManager modelManager, ModelDefinition model) {
		synchronized (this) {
			if (lastValue == null){
				lastValue = loadFromDDBB( modelManager,model);
			}

			lastValue+=1;
			return lastValue;

		}

	}

	/**
	 * <p>Carga de BBDD el valor máximo de la clave primaria definida para <code>object</code>.</p>
	 * @param object Objeto para el que se quiere recuperar el valor máximo de clave primaria.
	 * @return valor máximo de la clave primaria.
	 */
	private Long loadFromDDBB(ModelManager modelManager, ModelDefinition model){

		SQLField sqlField = new SQLField(model.getClass(),
										model.getPrimaryKeyField(),
										SQLFunction.MAX,
										SEQUENCE);
		SQLSelect select = new SQLSelect();
		select.addSelectField(sqlField);
		select.setFrom(new SQLFrom().addTable(model));
		select.setOutputModel(OUT_MODEL);
		return ((List<SequenceResult>)modelManager.getSelectProcessor().execute(select)).get(0).getValue();
	}
}
