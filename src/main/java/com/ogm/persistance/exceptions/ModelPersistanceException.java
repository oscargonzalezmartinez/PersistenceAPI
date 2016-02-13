package com.ogm.persistance.exceptions;

import com.ogm.persistance.util.ErrorMessageID;
/**
 * <p>Excepción lanzada si existen problemas con el modelo.</p>  
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class ModelPersistanceException extends PersistanceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2936245818993251864L;

	public ModelPersistanceException(String message) {
		super(message);
	}

	public ModelPersistanceException(Throwable t) {
		super(t);
	}

	public ModelPersistanceException(ErrorMessageID errorMessageID,
			Object... args) {
		super(errorMessageID, args);
	}

	public ModelPersistanceException(ErrorMessageID errorMessageID,
			Throwable t, Object... args) {
		super(errorMessageID, t, args);
	}

	public ModelPersistanceException(ErrorMessageID errorMessageID) {
		super(errorMessageID);
	}

	public ModelPersistanceException(ErrorMessageID errorMessageID, Throwable t) {
		super(errorMessageID, t);
	}

}
