package com.ogm.persistance.util;

/**
 * <p>Enumerado con los c�digos de error del motor de persistencia.</p>
 * @author Oscar Gonz�lez (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 *
 */
public enum ErrorMessageID {
	//Errores de los DAOs
	
	/**
	 * Error al ejecutar sentencia: c�digo log [{0}].
	 */
	PE_00000,
	/**
	 * Se esperaba un �nico registro de la tabla {0}.
	 */
	PE_00001,
	/**
	 * Error a especificar {0}.
	 */
	PE_00002,
	/**
	 * No se ha podido acceder al Data Source {0}.
	 */
	PE_00003,
	/**
	 * El contexto inicial es nulo. No se puede acceder al Data Source {0}.
	 */
	PE_00004,
	/**
	 * No se puede actualizar el objeto de tipo {0}, el campo {1} de clave primaria es nulo.
	 */
	PE_00008,
	/**
	 * El objeto de tipo {0}, con clave primaria {1} no tiene informado ning�n campo, 
	 * por lo tanto no se va a ejecutar el UPDATE din�mico.
	 */
	PE_00009,
	/**
	 * El fichero de configuraci�n [{0}] indica el uso de clases anotadas, pero el modelo definido en [{1}] 
	 * no es una clase anotada.
	 */
	PE_00010,
	/**
	 * Error en validaci�n de modelo de la clase [{0}]. Detalles: {1}. 
	 */
	PE_00011,
	
	/**
	 * Se ha de indicar un modelo de salida para {0}.
	 */
	PE_00012,
	
	/**
	 * El atributo [{0}] de la clase [{1}] no est� mapeado.
	 */
	PE_00013,
	/**
	 * No se ha indicado un from para la query {0}.
	 */
	PE_00014,
	/**
	 * Hay m�s de un from. Se han de indicar qu� campos se quieren recuperar. Query {0}.
	 */
	PE_00015,
	/**
	 * No se ha indicado un modelo de salida de la query, al tener m�s de una tabla no se puede asignar uno autom�ticamente: {0}.
	 */
	PE_00016,
	/**
	 * Error procesando la named query {0}:\n{1}.
	 */
	PE_00017,
	
	/**
	 * La clase {0} no est� configurada en {1} por lo que no es persistente. 
	 */
	PE_00018,
	
	/**
	 * No hay definido un transaction manager.
	 */
	PE_00020,

	/**
	 * La condici�n para el atributo {0} no tiene indicado la clase a la que pertenece.
	 */
	PE_00021,
	
	/**
	 * No se ha podido fijar el valor del atributo {0} de la clase {1}.
	 */
	PE_00022,
	
	/**
	 * No existe query con id [{0}].
	 */
	PE_00023, 
	
	//Errores con XML
	/**
	 *  Error al intentar transformar un objeto en xml. Detalles: {0}.
	 */
	XML000001,
	/**
	 * Error al intentar transformar un xml en objeto. Detalles: {0}.
	 */
	XML000002,
	/**
	 * El objeto a transformar en xml es nulo.
	 */
	XML000003,
	
	
	/**
	 * El campo [{0}] de la clase [{1}] es obligatorio: {2}.
	 */
	VA_00001,
	/**
	 * El campo [{0}] de la clase [{1}] tiene una longitud superior a [{2}]: {3}.
	 */
	VA_00002,	
	
	/**
	 * No se ha podido crear un objeto de la clase {0} 
	 */
	MO_00001,
	
	/**
	 * No se ha podido obtener el valor del atributo {0} de un objeto de la la clase {1}
	 */
	MO_00002, 
	
	/**
	 * No se puede acceder a un atributo ({0}) de un objeto nulo.
	 */
	MO_00003,
	/**
	 * No se puede acceder a un atributo sin nombre del objeto.
	 */
	MO_00004,
	
	/**
	 * No se ha podido obtener el tipo del atributo {0} de un objeto de la la clase {1}
	 */
	MO_00005,
	
	
	/**
	 * No se ha encontrado el fichero de mapeo para {0}
	 */
	MO_00006,
	
	/**
	 * La clase [{0}] no se ha encontrado a la hora de modificar su bytecode.
	 */
	EH_00001,
	
	/**
	 * La clase [{0}] no se ha podido compilar despu�s de modificar su bytecode.
	 */
	EH_00002 
	
}
