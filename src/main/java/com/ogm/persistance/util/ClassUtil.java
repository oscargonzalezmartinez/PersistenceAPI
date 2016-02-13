package com.ogm.persistance.util;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import com.ogm.persistance.exceptions.ModelPersistanceException;
/**
 * <p>clase de utilidades.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 */
public final class ClassUtil {
	
	/**
	 * Privado para evitar instanciación. 
	 */
	private ClassUtil(){
	}
	
	/**
	 * caracter '/'.
	 */
	private static final char SLASH = '/';
	/**
	 * caracter '.'.
	 */
	private static final char DOT = '.';
	/**
	 * <p>Instancia un nuevo objeto de la clase <code>clazzName</code>.</p>
	 * @param clazzName Nombre de la clase a instanciar
	 * @return Nuevo objeto de la clase  <code>clazzName</code>.
	 */
	public static Object newInstance(String clazzName){
		try {
			return Class.forName(clazzName).newInstance();
		} catch (InstantiationException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00001,e,clazzName);
		} catch (IllegalAccessException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00001,e,clazzName);
		} catch (ClassNotFoundException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00001,e,clazzName);
		}
	}
	
	/**
	 * <p>Devuelve el paquete de la clase.</p>
	 * @param clazz clase de la que se queire obtener el paquete.
	 * @return Devuelve el paquete de la clase.
	 */
	public static String getPackageName(Class clazz){
		return clazz.getPackage().getName().replace(DOT, SLASH);
	}

	/**
	 * <p>.</p>
	 * @param clazz
	 * @param resourceName
	 * @return
	 */
	public static InputStream getResourceInPackageName(Class clazz, String resourceName){
		return clazz.getClassLoader().getResourceAsStream(new StringBuilder(getPackageName(clazz)).append("/").append(resourceName).toString());
	}
	
	/**
	 * @param obj
	 * @param field
	 * @return
	 */
	public static Object getFieldValueFromObject(Object obj, String field){

		try {
			checkAcces(obj, field);
			
			return PropertyUtils.getSimpleProperty(obj, field);
		} catch (IllegalAccessException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00002,e,field,obj.getClass().getName());
		} catch (InvocationTargetException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00002,e,field,obj.getClass().getName());
		} catch (NoSuchMethodException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00002,e,field,obj.getClass().getName());
		}
	}

	/**
	 * Invoca al método setfield sobre el objeto <code>obj</code> con el valor <code>value</code>.
	 * @param obj Objeto.
	 * @param field Atributo.
	 * @param value Valor.
	 */
	public static void setFieldValueToObject(Object obj, String field, Object value){

		try {
			
			if (obj == null || field == null || value == null){
				return;
			}
			BeanUtils.setProperty(obj, field, value);
		} catch (IllegalAccessException e) {
			throw new  ModelPersistanceException(ErrorMessageID.PE_00022,e,field,obj.getClass());
		} catch (InvocationTargetException e) {
			throw new  ModelPersistanceException(ErrorMessageID.PE_00022,e,field,obj.getClass());
		} 
	}
	
	/**
	 * <p>Lanza una exceción si <code>obj</code> o <code>field</code> son nulos.</p>
	 * @param obj Objeto
	 * @param field atributo
	 * @throws  ModelPersistanceException
	 */
	private static void checkAcces(Object obj, String field) {
		if (obj == null){
			throw new ModelPersistanceException(ErrorMessageID.MO_00003,field);
		}
		
		if (field == null){
			throw new ModelPersistanceException(ErrorMessageID.MO_00004,obj);
		}
	}

	/**
	 * <p>Devuelve true si el atributo <code>field</code> del obejto <code>obj</code> es List.</p>
	 * @param obj
	 * @param field campo que queremos comprobar.
	 * @return true si el atributo <code>field</code> del obejto <code>obj</code> es List.
	 */
	public static boolean isList(Object obj, String field){
		try {
			checkAcces(obj, field);
			Class clazz = PropertyUtils.getPropertyType(obj, field);
			return clazz.isAssignableFrom(List.class);
		} catch (IllegalAccessException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00002,e,field,obj.getClass().getName());
		} catch (InvocationTargetException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00002,e,field,obj.getClass().getName());
		} catch (NoSuchMethodException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00002,e,field,obj.getClass().getName());
		}
		
	}
	
	public static Class getClass(String clazzName){
		try {
			return Class.forName(clazzName);
		} catch (ClassNotFoundException e) {
			throw new ModelPersistanceException(ErrorMessageID.MO_00001,e,clazzName);
		}
	}

}
