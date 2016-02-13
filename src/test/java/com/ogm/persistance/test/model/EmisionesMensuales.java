package com.ogm.persistance.test.model;

import java.util.Date;

import com.ogm.persistance.model.annotation.DBColumn;

public class EmisionesMensuales {
	@DBColumn(column="da",isTransient=true) 
	private String fecha = null;
	
	@DBColumn(column="NU_TEX_TIPO_TAREA",isTransient=true)
	private Integer tipoTarea =null;
	
	@DBColumn(column="c",isTransient=true)
	private Long count =null;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getTipoTarea() {
		return tipoTarea;
	}

	public void setTipoTarea(Integer tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		
		return new StringBuilder().append(fecha).append(";").append(tipoTarea).append(";").append(count).toString();
	}
	
	
}
