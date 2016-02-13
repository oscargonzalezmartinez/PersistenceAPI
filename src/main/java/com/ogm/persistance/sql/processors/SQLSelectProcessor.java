package com.ogm.persistance.sql.processors;

import java.util.List;

import com.ogm.persistance.model.Relationship;
import com.ogm.persistance.sql.SQLSelect;
import com.ogm.persistance.sql.SQLWhere;

/**
 * <p>Interfaz que define los m�todos para las clases encargadas de generar las selects.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public interface SQLSelectProcessor  extends SQLProcessor{
	/**
	 * <p>Devuelve el resultado de la ejecuci�n de <code>select</code></p>.
	 * @param select Sentencia select a ejecutar.
	 * @return resultado de la ejecuci�n de <code>select</code>.
	 */
	public List execute(SQLSelect select);
	/**
	 * <p>Devuelve un �nico objeto aplicando el filtro indicado en <code>objToFind</code>.</p>
	 * <p>Si retorna m�s de un objeto se lanza una <code>PersistanceException</code> con el c�digo 
	 * <code>ErrorMessageID.PE_00001</code>.</p>
	 * <p>Si se quiere obtener m�s de una instancia utilizar los m�todos <code>find</code>.
	 * @param objToFind Objeto con el que se realiza el filtro.
	 * @return �nico objeto aplicando el filtro indicado en <code>objToFind</code>.
	 * 
	 */
	public <T> T get(Object objToFind);
	
	/**
	 * <p>.</p>
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> clazz, Object id);
	
	/**
	 * <p>Devuelve el objeto de tipo <code>clazz</code> cuya clave primaria es <code>id</code> y todos
	 * los objetos cono los que tiene relaci�n.</p>
	 * <p>Este m�todo s�lo se ha de invocar cuando se quieren todas las relaciones del objeto, puede
	 * ser una ejecuci�n muy pesada con lo que hay que usarlo con sentido. Para la mayor�a de los casos
	 * usar <code>get(Class<T> clazz, Object id)</code></p>
	 * @param <T>
	 * @param clazz
	 * @param id
	 * @return
	 * @deprecated utilizar la definici�n de las relaciones
	 */
	@Deprecated
	public <T> T getComplete(Class<T> clazz, Object id);
	
	/**
	 * <p>Devuelve los datos asociados en la definci�n.</p>
	 * @param target
	 * @param relationship
	 * @param field
	 * @return
	 */
	public Object loadRelation(Object target,String field );
	
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * @param clazz Clase que representa la tabla a buscar.
	 * @return Listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 */
	public <T> List<T> find(Class<T> clazz);
	
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * aplicando las restricciones indicadas en <code>object</code></p>.
	 * 
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @return Listado de todos los objetos de la tabla representada por <code>object</code>.
	 */
	public <T> List<T> find(Object object);
	
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 * @param clazz Clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return Un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 */
	public <T> List<T> find(Class<T> clazz, SQLWhere where);
	
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code></p>.
	 * <p>Para realizar el filtro se a�aden los valores contenidos en <code>object</code>.
	 * </p>
	 * 
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return Un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 */
	public <T> List<T> find(Object object, SQLWhere where);
	
	/**
	 * <p>Devuelve una �nica fila de la tabla representada por <code>object</code></p>.
	 * <p>Si retorna m�s de un objeto se lanza una <code>PersistanceException</code> con el c�digo 
	 * <code>ErrorMessageID.PE_00001</code></p>.
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return una �nica fila de la tabla representada por <code>object</code>
	 */
	public Object get(Object object, SQLWhere where);
	
	/**
	 * <p>Representaci�n en SQL de la query de select de <code>clazz</code>.</p>
	 * <p>La utilidad de este m�todo es pregenerar las querys y poder cachearlas</p>
	 * @param clazz Modelo que representa una tabla
	 * @return SQL de la query de select de <code>model</code>
	 */
	public String getSQL(Class clazz);
	
	/**
	 * <p>Ejecuta la query cuyo id es <code>queryKey</code>.</p>
	 * <p>Si la query no define atributos de sustituci�n con <code>:=</code> 
	 * se presupone que <code>param</code> es un listado con los par�metros necesarios
	 * para la query </p>
	 * <p>Si define atributos se intentar� acceder a ellos mediante la invocaci�n <code>param.attributo</code>
	 * @param queryKey Clave de la query
	 * @param param Para�emtro de entrada para la query
	 * @return Resultado de ejecutar la query con id <code>queryKey</code>
	 */
	public List executeNamedQuery(String queryKey, Object param);
	
	/**
	 * <p>Devuelve el n�mero de elementos de tipo <code>clazz</code>.</p>
	 * @param clazz Clase del modelo
	 * @return n�mero de elementos de tipo <code>clazz</code>.
	 */
	public Long count(Class clazz);

	/**
	 * <p>Devuelve el n�mero de elementos que cumplen el filtro <code>example</code>.</p>
	 * @param example Objeto con el filtro
	 * @return n�mero de elementos que cumplen el filtro <code>example</code>.
	 */
	public Long count(Object example);
	
	/**
	 * <p>Crea un <code>SQLWhere</code> con las condiciones de filtro indicadas en <code>object</code>.</p>
	 * @param object
	 * @param sqlWhere
	 * @return sqlWhere
	 */
	public SQLWhere getWhereFromObject(Object object);
}