package com.ogm.persistance.test.model;

import com.ogm.persistance.model.KeyGeneratorEnum;
import com.ogm.persistance.model.annotation.DBColumn;
import com.ogm.persistance.model.annotation.DBSequence;
import com.ogm.persistance.model.annotation.DBTable;


 /**
 * <p>Tabla de base de datos TX_EXPEDIENTES.</p>
 * @author OGOMAR01 (latest modification by $LastChangedBy$)
 * @version 1 $LastChangedRevision$ $LastChangedDate$
 * Clase autogenerada: 10/06/2009
 * version generador 0.4
 */
@DBTable(table="TX_EXPEDIENTES", pk="NU_TEX_EXPEDIENTE", keyGenerator=KeyGeneratorEnum.SEQUENCE)
@DBSequence(name="SEQ_EXPEDIENTES") 
public class Expediente implements java.io.Serializable{
		/** Serial Version UID. */
		private static final long serialVersionUID = 316708755L;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_EXPEDIENTE</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_EXPEDIENTE") 
		 private java.lang.Long expediente = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_TIPO_PROCESO</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_TIPO_PROCESO") 
		 private java.lang.Integer tipoProceso = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_TIPO_TAREA</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_TIPO_TAREA") 
		 private java.lang.Integer tipoTarea = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TEX_INICIO_EXPED</b>. 
		 */ 
		 @DBColumn(column ="DA_TEX_INICIO_EXPED") 
		 private java.util.Date inicioExped = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TEX_FIN_EXPED</b>. 
		 */ 
		 @DBColumn(column ="DA_TEX_FIN_EXPED") 
		 private java.util.Date finExped = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_CLIENTE</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_CLIENTE") 
		 private java.lang.Long cliente = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_NEGOCIO</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_NEGOCIO") 
		 private java.lang.String negocio = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_DISTRIBUIDOR</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_DISTRIBUIDOR") 
		 private java.lang.String distribuidor = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_PUNTO_VENTA</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_PUNTO_VENTA") 
		 private java.lang.String puntoVenta = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_ORIGEN_PETICION</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_ORIGEN_PETICION") 
		 private java.lang.String origenPeticion = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_PROYECTO_WEB</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_PROYECTO_WEB") 
		 private java.lang.Long proyectoWeb = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_PROPUESTA_SVG</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_PROPUESTA_SVG") 
		 private java.lang.Long propuestaSvg = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_PROTOCOLO</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_PROTOCOLO") 
		 private java.lang.String protocolo = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_VERSION_PROTOCOLO</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_VERSION_PROTOCOLO") 
		 private java.lang.Integer versionProtocolo = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_CIA</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_CIA") 
		 private java.lang.String cia = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_RAMO</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_RAMO") 
		 private java.lang.String ramo = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_MODALIDAD</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_MODALIDAD") 
		 private java.lang.String modalidad = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_SUBMODALIDAD</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_SUBMODALIDAD") 
		 private java.lang.String submodalidad = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_PRODUCTO</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_PRODUCTO") 
		 private java.lang.String producto = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_POLIZA</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_POLIZA") 
		 private java.lang.String poliza = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_CERTIFICADO</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_CERTIFICADO") 
		 private java.lang.String certificado = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_NUMERO_MOVIMIENTO</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_NUMERO_MOVIMIENTO") 
		 private java.lang.Integer numeroMovimiento = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TEX_FECHA_EMISION_MOV</b>. 
		 */ 
		 @DBColumn(column ="DA_TEX_FECHA_EMISION_MOV") 
		 private java.util.Date fechaEmisionMov = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TEX_FECHA_EFECTO_POLIZA</b>. 
		 */ 
		 @DBColumn(column ="DA_TEX_FECHA_EFECTO_POLIZA") 
		 private java.util.Date fechaEfectoPoliza = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_ESTADO_EMISION</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_ESTADO_EMISION") 
		 private java.lang.String estadoEmision = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_RECIBO_SVG</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_RECIBO_SVG") 
		 private java.lang.Long reciboSvg = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_CIA_RECIBO</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_CIA_RECIBO") 
		 private java.lang.String ciaRecibo = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_RECIBO_AS400</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_RECIBO_AS400") 
		 private java.lang.Integer reciboAs400 = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TEX_FECHA_RECIBO</b>. 
		 */ 
		 @DBColumn(column ="DA_TEX_FECHA_RECIBO") 
		 private java.util.Date fechaRecibo = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_APLICACION_IMPR</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_APLICACION_IMPR") 
		 private java.lang.String aplicacionImpr = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_ANIO_IMPR</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_ANIO_IMPR") 
		 private java.lang.Integer anioImpr = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_NUMERO_ORDEN_IMPR</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_NUMERO_ORDEN_IMPR") 
		 private java.lang.Long numeroOrdenImpr = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TEX_FECHA_ORDEN_IMPR</b>. 
		 */ 
		 @DBColumn(column ="DA_TEX_FECHA_ORDEN_IMPR") 
		 private java.util.Date fechaOrdenImpr = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TEX_FECHA_IMPR</b>. 
		 */ 
		 @DBColumn(column ="DA_TEX_FECHA_IMPR") 
		 private java.util.Date fechaImpr = null;
		/**
		 * Atributo mapeado a la columna base datos <b>DA_TEX_FECHA_ARCHIVADO</b>. 
		 */ 
		 @DBColumn(column ="DA_TEX_FECHA_ARCHIVADO") 
		 private java.util.Date fechaArchivado = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_INSTANCIA_BPM</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_INSTANCIA_BPM") 
		 private java.lang.String instanciaBpm = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_HISTORICO_INTERVINIENTE</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_HISTORICO_INTERVINIENTE") 
		 private java.lang.Long historicoInterviniente = null;
		/**
		 * Atributo mapeado a la columna base datos <b>NU_TEX_HISTORICO_PERSONAL</b>. 
		 */ 
		 @DBColumn(column ="NU_TEX_HISTORICO_PERSONAL") 
		 private java.lang.Long historicoPersonal = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_ESTADO_EXPEDIENTE</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_ESTADO_EXPEDIENTE") 
		 private java.lang.String estadoExpediente = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_CONVERSATION_ID_BPM</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_CONVERSATION_ID_BPM") 
		 private java.lang.String conversationIdBpm = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_DESC_DISTRIBUIDOR</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_DESC_DISTRIBUIDOR") 
		 private java.lang.String descDistribuidor = null;
		/**
		 * Atributo mapeado a la columna base datos <b>TX_TEX_NIF_CLIENTE</b>. 
		 */ 
		 @DBColumn(column ="TX_TEX_NIF_CLIENTE") 
		 private java.lang.String nifCliente = null;
		/**
		 * Atributo <b>agencia</b>. No mapeado a BBDD.
		 */ 
		 private java.lang.String agencia = null;
		/**
		 * Atributo <b>agente</b>. No mapeado a BBDD.
		 */ 
		 private java.lang.String agente = null;
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
		 * Devuelve el valor del atributo <b>tipoProceso</b>. 
		 * @return valor del atributo <b>tipoProceso</b>. 
		 */ 
		 public java.lang.Integer getTipoProceso() { return tipoProceso; }
		/**
		 * Fija el valor del atributo <b>tipoProceso</b>. 
		 * @param newTipoProceso nuevo valor para tipoProceso.
		 */ 
		 public void setTipoProceso(java.lang.Integer newTipoProceso) { tipoProceso = newTipoProceso; }
		/**
		 * Devuelve el valor del atributo <b>tipoTarea</b>. 
		 * @return valor del atributo <b>tipoTarea</b>. 
		 */ 
		 public java.lang.Integer getTipoTarea() { return tipoTarea; }
		/**
		 * Fija el valor del atributo <b>tipoTarea</b>. 
		 * @param newTipoTarea nuevo valor para tipoTarea.
		 */ 
		 public void setTipoTarea(java.lang.Integer newTipoTarea) { tipoTarea = newTipoTarea; }
		/**
		 * Devuelve el valor del atributo <b>inicioExped</b>. 
		 * @return valor del atributo <b>inicioExped</b>. 
		 */ 
		 public java.util.Date getInicioExped() { return inicioExped; }
		/**
		 * Fija el valor del atributo <b>inicioExped</b>. 
		 * @param newInicioExped nuevo valor para inicioExped.
		 */ 
		 public void setInicioExped(java.util.Date newInicioExped) { inicioExped = newInicioExped; }
		/**
		 * Devuelve el valor del atributo <b>finExped</b>. 
		 * @return valor del atributo <b>finExped</b>. 
		 */ 
		 public java.util.Date getFinExped() { return finExped; }
		/**
		 * Fija el valor del atributo <b>finExped</b>. 
		 * @param newFinExped nuevo valor para finExped.
		 */ 
		 public void setFinExped(java.util.Date newFinExped) { finExped = newFinExped; }
		/**
		 * Devuelve el valor del atributo <b>cliente</b>. 
		 * @return valor del atributo <b>cliente</b>. 
		 */ 
		 public java.lang.Long getCliente() { return cliente; }
		/**
		 * Fija el valor del atributo <b>cliente</b>. 
		 * @param newCliente nuevo valor para cliente.
		 */ 
		 public void setCliente(java.lang.Long newCliente) { cliente = newCliente; }
		/**
		 * Devuelve el valor del atributo <b>negocio</b>. 
		 * @return valor del atributo <b>negocio</b>. 
		 */ 
		 public java.lang.String getNegocio() { return negocio; }
		/**
		 * Fija el valor del atributo <b>negocio</b>. 
		 * @param newNegocio nuevo valor para negocio.
		 */ 
		 public void setNegocio(java.lang.String newNegocio) { negocio = newNegocio; }
		/**
		 * Devuelve el valor del atributo <b>distribuidor</b>. 
		 * @return valor del atributo <b>distribuidor</b>. 
		 */ 
		 public java.lang.String getDistribuidor() { return distribuidor; }
		/**
		 * Fija el valor del atributo <b>distribuidor</b>. 
		 * @param newDistribuidor nuevo valor para distribuidor.
		 */ 
		 public void setDistribuidor(java.lang.String newDistribuidor) { distribuidor = newDistribuidor; }
		/**
		 * Devuelve el valor del atributo <b>puntoVenta</b>. 
		 * @return valor del atributo <b>puntoVenta</b>. 
		 */ 
		 public java.lang.String getPuntoVenta() { return puntoVenta; }
		/**
		 * Fija el valor del atributo <b>puntoVenta</b>. 
		 * @param newPuntoVenta nuevo valor para puntoVenta.
		 */ 
		 public void setPuntoVenta(java.lang.String newPuntoVenta) { puntoVenta = newPuntoVenta; }
		/**
		 * Devuelve el valor del atributo <b>origenPeticion</b>. 
		 * @return valor del atributo <b>origenPeticion</b>. 
		 */ 
		 public java.lang.String getOrigenPeticion() { return origenPeticion; }
		/**
		 * Fija el valor del atributo <b>origenPeticion</b>. 
		 * @param newOrigenPeticion nuevo valor para origenPeticion.
		 */ 
		 public void setOrigenPeticion(java.lang.String newOrigenPeticion) { origenPeticion = newOrigenPeticion; }
		/**
		 * Devuelve el valor del atributo <b>proyectoWeb</b>. 
		 * @return valor del atributo <b>proyectoWeb</b>. 
		 */ 
		 public java.lang.Long getProyectoWeb() { return proyectoWeb; }
		/**
		 * Fija el valor del atributo <b>proyectoWeb</b>. 
		 * @param newProyectoWeb nuevo valor para proyectoWeb.
		 */ 
		 public void setProyectoWeb(java.lang.Long newProyectoWeb) { proyectoWeb = newProyectoWeb; }
		/**
		 * Devuelve el valor del atributo <b>propuestaSvg</b>. 
		 * @return valor del atributo <b>propuestaSvg</b>. 
		 */ 
		 public java.lang.Long getPropuestaSvg() { return propuestaSvg; }
		/**
		 * Fija el valor del atributo <b>propuestaSvg</b>. 
		 * @param newPropuestaSvg nuevo valor para propuestaSvg.
		 */ 
		 public void setPropuestaSvg(java.lang.Long newPropuestaSvg) { propuestaSvg = newPropuestaSvg; }
		/**
		 * Devuelve el valor del atributo <b>protocolo</b>. 
		 * @return valor del atributo <b>protocolo</b>. 
		 */ 
		 public java.lang.String getProtocolo() { return protocolo; }
		/**
		 * Fija el valor del atributo <b>protocolo</b>. 
		 * @param newProtocolo nuevo valor para protocolo.
		 */ 
		 public void setProtocolo(java.lang.String newProtocolo) { protocolo = newProtocolo; }
		/**
		 * Devuelve el valor del atributo <b>versionProtocolo</b>. 
		 * @return valor del atributo <b>versionProtocolo</b>. 
		 */ 
		 public java.lang.Integer getVersionProtocolo() { return versionProtocolo; }
		/**
		 * Fija el valor del atributo <b>versionProtocolo</b>. 
		 * @param newVersionProtocolo nuevo valor para versionProtocolo.
		 */ 
		 public void setVersionProtocolo(java.lang.Integer newVersionProtocolo) { versionProtocolo = newVersionProtocolo; }
		/**
		 * Devuelve el valor del atributo <b>cia</b>. 
		 * @return valor del atributo <b>cia</b>. 
		 */ 
		 public java.lang.String getCia() { return cia; }
		/**
		 * Fija el valor del atributo <b>cia</b>. 
		 * @param newCia nuevo valor para cia.
		 */ 
		 public void setCia(java.lang.String newCia) { cia = newCia; }
		/**
		 * Devuelve el valor del atributo <b>ramo</b>. 
		 * @return valor del atributo <b>ramo</b>. 
		 */ 
		 public java.lang.String getRamo() { return ramo; }
		/**
		 * Fija el valor del atributo <b>ramo</b>. 
		 * @param newRamo nuevo valor para ramo.
		 */ 
		 public void setRamo(java.lang.String newRamo) { ramo = newRamo; }
		/**
		 * Devuelve el valor del atributo <b>modalidad</b>. 
		 * @return valor del atributo <b>modalidad</b>. 
		 */ 
		 public java.lang.String getModalidad() { return modalidad; }
		/**
		 * Fija el valor del atributo <b>modalidad</b>. 
		 * @param newModalidad nuevo valor para modalidad.
		 */ 
		 public void setModalidad(java.lang.String newModalidad) { modalidad = newModalidad; }
		/**
		 * Devuelve el valor del atributo <b>submodalidad</b>. 
		 * @return valor del atributo <b>submodalidad</b>. 
		 */ 
		 public java.lang.String getSubmodalidad() { return submodalidad; }
		/**
		 * Fija el valor del atributo <b>submodalidad</b>. 
		 * @param newSubmodalidad nuevo valor para submodalidad.
		 */ 
		 public void setSubmodalidad(java.lang.String newSubmodalidad) { submodalidad = newSubmodalidad; }
		/**
		 * Devuelve el valor del atributo <b>producto</b>. 
		 * @return valor del atributo <b>producto</b>. 
		 */ 
		 public java.lang.String getProducto() { return producto; }
		/**
		 * Fija el valor del atributo <b>producto</b>. 
		 * @param newProducto nuevo valor para producto.
		 */ 
		 public void setProducto(java.lang.String newProducto) { producto = newProducto; }
		/**
		 * Devuelve el valor del atributo <b>poliza</b>. 
		 * @return valor del atributo <b>poliza</b>. 
		 */ 
		 public java.lang.String getPoliza() { return poliza; }
		/**
		 * Fija el valor del atributo <b>poliza</b>. 
		 * @param newPoliza nuevo valor para poliza.
		 */ 
		 public void setPoliza(java.lang.String newPoliza) { poliza = newPoliza; }
		/**
		 * Devuelve el valor del atributo <b>certificado</b>. 
		 * @return valor del atributo <b>certificado</b>. 
		 */ 
		 public java.lang.String getCertificado() { return certificado; }
		/**
		 * Fija el valor del atributo <b>certificado</b>. 
		 * @param newCertificado nuevo valor para certificado.
		 */ 
		 public void setCertificado(java.lang.String newCertificado) { certificado = newCertificado; }
		/**
		 * Devuelve el valor del atributo <b>numeroMovimiento</b>. 
		 * @return valor del atributo <b>numeroMovimiento</b>. 
		 */ 
		 public java.lang.Integer getNumeroMovimiento() { return numeroMovimiento; }
		/**
		 * Fija el valor del atributo <b>numeroMovimiento</b>. 
		 * @param newNumeroMovimiento nuevo valor para numeroMovimiento.
		 */ 
		 public void setNumeroMovimiento(java.lang.Integer newNumeroMovimiento) { numeroMovimiento = newNumeroMovimiento; }
		/**
		 * Devuelve el valor del atributo <b>fechaEmisionMov</b>. 
		 * @return valor del atributo <b>fechaEmisionMov</b>. 
		 */ 
		 public java.util.Date getFechaEmisionMov() { return fechaEmisionMov; }
		/**
		 * Fija el valor del atributo <b>fechaEmisionMov</b>. 
		 * @param newFechaEmisionMov nuevo valor para fechaEmisionMov.
		 */ 
		 public void setFechaEmisionMov(java.util.Date newFechaEmisionMov) { fechaEmisionMov = newFechaEmisionMov; }
		/**
		 * Devuelve el valor del atributo <b>fechaEfectoPoliza</b>. 
		 * @return valor del atributo <b>fechaEfectoPoliza</b>. 
		 */ 
		 public java.util.Date getFechaEfectoPoliza() { return fechaEfectoPoliza; }
		/**
		 * Fija el valor del atributo <b>fechaEfectoPoliza</b>. 
		 * @param newFechaEfectoPoliza nuevo valor para fechaEfectoPoliza.
		 */ 
		 public void setFechaEfectoPoliza(java.util.Date newFechaEfectoPoliza) { fechaEfectoPoliza = newFechaEfectoPoliza; }
		/**
		 * Devuelve el valor del atributo <b>estadoEmision</b>. 
		 * @return valor del atributo <b>estadoEmision</b>. 
		 */ 
		 public java.lang.String getEstadoEmision() { return estadoEmision; }
		/**
		 * Fija el valor del atributo <b>estadoEmision</b>. 
		 * @param newEstadoEmision nuevo valor para estadoEmision.
		 */ 
		 public void setEstadoEmision(java.lang.String newEstadoEmision) { estadoEmision = newEstadoEmision; }
		/**
		 * Devuelve el valor del atributo <b>reciboSvg</b>. 
		 * @return valor del atributo <b>reciboSvg</b>. 
		 */ 
		 public java.lang.Long getReciboSvg() { return reciboSvg; }
		/**
		 * Fija el valor del atributo <b>reciboSvg</b>. 
		 * @param newReciboSvg nuevo valor para reciboSvg.
		 */ 
		 public void setReciboSvg(java.lang.Long newReciboSvg) { reciboSvg = newReciboSvg; }
		/**
		 * Devuelve el valor del atributo <b>ciaRecibo</b>. 
		 * @return valor del atributo <b>ciaRecibo</b>. 
		 */ 
		 public java.lang.String getCiaRecibo() { return ciaRecibo; }
		/**
		 * Fija el valor del atributo <b>ciaRecibo</b>. 
		 * @param newCiaRecibo nuevo valor para ciaRecibo.
		 */ 
		 public void setCiaRecibo(java.lang.String newCiaRecibo) { ciaRecibo = newCiaRecibo; }
		/**
		 * Devuelve el valor del atributo <b>reciboAs400</b>. 
		 * @return valor del atributo <b>reciboAs400</b>. 
		 */ 
		 public java.lang.Integer getReciboAs400() { return reciboAs400; }
		/**
		 * Fija el valor del atributo <b>reciboAs400</b>. 
		 * @param newReciboAs400 nuevo valor para reciboAs400.
		 */ 
		 public void setReciboAs400(java.lang.Integer newReciboAs400) { reciboAs400 = newReciboAs400; }
		/**
		 * Devuelve el valor del atributo <b>fechaRecibo</b>. 
		 * @return valor del atributo <b>fechaRecibo</b>. 
		 */ 
		 public java.util.Date getFechaRecibo() { return fechaRecibo; }
		/**
		 * Fija el valor del atributo <b>fechaRecibo</b>. 
		 * @param newFechaRecibo nuevo valor para fechaRecibo.
		 */ 
		 public void setFechaRecibo(java.util.Date newFechaRecibo) { fechaRecibo = newFechaRecibo; }
		/**
		 * Devuelve el valor del atributo <b>aplicacionImpr</b>. 
		 * @return valor del atributo <b>aplicacionImpr</b>. 
		 */ 
		 public java.lang.String getAplicacionImpr() { return aplicacionImpr; }
		/**
		 * Fija el valor del atributo <b>aplicacionImpr</b>. 
		 * @param newAplicacionImpr nuevo valor para aplicacionImpr.
		 */ 
		 public void setAplicacionImpr(java.lang.String newAplicacionImpr) { aplicacionImpr = newAplicacionImpr; }
		/**
		 * Devuelve el valor del atributo <b>anioImpr</b>. 
		 * @return valor del atributo <b>anioImpr</b>. 
		 */ 
		 public java.lang.Integer getAnioImpr() { return anioImpr; }
		/**
		 * Fija el valor del atributo <b>anioImpr</b>. 
		 * @param newAnioImpr nuevo valor para anioImpr.
		 */ 
		 public void setAnioImpr(java.lang.Integer newAnioImpr) { anioImpr = newAnioImpr; }
		/**
		 * Devuelve el valor del atributo <b>numeroOrdenImpr</b>. 
		 * @return valor del atributo <b>numeroOrdenImpr</b>. 
		 */ 
		 public java.lang.Long getNumeroOrdenImpr() { return numeroOrdenImpr; }
		/**
		 * Fija el valor del atributo <b>numeroOrdenImpr</b>. 
		 * @param newNumeroOrdenImpr nuevo valor para numeroOrdenImpr.
		 */ 
		 public void setNumeroOrdenImpr(java.lang.Long newNumeroOrdenImpr) { numeroOrdenImpr = newNumeroOrdenImpr; }
		/**
		 * Devuelve el valor del atributo <b>fechaOrdenImpr</b>. 
		 * @return valor del atributo <b>fechaOrdenImpr</b>. 
		 */ 
		 public java.util.Date getFechaOrdenImpr() { return fechaOrdenImpr; }
		/**
		 * Fija el valor del atributo <b>fechaOrdenImpr</b>. 
		 * @param newFechaOrdenImpr nuevo valor para fechaOrdenImpr.
		 */ 
		 public void setFechaOrdenImpr(java.util.Date newFechaOrdenImpr) { fechaOrdenImpr = newFechaOrdenImpr; }
		/**
		 * Devuelve el valor del atributo <b>fechaImpr</b>. 
		 * @return valor del atributo <b>fechaImpr</b>. 
		 */ 
		 public java.util.Date getFechaImpr() { return fechaImpr; }
		/**
		 * Fija el valor del atributo <b>fechaImpr</b>. 
		 * @param newFechaImpr nuevo valor para fechaImpr.
		 */ 
		 public void setFechaImpr(java.util.Date newFechaImpr) { fechaImpr = newFechaImpr; }
		/**
		 * Devuelve el valor del atributo <b>fechaArchivado</b>. 
		 * @return valor del atributo <b>fechaArchivado</b>. 
		 */ 
		 public java.util.Date getFechaArchivado() { return fechaArchivado; }
		/**
		 * Fija el valor del atributo <b>fechaArchivado</b>. 
		 * @param newFechaArchivado nuevo valor para fechaArchivado.
		 */ 
		 public void setFechaArchivado(java.util.Date newFechaArchivado) { fechaArchivado = newFechaArchivado; }
		/**
		 * Devuelve el valor del atributo <b>instanciaBpm</b>. 
		 * @return valor del atributo <b>instanciaBpm</b>. 
		 */ 
		 public java.lang.String getInstanciaBpm() { return instanciaBpm; }
		/**
		 * Fija el valor del atributo <b>instanciaBpm</b>. 
		 * @param newInstanciaBpm nuevo valor para instanciaBpm.
		 */ 
		 public void setInstanciaBpm(java.lang.String newInstanciaBpm) { instanciaBpm = newInstanciaBpm; }
		/**
		 * Devuelve el valor del atributo <b>historicoInterviniente</b>. 
		 * @return valor del atributo <b>historicoInterviniente</b>. 
		 */ 
		 public java.lang.Long getHistoricoInterviniente() { return historicoInterviniente; }
		/**
		 * Fija el valor del atributo <b>historicoInterviniente</b>. 
		 * @param newHistoricoInterviniente nuevo valor para historicoInterviniente.
		 */ 
		 public void setHistoricoInterviniente(java.lang.Long newHistoricoInterviniente) { historicoInterviniente = newHistoricoInterviniente; }
		/**
		 * Devuelve el valor del atributo <b>historicoPersonal</b>. 
		 * @return valor del atributo <b>historicoPersonal</b>. 
		 */ 
		 public java.lang.Long getHistoricoPersonal() { return historicoPersonal; }
		/**
		 * Fija el valor del atributo <b>historicoPersonal</b>. 
		 * @param newHistoricoPersonal nuevo valor para historicoPersonal.
		 */ 
		 public void setHistoricoPersonal(java.lang.Long newHistoricoPersonal) { historicoPersonal = newHistoricoPersonal; }
		/**
		 * Devuelve el valor del atributo <b>estadoExpediente</b>. 
		 * @return valor del atributo <b>estadoExpediente</b>. 
		 */ 
		 public java.lang.String getEstadoExpediente() { return estadoExpediente; }
		/**
		 * Fija el valor del atributo <b>estadoExpediente</b>. 
		 * @param newEstadoExpediente nuevo valor para estadoExpediente.
		 */ 
		 public void setEstadoExpediente(java.lang.String newEstadoExpediente) { estadoExpediente = newEstadoExpediente; }
		/**
		 * Devuelve el valor del atributo <b>conversationIdBpm</b>. 
		 * @return valor del atributo <b>conversationIdBpm</b>. 
		 */ 
		 public java.lang.String getConversationIdBpm() { return conversationIdBpm; }
		/**
		 * Fija el valor del atributo <b>conversationIdBpm</b>. 
		 * @param newConversationIdBpm nuevo valor para conversationIdBpm.
		 */ 
		 public void setConversationIdBpm(java.lang.String newConversationIdBpm) { conversationIdBpm = newConversationIdBpm; }
		/**
		 * Devuelve el valor del atributo <b>descDistribuidor</b>. 
		 * @return valor del atributo <b>descDistribuidor</b>. 
		 */ 
		 public java.lang.String getDescDistribuidor() { return descDistribuidor; }
		/**
		 * Fija el valor del atributo <b>descDistribuidor</b>. 
		 * @param newDescDistribuidor nuevo valor para descDistribuidor.
		 */ 
		 public void setDescDistribuidor(java.lang.String newDescDistribuidor) { descDistribuidor = newDescDistribuidor; }
		/**
		 * Devuelve el valor del atributo <b>nifCliente</b>. 
		 * @return valor del atributo <b>nifCliente</b>. 
		 */ 
		 public java.lang.String getNifCliente() { return nifCliente; }
		/**
		 * Fija el valor del atributo <b>nifCliente</b>. 
		 * @param newNifCliente nuevo valor para nifCliente.
		 */ 
		 public void setNifCliente(java.lang.String newNifCliente) { nifCliente = newNifCliente; }
		/**
		 * Devuelve el valor del atributo <b>agencia</b>. 
		 * @return valor del atributo <b>agencia</b>. 
		 */ 
		 public java.lang.String getAgencia() { return agencia; }
		/**
		 * Fija el valor del atributo <b>agencia</b>. 
		 * @param newAgencia nuevo valor para agencia.
		 */ 
		 public void setAgencia(java.lang.String newAgencia) { agencia = newAgencia; }
		/**
		 * Devuelve el valor del atributo <b>agente</b>. 
		 * @return valor del atributo <b>agente</b>. 
		 */ 
		 public java.lang.String getAgente() { return agente; }
		/**
		 * Fija el valor del atributo <b>agente</b>. 
		 * @param newAgente nuevo valor para agente.
		 */ 
		 public void setAgente(java.lang.String newAgente) { agente = newAgente; }

