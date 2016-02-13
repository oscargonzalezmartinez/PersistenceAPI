package com.ogm.persistance.sql.util;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLFunction;
import com.ogm.persistance.sql.conditions.render.IConditionRender;
import com.ogm.persistance.sql.conditions.render.IFunctionRender;
import com.ogm.persistance.util.ClassUtil;

/**
 * <p>Factory para los renders de condiciones. La única finalidad de este factory es
 * reutilizar las intancias de los renders.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public final class RenderFactory {

	/**
	 * Privado para evitar instanciación. 
	 */
	private RenderFactory(){
	}
	
	private static XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("/"+ClassUtil.getPackageName(RenderFactory.class) + "/renders.xml", RenderFactory.class));

	
	/**
	 * <p>Devuelve una instancia del obejto de id <code>id</code> de la cache. Si no la encuetra la crea</p>.
	 * @param id Identificador de la clase
	 * @return instancia del obejto de id <code>id</code>
	 */
	private static Object getCachedObject(String id){
		return bf.getBean(id);
	}
	
	/**
	 * <p>Devuelve una instancia de IConditionRenderer capaz de generar el sql para  <code>condition</code>.</p>
	 * @param condition  condición.
	 * @return instancia de IConditionRenderer capaz de generar el sql para  <code>condition</code>.
	 */
	public static IConditionRender getConditionRenderer(Class<? extends SQLCondition> condition){
		return (IConditionRender) getCachedObject(condition.getName());
	}

	/**
	 * <p>Devuelve una instancia de IFunctionRenderer de la clase <code>clazz</code>.</p>
	 * @param function Clase del IFunctionRenderer.
	 * @return instancia de IFunctionRenderer de la clase <code>function</code>.
	 */
	public static IFunctionRender getFunctionRenderer(SQLFunction function){
		return (IFunctionRender) getCachedObject(function.getFunction().replace(' ', '_'));
	}
}
