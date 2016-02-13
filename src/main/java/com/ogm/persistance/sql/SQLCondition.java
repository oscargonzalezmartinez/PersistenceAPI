package com.ogm.persistance.sql;

import com.ogm.persistance.sql.conditions.SQLBracket;
import com.ogm.persistance.sql.conditions.SQLNullCondition;
import com.ogm.persistance.sql.conditions.render.IConditionRender;
import com.ogm.persistance.sql.util.RenderFactory;

/**
 * <p>Clase que permite generar condiciones SQL básicas.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLCondition {
	
	/**
	 * Clase sobre la que aplicar la condición.
	 */
	protected Class clazz = null;
	/**
	 * Campo sobre el que aplicar la condición.
	 */
	protected String field = null;
	/**
	 * Valor del la condición.
	 */
	protected Object value = null;
	/**
	 * Operador.
	 */
	protected String operator =null;
	/**
	 * Expresión.
	 */
	protected SQLExpresion expresion = SQLExpresion.EQUALS;
	/**
	 * Corchetes.
	 */
	protected SQLBracket bracket = null; 
	/**
	 * Función a aplicar sobre el campo.
	 */
	protected SQLFunction function = null;
	/**
	 * Render por defecto.
	 */
	protected IConditionRender render = RenderFactory.getConditionRenderer(SQLCondition.class);
	
	/**
	 * <p> AND <code>newField</code> = <code>newValue</code>.</p>
	 * @param newField Atributo de la clase al que se quiere añadir una condición.
	 * @param newValue Valor que ha de cumplir.
	 * @return  AND <code>newField</code> = <code>newValue</code>.
	 */
	public static SQLCondition getAND(String newField,Object newValue ){
		return new SQLCondition(null,newField, newValue, SQLConstants.AND, SQLExpresion.EQUALS);
	}

	/**
	 * <p> AND <code>newField</code> = <code>newValue</code>.</p>
	 * @param newField Atributo de la clase al que se quiere añadir una condición.
	 * @param newValue Valor que ha de cumplir.
	 * @return  AND <code>newField</code> = <code>newValue</code>.
	 */
	public static SQLCondition getOR(String newField,Object newValue ){
		return new SQLCondition(null,newField, newValue, SQLConstants.OR, SQLExpresion.EQUALS);
	}

	public static SQLCondition getAND(String newField,Object newValue, SQLExpresion newExpresion ){
		return new SQLCondition(null,newField, newValue, SQLConstants.AND, newExpresion);
	}

	public static SQLCondition getOR(String newField,Object newValue, SQLExpresion newExpresion  ){
		return new SQLCondition(null,newField, newValue, SQLConstants.OR, newExpresion);
	}
	
	public static SQLCondition getAND(Class newClass,String newField,Object newValue ){
		return new SQLCondition(newClass,newField, newValue, SQLConstants.AND, SQLExpresion.EQUALS);
	}

	public static SQLCondition getOR(Class newClass,String newField,Object newValue ){
		return new SQLCondition(newClass,newField, newValue, SQLConstants.OR, SQLExpresion.EQUALS);
	}

	public static SQLCondition getAND(Class newClass,String newField,Object newValue, SQLExpresion newExpresion ){
		return new SQLCondition(newClass,newField, newValue, SQLConstants.AND, newExpresion);
	}

	public static SQLCondition getOR(Class newClass,String newField,Object newValue, SQLExpresion newExpresion  ){
		return new SQLCondition(newClass,newField, newValue, SQLConstants.OR, newExpresion);
	}
	
	public static SQLCondition getAND_IS_NULL(Class newClass,String newField){
		return new SQLNullCondition(newClass,newField, SQLConstants.AND, SQLExpresion.IS_NULL);
	}

	public static SQLCondition getAND_IS_NOT_NULL(Class newClass,String newField){
		return new SQLNullCondition(newClass,newField, SQLConstants.AND, SQLExpresion.IS_NOT_NULL);
	}
	
	public static SQLCondition getANDFunction(String newField,SQLFunction newFunction,Object newValue ){
		return new SQLCondition(null,newField, newValue, SQLConstants.AND, SQLExpresion.EQUALS, newFunction);
	}
	
	public static SQLCondition getANDFunction(Class newClass,String newField,SQLFunction newFunction,Object newValue ){
		return new SQLCondition(newClass,newField, newValue, SQLConstants.AND, SQLExpresion.EQUALS, newFunction);
	}
	
	public static SQLCondition getANDFunction(String newField,SQLFunction newFunction,Object newValue, SQLExpresion newExpresion ){
		return new SQLCondition(null,newField, newValue, SQLConstants.AND, newExpresion, newFunction);
	}
	
	public static SQLCondition getANDFunction(Class newClass,String newField,SQLFunction newFunction,Object newValue, SQLExpresion newExpresion ){
		return new SQLCondition(newClass,newField, newValue, SQLConstants.AND, newExpresion, newFunction);
	}
	
	
	public static SQLCondition getORFunction(String newField,SQLFunction newFunction,Object newValue ){
		return new SQLCondition(null,newField, newValue, SQLConstants.OR, SQLExpresion.EQUALS, newFunction);
	}
	
	public static SQLCondition getORFunction(Class newClass,String newField,SQLFunction newFunction,Object newValue ){
		return new SQLCondition(newClass,newField, newValue, SQLConstants.OR, SQLExpresion.EQUALS, newFunction);
	}
	
	public static SQLCondition getORFunction(String newField,SQLFunction newFunction,Object newValue, SQLExpresion newExpresion ){
		return new SQLCondition(null,newField, newValue, SQLConstants.OR, newExpresion, newFunction);
	}
	
	public static SQLCondition getORFunction(Class newClass,String newField,SQLFunction newFunction,Object newValue, SQLExpresion newExpresion ){
		return new SQLCondition(newClass,newField, newValue, SQLConstants.OR, newExpresion, newFunction);
	}
	
	/**
	 * Constructor. 
	 */
	public SQLCondition(){}
	
	/**
	 * <p>Crea un nueva condición.</>
	 * @param newClass Clase del modelo.
	 * @param newField Campo.
	 * @param newValue Valor del campo.
	 * @param newExpresion expresión a aplicar en la condición.
	 */
	public SQLCondition(Class newClass, String newField, Object newValue, SQLExpresion newExpresion) {
		super();
		this.clazz = newClass;
		this.field = newField;
		this.value = newValue;
		this.expresion = newExpresion;
	}
	
	/**
	 * <p>Crea un nueva condición.</>
	 * @param newClass Clase del modelo.
	 * @param newField Campo.
	 * @param newValue Valor del campo.
	 * @param newOperator operador.
	 * @param newFunction Función.
	 */
	public SQLCondition(Class newClass, String newField, Object newValue, SQLExpresion newExpresion, SQLFunction newFunction) {
		super();
		this.clazz = newClass;
		this.field = newField;
		this.value = newValue;
		this.expresion = newExpresion;
		function = newFunction;
		//al tener función cogemos el render de la función
		render = function.getRender();
	}
	
	/**
	 * <p>Crea un nueva condición.</>
	 * @param newClass Clase del modelo.
	 * @param newField Campo.
	 * @param newValue Valor del campo.
	 * @param newOperator operador.
	 * @param newExpresion expresión a aplicar en la condición.
	 */
	public SQLCondition(Class newClass,String newField, Object newValue,String newOperator, SQLExpresion newExpresion) {
		this(newClass,newField,newValue,newExpresion);
		this.operator = newOperator;
	}

	/**
	 * <p>Crea un nueva condción.</>
	 * @param newClass Clase del modelo.
	 * @param newField Campo.
	 * @param newValue Valor del campo.
	 * @param newOperator operador.
	 * @param newExpresion expresión a aplicar en la condición.
	 * @param newFunction Función.
	 */
	public SQLCondition(Class newClass,String newField, Object newValue,String newOperator, SQLExpresion newExpresion, SQLFunction newFunction) {
		this(newClass,newField,newValue,newExpresion);
		operator = newOperator;
		function = newFunction;
		//al tener función cogemos el render de la función
		render = function.getRender();
	}
	
	/**
	 * <p>Devuelve la expresión a aplicar en la condición.</p>
	 * @return xpresión a aplicar en la condición.
	 */
	public SQLExpresion getExpresion() {
		return expresion;
	}
	/**
	 * <p>Establece la expresión a aplicar en la condición.</p>
	 * @param newExpresion  expresión a aplicar en la condición.
	 */
	public void setExpresion(SQLExpresion newExpresion) {
		this.expresion = newExpresion;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public String getField() {
		return field;
	}
	/**
	 * <p>.</p>
	 * @param newField
	 */
	public void setField(String newField) {
		this.field = newField;
	}
	/**
	 * <p>.</p>
	 * @return
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * <p>.</p>
	 * @param newValue
	 */
	public void setValue(Object newValue) {
		this.value = newValue;
	}

	/**
	 * <p>.</p>
	 * @return
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * <p>.</p>
	 * @param newOperator
	 */
	public void setOperator(String newOperator) {
		this.operator = newOperator;
	}

	/**
	 * <p>Devuelve la clase del modelo sobre el que se aplica la condición.</p>
	 * @return Clase del modelo sobre el que se aplica la condición.
	 */
	public Class getClazz() {
		return clazz;
	}

	/**
	 * <p>Establece la clase del modelo sobre el que se aplica la condición..</p>
	 * @param newClazz Clase del modelo sobre el que se aplica la condición.
	 */
	public void setClazz(Class newClazz) {
		this.clazz = newClazz;
	}

	/**
	 * <p>.</p>
	 * @return
	 */
	public IConditionRender getRender() {
		return render;
	}

	/**
	 * <p>.</p>
	 * @param newRender
	 */
	public void setRender(IConditionRender newRender) {
		this.render = newRender;
	}

	/**
	 * <p>.</p>
	 * @return
	 */
	public SQLFunction getFunction() {
		return function;
	}

	/**
	 * <p>.</p>
	 * @param newFunction
	 */
	public void setFunction(SQLFunction newFunction) {
		this.function = newFunction;
	}

	/**
	 * <p>.</p>
	 * @return
	 */
	public SQLBracket getBracket() {
		return bracket;
	}

	/**
	 * <p>.</p>
	 * @param newBracket
	 */
	public void setBracket(SQLBracket newBracket) {
		this.bracket = newBracket;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(operator).append(" ").append(field).append(" ").append(expresion).append(value);
		return sb.toString();
	}
}