		 /**
		  * <p>Devuelve la representación en String del objeto.</p>
		  * @return representación en String del objeto.
		  **/
		 public String toString(){
				 StringBuilder out = new StringBuilder();

				 out.append("Class: Expediente:\n");

				 out.append("expediente").append("=[").append(expediente).append("];\n" );
 
				 out.append("tipoProceso").append("=[").append(tipoProceso).append("];\n" );
 
				 out.append("tipoTarea").append("=[").append(tipoTarea).append("];\n" );
 
				 out.append("inicioExped").append("=[").append(inicioExped).append("];\n" );
 
				 out.append("finExped").append("=[").append(finExped).append("];\n" );
 
				 out.append("cliente").append("=[").append(cliente).append("];\n" );
 
				 out.append("negocio").append("=[").append(negocio).append("];\n" );
 
				 out.append("distribuidor").append("=[").append(distribuidor).append("];\n" );
 
				 out.append("puntoVenta").append("=[").append(puntoVenta).append("];\n" );
 
				 out.append("origenPeticion").append("=[").append(origenPeticion).append("];\n" );
 
				 out.append("proyectoWeb").append("=[").append(proyectoWeb).append("];\n" );
 
				 out.append("propuestaSvg").append("=[").append(propuestaSvg).append("];\n" );
 
				 out.append("protocolo").append("=[").append(protocolo).append("];\n" );
 
				 out.append("versionProtocolo").append("=[").append(versionProtocolo).append("];\n" );
 
				 out.append("cia").append("=[").append(cia).append("];\n" );
 
				 out.append("ramo").append("=[").append(ramo).append("];\n" );
 
				 out.append("modalidad").append("=[").append(modalidad).append("];\n" );
 
				 out.append("submodalidad").append("=[").append(submodalidad).append("];\n" );
 
				 out.append("producto").append("=[").append(producto).append("];\n" );
 
				 out.append("poliza").append("=[").append(poliza).append("];\n" );
 
				 out.append("certificado").append("=[").append(certificado).append("];\n" );
 
				 out.append("numeroMovimiento").append("=[").append(numeroMovimiento).append("];\n" );
 
				 out.append("fechaEmisionMov").append("=[").append(fechaEmisionMov).append("];\n" );
 
				 out.append("fechaEfectoPoliza").append("=[").append(fechaEfectoPoliza).append("];\n" );
 
				 out.append("estadoEmision").append("=[").append(estadoEmision).append("];\n" );
 
				 out.append("reciboSvg").append("=[").append(reciboSvg).append("];\n" );
 
				 out.append("ciaRecibo").append("=[").append(ciaRecibo).append("];\n" );
 
				 out.append("reciboAs400").append("=[").append(reciboAs400).append("];\n" );
 
				 out.append("fechaRecibo").append("=[").append(fechaRecibo).append("];\n" );
 
				 out.append("aplicacionImpr").append("=[").append(aplicacionImpr).append("];\n" );
 
				 out.append("anioImpr").append("=[").append(anioImpr).append("];\n" );
 
				 out.append("numeroOrdenImpr").append("=[").append(numeroOrdenImpr).append("];\n" );
 
				 out.append("fechaOrdenImpr").append("=[").append(fechaOrdenImpr).append("];\n" );
 
				 out.append("fechaImpr").append("=[").append(fechaImpr).append("];\n" );
 
				 out.append("fechaArchivado").append("=[").append(fechaArchivado).append("];\n" );
 
				 out.append("instanciaBpm").append("=[").append(instanciaBpm).append("];\n" );
 
				 out.append("historicoInterviniente").append("=[").append(historicoInterviniente).append("];\n" );
 
				 out.append("historicoPersonal").append("=[").append(historicoPersonal).append("];\n" );
 
				 out.append("estadoExpediente").append("=[").append(estadoExpediente).append("];\n" );
 
				 out.append("conversationIdBpm").append("=[").append(conversationIdBpm).append("];\n" );
 
				 out.append("descDistribuidor").append("=[").append(descDistribuidor).append("];\n" );
 
				 out.append("nifCliente").append("=[").append(nifCliente).append("];\n" );
 
				 out.append("agencia").append("=[").append(agencia).append("];\n" );
 
				 out.append("agente").append("=[").append(agente).append("];\n" );
 
				 return out.toString();
		}

}