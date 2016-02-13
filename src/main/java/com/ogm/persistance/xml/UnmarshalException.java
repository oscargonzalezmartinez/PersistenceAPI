package com.ogm.persistance.xml;

import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.util.ErrorMessageID;


/**
 * <p>Excepci�n en el parseo de xml.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
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
	 * <p>Excepci�n en el parseo de xml.</p>
	 * @param errorMessageID c�digo de error
	 * @param t excepci�n producida
	 * @param args argumentos para completar la informaci�n.
	 */
	public UnmarshalException(ErrorMessageID errorMessageID,Throwable t,Object... args){
		super(errorMessageID, t,args);

	}

}
