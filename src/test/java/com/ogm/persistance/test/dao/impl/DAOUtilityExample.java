package com.ogm.persistance.test.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLSelect;
import com.ogm.persistance.sql.SQLWhere;
import com.ogm.persistance.sql.processors.SQLDeleteProcessor;
import com.ogm.persistance.sql.processors.SQLInsertProcessor;
import com.ogm.persistance.sql.processors.SQLSelectProcessor;
import com.ogm.persistance.sql.processors.SQLUpdateProcessor;

/**
 * <p>Esta clase realiza todas las query de las clases mapeadas de forma dinámica, para ello se basa en los ModelDefinition
 * de las clases.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.1 $LastChangedRevision: 25405 $ $LastChangedDate: 2009-01-27 13:39:58 +0100 (mar, 27 ene 2009) $
 * @since 1.0
 *
 */
public class DAOUtilityExample {

	/**
	 * <p>Fichero donde se indican las clases a persistir.</p>
	 */
	private static final String CONFIG_FILE = "com/ogm/persistance/test/dao_mapping.xml";
	private static SQLInsertProcessor insertProcessor = null;
	private static SQLUpdateProcessor updateProcessor = null;
	private static SQLSelectProcessor selectProcessor = null;
	private static SQLDeleteProcessor deleteProcessor = null;
	
	static {
		
		insertProcessor = ModelManager.getInstance(CONFIG_FILE).getInsertProcessor();
		updateProcessor = ModelManager.getInstance(CONFIG_FILE).getUpdateProcessor();
		selectProcessor = ModelManager.getInstance(CONFIG_FILE).getSelectProcessor();
		deleteProcessor = ModelManager.getInstance(CONFIG_FILE).getDeleteProcessor();
		
	}
	/**
	 * Constructor privado para evitar instanciación.
	 */
	private DAOUtilityExample(){}
	
	
	/**
	 * <p>Devuelve un único objeto aplicando el filtro indicado en <code>objToFind</code>.</p>
	 * <p>Si retorna más de un objeto se lanza una <code>DAOException</code> con el código 
	 * <code>ErrorMessageID.DAO00001</code>.</p>
	 * <p>Si se quiere obtener más de una instancia utilizar los métodos <code>find</code>.
	 * @param objToFind Objeto con el que se realiza el filtro.
	 * @return único objeto aplicando el filtro indicado en <code>objToFind</code>.
	 * 
	 */
	public static <T> T get(Object objToFind){
		return (T)selectProcessor.get(objToFind);
	}
	
	/**
	 * <p>Devuelve un objeto de la clase <code>clazz</code> cuya clave primaria tiene el valor <code>id</code>.
	 * <p>Si retorna más de un objeto se lanza una <code>DAOException</code> con el código.
	 * <code>ErrorMessageID.DAO00001</code></p>.
	 * <p>Si se quiere obtener más de una instancia utilizar los métodos <code>find</code>. 
	 * @param clazz Clase que representa la tabla a consultar.
	 * @param id Valor de la clave primaria.
	 * @return Un objeto de la clase <code>clazz</code> cuya clave primaria tiene el valor <code>id</code>.
	 */
	public static <T> T get(Class<T> clazz, Object id){
		return selectProcessor.get(clazz, id);
	}
	
	public static <T> T getComplete(Class<T> clazz, Object id){
		return selectProcessor.getComplete(clazz, id);
	}

	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * @param clazz Clase que representa la tabla a buscar.
	 * @return Listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 */
	public static <T> List<T> find(Class<T> clazz){
		return selectProcessor.find(clazz);
	}
	
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * aplicando las restricciones indicadas en <code>object</code></p>.
	 * 
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @return Listado de todos los objetos de la tabla representada por <code>object</code>.
	 */
	public static <T> List<T> find(Object object){
		return selectProcessor.find(object);
	}
	
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 * @param clazz Clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return Un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 */
	public static <T> List<T> find(Class<T> clazz, SQLWhere where){
		return selectProcessor.find(clazz, where);
	}


	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code></p>.
	 * <p>Para realizar el filtro se añaden los valores contenidos en <code>object</code>.
	 * </p>
	 * 
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return Un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 */
	public static <T> List<T> find(Object object, SQLWhere where){
		return selectProcessor.find(object, where);
	}
	
