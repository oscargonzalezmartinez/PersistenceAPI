package com.ogm.persistance.sql.processors.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.util.ErrorMessageID;



/**
 * <p>Clase encargada de ejecutar las SQLs.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.1 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public final class SQLExecutor {
	/**
	 * log category.
	 */
	private static final String PERSISTANCE_SQL_LOG = "com.ogm.persistance.SQL";

	/**
	 * log.
	 */
	protected static final Log sqlLog = LogFactory.getLog(PERSISTANCE_SQL_LOG);
	
	/**
	 * para pasar a segundos.
	 */
	private static final int MIL = 1000;


	/**
	 * Constructor privado.
	 */
	private SQLExecutor(){
		
	}
	/**
	 * <p>Ejecuta un update.</p>
	 * @param modelManager Modelmanager sobre el que ejecutar la sentencia.
	 * @param sql Sentencia a ejecutar.
	 * @param params parámetros de la sentencia.
	 * @return número de registros afectados.
	 */
	protected static  int executeUpdate(ModelManager modelManager,String sql, List params){

		if (sqlLog.isInfoEnabled()){
			sqlLog.info(sql);
		}		
		
		DataSource ds = getDataSource(modelManager);
		Connection con = getConnection(ds);

		PreparedStatement st = null;
		try{
			st = con.prepareStatement(sql);//Statement.RETURN_GENERATED_KEYS  Statement.NO_GENERATED_KEYS
			setParams(params, st);
			long ini = System.currentTimeMillis();
			int result = st.executeUpdate();
			if (sqlLog.isDebugEnabled()){
				sqlLog.debug("Tiempo ejecución (ms) " + (System.currentTimeMillis() - ini));
			}
			return result;
		}catch(Exception e){
			handleException(sql, params, e);
			//nunca vamos a llegar hasta aquí, ya que handleException siempre lanza una Runtime, 
			//pero el compilador no lo sabe y nos obliga a poner un valor de retorno
			return -1;
		}finally{
			close(ds, con, st, null); 
		}
	}



	/**
	 * <p>Devuelve una conexión a base de datos.</p>
	 * @param ds Datasource que proporciona el acceso.
	 * @return  conexión a base de datos.
	 */
	private static Connection getConnection(DataSource ds) {
		long inids = System.currentTimeMillis();
		Connection con = DataSourceUtils.getConnection(ds);
		long endds = System.currentTimeMillis() - inids;
		if (endds > MIL){
			sqlLog.warn("DS_WAIT : El DataSource ha tardado en devolver una conexión " + (endds / MIL) + " s ");
		}
		return con;
	}


	
	/**
	 * <p>Ejecuta la sql.</p>
	 * @param modelManager Modelmanager sobre el que ejecutar la sentencia.
	 * @param sql Sentencia a ejecutar.
	 * @param params par�metros de la sentencia.
	 * @return listado de mapas.
	 */
	protected static List<Map> execute(ModelManager modelManager,String sql, List params){
		if (sqlLog.isInfoEnabled()){
			sqlLog.info(sql);
		}		
		
		DataSource ds = getDataSource(modelManager);
		Connection con = getConnection(ds);
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			st = con.prepareStatement(sql);
			setParams(params, st);
			
			long ini = System.currentTimeMillis();
			rs = st.executeQuery();
			if (sqlLog.isDebugEnabled()){
				sqlLog.debug("Tiempo ejecución (ms) " + (System.currentTimeMillis() - ini));
			}
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String []columns = new String[columnCount];
			for (int i = 1; i <= columnCount; i++){
				columns[i-1] = rsmd.getColumnName(i);
			}
			
			List<Map> result = new ArrayList<Map>();
			while(rs.next()){
				Map row = new HashMap();
				for (int i = 0; i < columnCount; i++){
					String columnName = columns[i];
					Object value = rs.getObject(columnName);
					if (value instanceof Date){
						value = rs.getTimestamp(columnName);
					}
					row.put(columnName, value);
				}
				result.add(row);
			}
			return result;
		}catch(Exception e){
			handleException(sql, params, e);
			//nunca vamos a llegar hasta aquí, ya que handleException siempre lanza una Runtime, 
			//pero el compilador no lo sabe y nos obliga a poner un valor de retorno
			return null;
		}finally{
			close(ds, con, st, rs); 
		}
	}


	/**
	 * <p>Recupera el data source asociado a <b>modelManager</b>.</p>
	 * @param modelManager ModelManager del que obtener el data source
	 * @return data source asociado a <b>modelManager</b>.
	 */
	private static DataSource getDataSource(ModelManager modelManager) {
		return modelManager.getDataSourceProvider().getDataSource();
	}


	/**
	 * <p>Cierra la conexi�n, el resultset y el prepared statemenr.</p>
	 * @param ds Data source al que pertenenecen.
	 * @param con conexi�n a cerrar.
	 * @param st PreparedStatement a cerrar.
	 * @param rs ResultSet a cerrar.
	 */
	private static void close(DataSource ds, Connection con,
			PreparedStatement st, ResultSet rs) {
		if (st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				sqlLog.warn("close",e);
			}
		}
		if (rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				sqlLog.warn("close",e);
			}
		}
		DataSourceUtils.releaseConnection(con, ds);
	}


	/**
	 * <p>Fija los parámetros en el preparedstatement.</p>
	 * @param params
	 * @param st
	 * @throws SQLException
	 */
	private static void setParams(List params, PreparedStatement st)	throws SQLException {
		int index = 1;
		StringBuilder sb = null;
		if (params!=null){
			
			try{
			sb = new StringBuilder();
			for (Iterator it =  params.iterator(); it.hasNext();) {
				Object value = (Object) it.next();
				sb.append(value).append("; ");
				st.setObject(index, value);
				index++;

			}
			if (sqlLog.isDebugEnabled()){
				sqlLog.debug("params " + sb);
			}
			}catch(SQLException e){
				if (sb!=null){
					sqlLog.error("�ndice ["+index+"]. Params: "+sb,e);
				}
				throw e;
			}
		}
	}

	

	/**
	 * <p>Trata la excepción.</p>
	 * @param sql Sql que ha provocado el error
	 * @param params par�metros de la sql.
	 * @param e excepci�n
	 * @throws PersistanceException de c�digo ErrorMessageID.PE_00000
	 */
	private static void handleException(String sql, List params, Exception e) throws PersistanceException{
		String logCode = getLogCode();
		sqlLog.error("Error "+logCode+": \nsql:" + sql + " \nparams " + params);
		sqlLog.error(e);
		throw new PersistanceException(ErrorMessageID.PE_00000, e,logCode);
	}
	
	/**
	 * <p>código de log..</p>
	 * @return código de log.
	 */
	private static String getLogCode(){
		return System.currentTimeMillis() + "#"+ Math.round(Math.random()*MIL);
	}
	
}
