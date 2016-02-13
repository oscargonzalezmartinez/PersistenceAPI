package com.ogm.persistance.test.model;

import com.ogm.persistance.model.KeyGeneratorEnum;
import com.ogm.persistance.model.ValidationEnum;
import com.ogm.persistance.model.annotation.DBColumn;
import com.ogm.persistance.model.annotation.DBSequence;
import com.ogm.persistance.model.annotation.DBTable;
import com.ogm.persistance.model.annotation.DBValidation;


 /**
 * <p>Tabla de base de datos TX_DETALLE_SUCESOS</p>
 * @author OGOMAR01 (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1 $LastChangedRevision: 58878 $ $LastChangedDate: 2009-07-09 09:40:05 +0200 (jue, 09 jul 2009) $
 * Clase autogenerada: 03/12/2008
 * version generador 0.4
 */
@DBTable(table="TX_DETALLE_SUCESOS", pk="NU_TSU_NUMERO_DETALLE", keyGenerator=KeyGeneratorEnum.SEQUENCE)
@DBSequence(name="SEQ_DETALLE_SUCESO")
public class DetalleSuceso implements java.io.Serializable{
		/** Serial Version UID */
		private static final long serialVersionUID = 1938060203L;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TSU_NUMERO_DETALLE</b>. 
		 */ 
		 @DBColumn(column ="NU_TSU_NUMERO_DETALLE") 
		 private java.lang.Long numeroDetalle = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TSU_EXPEDIENTE</b>. 
		 */ 
		 @DBColumn(column ="NU_TSU_EXPEDIENTE") 
		 @DBValidation(validation=ValidationEnum.MANDATORY)
		 private java.lang.Long expediente = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TSU_TIPO_SUCESO</b>. 
		 */ 
		 @DBColumn(column ="NU_TSU_TIPO_SUCESO") 
		 private java.lang.Integer tipoSuceso = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TSU_CODIGO_SUCESO</b>. 
		 */ 
		 @DBColumn(column ="TX_TSU_CODIGO_SUCESO") 
		 @DBValidation(validation=ValidationEnum.MAX_LENGTH,value="2")
		 private java.lang.String codigoSuceso = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TSU_DESCRIPCION</b>. 
		 */ 
		 @DBColumn(column ="TX_TSU_DESCRIPCION") 
		 private java.lang.String descripcion = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TSU_RESPONSABLE</b>. 
		 */ 
		 @DBColumn(column ="TX_TSU_RESPONSABLE") 
		 private java.lang.String responsable = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TSU_USUARIO_REVISION</b>. 
		 */ 
		 @DBColumn(column ="TX_TSU_USUARIO_REVISION") 
		 private java.lang.String usuarioRevision = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TSU_FECHA_SUCESO</b>. 
		 */ 
		 @DBColumn(column ="DA_TSU_FECHA_SUCESO") 
		 private java.util.Date fechaSuceso = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TSU_FECHA_REVISION</b>. 
		 */ 
		 @DBColumn(column ="DA_TSU_FECHA_REVISION") 
		 private java.util.Date fechaRevision = null;
		/**
		 * Atributo desTipoSuceso .
		 */ 
		 @DBColumn(column ="desTipoSuceso",isTransient=true) 
		 private java.lang.String desTipoSuceso = null;
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
		 * Devuelve el valor del atributo <b>tipoSuceso</b>. 
		 * @return valor del atributo <b>tipoSuceso</b>. 
		 */ 
		 public java.lang.Integer getTipoSuceso() { return tipoSuceso; }
		/**
		 * Fija el valor del atributo <b>tipoSuceso</b>. 
		 * @param newTipoSuceso nuevo valor para tipoSuceso.
		 */ 
		 public void setTipoSuceso(java.lang.Integer newTipoSuceso) { tipoSuceso = newTipoSuceso; }
		/**
		 * Devuelve el valor del atributo <b>codigoSuceso</b>. 
		 * @return valor del atributo <b>codigoSuceso</b>. 
		 */ 
		 public java.lang.String getCodigoSuceso() { return codigoSuceso; }
		/**
		 * Fija el valor del atributo <b>codigoSuceso</b>. 
		 * @param newCodigoSuceso nuevo valor para codigoSuceso.
		 */ 
		 public void setCodigoSuceso(java.lang.String newCodigoSuceso) { codigoSuceso = newCodigoSuceso; }
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
		 * Devuelve el valor del atributo <b>responsable</b>. 
		 * @return valor del atributo <b>responsable</b>. 
		 */ 
		 public java.lang.String getResponsable() { return responsable; }
		/**
		 * Fija el valor del atributo <b>responsable</b>. 
		 * @param newResponsable nuevo valor para responsable.
		 */ 
		 public void setResponsable(java.lang.String newResponsable) { responsable = newResponsable; }
		/**
		 * Devuelve el valor del atributo <b>usuarioRevision</b>. 
		 * @return valor del atributo <b>usuarioRevision</b>. 
		 */ 
		 public java.lang.String getUsuarioRevision() { return usuarioRevision; }
		/**
		 * Fija el valor del atributo <b>usuarioRevision</b>. 
		 * @param newUsuarioRevision nuevo valor para usuarioRevision.
		 */ 
		 public void setUsuarioRevision(java.lang.String newUsuarioRevision) { usuarioRevision = newUsuarioRevision; }
		/**
		 * Devuelve el valor del atributo <b>fechaSuceso</b>. 
		 * @return valor del atributo <b>fechaSuceso</b>. 
		 */ 
		 public java.util.Date getFechaSuceso() { return fechaSuceso; }
		/**
		 * Fija el valor del atributo <b>fechaSuceso</b>. 
		 * @param newFechaSuceso nuevo valor para fechaSuceso.
		 */ 
		 public void setFechaSuceso(java.util.Date newFechaSuceso) { fechaSuceso = newFechaSuceso; }
		/**
		 * Devuelve el valor del atributo <b>fechaRevision</b>. 
		 * @return valor del atributo <b>fechaRevision</b>. 
		 */ 
		 public java.util.Date getFechaRevision() { return fechaRevision; }
		/**
		 * Fija el valor del atributo <b>fechaRevision</b>. 
		 * @param newFechaRevision nuevo valor para fechaRevision.
		 */ 
		 public void setFechaRevision(java.util.Date newFechaRevision) { fechaRevision = newFechaRevision; }
		/**
		 * Devuelve el valor del atributo <b>desTipoSuceso</b>. 
		 * @return valor del atributo <b>desTipoSuceso</b>. 
		 */ 
		 public java.lang.String getDesTipoSuceso() { return desTipoSuceso; }
		/**
		 * Fija el valor del atributo <b>desTipoSuceso</b>. 
		 * @param newDesTipoSuceso nuevo valor para desTipoSuceso.
		 */ 
		 public void setDesTipoSuceso(java.lang.String newDesTipoSuceso) { desTipoSuceso = newDesTipoSuceso; }

		 /**
		  * <p>Devuelve la representación en String del objeto.</p>
		  * @return representación en String del objeto.
		  **/
		 public String toString(){
				 StringBuilder out = new StringBuilder();

				 out.append("Class: DetalleSuceso:\n");

				 out.append("numeroDetalle").append("=[").append(numeroDetalle).append("];\n" );
 
				 out.append("expediente").append("=[").append(expediente).append("];\n" );
 
				 out.append("tipoSuceso").append("=[").append(tipoSuceso).append("];\n" );
 
				 out.append("codigoSuceso").append("=[").append(codigoSuceso).append("];\n" );
 
				 out.append("descripcion").append("=[").append(descripcion).append("];\n" );
 
				 out.append("responsable").append("=[").append(responsable).append("];\n" );
 
				 out.append("usuarioRevision").append("=[").append(usuarioRevision).append("];\n" );
 
				 out.append("fechaSuceso").append("=[").append(fechaSuceso).append("];\n" );
 
				 out.append("fechaRevision").append("=[").append(fechaRevision).append("];\n" );
 
				 out.append("desTipoSuceso").append("=[").append(desTipoSuceso).append("];\n" );
 
				 return out.toString();
		}

}