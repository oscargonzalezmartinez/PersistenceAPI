package com.ogm.persistance.sql.conditions;

import java.util.Date;

import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.util.RenderFactory;

/**
 * <p>Genera una condición <code>BETWEEN</code>.
 * <p>El sql generado es:<br/>
 * Fecha BETWEEN field1 AND field2
 * <p>Si no se indica fecha se utilizará SYSDATE</p>
 * <p>Esta versión sólo soporta fechas</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLBetweenCondition extends SQLCondition{
	private Date fecha = null;
	private String field2 = null;
	/**
	 * @param clazz
	 * @param newField
	 * @param newField2
	 */
	public SQLBetweenCondition(Class clazz,String newField,String newField2){
		super(clazz, newField, null,null);
		operator = SQLConstants.AND;
		this.field = newField;
		this.field2 = newField2;
		render = RenderFactory.getConditionRenderer(SQLBetweenCondition.class);
	}

	/**
	 * @param clazz
	 * @param newDate
	 * @param newField
	 * @param newField2
	 */
	public SQLBetweenCondition(Class clazz,Date newDate,String newField,String newField2){
		this( clazz,newField,newField2);
		fecha = newDate;
	}
	
	public Date getFecha() {
		return fecha;
	}

	/**
	 * <p>.</p>
	 * @param newFecha
	 */
	public void setFecha(Date newFecha) {
		this.fecha = newFecha;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String newField2) {
		this.field2 = newField2;
	}
}
