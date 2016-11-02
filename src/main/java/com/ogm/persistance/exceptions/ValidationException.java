package com.ogm.persistance.exceptions;

import com.ogm.persistance.util.ErrorMessageID;

/**
 * <p>Esta excepción es lanzada desde los validadores cuando no se supera la validación.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class ValidationException extends PersistanceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -801268904145632581L;
	
	/**
	 * <p>Constructor.</p>
	 * @param message Mensaje de error.
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * <p>Constructor.</p>
	 * @param t Excepci�n original
	 */
	public ValidationException(Throwable t) {
		super(t);
	}

	/**
	 * <p>Constructor que permite crear la excepción con un id de mensaje y los parámetros
	 * necesarios para completar el mensaje.</p>
	 * @param errorMessageID Código del mensaje de error
	 * @param args Número variable de argumentos para completar el mensaje de error.
	 */
	public ValidationException(ErrorMessageID errorMessageID,
			Object... args) {
		super(errorMessageID, args);
	}

	/**
	 * <p>Constructor que permite crear la excepción con un id de mensaje y los parámetros
	 * necesarios para completar el mensaje.</p>
	 * @param errorMessageID código del mensaje de error
	 * @param t Excepción original
	 * @param args variable de argumentos para completar el mensaje de error.
	 */
	public ValidationException(ErrorMessageID errorMessageID,
			Throwable t, Object... args) {
		super(errorMessageID, t, args);
	}

	/**
	 * <p>Constructor que permite crear la excepción con un id de mensaje.</p>
	 * @param errorMessageID código del mensaje de error
	 */
	public ValidationException(ErrorMessageID errorMessageID) {
		super(errorMessageID);
	}

	/**
	 * <p>Constructor.</p>
	 * @param errorMessageID código del mensaje de error
	 * @param t Excepción original
	 */
	public ValidationException(ErrorMessageID errorMessageID, Throwable t) {
		super(errorMessageID, t);
	}
	

}
