package com.ogm.persistance.test.model;

import com.ogm.persistance.model.KeyGeneratorEnum;
import com.ogm.persistance.model.annotation.DBColumn;
import com.ogm.persistance.model.annotation.DBTable;

@DBTable(table="NO_EXISTE_TABLA", keyGenerator=KeyGeneratorEnum.NONE)
public class NoExiste implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -928425130359924459L;
	
	 @DBColumn(column ="CIA",pk=true) 
	 private java.lang.String cia = null;
	/**
	 * Atributo mapeado a la columna base datos <b>TX_TEX_RAMO</b>. 
	 */ 
	 @DBColumn(column ="RAMO",pk=true) 
	 private java.lang.String ramo = null;
	/**
	 * Atributo mapeado a la columna base datos <b>TX_TEX_MODALIDAD</b>. 
	 */ 
	 @DBColumn(column ="MODA",pk=true) 
	 private java.lang.String modalidad = null;
	/**
	 * Atributo mapeado a la columna base datos <b>TX_TEX_SUBMODALIDAD</b>. 
	 */ 
	 @DBColumn(column ="SUBMODA",pk=true) 
	 private java.lang.String submodalidad = null;

	 @DBColumn(column ="WM") 
	 private java.lang.String wm = null;
	 
	 @DBColumn(column ="DES") 
	 private java.lang.String des = null;

	public java.lang.String getCia() {
		return cia;
	}

	public void setCia(java.lang.String cia) {
		this.cia = cia;
	}

	public java.lang.String getRamo() {
		return ramo;
	}

	public void setRamo(java.lang.String ramo) {
		this.ramo = ramo;
	}

	public java.lang.String getModalidad() {
		return modalidad;
	}

	public void setModalidad(java.lang.String modalidad) {
		this.modalidad = modalidad;
	}

	public java.lang.String getSubmodalidad() {
		return submodalidad;
	}

	public void setSubmodalidad(java.lang.String submodalidad) {
		this.submodalidad = submodalidad;
	}

	public java.lang.String getWm() {
		return wm;
	}

	public void setWm(java.lang.String wm) {
		this.wm = wm;
	}

	public java.lang.String getDes() {
		return des;
	}

	public void setDes(java.lang.String des) {
		this.des = des;
	}
}
