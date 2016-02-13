package com.ogm.persistance.sql.processors;

import com.ogm.persistance.sql.SQLWhere;

/**
 * <p>Interfaz que define los métodos para las clases encargadas de generar los updates.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public interface SQLUpdateProcessor  extends SQLProcessor{
	/**
	 * <p>Actualiza objeto por primary key</p>.
	 * @param toUpdate objeto a actualizar.
	 * @return número de registros actualizados.
	 * 
	 */
	public long update(Object toUpdate);
	
	/**
	 * <p>Actualiza la tabla representada por  <code>toUpdate</code> con los datos contenidos en le objeto
	 * y seleccionando los registro que cumplan las restricciones indicadas en <code>where</code>.
	 * @param toUpdate Nuevos datos.
	 * @param where Restricciones de selección de registros a actualizar.
	 * @return Si se ha visto afectado algún registro.
	 */
	//public boolean update(Object toUpdate , SQLWhere where);
	
	/**
	 * <p>Actualiza la tabla representada por  <code>toUpdate</code> con los datos contenidos en le objeto
	 * y seleccionando los registro que cumplan las restricciones indicadas en <code>where</code>.
	 * @param toUpdate Nuevos datos.
	 * @param where Restricciones de selección de registros a actualizar.
	 * @return número de registros actualizados.
	 */
	public long update(Object toUpdate , SQLWhere where);
	
	/**
	 * <p>.</p>
	 * @param toUpdate
	 * @return
	 */
	public boolean updateComplete(Object toUpdate);
}
