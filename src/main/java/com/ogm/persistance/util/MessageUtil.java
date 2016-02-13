package com.ogm.persistance.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.logging.LogFactory;



/**
 * <p>Clase de utilidades para leer los textos de los errores.</p>
 * <p>EL fichero cono los texto es <b>es/caser/po2008/bundle/errors.properties</b> .</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public final class MessageUtil {

	/**
	 * Privado para evitar instanciación. 
	 */
	private MessageUtil(){
		
	}
	
	/**
	 * <p>Almacen de errores.</p>
	 */
	private static Properties errorProperties = new Properties();
	/**
	 * <p>Almacen de mensajes.</p>
	 */
	private static Properties messageProperties = new Properties();
	static{
		try {
			errorProperties.load(	 MessageUtil.class.getClassLoader().getResourceAsStream("com/ogm/persistance/bundle/errors.properties"));
			messageProperties.load(	 MessageUtil.class.getClassLoader().getResourceAsStream("com/ogm/persistance/bundle/app.properties"));
			
		} catch (IOException e) {
			LogFactory.getLog(MessageUtil.class).error("Fichero  no encontrado", e);
		}
	}
	
	/**
	 * <p>Devuelve el mensaje de error que corresponde al código <b>messageID</b>.
	 * @param messageID código del mensaje de error
	 * @return mensaje que corresponde al código <b>messageID</b>
	 */
	public static String getErrorMessage(String messageID){
		String msg = errorProperties.getProperty(messageID);
		if (msg == null){
			return messageID;
		}
		
		return msg;
	}

	/**
	 * <p>Devuelve el mensaje de error que corresponde al código <b>messageID</b>.
	 * @param messageID código del mensaje de error
	 * @return mensaje que corresponde al código <b>messageID</b>
	 */
	public static String getErrorMessage(ErrorMessageID messageID){
		return getErrorMessage(messageID.name());
	}
	
	/**
	 * <p>Mensaje de error completado con los argumentos <b>args</b>.
	 * @param messageID código del mensaje de error
	 * @param args argumentos para completar le mensaje.
	 * @return Mensaje de error completado con los argumentos <b>args</b>.
	 */
	public static String getErrorMessage(ErrorMessageID messageID, Object... args){
		String pattern =  getErrorMessage(messageID.name());
		return MessageFormat.format(pattern, args);
	}
	
	/**
	 * <p>Devuelve el mensaje de aplicación que corresponde al código <b>messageID</b>.
	 * @param messageID código del mensaje.
	 * @return mensaje que corresponde al código <b>messageID</b>
	 */
	public static String getAppMessage(String messageID){
		String msg = messageProperties.getProperty(messageID);
		if (msg == null){
			return messageID;
		}
		
		return msg;
	}
	
	/**
	 * <p>Mensaje de aplicación completado con los argumentos <b>args</b>.
	 * @param messageID código del mensaje.
	 * @param args argumentos para completar le mensaje.
	 * @return Mensaje de aplicación completado con los argumentos <b>args</b>.
	 */
	public static String getAppMessage(String messageID, Object... args){
		String pattern =  getErrorMessage(messageID);
		return MessageFormat.format(pattern, args);
	}
}