	/**
	 * <p>Devuelve una única fila de la tabla representada por <code>object</code></p>.
	 * <p>Si retorna más de un objeto se lanza una <code>DAOException</code> con el código 
	 * <code>ErrorMessageID.DAO00001</code></p>.
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return una única fila de la tabla representada por <code>object</code>
	 */
	public static Object get(Object object, SQLWhere where){
		return selectProcessor.get(object, where);
	}
	
	public static List execute(SQLSelect select){
		return selectProcessor.execute(select);
	}
	/**
	 * <p>Inserta una nueva fila en la tabla representada por el objeto <code>toInsert</code></p>.
	 * @param toInsert Objeto a insertar.
	 * @return toInsert con el campo clave informado.
	 */
	public static Object insert(Object toInsert){
		return insertProcessor.insert(toInsert);
	}
	
	public static Object insertComplete(Object toInsert){
		return insertProcessor.insertComplete(toInsert);
	}

	/**
	 * <p>Actualiza objeto por primary key</p>.
	 * @param toUpdate objeto a actualizar.
	 * @return Si se ha visto afectado algún registro.
	 * 
	 */
	public static boolean update(Object toUpdate){
		return updateProcessor.update(toUpdate)!=0;
	}


	/**
	 * <p>Actualiza la tabla representada por  <code>toUpdate</code> con los datos contenidos en le objeto
	 * y seleccionando los registro que cumplan las restricciones indicadas en <code>where</code>.
	 * @param toUpdate Nuevos datos.
	 * @param where Restricciones de selección de registros a actualizar.
	 * @return Si se ha visto afectado algún registro.
	 */
	public static boolean update(Object toUpdate , SQLWhere where){
		return updateProcessor.update(toUpdate, where)!=0;
	}
	
	public static boolean updateComplete(Object toUpdate){
		return updateProcessor.updateComplete(toUpdate);
	}
	/**
	 * @param toDelete
	 * @return
	 */
	public static boolean delete(Object toDelete){
		return deleteProcessor.delete(toDelete);
	}

	/**
	 * @param clazzToDelete
	 * @param id
	 * @return
	 */
	public static boolean delete(Class clazzToDelete, Object id){
		return deleteProcessor.delete(clazzToDelete, id);
	}
	
	/**
	 * @param toDelete
	 * @param where
	 * @return
	 */
	public static boolean delete(Object toDelete , SQLWhere where){
		return deleteProcessor.delete(toDelete, where);
	}
	
	/**
	 * <p>añade la condición <code>condition</code> al where si la condición no tiene un valor vacío o blanco</p>.
	 * @param where
	 * @param condition
	 */
	public static void appendFieldNotEmpty(SQLWhere where, SQLCondition condition){
		if (condition.getValue() !=null && StringUtils.isNotBlank(String.valueOf(condition.getValue()))){
			where.add(condition);
		}
	}
	
	
	public static List executeNamedQuery(String queryKey, List params){
		return selectProcessor.executeNamedQuery(queryKey, params);
	}
	
	public static List executeNamedQuery(String queryKey, Object param){
		return selectProcessor.executeNamedQuery(queryKey, param);
	}
	
	
	public static void beginTransaction(){
		ModelManager.getInstance(CONFIG_FILE).beginTransaction();
	}
	
	public static void commitTransaction(){
		ModelManager.getInstance(CONFIG_FILE).commitTransaction();
	}
	
	public static void rollbackTransaction(){
		ModelManager.getInstance(CONFIG_FILE).rollbackTransaction();
	}
	
	public static Long count(Class clazz){
		return selectProcessor.count(clazz);
	}
}
