package com.ogm.persistance.sql.processors.impl.proxy;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.model.Relationship;
import com.ogm.persistance.util.ClassUtil;

/**
 * <p>Clase que permite, mediante un proxy, cargar las relaciones del objeto bajo demanda, sólo cuando
 * vayan a ser utilizadas.<p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class ProxyLazyImpl implements MethodHandler,IProxyLazy{
	private static final String LOG_PKG_PROXYLAZY = "es.caser.persistance.proxylazy";
	protected static final Log log =  LogFactory.getLog(LOG_PKG_PROXYLAZY);
//	private boolean updated = false;
	private Class clazz = null;
	private ModelManager modelManager = null;
	private ModelDefinition model = null;
	private ProxyLazyImpl(ModelManager newModelManager,Class newClazz){
		modelManager = newModelManager;
		clazz = newClazz; 
		model = modelManager.getModel(clazz);
	}
	
	public static IProxyLazy newProxyLazy(ModelManager newModelManager, Class newClazz){ 
		ProxyFactory factory = new ProxyFactory();
		if (log.isDebugEnabled()){
			log.debug("Creando proxy para " + newClazz);
		}
		factory.setSuperclass( newClazz);
		Class []interfaces = {IProxyLazy.class};
		factory.setInterfaces( interfaces );
		//factory.setFilter( FINALIZE_FILTER );
		Class cl = factory.createClass();
		try {
			final IProxyLazy proxy = ( IProxyLazy ) cl.newInstance();
			( ( ProxyObject ) proxy ).setHandler( new ProxyLazyImpl(newModelManager,newClazz) );
			
			return  proxy;
		} catch (InstantiationException e) {
			// TODO ERROR!!!
			log.error(e);
		} catch (IllegalAccessException e) {
			// TODO ERROR!!!
			log.error(e);
		}
		return null;
	}
	
	public Object invoke(final Object proxy,
			final Method thisMethod,
			final Method proceed,
			final Object[] args)
			throws Throwable {

		//esto indica invocación sobre el interface
		if (proceed == null){
		}
		
		String methodName = thisMethod.getName();
		if (args == null || args.length == 0){
			if (methodName.startsWith("get")){
				
				Object result = proceed.invoke(proxy, args);
				if (result != null ){//ya está cargado
					return result;
				}
				String property = methodName.substring(3);
				property = String.valueOf(property.charAt(0)).toLowerCase() + property.substring(1);
				Relationship relation = model.getRelations().get(property);
				if (relation!=null){
					result = load(proxy,relation,property);
					ClassUtil.setFieldValueToObject(proxy, property, result);
					return result;
				}
			}
		}
		
		return proceed.invoke(proxy, args);
	}

	private Object load(Object target,Relationship relationship, String field  ){

		if (log.isDebugEnabled()){
			log.debug("Cargando relación " + relationship);
		}
		
		return modelManager.getSelectProcessor().loadRelation(target, field);
	}
}
