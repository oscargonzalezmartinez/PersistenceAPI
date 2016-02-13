package com.ogm.persistance.exceptions;

import com.ogm.persistance.util.ErrorMessageID;
import com.ogm.persistance.util.MessageUtil;



/**
 * <p>Excepción lanzada si existen problemas en la interacción con la base de datos.</p>  
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class PersistanceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3896108798208859592L;

	protected ErrorMessageID errorID = null;
	
	public PersistanceException(String message){
		super(message);
	}
	
	public PersistanceException(Throwable t){
		super(t);
	}
	
	public PersistanceException(ErrorMessageID errorMessageID,Object... args){
		super(MessageUtil.getErrorMessage(errorMessageID,args));
		errorID = errorMessageID;
	}
	
	public PersistanceException(ErrorMessageID errorMessageID,Throwable t,Object... args){
		super(MessageUtil.getErrorMessage(errorMessageID,args) , t);
		errorID = errorMessageID;
	}



	public PersistanceException(ErrorMessageID errorMessageID){
		super(MessageUtil.getErrorMessage(errorMessageID));
		errorID = errorMessageID;
	}
	
	public PersistanceException(ErrorMessageID errorMessageID,Throwable t){
		super(MessageUtil.getErrorMessage(errorMessageID) , t);
		errorID = errorMessageID;
	}
	
	public ErrorMessageID getErrorID() {
		return errorID;
	}

	
	
}
