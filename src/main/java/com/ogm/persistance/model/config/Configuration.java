package com.ogm.persistance.model.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.igfay.jfig.JFig;
import org.igfay.jfig.JFigException;
import org.igfay.jfig.JFigIF;
import org.igfay.jfig.JFigLocator;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ogm.persistance.sql.SQLPagination;
import com.ogm.persistance.sql.processors.SQLDeleteProcessor;
import com.ogm.persistance.sql.processors.SQLDialect;
import com.ogm.persistance.sql.processors.SQLInsertProcessor;
import com.ogm.persistance.sql.processors.SQLSelectProcessor;
import com.ogm.persistance.sql.processors.SQLUpdateProcessor;
import com.ogm.persistance.util.ClassUtil;

/**
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class Configuration {
	private static XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/"+ClassUtil.getPackageName(Configuration.class) + "/default-config.xml", Configuration.class));
	private static final String CONFIG_SECTION = "config";
	private static final String DELETE = "delete";
	private static final String UPDATE = "update";
	private static final String INSERT = "insert";
	private static final String SELECT = "select";
	private static final String PROCESSORS = "processors";
	private static final String SQL_PAGINATION_MAX = "sql.pagination.max";
	private static final String SQL_PAGINATION_MANDATORY = "sql.pagination.mandatory";
	private static final String DEFAULT_DIALECT = "dialect.oracle";
	private static final String DIALECT = "dialect";
	private static final String QUERIES = "queries";
	private static Log log = LogFactory.getLog(Configuration.class);
	private static final String BD_SCHEMA = "bd.schema";
	//Variables de indirecci�n para acceder a la configuraci�n de bbdd
	//solo se usan si detr� est� el FrameworkCaser
	/**
	 * <p>Entrada de configuraci�n que indica la secci�n de bbdd en la configuraci�n framework de la aplicaci�n.</p>
	 */
	private static final String INDIR_BB_DD_SECTION = "bdsection";
	/**
	 * <p>Entrada de configuraci�n la variable que contiene el schema en la configuraci�n framework de la aplicaci�n.</p>
	 */
	private static final String INDIR_BB_DD_SCHEMA = "bdsschema";


	
	private String schema = null;
	private String configFile = null;
	private JFigIF jfig = null;
	/**
	 * @param newConfigFile
	 * @throws JFigException
	 */
	public Configuration(String newConfigFile) throws JFigException {
		super();
		configFile = newConfigFile;
		if (log.isInfoEnabled()){
			log.info("Cargando configuraci�n de " + configFile);
		}
		
		jfig = JFig.initialize(new JFigLocator(configFile));
		schema = getValue(CONFIG_SECTION, BD_SCHEMA, null);
//		if (schema == null){
//			//si el esquema es nulo buscamos una configuraci�n del framework;
//			schema = loadSchemaFromFramework();
//		}
		
		if (log.isDebugEnabled()){
			log.debug("schema " + schema);
		}
	}
	
	/**
	 * <p>.</p>
	 * @param processorType
	 * @return
	 */
	private Object loadProcessors(String processorType) {
		//cargamos los procesadores 
		String clazzName = jfig.getValue(PROCESSORS, processorType,null);
		log.info("Cargando processor " + processorType +" : " + clazzName);
		if (clazzName!=null){
			//definido por el usuario
			return ClassUtil.newInstance(clazzName);
		}
	
		Object object = bf.getBean(processorType);

		log.info("Cargando valor por defecto " + object.getClass().getName());

		return object;
	}
	
	/**
	 * <p>Cargando la configuraci�n si utilizamos Framework Caser.</p>
	 * @return
	 */
//	private String loadSchemaFromFramework(){
//		String bbddSection = getValue(CONFIG_SECTION, INDIR_BB_DD_SECTION,null);
//		log.info("Section indirection  [" + bbddSection + "]");
//		String bbddSchema =  getValue(CONFIG_SECTION, INDIR_BB_DD_SCHEMA,null);
//		log.info("Schema indirection  [" + bbddSchema + "]");
//		
//		if (bbddSection==null || bbddSchema==null){
//			return null;
//		}
//		log.info("Cargamos Schema desde configuraci�n Framework Caser");
//
//		IFrameworkConfigWrapper wrapper = (IFrameworkConfigWrapper) bf.getBean(IFrameworkConfigWrapper.class.getSimpleName());
//		return wrapper.getValue(bbddSection, bbddSchema, null);
//	}
	
	/**
	 * <p>Dialecto de la base de datos.</p>
	 * @return Dialecto de la base de datos
	 */
	public SQLDialect getDialect(){
		String dialect = getValue(CONFIG_SECTION, DIALECT, DEFAULT_DIALECT);
		log.info("Dialecto a utilizar " + dialect);

		SQLDialect dialectImpl = (SQLDialect) bf.getBean(dialect);
		log.debug("Clase que implementa el dialecto " + dialectImpl.getClass().getName());
		return dialectImpl;
		
	}
	
	/**
	 * <p>Devuelve la paginaci�n indicada en la configuraci�n.</p>
	 * @return
	 */
	public SQLPagination getPagination(){
		String paginacion = getValue(CONFIG_SECTION, SQL_PAGINATION_MANDATORY,Boolean.FALSE.toString());
		if (Boolean.parseBoolean(paginacion)){
			//hay paginaci�n definida por el usuario
			String maxValue = getValue(CONFIG_SECTION, SQL_PAGINATION_MAX,"2000");
			log.info("Paginaci�n obligatoria MAX [" +maxValue + "]");
			return new SQLPagination(1L, Long.valueOf(maxValue));
		}
		
		return null;
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public SQLSelectProcessor loadSQLSelectProcessor() {
		return (SQLSelectProcessor) loadProcessors(SELECT);
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public SQLInsertProcessor loadSQLInsertProcessor() {
		return (SQLInsertProcessor) loadProcessors(INSERT);
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public SQLUpdateProcessor loadSQLUpdateProcessor() {
		return (SQLUpdateProcessor) loadProcessors(UPDATE);
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public SQLDeleteProcessor loadSQLDeleteProcessor() {
		return (SQLDeleteProcessor) loadProcessors(DELETE);
	}
	
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getQueriesFile(){
		return jfig.getValue(CONFIG_SECTION, QUERIES,null);
	}
	
	/**
	 * <p>Devuelve el valor de configuraci�n.</p>
	 * @param section secci�n de la configuraci�n.
	 * @param key clave dentro de la secci�n.
	 * @param defaultValue valor devuelto si no se encuentra.
	 * @return valor de configuraci�n.
	 */
	public String getValue(String section, String key, String defaultValue){
		return jfig.getValue(section, key,defaultValue);
	}
	
	/**
	 * <p>Esquema de la base de datos.</p>
	 * @return Esquema de la base de datos.
	 */
	public String getSchema(){
		return schema;
	}

	@Override
	public String toString() {
		return new StringBuilder(getClass().getName()).append(configFile).toString();
	}
	
	
}
