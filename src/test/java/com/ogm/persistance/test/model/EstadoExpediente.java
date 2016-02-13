package com.ogm.persistance.test.model;

import com.ogm.persistance.model.KeyGeneratorEnum;
import com.ogm.persistance.model.annotation.DBColumn;
import com.ogm.persistance.model.annotation.DBSequence;
import com.ogm.persistance.model.annotation.DBTable;
 /**
 * <p>Tabla de base de datos TX_ESTADO_EXPEDIENTE</p>
 * @author OGOMAR01 (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1 $LastChangedRevision: 25529 $ $LastChangedDate: 2009-01-29 13:43:56 +0100 (jue, 29 ene 2009) $
 * Clase autogenerada: 03/12/2008
 * version generador 0.4
 */
@DBTable(table="TX_ESTADO_EXPEDIENTE", pk="NU_TST_NUMERO_DETALLE", keyGenerator=KeyGeneratorEnum.SEQUENCE)
@DBSequence(name="SEQ_ESTADO_EXPEDIENTE")
public class EstadoExpediente implements java.io.Serializable{
		/** Serial Version UID */
		private static final long serialVersionUID = 1947917465L;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TST_NUMERO_DETALLE</b>. 
		 */ 
		 @DBColumn(column ="NU_TST_NUMERO_DETALLE") 
		 private java.lang.Long numeroDetalle = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TST_EXPEDIENTE</b>. 
		 */ 
		 @DBColumn(column ="NU_TST_EXPEDIENTE") 
		 private java.lang.Long expediente = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TST_FECHA_DETALLE</b>. 
		 */ 
		 @DBColumn(column ="DA_TST_FECHA_DETALLE") 
		 private java.util.Date fechaDetalle = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TST_NUMERO_BLOQUE</b>. 
		 */ 
		 @DBColumn(column ="NU_TST_NUMERO_BLOQUE") 
		 private java.lang.Integer numeroBloque = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TST_ESTADO_DETALLE</b>. 
		 */ 
		 @DBColumn(column ="TX_TST_ESTADO_DETALLE") 
		 private java.lang.String estadoDetalle = null;
		/**
		 * Atributo descripcion .
		 */ 
		 @DBColumn(column="descripcion", isTransient=true)
		 private java.lang.String descripcion = null;
		/**
		 * Devuelve el valor del atributo <b>numeroDetalle</b>. 
		 * @return valor del atributo <b>numeroDetalle</b>. 
		 */ 
		 public java.lang.Long getNumeroDetalle() { return numeroDetalle; }
		/**
		 * Fija el valor del atributo <b>numeroDetalle</b>. 
		 * @param newNumeroDetalle nuevo valor para numeroDetalle.
		 */ 
		 public void setNumeroDetalle(java.lang.Long newNumeroDetalle) { numeroDetalle = newNumeroDetalle; }
		/**
		 * Devuelve el valor del atributo <b>expediente</b>. 
		 * @return valor del atributo <b>expediente</b>. 
		 */ 
		 public java.lang.Long getExpediente() { return expediente; }
		/**
		 * Fija el valor del atributo <b>expediente</b>. 
		 * @param newExpediente nuevo valor para expediente.
		 */ 
		 public void setExpediente(java.lang.Long newExpediente) { expediente = newExpediente; }
		/**
		 * Devuelve el valor del atributo <b>fechaDetalle</b>. 
		 * @return valor del atributo <b>fechaDetalle</b>. 
		 */ 
		 public java.util.Date getFechaDetalle() { return fechaDetalle; }
		/**
		 * Fija el valor del atributo <b>fechaDetalle</b>. 
		 * @param newFechaDetalle nuevo valor para fechaDetalle.
		 */ 
		 public void setFechaDetalle(java.util.Date newFechaDetalle) { fechaDetalle = newFechaDetalle; }
		/**
		 * Devuelve el valor del atributo <b>numeroBloque</b>. 
		 * @return valor del atributo <b>numeroBloque</b>. 
		 */ 
		 public java.lang.Integer getNumeroBloque() { return numeroBloque; }
		/**
		 * Fija el valor del atributo <b>numeroBloque</b>. 
		 * @param newNumeroBloque nuevo valor para numeroBloque.
		 */ 
		 public void setNumeroBloque(java.lang.Integer newNumeroBloque) { numeroBloque = newNumeroBloque; }
		/**
		 * Devuelve el valor del atributo <b>estadoDetalle</b>. 
		 * @return valor del atributo <b>estadoDetalle</b>. 
		 */ 
		 public java.lang.String getEstadoDetalle() { return estadoDetalle; }
		/**
		 * Fija el valor del atributo <b>estadoDetalle</b>. 
		 * @param newEstadoDetalle nuevo valor para estadoDetalle.
		 */ 
		 public void setEstadoDetalle(java.lang.String newEstadoDetalle) { estadoDetalle = newEstadoDetalle; }
		/**
		 * Devuelve el valor del atributo <b>descripcion</b>. 
		 * @return valor del atributo <b>descripcion</b>. 
		 */ 
		 public java.lang.String getDescripcion() { return descripcion; }
		/**
		 * Fija el valor del atributo <b>descripcion</b>. 
		 * @param newDescripcion nuevo valor para descripcion.
		 */ 
		 public void setDescripcion(java.lang.String newDescripcion) { descripcion = newDescripcion; }

		 /**
		  * <p>Devuelve la representación en String del objeto.</p>
		  * @return representación en String del objeto.
		  **/
		 public String toString(){
				 StringBuilder out = new StringBuilder();

				 out.append("Class: EstadoExpediente:\n");

				 out.append("numeroDetalle").append("=[").append(numeroDetalle).append("];\n" );
 
				 out.append("expediente").append("=[").append(expediente).append("];\n" );
 
				 out.append("fechaDetalle").append("=[").append(fechaDetalle).append("];\n" );
 
				 out.append("numeroBloque").append("=[").append(numeroBloque).append("];\n" );
 
				 out.append("estadoDetalle").append("=[").append(estadoDetalle).append("];\n" );
 
				 out.append("descripcion").append("=[").append(descripcion).append("];\n" );
 
				 return out.toString();
		}

}