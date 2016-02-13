package com.ogm.persistance.xml;

import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.util.ErrorMessageID;


/**
 * <p>Excepción en el parseo de xml.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public class UnmarshalException extends PersistanceException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1512335257222177986L;

	
	/**
	 * <p>Excepción en el parseo de xml.</p>
	 * @param errorMessageID código de error
	 * @param t excepción producida
	 * @param args argumentos para completar la información.
	 */
	public UnmarshalException(ErrorMessageID errorMessageID,Throwable t,Object... args){
		super(errorMessageID, t,args);

	}

}
