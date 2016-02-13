package com.ogm.persistance.sql.processors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.model.Field;
import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.NamedQuery;
import com.ogm.persistance.model.Relationship;
import com.ogm.persistance.model.util.ScalarResult;
import com.ogm.persistance.sql.SQLCondition;
import com.ogm.persistance.sql.SQLConstants;
import com.ogm.persistance.sql.SQLField;
import com.ogm.persistance.sql.SQLFrom;
import com.ogm.persistance.sql.SQLFunction;
import com.ogm.persistance.sql.SQLGroupBy;
import com.ogm.persistance.sql.SQLHaving;
import com.ogm.persistance.sql.SQLInnerJoin;
import com.ogm.persistance.sql.SQLOrderBy;
import com.ogm.persistance.sql.SQLPagination;
import com.ogm.persistance.sql.SQLSelect;
import com.ogm.persistance.sql.SQLWhere;
import com.ogm.persistance.sql.antlr.ObjectQueryToSQL;
import com.ogm.persistance.sql.processors.SQLSelectProcessor;
import com.ogm.persistance.util.ClassUtil;
import com.ogm.persistance.util.ErrorMessageID;

/**
 * <p>Implementación de SQLSelectProcessor.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class DefaultSelectProcessorImpl extends SQLProcessorImpl implements SQLSelectProcessor {

	
	/**
	 * Valor por defecto de la primera fila de la paginación.
	 */
	private static final Long PAGINATION_FIRST_ROW = Long.valueOf(1);
	/**
	 * Valor por defeto para la última fila de la paginación. 
	 */
	private static final Long PAGINATION_LAST_ROW = Long.valueOf(1000);

	public DefaultSelectProcessorImpl() {

	}

	/**
	 * <p>Devuelve el resultado de la ejecución de <code>select</code></p>.
	 * @param select Sentencia select a ejecutar.
	 * @return resultado de la ejecución de <code>select</code>.
	 */
	public List execute(SQLSelect select){
		
		if (select.getSqlQuery()!=null){
			return executeLiteralQuery(select);
		}
		
		if (select.getObjectQuery()!=null){
			return executeObjectQuery(select);
		}
		
		List params = new ArrayList();
		List<SQLField> fields = select.getSelectFields();
		SQLFrom from = select.getFrom();
		StringBuilder sql = new StringBuilder();

		if (fields!=null){
			sql.append(SQLConstants.SELECT);
			for (SQLField sqlField : fields) {
				ModelDefinition model = getModel(sqlField.getClazz());
				String sqlColumn = model.getAttributeToColumn(sqlField.getField());
				//Esto solo debería pasar en primeras fases de desarrollo
				if (sqlColumn == null){
					//"El atributo ["+sqlField.getField()+"] de la clase ["+model.getClassName()+"] no está mapeado."
					throw new PersistanceException(ErrorMessageID.PE_00013, sqlField.getField(),model.getClassName());
				}
				
				if (sqlField.getFunction()!=null){
					sqlField.getFunction().getRender().render(modelManager,sqlField, sql);
				}
				else{
					sql.append( model.getTable())
					.append(SQLConstants.DOT)
					.append(sqlColumn);
					
					if (sqlField.getSqlSynonym()!=null){
						sql.append(SQLConstants.BLANK)
						.append(SQLConstants.DOUBLE_QUOTE)
						.append(sqlField.getSqlSynonym())
						.append(SQLConstants.DOUBLE_QUOTE);
					}
					
				}
				
				sql.append(SQLConstants.COMMA);
			}
			//eliminamos coma
			sql = sql.deleteCharAt(sql.length()-1);
			
	//		String schema = modelManager.getSchemaName();

			if ( from == null ){
				// No se ha indicado un from para la query " + sql
				throw new PersistanceException(ErrorMessageID.PE_00014,sql);
			}
			sql.append(SQLConstants.FROM);
			
			for (Class clazz: from.getTables()){
				ModelDefinition model = getModel(clazz);
				sql.append(model.getFullTableName()).append(SQLConstants.COMMA);
			}
			
			//eliminamos coma
			sql = sql.deleteCharAt(sql.length()-1);
		}
		else{
			//no se han indicado campos, los generamos nosotros
			if ( from == null ){
				// No se ha indicado un from para la query " + sql
				throw new PersistanceException(ErrorMessageID.PE_00014,sql);
			}
			
			if (from.getTables().size() > 1){
				//" Hay más de un from. Se han de indicar qué campos se quieren recuperar " + sql
				throw new PersistanceException(ErrorMessageID.PE_00015,sql);
			}
			
			ModelDefinition model = getModel(from.getTables().get(0));
			sql.append( model.getSqlSelect());//leemos SELECT [fields]* FROM SCHEMA.TABLE de la cache
			
		}
		
		

			
	//	sql = new StringBuilder(sql.substring(0, sql.length()-1));
		//inner join
		processInnerJoin(select, sql, params);
		//Procesamos where
		processWhere(select, sql, params);
		//Group by
		processGroupBy(select.getGroupBy(), sql);
		//Order by
		processOrderBy(select.getOrderBy(), sql);
		//Having
		processHaving(select.getHaving(),sql, params);
		//comprobamos la paginación
		processPagination(select, sql);
		
		//comprobamos el modelo para la salida
		checkOuputModel(select, from, sql);
		return execute(select.getOutputModel(modelManager),sql.toString(), params);
	}

	/**
	 * <p>Ejecuta la query tal como es devuelta por la invocación a <code>select.getSqlQuery()</code>.</p>
	 * @param select Select a ejecutar
	 * @return resultado de la select
	 */
	private List executeLiteralQuery(SQLSelect select) {
		//comprobamos el modelo para la salida
		//si la literalquery no tiene definido un mapeo de salida, se devuelve un vector, y cada
		//fila representado por un Map, cuyas claves son las columnas de retorno de la query.
//		if (select.getOutputModel(modelManager)==null){
//			//"Se ha de indicar un modelo de salida para " 
//			throw new PersistanceException(ErrorMessageID.DAO00012, select.getSqlQuery());
//		}
		
		String sqlQuery = select.getSqlQuery();
		if (modelManager.getSchemaName()!=null){
			sqlQuery = sqlQuery.replace("{schema}", modelManager.getSchemaName());
		}
		StringBuilder sb = new StringBuilder(sqlQuery);
		processPagination(select, sb);

		return execute(select.getOutputModel(modelManager),sb.toString(), select.getSQLLiteralParams());
	}

	private List executeObjectQuery(SQLSelect select){
		NamedQuery mq = ObjectQueryToSQL.process(select.getObjectQuery(), modelManager);
		//si la select origen no tiene definido un modelo de salida le asignamos el defindo 
		//por el procesador  ObjectQueryToSQL
		if (select.getOutputModel(modelManager) == null){
			select.setOutputModel(modelManager.getModel(mq.getModel()));
		}
		select.setSqlQuery(mq.getQuery());
		return executeLiteralQuery(select);
	}
	/**
	 * <p>Comprueba que <code>select</code> tiene definido un modelo de salida, si no es así intenta asignarle
	 * uno mediante los from definidos.</p>
	 * @param select Sentencia select sql
	 * @param from From de la query
	 * @param sql Buffer donde generar la sentencia
	 */
	private void checkOuputModel(SQLSelect select, SQLFrom from,
			StringBuilder sql) {
		ModelDefinition outputModel = select.getOutputModel(modelManager);
		if (outputModel == null){
			if ( from == null ){
				// No se ha indicado un from para la query " + sql
				throw new PersistanceException(ErrorMessageID.PE_00014,sql);
			}
			
			if (from.getTables().size() > 1){
				//" No se ha indicado un modelo de salida de la query, al tener más de una tabla no se puede asignar uno automáticamente: " + sql
				throw new PersistanceException(ErrorMessageID.PE_00016,sql);
			}
			
			outputModel = getModel(from.getTables().get(0));
			select.setOutputModel(outputModel);
		}
	}

	private void processPagination(SQLSelect select, StringBuilder sql) {
		SQLPagination pagination = select.getPagination();
		if (pagination == null){
			//comprobamos la paginación global
			pagination = modelManager.getGlobalPagination();
		}
		
		processPagination(pagination,sql);

	}
	
	private void processPagination(StringBuilder sql) {
		processPagination(modelManager.getGlobalPagination(),sql);
	}
	
	private void processPagination(SQLPagination pagination,StringBuilder sql) {
		if (pagination==null){
			return ;
		}
		
		Long min = pagination.getMinRow();
		if (min == null){
			min = PAGINATION_FIRST_ROW;
		}
		
		Long max = pagination.getMaxRow();
		if (max == null){
			max = PAGINATION_LAST_ROW;
		}
		
		modelManager.getDialect().pagination(sql, min, max);
//		StringBuilder sb = new StringBuilder ("SELECT *   FROM ( SELECT /*+ FIRST_ROWS(n) */ "); 
//		sb.append("  a_pagination.*, ROWNUM rnum from ( ");
//		sb.append(sql);
//		sb.append(" ) a_pagination  ");
//		sb.append(" WHERE ROWNUM <= ").append(max);
//		sb.append(" ) WHERE rnum > ").append(min);
//		sql.setLength(0);
//		sql.append(sb);
	}
	
	/**
	 * <p>Devuelve un único objeto aplicando el filtro indicado en <code>objToFind</code>.</p>
	 * <p>Si retorna más de un objeto se lanza una <code>DAOException</code> con el código 
	 * <code>ErrorMessageID.PE_00001</code>.</p>
	 * <p>Si se quiere obtener más de una instancia utilizar los métodos <code>find</code>.
	 * @param objToFind Objeto con el que se realiza el filtro.
	 * @return único objeto aplicando el filtro indicado en <code>objToFind</code>.
	 * 
	 */
	public <T> T get(Object objToFind){
		ModelDefinition model = getModel(objToFind);

		StringBuilder sql = new StringBuilder(model.getSqlSelect());

		List params = getDynamicWhereFromObject(objToFind, model, sql);
		List result = execute(model, sql.toString(), params);
		if (result == null || result.isEmpty()){
			return null;
		}
		if (result.size() > 1){
			throw new PersistanceException(ErrorMessageID.PE_00001 , model.getTable());
		}
		
		return (T)result.get(0);
	}
	
	
	public <T> T get(Class<T> clazz, Object id){
		ModelDefinition model = getModel(clazz);

		StringBuilder sql = new StringBuilder(model.getSqlSelect());
		sql
		.append(SQLConstants.WHERE)
		.append(model.getPrimaryKey())
		.append(SQLConstants.EQUAL_QUESTION_MARK);
		
		List params = new ArrayList();
		params.add(id);

		List result = execute(model, sql.toString(), params);
		if (result == null || result.isEmpty()){
			return null;
		}
		if (result.size() > 1){
			throw new PersistanceException(ErrorMessageID.PE_00001 , model.getTable());
		}		
		return (T)result.get(0);
	}
	
	@Deprecated
	public <T> T getComplete(Class<T> clazz, Object id){
		Object obj = get(clazz,id);
		if (obj!=null){
			loadRelationsOld(obj);
		}
		return (T)obj;
	}
	
	private void loadRelationsOld(Object obj){
		ModelDefinition model = getModel(obj.getClass());
		Map<String,Relationship> relations =model.getRelations();
		if (relations ==null || relations.isEmpty()){
			return;
		}
		
		for (Iterator<String> it = relations.keySet().iterator(); it.hasNext();){
			String field = it.next();
			Relationship relationship = relations.get(field);
			ModelDefinition modelR = getModel(relationship.getTargetClass());

				Class realClazz = ClassUtil.getClass(modelR.getClassName());
				Object searchValue = ClassUtil.getFieldValueFromObject(obj, relationship.getField());
				SQLWhere where = new SQLWhere();
				where.add(SQLCondition.getAND(realClazz, 
											relationship.getTargetField(), 
											searchValue));
				if (ClassUtil.isList(obj, field)){//Buscamos un listado?

					List relation = find(realClazz, where);
					for (Object r: relation){
						loadRelationsOld(r);
					}
					setFieldValueToObject(obj, field, relation);
				}
				else{
					Object relation = get(ClassUtil.newInstance(modelR.getClassName()),where);
					loadRelationsOld(relation);
					setFieldValueToObject(obj, field, relation);
				}
				


		}
		
	}
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * @param clazz Clase que representa la tabla a buscar.
	 * @return Listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 */
	public <T> List<T> find(Class<T> clazz){
		ModelDefinition model = getModel(clazz);
		StringBuilder sql = new StringBuilder(model.getSqlSelect());
		processPagination(sql);
		return execute(model,sql.toString(), null);
	}
	
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * aplicando las restricciones indicadas en <code>object</code></p>.
	 * 
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @return Listado de todos los objetos de la tabla representada por <code>object</code>.
	 */
	public <T> List<T> find(Object object){
		ModelDefinition model = getModel(object);
		StringBuilder sql = new StringBuilder(model.getSqlSelect());
		List params = getDynamicWhereFromObject(object, model, sql);
		processPagination(sql);
		return execute(model,sql.toString(), params);
	}
	
	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 * @param clazz Clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return Un listado de todos los objetos de la tabla representada por <code>clazz</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 */
	public <T> List<T> find(Class<T> clazz, SQLWhere where){
		ModelDefinition model = getModel(clazz);
		StringBuilder sql = new StringBuilder(model.getSqlSelect());
		List params = new ArrayList();
		processWhere(clazz, where, sql, params);	
		processPagination(sql);
		return execute(model,sql.toString(), params);
	}


	/**
	 * <p>Devuelve un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code></p>.
	 * <p>Para realizar el filtro se añaden los valores contenidos en <code>object</code>.
	 * </p>
	 * 
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return Un listado de todos los objetos de la tabla representada por <code>object</code>.
	 * que cumplan con las restricciones indicadas en <code>where</code>.
	 */
	public List find(Object object, SQLWhere where){
		appendWhereFromObject(object, getModel(object), where);
		return find(object.getClass() , where);
	}
	
	/**
	 * <p>Devuelve una única fila de la tabla representada por <code>object</code></p>.
	 * <p>Si retorna más de un objeto se lanza una <code>PersistanceException</code> con el código 
	 * <code>ErrorMessageID.PE_00001</code></p>.
	 * @param object Objeto de la clase que representa la tabla a buscar.
	 * @param where Restricciones de la consulta.
	 * @return una única fila de la tabla representada por <code>object</code>
	 */
	public Object get(Object object, SQLWhere where){
		ModelDefinition model = getModel(object);


		StringBuilder sql = new StringBuilder(model.getSqlSelect());
		List params = new ArrayList();
		processWhere(object.getClass(), where, sql, params);	
		List result = execute(model, sql.toString(), params);
		if (result == null || result.isEmpty()){
			return null;
		}
		
		if (result.size() > 1){
			throw new PersistanceException(ErrorMessageID.PE_00001 , model.getTable());
		}
		
		return result.get(0);
	}

	
	/**
	 * @param orderBy
	 * @param sql
	 */
	private void processOrderBy(SQLOrderBy orderBy, StringBuilder sql) {
		if (orderBy == null){
			return ;
		}
		
		List<SQLField> fields = orderBy.getFields();
		
		if (fields == null || fields.isEmpty()){
			return; 
		}
		
		sql.append(SQLConstants.ORDER_BY);
		for (SQLField field : fields) {
			ModelDefinition md = getModel(field.getClazz());
			String table = md.getTable();
			String column = md.getAttributeToColumn(field.getField());
			
			sql.append(table)
				.append(SQLConstants.DOT)
				.append(column)
				.append(SQLConstants.COMMA);
		}
		
		sql = sql.deleteCharAt(sql.length()-1);
		
		sql.append(SQLConstants.BLANK).append(orderBy.getOrder());
		
	}
	
	private void processGroupBy(SQLGroupBy groupBy, StringBuilder sql) {
		if (groupBy == null){
			return ;
		}
		
		List<SQLField> fields = groupBy.getFields();
		
		if (fields == null || fields.isEmpty()){
			return; 
		}
		
		sql.append(SQLConstants.GROUP_BY);
		for (SQLField field : fields) {
			ModelDefinition md = getModel(field.getClazz());
			String table = md.getTable();
			String column = md.getAttributeToColumn(field.getField());
			
			sql.append(table)
				.append(SQLConstants.DOT)
				.append(column)
				.append(SQLConstants.COMMA);
		}
		
		sql = sql.deleteCharAt(sql.length()-1);
		

		
	}
	/**
	 * @param object
	 * @param model
	 * @param sql
	 * @return
	 */
	private List getDynamicWhereFromObject(Object object, ModelDefinition model, StringBuilder sql) {
		List<String> columnsList = model.getColumnNames();
		Map<String,Field> attSql =  model.getColumnToAttribute();
		Map<String,Relationship> relations =model.getRelations();
		//primero se han de procesar las relaciones con inner join y después los campos "normales"
		List params = new ArrayList();
		boolean isWhereSet = false;
		for (String column : columnsList) {
			Field field = attSql.get(column);
			Object value = ClassUtil.getFieldValueFromObject(object, field.getAttribute());
			
			if (value!=null){
//				Relationship r =  relations.get(field.getAttribute());
//				if (r!=null){
//					SQLInnerJoin inj = new SQLInnerJoin(object.getClass(), r.getTargetClass(), r.getField(),r.getTargetField());
//					SQLSelect se = new SQLSelect();
//					se.setInnerJoin(inj);
//					processInnerJoin(se, sql, params);
//				}
				
				if (!isWhereSet){
					sql.append(SQLConstants.WHERE_1_1);
					isWhereSet = true;
				}
				sql.append(SQLConstants.AND)
				.append(column)
				.append(SQLConstants.EQUAL_QUESTION_MARK);
				params.add(value);
			}
		}
		return params;
	}
	
	/**
	 * <p>Añade a <code>sqlWhere</code> las condiciones de filtro indicadas en <code>object</code>.</p>
	 * @param object
	 * @param model
	 * @param sqlWhere
	 * @return sqlWhere
	 */
	private SQLWhere appendWhereFromObject(Object object, ModelDefinition model, SQLWhere sqlWhere) {
		List<String> columnsList = model.getColumnNames();
		Map<String,Field> attSql =  model.getColumnToAttribute();
		for (String column : columnsList) {
			Field field = attSql.get(column);
			Object value = ClassUtil.getFieldValueFromObject(object, field.getAttribute());
			if (value!=null){
				sqlWhere.add(SQLCondition.getAND(field.getAttribute(), value));
			}

		}
		return sqlWhere;
	}
	
	/**
	 * <p>Crea un <code>SQLWhere</code> con las condiciones de filtro indicadas en <code>object</code>.</p>
	 * @param object
	 * @param sqlWhere
	 * @return sqlWhere
	 */
	public SQLWhere getWhereFromObject(Object object) {
		SQLWhere sqlWhere = new SQLWhere();
		ModelDefinition model = getModel(object);
		return appendWhereFromObject(object,model,sqlWhere);
	}
	
	/**
	 * <p>.</p>
	 * @param select
	 * @param sql
	 */
	private void processInnerJoin(SQLSelect select, StringBuilder sql, List params){
		if (select.getInnerJoin() == null){
			return;
		}
		
		SQLInnerJoin innerJoin = select.getInnerJoin();
		ModelDefinition sourceModel = getModel(innerJoin.getSourceTable());
		ModelDefinition targetModel = getModel(innerJoin.getTargetTable());
		
		sql.append( SQLConstants.INNER_JOIN)
			.append(targetModel.getFullTableName())		
			.append( SQLConstants.ON);

		sql.append(sourceModel.getFullTableName())
		.append(SQLConstants.DOT)
		.append(sourceModel.getAttributeToColumn(innerJoin.getSourceField()))
		.append( SQLConstants.EQUAL) //TODO esto debería poder especificarlo el usuario
		.append(targetModel.getFullTableName())
		.append(SQLConstants.DOT)
		.append(targetModel.getAttributeToColumn(innerJoin.getTargetField()));
		
		
		if (innerJoin.getConditions() != null){
//			int index = 0;
			for (SQLCondition condition : innerJoin.getConditions()) {
				if (conditionToSQL(condition, sql)){
					params.add(condition.getValue());
				}
//				index++;
			}

		}
	}
	
	/**
	 * <p>.</p>
	 * @param having
	 * @param sql
	 * @param params
	 */
	private void processHaving(SQLHaving having, StringBuilder sql, List params){
		if (having == null){
			return;
		}
		
		sql.append( SQLConstants.HAVING);
		sql.append(SQLConstants._1_1);
		//El render de la condición incluye el AND, por eso poneos 1=1
		SQLCondition condition = having.getCondition();
		if (conditionToSQL(condition, sql)){
			params.add(condition.getValue());
		}

	}

	/* (non-Javadoc)
	 * @see es.caser.po2008.dao.sql.processors.SQLSelectProcessor#getSQL(java.lang.Class)
	 */
	public String getSQL(Class clazz) {
		ModelDefinition model = modelManager.getModel(clazz);
		//List<String> list = model.getColumnNames();
		Collection<Field> list =  model.getAttributeToColumn().values();
		StringBuilder sql = new StringBuilder(SQLConstants.SELECT);

		for (Field field : list) {
			if (!field.isTransient()){
				sql.append(field.getColumn()).append(SQLConstants.COMMA);
			}
		}
		sql = new StringBuilder(sql.substring(0, sql.length()-1));
		sql.append(SQLConstants.FROM)
//		.append(ModelManager.getInstance().getSchemaName())
//		.append(SQLConstants.DOT)
//		.append(model.getTable());
		.append(model.getFullTableName());
		return sql.toString();
	}

	public List executeNamedQuery(String queryKey, Object param) {
		NamedQuery query = modelManager.getNamedQuery(queryKey);
		if (query == null){
			throw new PersistanceException(ErrorMessageID.PE_00023, queryKey);
		}
		List<String> attributtes = query.getAttributes();
		List params = new ArrayList();
		if (attributtes!=null){
			
			for (String attribute : attributtes) {
				params.add( ClassUtil.getFieldValueFromObject(param, attribute));
			}
		}
		else{
			params = (List)(param);
		}
		
		SQLSelect select = new SQLSelect();
		select.setOutputModel(getModel(query.getModel()));
		select.setSqlQuery(query.getQuery(), params);
		return executeLiteralQuery(select);
	}

	
	
	/* (non-Javadoc)
	 * @see es.caser.persistance.sql.processors.SQLSelectProcessor#count(java.lang.Class)
	 */
	public Long count(Class clazz) {
		SQLSelect select = new SQLSelect();
		select.addSelectField(new SQLField(clazz,"*",SQLFunction.COUNT, ScalarResult.SCALAR_RESULT));
		select.addFrom(clazz);
		select.setOutputModel(ScalarResult.getModel());
		
		List<ScalarResult> result = execute(select);
		return result.get(0).getValue();
	}

	/* (non-Javadoc)
	 * @see es.caser.persistance.sql.processors.SQLSelectProcessor#count(java.lang.Object)
	 */
	public Long count(Object example) {
		SQLSelect select = new SQLSelect();
		select.addSelectField(new SQLField(example.getClass(),"*",SQLFunction.COUNT, ScalarResult.SCALAR_RESULT));
		select.addFrom(example.getClass());
		select.setOutputModel(ScalarResult.getModel());
		select.setWhere(getWhereFromObject(example));
		List<ScalarResult> result = execute(select);
		return result.get(0).getValue();
	}
	
	public Object loadRelation(Object target , String field) {
		ModelDefinition model = modelManager.getModel(target);
		Map<String, Relationship> relations = model.getRelations();
		if (relations == null){
			return null;
		}
		
		Relationship relationship = relations.get(field);
		if (relationship == null){
			return null;
		}
		
		ModelDefinition modelR = modelManager.getModel(relationship.getTargetClass());

		Class realClazz = ClassUtil.getClass(modelR.getClassName());
		Object searchValue = ClassUtil.getFieldValueFromObject(target, relationship.getField());
		SQLWhere where = new SQLWhere();
		where.add(SQLCondition.getAND(realClazz, 
									relationship.getTargetField(), 
									searchValue));
		
		if (ClassUtil.isList(target, field)){//Buscamos un listado?
			return find(realClazz, where);
		}

		return get(ClassUtil.newInstance(modelR.getClassName()),where);

	}


}
