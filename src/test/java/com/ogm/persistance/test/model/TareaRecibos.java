package com.ogm.persistance.test.model;

import java.util.Date;

import com.ogm.persistance.model.annotation.DBColumn;



/**
 * <p>Esta clase es utilizada para filtrar en la consulta de las tareas de recibos y como 
 * resultado de la misma.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 58878 $ $LastChangedDate: 2009-07-09 09:40:05 +0200 (jue, 09 jul 2009) $
 * @since 1.0
 *
 */
public class TareaRecibos {

	//campos para el filtro
	private String grupoResponsable = null;
	private Date fechaDesde = null;
	private Date fechaHasta = null;
	
	//campos de salida Se mapean a los alias de la SQL
	@DBColumn(column="numeroDetalle")
	private Integer numeroDetalle = null;
	
	@DBColumn(column="reciboAs400")
	private Integer reciboAs400 = null;
	
	@DBColumn(column="ciaRecibo")
	private String ciaRecibo = null;
	
	@DBColumn(column="ramo")
	private String ramo = null;
	
	@DBColumn(column="modalidad")
	private String modalidad = null;
	
	@DBColumn(column="poliza")
	private String poliza = null;
	
	@DBColumn(column="certificado")
	private String certificado = null;
	
	@DBColumn(column="codigoSuceso")
	private String codigoSuceso = null;
	
	@DBColumn(column="descSuceso")
	private String descSuceso = null;
	
	@DBColumn(column="usuarioRevision")
	private String usuarioRevision = null;
	
	@DBColumn(column="fechaRevision")
	private Date fechaRevision = null;
	
	@DBColumn(column="fechaSuceso")
	private Date fechaSuceso = null;

	
	public Integer getNumeroDetalle() {
		return numeroDetalle;
	}
	public void setNumeroDetalle(Integer newNumeroDetalle) {
		this.numeroDetalle = newNumeroDetalle;
	}
	public Integer getReciboAs400() {
		return reciboAs400;
	}
	public void setReciboAs400(Integer newReciboAs400) {
		this.reciboAs400 = newReciboAs400;
	}
	 
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String newCertificado) {
		this.certificado = newCertificado;
	}
	public String getCiaRecibo() {
		return ciaRecibo;
	}
	public void setCiaRecibo(String newCiaRecibo) {
		this.ciaRecibo = newCiaRecibo;
	}
	public String getCodigoSuceso() {
		return codigoSuceso;
	}
	public void setCodigoSuceso(String newCodigoSuceso) {
		this.codigoSuceso = newCodigoSuceso;
	}
	public String getDescSuceso() {
		return descSuceso;
	}
	public void setDescSuceso(String newDescSuceso) {
		this.descSuceso = newDescSuceso;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date newFechaDesde) {
		this.fechaDesde = newFechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date newFechaHasta) {
		this.fechaHasta = newFechaHasta;
	}
	public Date getFechaRevision() {
		return fechaRevision;
	}
	public void setFechaRevision(Date newFechaRevision) {
		this.fechaRevision = newFechaRevision;
	}
	public Date getFechaSuceso() {
		return fechaSuceso;
	}
	public void setFechaSuceso(Date newFechaSuceso) {
		this.fechaSuceso = newFechaSuceso;
	}
	public String getGrupoResponsable() {
		return grupoResponsable;
	}
	public void setGrupoResponsable(String newGrupoResponsable) {
		this.grupoResponsable = newGrupoResponsable;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String newModalidad) {
		this.modalidad = newModalidad;
	}
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String newPoliza) {
		this.poliza = newPoliza;
	}
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String newRamo) {
		this.ramo = newRamo;
	}
	public String getUsuarioRevision() {
		return usuarioRevision;
	}
	public void setUsuarioRevision(String newUsuarioRevision) {
		this.usuarioRevision = newUsuarioRevision;
	}
	
	
	 /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		 StringBuilder out = new StringBuilder("Class: TareaRecibos:\n");
		 
		 out.append("numeroDetalle").append("=[").append(numeroDetalle).append("];\n" );
		 out.append("grupoResponsable").append("=[").append(grupoResponsable).append("];\n" );
		 out.append("fechaDesde").append("=[").append(fechaDesde).append("];\n" );
		 out.append("fechaHasta").append("=[").append(fechaHasta).append("];\n" );
		 out.append("descSuceso").append("=[").append(descSuceso).append("];\n" );
		 return out.toString();
	 }
}
