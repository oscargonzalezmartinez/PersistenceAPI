package com.ogm.persistance.test.model;

import com.ogm.persistance.model.KeyGeneratorEnum;
import com.ogm.persistance.model.annotation.DBColumn;
import com.ogm.persistance.model.annotation.DBSequence;
import com.ogm.persistance.model.annotation.DBTable;

/**
 * <p>
 * Tabla de base de datos PROYECTO
 * </p>
 * 
 * @author Oscar (latest modification by $LastChangedBy: Oscar $)
 * @version 1 
 *          version generador 0.4
 */
@DBTable(table = "T_PROYECTO", pk = "ID", keyGenerator = KeyGeneratorEnum.SEQUENCE)
@DBSequence(name = "SEC_PROYECTO")
public class Proyecto implements java.io.Serializable {
	/** Serial Version UID */
	private static final long serialVersionUID = 1938060448L;
	/**
	 * Atributo mapeado a la columna base datos <b>ID</b>.
	 */
	@DBColumn(column = "ID")
	private java.lang.Long id = null;
	
		/**
	 * Atributo mapeado a la columna base datos <b>ID</b>.
	 */
	@DBColumn(column = "ID_USUARIO")
	private java.lang.Long idUsuario = null;
	/**
	 * Atributo mapeado a la columna base datos <b>TEXTO</b>.
	 */
	@DBColumn(column = "TEXTO")
	private java.lang.String texto = null;


	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(java.lang.Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public java.lang.String getTexto() {
		return texto;
	}

	public void setTexto(java.lang.String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", texto=" + texto + "]";
	}

}