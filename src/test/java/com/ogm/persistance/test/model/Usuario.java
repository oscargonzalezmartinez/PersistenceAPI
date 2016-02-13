package com.ogm.persistance.test.model;

import com.ogm.persistance.model.KeyGeneratorEnum;
import com.ogm.persistance.model.annotation.DBColumn;
import com.ogm.persistance.model.annotation.DBSequence;
import com.ogm.persistance.model.annotation.DBTable;
import com.ogm.persistance.model.annotation.DBRelacion;

/**
 * <p>
 * Tabla de base de datos usuario
 * </p>
 * 
 * @author Oscar (latest modification by $LastChangedBy: Oscar $)
 * @version 1 
 *          version generador 0.4
 */
@DBTable(table = "T_USUARIO", pk = "ID", keyGenerator = KeyGeneratorEnum.SEQUENCE)
@DBSequence(name = "SEC_USUARIO")
public class Usuario implements java.io.Serializable {
	/** Serial Version UID */
	private static final long serialVersionUID = 1938060203L;
	/**
	 * Atributo mapeado a la columna base datos <b>NU_TSU_NUMERO_DETALLE</b>.
	 */
	@DBColumn(column = "ID")
	private java.lang.Long id = null;
	/**
	 * Atributo mapeado a la columna base datos <b>NU_TSU_EXPEDIENTE</b>.
	 */
	@DBColumn(column = "NOMBRE")
	private java.lang.String nombre = null;

	/**
	 * Atributo mapeado a la columna base datos <b>NU_TSU_NUMERO_DETALLE</b>.
	 */
	@DBColumn(column = "EDAD")
	private java.lang.Long edad = null;
	/**
	 * Atributo mapeado a la columna base datos <b>NU_TSU_EXPEDIENTE</b>.
	 */
	@DBColumn(column = "APELLIDOS")
	private java.lang.String apellidos = null;

	@DBRelacion(field="id", targetClass=Detalle.class , targetField="idUsuario" , readOnly = false, lazy = false) 
    private Detalle detalle = null;	 

	@DBRelacion(field="id", targetClass=Proyecto.class , targetField="idUsuario" , readOnly = false, lazy = true) 
    private java.util.List<Proyecto> proyectos = null;	 
	
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public java.lang.String getNombre() {
		return nombre;
	}

	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}

	public java.lang.Long getEdad() {
		return edad;
	}

	public void setEdad(java.lang.Long edad) {
		this.edad = edad;
	}

	public java.lang.String getApellidos() {
		return apellidos;
	}

	public void setApellidos(java.lang.String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}
	
	public Detalle getDetalle() {
		return detalle;
	}
	
	public java.util.List<Proyecto> getProyectos(){
		return proyectos;	 
	}

	public void setProyectos(java.util.List<Proyecto> proyectos){
		this.proyectos = proyectos;	 
	}
	
	@Override
	public String toString() {
		return super.toString() + " [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", apellidos=" + apellidos + "]";
	}

}