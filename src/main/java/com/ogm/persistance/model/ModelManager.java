package com.ogm.persistance.model;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.igfay.jfig.JFigException;

import com.ogm.persistance.ds.DataSourceProvider;
import com.ogm.persistance.exceptions.ModelPersistanceException;
import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.model.config.Configuration;
import com.ogm.persistance.model.xml.Querys;
import com.ogm.persistance.sql.SQLPagination;
import com.ogm.persistance.sql.antlr.ObjectQueryToSQL;
import com.ogm.persistance.sql.pk.MaxPrimaryKeyGenerator;
import com.ogm.persistance.sql.pk.SequencePrimaryKeyGenerator;
import com.ogm.persistance.sql.processors.SQLDeleteProcessor;
import com.ogm.persistance.sql.processors.SQLDialect;
import com.ogm.persistance.sql.processors.SQLInsertProcessor;
import com.ogm.persistance.sql.processors.SQLSelectProcessor;
import com.ogm.persistance.sql.processors.SQLUpdateProcessor;
import com.ogm.persistance.tx.ITransaction;
import com.ogm.persistance.util.ClassUtil;
import com.ogm.persistance.util.ErrorMessageID;
import com.ogm.persistance.util.MessageUtil;
import com.ogm.persistance.xml.XMLUtil;


