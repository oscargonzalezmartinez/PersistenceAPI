package com.ogm.persistance.sql;

import java.util.ArrayList;
import java.util.List;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;

/**
 * <p>Esta clase representa una sentencia select.</p>
 * <p>Esta compuesta por una serie de campos, una clausula from, un where , un orderby, etc.</p>
 * <p>Esta clase se usará cuando necesitemos algo más que un CRUD de una tabla.</p>
 * <p>Un ejemplo de uso sería:<br>
 * <code>
 * 		//Definimos el modelo de la salida de la sentencia
 *		ModelDefinition outputModel = ModelDefinition.newModel(TareaRecibos.class);
 *		TareaRecibos tareaRecibos = new TareaRecibos();
 *		tareaRecibos.setGrupoResponsable("INFORMAT");
 *		tareaRecibos.setFechaHasta(new Date());
 *		SQLSelect select = new SQLSelect();
 *
 *		//a�adimos todos los campos de la salida
 *		//con alias SQL para el mapeo a otra clase distinta que las indicadas aqu�
 *		select.addSelectField(DetalleSuceso.class, "numeroDetalle", "numeroDetalle")
 *				.addSelectField(Expediente.class, "reciboAs400", "reciboAs400")
 *				.addSelectField(Expediente.class, "ciaRecibo", "ciaRecibo")
 *				.addSelectField(Expediente.class, "ramo", "ramo")
 *				.addSelectField(Expediente.class, "modalidad", "modalidad")
 *				.addSelectField(Expediente.class, "poliza", "poliza")
 *				.addSelectField(Expediente.class, "certificado", "certificado")
 *				.addSelectField(DetalleSuceso.class, "codigoSuceso", "codigoSuceso")
 *				.addSelectField(DetalleSuceso.class, "descripcion", "descSuceso")
 *				.addSelectField(DetalleSuceso.class, "usuarioRevision", "usuarioRevision")
 *				.addSelectField(DetalleSuceso.class, "fechaRevision", "fechaRevision")
 *				.addSelectField(DetalleSuceso.class, "fechaSuceso", "fechaSuceso");
 *		
 *		//a�adimos las tablas
 *		select.addFrom(Expediente.class).addFrom(DetalleSuceso.class);
 *		
 *		//a�adimos las restricciones
 *		select.addCondition(new SQLJoinCondition(Expediente.class,"expediente",DetalleSuceso.class,"expediente"))
 *			.addCondition(SQLCondition.getAND(DetalleSuceso.class, "tipoSuceso", 1))
 *			.addCondition(SQLCondition.getAND_IS_NULL(DetalleSuceso.class,"fechaRevision"));
 *			.addCondition(SQLCondition.getAND(DetalleSuceso.class, "responsable", tareaRecibos.getGrupoResponsable()));
 *			.addCondition(SQLCondition.getAND_IS_NOT_NULL(Expediente.class,"expediente"));
 *			.addCondition(new SQLBetweenCondition(Expediente.class,"inicioExped","finExped"));
 *		//el resultado será de tipo List<TareaRecibos>
 *		select.setOutputModel(outputModel);
 * </code>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLSelect{
	/**
	 * Query en formato SQL.
	 */
	private String sqlQuery = null;
	
	/**
	 * Query en formato Object Query
	 */
	private String objectQuery = null;
	/**
	 * Listado de parámetros de la query cuando se indica en SQL puro u Object Query.
	 * Si se usa de forma programática esta lista está vacía.
	 */
	private List params = null;
	/**
	 * 
	 */
	private SQLFrom  from  = null;
	/**
	 * 
	 */
	private SQLInnerJoin innerJoin = null;
	/**
	 * 
	 */
	private SQLWhere where = null;
	/**
	 * 
	 */
	private SQLOrderBy orderBy = null;
	/**
	 * 
	 */
	private SQLGroupBy groupBy = null;
	/**
	 * 
	 */
	private SQLHaving having = null;
	/**
	 * 
	 */
	private SQLPagination pagination = null;
	/**
	 * 
	 */
	private List<SQLField> selectFields = null;
	/**
	 * 
	 */
	private ModelDefinition outputModel = null;
	/**
	 * 
	 */
	private Class outputModelClass = null;
	
	/**
	 * Constructor
	 */
	public SQLSelect(){		
	}
	
	public SQLSelect(SQLFrom newFrom, SQLWhere newWhere) {
		super();
		this.from = newFrom;
		this.where = newWhere;
	}
	
	public SQLFrom getFrom() {
		return from;
	}

	public void setFrom(SQLFrom newFrom) {
		this.from = newFrom;
	}

	public List<SQLField> getSelectFields() {
		return selectFields;
	}

	public void setSelectFields(List<SQLField> newSelectFileds) {
		this.selectFields = newSelectFileds;
	}

	public SQLSelect addSelectField(SQLField sqlField) {
		if (selectFields == null){
			selectFields = new ArrayList<SQLField>();
		}
		this.selectFields.add(sqlField);
		return this;
	}
	public SQLSelect addSelectField(Object obj, String field) {
		return addSelectField(obj.getClass(), field);
	}

	public SQLSelect addSelectField(Class clazz, String field) {
		return addSelectField(new SQLField(clazz,field));
	}

	public SQLSelect addSelectField(Class clazz, String field, String synonym) {
		return addSelectField(new SQLField(clazz,field,synonym));
	}

	public SQLWhere getWhere() {
		return where;
	}

	public void setWhere(SQLWhere newWhere) {
		this.where = newWhere;
	}


	public SQLSelect addCondition(SQLCondition condition){
		if (where == null){
			where = new SQLWhere();
		}
		
		where.add(condition);
		return this;
	}
	
	public SQLSelect addFrom(Object obj){
		return addFrom(obj.getClass());
	}
	
	public SQLSelect addFrom(Class clazz){
		if (from == null){
			 from = new SQLFrom();
		}
		from.addTable(clazz);
		return this;
		
	}

	public ModelDefinition getOutputModel(ModelManager modelManager) {
		if (outputModel != null){
			return outputModel;
		}
		
		if (outputModelClass!=null){
			return modelManager.getModel(outputModelClass);
		}
		
		//TODO lanzar una excepci�n?
		return null;
	}

	public void setOutputModel(ModelDefinition newOutputModel) {
		this.outputModel = newOutputModel;
	}

	public void setOutputModel(Class newTargetClass) {
		outputModelClass = newTargetClass;
	}
	
	public SQLOrderBy getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(SQLOrderBy newOrderBy) {
		this.orderBy = newOrderBy;
	}

	public SQLPagination getPagination() {
		return pagination;
	}

	public void setPagination(SQLPagination newPagination) {
		this.pagination = newPagination;
	}

	public SQLGroupBy getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(SQLGroupBy newGroupBy) {
		this.groupBy = newGroupBy;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String newSqlQuery) {
		this.sqlQuery = newSqlQuery;
	}
	
	public void setSqlQuery(String newSqlQuery, Object... newParams) {
		this.sqlQuery = newSqlQuery;
		setParams(newParams);
	}
	


	/**
	 * <p>.</p>
	 * @param newParams
	 */
	private void setParams(Object... newParams) {
		if (newParams==null){
			params=null;
			return;
		}

		//en Java 5 con n�mero variables de argumentos 
		//en llamadas de este tipo setSqlQuery("query",null)
		// newParams.length.length == 1 y newParams[0] == null
		
		if (newParams.length == 1){
			if(newParams[0] instanceof List){
				params = (List)newParams[0];
			}
			else if (newParams[0]!=null){
				//en otro caso lo	copiamos tal cual
				params = new ArrayList(1);
				params.add(newParams[0]);
			}
			else{
				//es un objeto nulo
				params = null;
			}
		}
		else{
			
		
			int size = newParams.length;
			params = new ArrayList(size);
			for(int i = 0; i < size; i++){
				params.add(newParams[i]);
			}
		}
	}

	public SQLInnerJoin getInnerJoin() {
		return innerJoin;
	}

	public void setInnerJoin(SQLInnerJoin newInnerJoin) {
		this.innerJoin = newInnerJoin;
	}

	public SQLHaving getHaving() {
		return having;
	}

	public void setHaving(SQLHaving newHaving) {
		this.having = newHaving;
	}

	public List getSQLLiteralParams() {
		return params;
	}

	public String getObjectQuery() {
		return objectQuery;
	}

	public void setObjectQuery(String newObjectQuery) {
		params = null;
		this.objectQuery = newObjectQuery;
	}
	
	public void setObjectQuery(String newObjectQuery, Object... newParams) {
		this.objectQuery = newObjectQuery;
		setParams(newParams);
	}
	
	public void resetParams(){
		params = null;
	}
}