/**
 * <p>Gestor de los modelos java que representan las tablas de BBDD.</p>
 * <p>Hay una instancia de esta clase por cada configuración de bbdd que se queirea utilizar.<p>
 * <p>Para obtener una referencia determinada se ha de llamar al método estático <code>getInstance(configFile)</code>.</p>
 * <p>Al fichero configFile se accederá mediante <code>JFigLocator</code>, con lo que hay que tener esto en cuenta 
 * para saber ubicarlo. Normalmente el classpath de aplicación.</p>  
 * <p>En este fichero se indican cada uno de los ficheros de mapeo de cada una de las clases mapeadas a BBDD
 * así como el data source provider necesario para acceder a la bbdd.</p>
 * 
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public class ModelManager {
	private static final String CONFIG_SECTION = "config";
	private static final String DATA_SOURCE_PROVIDER = "datasource.provider";
	private static final String TRANSACTION_MANAGER = "transaction.manager";	

	private static Map<String,ModelManager> managers = new HashMap<String, ModelManager>();
	private static Log log = LogFactory.getLog(ModelManager.class); 


	//miembros de instancia
	/**
	 * Data source provider.
	 */
	private DataSourceProvider dataSourceProvider = null;
	/**
	 * <p>Fichero donde se indican las clases a persistir.</p>
	 */
	private String configFile = null;
	
	/**
	 * <p>Cache de modelos.</p>
	 */
	private Map<String,ModelDefinition> models = new HashMap<String,ModelDefinition>();
	/**
	 * <p>Cache de queries a las que se accede por clave.</p>
	 */
	private Map<String,NamedQuery> namedQueries = new HashMap<String,NamedQuery>();
	
	/**
	 * Configuración.
	 */
	private Configuration configuration = null;
	
	/**
	 * <p>Si este dato no es nulo se aplica una paginación obligatoria a todas las consultas.</p>
	 */
	private SQLPagination pagination = null;
	
	/**
	 * <p>Clase que implementa las sql específicas para el motor de bbdd utilizado</p>
	 */
	private SQLDialect dialect = null;
	
	//diferentes procesadores de querys
	private SQLInsertProcessor insertProcessor = null;
	private SQLUpdateProcessor updateProcessor = null;
	private SQLSelectProcessor selectProcessor = null;
	private SQLDeleteProcessor deleteProcessor = null;
	

	/**
	 * Fichero con las named queys, es opcional.
	 */
	private String queriesFile = null;


	/**
	 * <p>Gestor de transacciones. Sólo para transacción programática.</p>
	 */
	private ITransaction transaction = null;

	/**
	 * <p>Devuelve el modelManager que corresponde con la configuración definida en <code>config</code>.<p>
	 * @return  modelManager que corresponde con la configuración definida en <code>config</code>..
	 */
	public static ModelManager getInstance(String config){
		ModelManager mm = managers.get(config);
		if (mm == null){
			synchronized (ModelManager.class) {
				if (mm == null){
					mm = new ModelManager(config);
					mm.initModels();
					mm.loadNamedQueries();
					
				}
			}
			
			managers.put(config,mm);
		}

		return mm;
	}
	
	/**
	 * <p>Devuelve el modelo mapeado que corresponde a esta clase.</p>
	 * <p>Hay que tener en cuenta que se recorre tods los modelmanager para encontrar el modelo
	 * desado, por lo que si hay varios definídos será poco eficiente.<br>
	 * La mejor opción es ModelManager.getInstace(configFile).getModel(class).</p>
	 * @param clazz
	 * @return model manager.
	 */
	public static ModelManager getModelManager(Class clazz){
		
		for (Iterator<String> keys = managers.keySet().iterator();keys.hasNext();) {
			String key = keys.next();
			if (managers.get(key).getModel(clazz)!=null){
				return managers.get(key);
			}
		} 
		
		return null;
	}
	
	/**
	 * Constructor privado.
	 */
	private ModelManager(){}
	
	/**
	 * <p>Contructor privado para evitar instanciación.</p>
	 */
	private ModelManager(String file){
		configFile = file;
		initialMessage();
		
		init();
	}

	/**
	 * <p>Mensaje incial en el que se indica la versión y el fichero de configuración.</p>
	 */
	private void initialMessage() {
		log.info("******************************************");
		log.info("** Persistance API version: " + MessageUtil.getAppMessage("persistance.version"));
		log.info("** Persistance API release date: " + MessageUtil.getAppMessage("persistance.date"));
		log.info("** Configuración " + configFile);
		log.info("******************************************");
	}
	
	/**
	 * <p>Inicializa toda la configuración de los mapeos de clases.</p>
	 */
	private void init(){

		try {
			log.info("Cargando mapeo de fichero " + configFile);
			//JFigIF jfig = JFig.initialize(new JFigLocator(CONFIG_FILE));
			configuration = new Configuration(configFile);
			loadProcessors();	
			loadConfig();
			//bAnnotated = Boolean.valueOf(jfig.getValue("mappings", "annotated",Boolean.FALSE.toString()));
			
			boolean bXml = Boolean.valueOf(configuration.getValue("mappings", "xml",Boolean.FALSE.toString()));
			int index = 1;
			String mapping = null;
			ModelDefinitionLoader modelLoader = new ModelDefinitionLoader();
			while((mapping = configuration.getValue("mappings","mapping."+index,null) ) != null){
				
				loadDefinition(modelLoader,mapping,bXml);
				index++;
			}
			
			
		} catch (JFigException e) {
			throw new ModelPersistanceException(e);
		}

	}
	
	/**
	 * <p>Carga los procesadores de sentencias.</p>
	 */
	private void loadProcessors() {
		//cargamos los procesadores 
		selectProcessor = configuration.loadSQLSelectProcessor();
		log.info("select " + selectProcessor.getClass().getName());
		//
		insertProcessor = configuration.loadSQLInsertProcessor();
		log.info("insert " + insertProcessor.getClass().getName());
		
		//
		updateProcessor = configuration.loadSQLUpdateProcessor();
		log.info("update " + updateProcessor.getClass().getName());
	
		deleteProcessor = configuration.loadSQLDeleteProcessor();
		log.info("delete " + deleteProcessor.getClass().getName());
		
		
		insertProcessor.setModelManager(this);
		updateProcessor.setModelManager(this);
		selectProcessor.setModelManager(this);
		deleteProcessor.setModelManager(this);
		
	}

	/**
	 * <p>Carga la configuración.</p>
	 */
	private void loadConfig() {
		
		dialect = configuration.getDialect();
		
		queriesFile = configuration.getQueriesFile();//jfig.getValue(CONFIG_SECTION, "queries",null); 
		log.info("Fichero de queries (opcional)  [" + queriesFile+"]");

		pagination = configuration.getPagination();
		loadDataSourceProvider();
		loadTransactionManager();
	}
	
	/**
	 * <p>Carga el data source provider definido en la configuración.</p>
	 */
	private void loadDataSourceProvider() {
		//cargamos los procesadores 
		String provider = configuration.getValue(CONFIG_SECTION, DATA_SOURCE_PROVIDER,null); 
		log.info("Data Source Provider  [" + provider+"]");
		dataSourceProvider = (DataSourceProvider) ClassUtil.newInstance(provider);
		
		List<String> parametersList = dataSourceProvider.getParametersNames();
		if (parametersList!=null){
			Map<String,String> parameters = new HashMap<String,String>();
			for (Iterator iterator = parametersList.iterator(); iterator.hasNext();) {
				String param = (String) iterator.next();
				String value = configuration.getValue(CONFIG_SECTION, param,null);
				//TODO error si es nulo??
				parameters.put(param,value);
			}//for
			
			dataSourceProvider.setParameters(parameters);
		}
		
		dataSourceProvider.init();
	}	
	
	/**
	 * <p>Carga el gestor de transacciones definido en la configuración.</p>
	 */
	private void loadTransactionManager(){
		String tx = configuration.getValue(CONFIG_SECTION, TRANSACTION_MANAGER,null);
		if (tx == null){
			return;
		}
		
		transaction = (ITransaction) ClassUtil.newInstance(tx);
		transaction.setDatasourceProvider(dataSourceProvider);
	}
	
	/**
	 * <p>Devuelve el transaction manager definido.</p>
	 * <p>Si no hay ninguno definido se lanza la excepción de código <code>ErrorMessageID.PE_00020</code>
	 * @return transaction manager definido.
	 * @throws  ModelPersistanceException si no está definido el transaction manager
	 */
	private ITransaction getTransaction(){
		if (transaction == null){
			throw new ModelPersistanceException(ErrorMessageID.PE_00020);
		}
		return transaction;
	}
	
	/**
	 * <p>Marca el incio de una transacción.</p>
	 */
	public void beginTransaction(){
		getTransaction().begin();
	}
	
	/**
	 * <p>Realiza un commit sobre la transacción activa.</p>
	 */
	public void commitTransaction(){
		getTransaction().commit();
	}
	
	/**
	 * <p>Realiza un rollback sobre la transacción activa.</p>
	 */
	public void rollbackTransaction(){
		getTransaction().rollback();
	}
	
	/**
	 * <p>Carga la definición del mapeo indicado en <code>configurationFileName</code>.</p>.
	 * @param configurationFileName Fichero de mapeo.
	 * @param  modelLoader
	 * @param bXml true si el mapeo es en xml
	 */
	private void loadDefinition(ModelDefinitionLoader modelLoader, String configurationFileName,boolean bXml) {
		log.info( "Cargando mapeo " + configurationFileName);
		ModelDefinition md = null;
		if (bXml){
			md = modelLoader.loadFromMappingFile(configurationFileName);
		}
		else{
			md = modelLoader.loadFromAnnotatedClass(configurationFileName);
		}
		md.setSchema(getSchemaName());
		check(md);
		models.put(md.getClassName(), md);
	}



	/**
	 * <p>Lee las anotaciones de la clase.</p>
	 * <p>Es público y estático para poder mapear a querys objetos que no mapean directamente una tabla
	 * y por lo tanto no aparecen en el fichero de mapeos.</p>
	 * @param clazz
	 * @return  modelo que representa a clazz
	 */
	public static ModelDefinition loadFromAnnotatedClass(Class clazz){
		ModelDefinitionLoader modelLoader = new ModelDefinitionLoader();
		return modelLoader.loadFromAnnotatedClass(clazz);
	}
	

	/**
	 * <p>Devuelve el nombre del esquema de BBDD utilizado.</p>
	 * @return Nombre del esquema de BBDD utilizado.
	 */
	public final String getSchemaName(){
		return configuration.getSchema();
	}
	
	/**
	 * <p>Devuelve la definición del modelo del objeto <code>object</code>.</p>
	 * @param object Objeto del que queremos obtener el modelo.
	 * @return Definición del modelo del objeto <code>object</code>.
	 */
	public ModelDefinition getModel(Object object){
		return getModel(object.getClass());
	}
	/**
	 * <p>Devuelve la definición del modelo de la clase <code>clazz</code>.</p>
	 * <p>si la clase no está configurada en el entorno actual se lanza una excepción
	 * PersistanceException con código de error ErrorMessageID.PE_00018.<p>
	 * @param clazz Clase de la que queremos obtener el modelo.
	 * @return Definición del modelo de la clase <code>clazz</code>.
	 */
	public ModelDefinition getModel(Class clazz){
		ModelDefinition md = models.get(clazz.getName());
		if (md != null){
			return md;
		}
		
		//buscamos el padre por si es una clase proxy
		return getModel(clazz.getSuperclass().getName());
	}

	/**
	 * <p>Devuelve la definición del modelo de la clase con nombre<code>clazz</code>.</p>
	 * <p>El nombre el "full qualified", es decir paquete.Clase.</p>
	 * <p>si la clase no está configurada en el entorno actual se lanza una excepción
	 * PersistanceException con código de error ErrorMessageID.PE_00018.<p>
	 * @param clazz Nombre de la clase de la que queremos obtener el modelo.
	 * @return Definición del modelo de la clase <code>clazz</code>.
	 */
	public ModelDefinition getModel(String clazz){
		ModelDefinition md = models.get(clazz);
		if (md == null){
			throw new PersistanceException(ErrorMessageID.PE_00018,clazz,configFile);
		}
		
		return md;
		
	}
	
	/**
	 * <p>Devuelve la definición del modelo de la clase con nombre<code>clazz</code>.</p>
	 * @param clazz Nombre de la clase de la que queremos obtener el modelo.
	 * @return Definición del modelo de la clase <code>clazz</code>.
	 */
	public ModelDefinition getModelFromSimpleName(String clazzSimpleName){
		clazzSimpleName = "."+clazzSimpleName;
		for (Iterator<String> iterator = models.keySet().iterator(); iterator.hasNext();) {
			String clazzName = iterator.next();
			if (clazzName.endsWith(clazzSimpleName)){
				return models.get(clazzName);
			}
			
		}
		return null;
	}
	
	/**
	 * <p>Realiza una comprobación básica del modelo <code>md</code>.</p>
	 * <p>Se comprueban tres puntos:</p>
	 * <ol>
	 * <li>Se tiene acceso a la clase a la que hace referencia el modelo.</li>
	 * <li>Se pueden instanciar objetos de esta clase.</li>
	 * <li>Se tiene acceso a cada una de las propiedades indicadas en el modelo.</li>
	 * </ol>
	 * <p>Si alguna de las comprobaciones falla el proceso se detiene y se lanza una excepción.</p>
	 * <p>Este es un error muy serio que solo debería producirse en fase de desarrollo.</p> 
	 * @param md Modelo a validar.
	 */
	private void check(ModelDefinition md){
		log.info( "Comprobando mapeo definido para  " + md.getClassName());
		String property = null;
		try {
			if(log.isDebugEnabled()){
				log.debug("Cargando clase " + md.getClassName());
			}
			Class clazz = Class.forName(md.getClassName());
			if(log.isDebugEnabled()){
				log.debug("Instanciando objeto de clase " + md.getClassName());
			}			
			Object objInstance = clazz.newInstance();

			for (Iterator<String> iter = md.getAttributeToColumn().keySet().iterator(); iter.hasNext();) {
				property = iter.next();
				if(log.isDebugEnabled()){
					log.debug( "Accediedo a propiedad ["+property+"] de  " + md.getClassName());
				}							
				PropertyUtils.getProperty(objInstance, property);
			}

		} catch (ClassNotFoundException e) {
			throwException(md,e,null);
		} catch (InstantiationException e) {
			throwException(md,e,null);
		} catch (IllegalAccessException e) {
			throwException(md,e,null);
		} catch (InvocationTargetException e) {
			throwException(md,e," no se puede acceder a  " + property);
		} catch (NoSuchMethodException e) {
			throwException(md,e," no existe la propiedad " + property);
		}
	}
	
	/**
	 * <p>Inicializa los modelos.</p>
	 */
	private void initModels(){
		for (Iterator<ModelDefinition> iterator =models.values().iterator(); iterator.hasNext();){
			ModelDefinition md = iterator.next();
			log.info("Inicializando modelo  " + md.getClassName());
			try {
				Class clazz = Class.forName(md.getClassName()).newInstance().getClass();
				md.setClazz(clazz);
				String sql = getSelectProcessor().getSQL(md.getClazz());
				if (log.isDebugEnabled()){
					log.debug( "Select ["+md.getClassName()+"] : " + sql);
				}
				md.setSqlSelect(sql);
				
				String keyGenerator = md.getKeyGenerator();
				log.info("KeyGenerator  " + keyGenerator);
				if (keyGenerator!=null){
					KeyGeneratorEnum kg = KeyGeneratorEnum.valueOf(keyGenerator);
					switch (kg) {
					case SEQUENCE:
							md.setPrimaryKeyGenerator(new SequencePrimaryKeyGenerator());
						break;
					case MAX:
							md.setPrimaryKeyGenerator(new MaxPrimaryKeyGenerator());
						break;
					default:
						break;
					}
				}
			} catch (ClassNotFoundException e) {
				throwException(md,e,null);
			} catch (InstantiationException e) {
				throwException(md,e,null);
			} catch (IllegalAccessException e) {
				throwException(md,e,null);
			}
		}
	}
	
	/**
	 * <p>Carga las queries desde el fichero indicado en <code>queriesFile</code>.</p>
	 */
	private void loadNamedQueries(){
		if (queriesFile==null){
			return;
		}
		log.info("Leyendo fichero de sentencias desde ["+queriesFile+"]");
		Querys querys = (Querys) XMLUtil.unmarshall(Querys.class.getPackage(),ModelManager.class.getClassLoader().getResourceAsStream(queriesFile));
		List<Querys.NamedQuery> list =  querys.getNamedQuery();
		for (Querys.NamedQuery namedQueryXml : list) {
			String key = namedQueryXml.getKey();
			String query = namedQueryXml.getQuery();
			log.info("Procesando object query ["+key+"] = " + query);
			
			//Comprobamos que este modelo es correcto y los cacheamos 
			//el preprocesador de queries necesita los modelos cargados
			ModelDefinition model = getModel(namedQueryXml.getModel());
			if (model == null){
				try {
					Class clazz = Class.forName(namedQueryXml.getModel());
					model = loadFromAnnotatedClass(clazz);
					models.put(model.getClassName(), model);
				} catch (ClassNotFoundException e) {
					throwException(new ModelDefinition(namedQueryXml.getModel() , null ,null), e, null);
				}

			}
			
			NamedQuery namedQuery = ObjectQueryToSQL.process(query,this);
			namedQuery.setKey(key);

			namedQuery.setModel(namedQueryXml.getModel());

			namedQueries.put(namedQuery.getKey(), namedQuery);
			log.info("Query sql : \n" + namedQuery);
		}
	}
	
	/**
	 * <p>Devuelve la namedquery cuya clave es <code>key</code>.</p>
	 * @param key clave de la namesquery
	 * @return namedquery cuya clave es <code>key</code>.
	 */
	public com.ogm.persistance.model.NamedQuery getNamedQuery(String key){
		return namedQueries.get(key);
	}
	
	/**
	 * <p>Lanza una excepción ModelPersistanceException con la información del modelo <code>md</code> y el fallo indicado en
	 * <code>msg</code>. Si <code>msg</code> el mensaje devuelto es el resultado de invocar <code>e.getMessage()</code>.</p>
	 * @param md Modelo erroneo.
	 * @param e Excepción producida.
	 * @param msg Mensaje complementario.
	 */
	private void throwException(ModelDefinition md, Exception e, String msg) throws ModelPersistanceException{
		throw new ModelPersistanceException(ErrorMessageID.PE_00011,md.getClassName(), msg!=null?msg:e );
	}

	/**
	 * <p>Devuelve el procesador de sentencias insert.</p>
	 * @return procesador de sentencias insert.
	 */
	public SQLInsertProcessor getInsertProcessor() {
		return insertProcessor;
	}

	/**
	 * <p>Devuelve el procesador de sentencias update.</p>
	 * @return procesador de sentencias update.
	 */
	public SQLUpdateProcessor getUpdateProcessor() {
		return updateProcessor;
	}

	/**
	 * <p>Devuelve el procesador de sentencias select.</p>
	 * @return procesador de sentencias select.
	 */
	public SQLSelectProcessor getSelectProcessor() {
		return selectProcessor;
	}

	/**
	 * <p>Devuelve el procesador de sentencias delete.</p>
	 * @return procesador de sentencias delete.
	 */
	public SQLDeleteProcessor getDeleteProcessor() {
		return deleteProcessor;
	}

	/**
	 * <p>Devuelve el proveedor de data source.</p>
	 * @return proveedor de data source.
	 */
	public DataSourceProvider getDataSourceProvider() {
		return dataSourceProvider;
	}

	/**
	 * <p>Devuelve el procesador de sentencias insert.</p>
	 * @return procesador de sentencias insert.
	 */
	public SQLPagination getGlobalPagination() {
		return pagination;
	}

	/**
	 * <p>Devuelve el dialecto de base de datos.</p>
	 * @return dialecto de base de datos.
	 * @see SQLDialect
	 */
	public SQLDialect getDialect() {
		return dialect;
	}
}
