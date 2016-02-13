package com.ogm.persistance.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import com.ogm.persistance.test.dao.impl.DAOUtilityExample;
import com.ogm.persistance.test.model.Usuario;
import com.ogm.persistance.test.model.Detalle;
import com.ogm.persistance.test.model.Proyecto;

import junit.framework.TestCase;

import com.ogm.persistance.sql.*;
import com.ogm.persistance.sql.conditions.*;

public class Test extends TestCase{
	
	protected static final Log log =  LogFactory.getLog(Test.class.getName());
		
	@Override
	protected void setUp() throws Exception {
	
			PropertyConfigurator.configure(Test.class.getResource("/log4j.properties"));
			//Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:PUBLIC;sql.syntax_ora=true");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:PUBLIC;sql.syntax_ora=true");
			
			

			java.sql.DatabaseMetaData dbm = conn.getMetaData();

			java.sql.ResultSet tables = dbm.getTables(null, null, "T_USUARIO", null);
			if (!tables.next()) {
				BufferedReader br = new BufferedReader(new InputStreamReader(Test.class.getResourceAsStream("/testDB.ddl")));
				String line = br.readLine();
				while(line!=null){
					log.info(conn.createStatement().executeUpdate(line));
					//conn.commit();
					line = br.readLine();
				}		

				conn.close();
			}
	}

	
	public boolean isTableExist(Connection connection,String sTablename) throws SQLException{
	        DatabaseMetaData dbmd = connection.getMetaData();
	        ResultSet rs = dbmd.getTables(null, null, sTablename.toUpperCase(),null);
	        return rs.next();
	}
	
	//protected static Log log = LogFactory.getLog(Test.class.getName()+".SQL");
	public static void main(String[] args){
		//junit.textui.TestRunner.run(Test.class);
		Test t = new Test();
		//t.testFechaEfectoOrNull();
		//t.testInnerjoin();
		//t.testReciboPolizaCertificado();
		//t.testTransaction();
		//t.testConditions();
	//	t.testNamedQuery();
		//t.testExpedienteR();
		//t.testMandatory();
		//t.testPagination();
		
		//t.testCache();
		//t.testCount();
		//t.testEnhace();
		
		//t.testHaving();
		
		
		DAOUtilityExample.executeNamedQuery("ejemplar.con.codigoPostal",null);
	}
//	}
//	@org.junit.Test
//	public void update() {
//		Expediente ex = testLoadExpediente();
//		DAOUtilityExample.updateComplete(ex);
//		
//	}


	
	//@org.junit.Test
	public void testInsertUsuario(){
		log.info("testInsertUsuario----------------------");
		Usuario usuario = new  Usuario();
		//usuario.setId(154L);
		usuario.setEdad(25L);
		usuario.setApellidos("apellidos");
		usuario.setNombre("MyName");
		DAOUtilityExample.beginTransaction();
		DAOUtilityExample.insert(usuario);
		DAOUtilityExample.commitTransaction();
	
		usuario = new  Usuario();
		usuario.setNombre("MyName");
		java.util.List<Usuario> usuariosDB = DAOUtilityExample.find(usuario);
		log.info("***  usuarioDB " + usuariosDB);
	}
	
	@org.junit.Test
	public void testInsertUsuarioFull(){
		log.info("testInsertUsuarioFull----------------------");
		Usuario usuario = new  Usuario();
		//usuario.setId(154L);
		usuario.setEdad(25L);
		usuario.setApellidos("apellidos");
		usuario.setNombre("MyName");
		
		Detalle detalle = new Detalle();
		detalle.setTexto("Esto es un detalle");
		usuario.setDetalle(detalle);

		java.util.List<Proyecto> proyectos = new java.util.ArrayList<Proyecto>();		
		Proyecto proyecto = new Proyecto();
		proyecto.setTexto("Esto es un Proyecto 1 ");
		proyectos.add(proyecto);
		
		proyecto = new Proyecto();
		proyecto.setTexto("Esto es un Proyecto 2 ");
		proyectos.add(proyecto);
		
		usuario.setProyectos(proyectos);	

		DAOUtilityExample.beginTransaction();
		DAOUtilityExample.insertComplete(usuario);
		DAOUtilityExample.commitTransaction();
	
		usuario = new  Usuario();
		usuario.setNombre("MyName");
		java.util.List<Usuario> usuariosDB = DAOUtilityExample.find(usuario);
		usuario = usuariosDB.get(0);
		log.info("***  usuarioDB " + usuario);
		log.info("***  usuarioDB detalle (eager) " + usuario.getDetalle());
		log.info("***  usuarioDB proyectos (lazy) " + usuario.getProyectos());
		log.info("----------------------------");
		log.info("***  usuarioDB proyectos (lazy) " + usuario.getProyectos());
	}
	
	public void testNamedQueryQM(){
		log.info("testNamedQueryQM----------------------");
		log.info(DAOUtilityExample.executeNamedQuery("proyecto.texto.qmark",java.util.Arrays.asList(1L)));
	}
	
	public void testNamedQueryATTR(){
		log.info("testNamedQueryATTR----------------------");
		Proyecto proyecto = new Proyecto();
		proyecto.setId(1L);
		log.info(DAOUtilityExample.executeNamedQuery("proyecto.texto.attr",proyecto));
	}
	
	public void testProgrammingQuery(){
		log.info("testProgrammingQuery----------------------");
		Long isUsuario = new Long(2L);
		SQLSelect select = new SQLSelect();

		select.addSelectField(Usuario.class, "nombre")
				.addSelectField(Proyecto.class, "id")
				.addSelectField(Proyecto.class, "texto");
		//añadimos las tablas
		select.addFrom(Usuario.class).addFrom(Proyecto.class);
//		
//		//añadimos las restricciones
		select.addCondition(SQLCondition.getAND(Usuario.class, "id", isUsuario))
			.addCondition(new SQLJoinCondition(Usuario.class,"id",Proyecto.class,"idUsuario"))
			.addCondition(SQLCondition.getANDFunction(Proyecto.class, "texto", SQLFunction.LIKE,"%Proyecto%"));
//
		SQLOrderBy orderBy =  new SQLOrderBy();
		orderBy.addField(Usuario.class, "nombre");
		orderBy.addField(Proyecto.class, "texto");
//
		select.setOrderBy(orderBy);
//
		select.setOutputModel(Proyecto.class);
		log.info(DAOUtilityExample.execute(select));
	}
	
//	@org.junit.Test
//	public void testJoin(){
//
//		Long idExpediente = new Long(1172L);
//		SQLSelect select = new SQLSelect();
//		//añadimos todos los campos de la salida
//		select.addSelectField(EstadoExpediente.class, "fechaDetalle")
//				.addSelectField(EstadoExpediente.class, "estadoDetalle")
//				.addSelectField(EstadoExpediente.class, "numeroBloque")
//				.addSelectField(TipoBloque.class, "textoGui", "descripcion");
//		//añadimos las tablas
//		select.addFrom(EstadoExpediente.class).addFrom(TipoBloque.class);
//		
//		//añadimos las restricciones
//		select.addCondition(SQLCondition.getAND(EstadoExpediente.class, "expediente", idExpediente))
//			.addCondition(new SQLJoinCondition(EstadoExpediente.class,"numeroBloque",TipoBloque.class,"numeroBloque"));
//
//		SQLOrderBy orderBy =  new SQLOrderBy();
//		orderBy.addField(EstadoExpediente.class, "fechaDetalle");
//		orderBy.addField(EstadoExpediente.class, "numeroBloque");
//
//		select.setOrderBy(orderBy);
//
//		select.setOutputModel(EstadoExpediente.class);
//		DAOUtilityExample.execute(select);
//
//	}	
//	@org.junit.Test
//	public void testConditions() {
//		SQLSelect select = new SQLSelect();
//		//añadimos todos los campos de la salida
//
//		//añadimos las tablas
//		select.addFrom(Expediente.class);
//		//select.addSelectField(new SQLField(Expediente.class, "expediente"));
//		//añadimos las restricciones
//		select.addCondition(SQLCondition.getAND("tipoProceso", "2", SQLExpresion.NOT_EQUALS));
//	//	select.addCondition(SQLCondition.getAND("tipoProceso", "2"));
//		System.out.println(DAOUtilityExample.execute(select).size());
//	}
//	
//	@org.junit.Test
//	public void testPagination() {
//		SQLField field = new SQLField(Expediente.class, "distribuidor", "MyDis");
// 
//		SQLSelect select = new SQLSelect();
//		select.addSelectField(field);
//		select.addSelectField(new SQLField(Expediente.class, "expediente"));
//		select.addFrom(Expediente.class).addFrom(EstadoExpediente.class);
//		
//		//select.addCondition(SQLCondition.getANDFunction(Expediente.class, "descDistribuidor", SQLFunction.LIKE, "%CAJA%"));
//		select.addCondition(new SQLJoinCondition(Expediente.class,"expediente",EstadoExpediente.class,"expediente"));
//		
//		SQLGroupBy groupBy = new SQLGroupBy();
//		groupBy.addField(field);
//		//select.setGroupBy(groupBy);
//		
//		SQLOrderBy orderBy = new SQLOrderBy();
//		orderBy.addField(field);
//		select.setOrderBy(orderBy);
//		
//		select.setOutputModel(Expediente.class);
//		select.setPagination(new SQLPagination(100L,103L));
//		List result = DAOUtilityExample.execute(select);
//		log.info("result " + result.size());
//		log.info("result " + result.get(0));
//		log.info("result " + result.get(result.size()-1));
//		
//	}
////	private static void insert() {
////		Expediente exp = load();
////		exp.setExpediente(null);
////		for(EstadoExpediente ee: exp.getEstadosExpediente()){
////			ee.setExpediente(null);
////			ee.setNumeroDetalle(null);
////		}
////
////		for(DetalleSuceso ee: exp.getDetalleSucesos()){
////			ee.setExpediente(null);
////			ee.setNumeroDetalle(null);
////		}
////		
////		DAOUtilityExample.insertComplete(exp);
////	}
//
//	@org.junit.Test
//	public void testLoadExpediente() {
//		Expediente exp = DAOUtilityExample.getComplete(Expediente.class, new Long(862));
//		Assert.assertNotNull(exp);
//		//log.info(exp);
////		sqlTracer.info(exp.getEstadosExpediente());
////		sqlTracer.info(exp.getDetalleSucesos());
////		sqlTracer.info(exp.getTipoProcesoBPM());
//		//return exp;
//	}
//	
//	@org.junit.Test
//	public void testExecuteLiteral(){
//		String sql = "select * from adm_bpmpo.TX_EXPEDIENTES";
//		SQLSelect select = new SQLSelect();
//		select.setSqlQuery(sql);
//		select.setPagination(new SQLPagination(0L,10L));//limitamos el resultado
//		Assert.assertNotNull(DAOUtilityExample.execute(select));
//	}
//	
//	@org.junit.Test
//	public  void testQueryByExample() {
//		
//		Expediente exp = new Expediente();
//		exp.setPuntoVenta("33002145");
//		exp.setCliente(new Long(56));
//			
//		log.info(	DAOUtilityExample.find(exp));
//
//	}
//	
//	@org.junit.Test
//	public void testQuery() {
//		//SQLField field = new SQLField(Expediente.class, "*", SQLFunction.COUNT, "c");
//		SQLField field = new SQLField(Expediente.class, "expediente", SQLFunction.SUM, "res");
//		
////		ModelDefinition md = new ModelDefinition("es.caser.test.MyObject",null,null);
////		md.addColumnToAttribute("c", "myCount");
//		
//		ModelDefinition md = ModelDefinition.newModel(com.ogm.persistance.test.ScalarResult.class);
//		
//		SQLSelect select = new SQLSelect();
//		select.addSelectField(field);
//		select.addFrom(Expediente.class);
//		select.setOutputModel(md);
//		
//		List result = DAOUtilityExample.execute(select);
//		log.info("result programado SUM " + result);
////		String sqlQuery = "SELECT COUNT ( TX_EXPEDIENTES.TX_TEX_PUNTO_VENTA )  res FROM ADM_BPMPO.TX_EXPEDIENTES";
////		select.setSqlQuery(sqlQuery);
//		//result = DAOUtilityExample.execute(select);
//		//mantenemos el model de salida
//		//sqlTracer.info("result a pelo COUNT " + result);
//		
//	}
//	
//	@org.junit.Test
//	public  void testNamedQuery(){
//		Expediente expediente = new Expediente();
//		expediente.setTipoProceso(new Integer(2));
//		expediente.setTipoTarea(new Integer(10));
//
//		//System.out.println(DAOUtilityExample.executeNamedQuery("emisiones.mensuales",Arrays.asList(new Expediente[] {expediente} )));
//		System.out.println(DAOUtilityExample.executeNamedQuery("emisiones.mensuales",expediente).size());
//		System.out.println(DAOUtilityExample.executeNamedQuery("test2",expediente).size());
//		
//	}
//	
//	@org.junit.Test
//	public void  testComplexQuery(){
//		ModelDefinition outputModel = ModelDefinition.newModel(TareaRecibos.class);
//		Boolean bFechaRevisionNull = Boolean.TRUE;
//		TareaRecibos tareaRecibos = new TareaRecibos();
//		tareaRecibos.setGrupoResponsable("INFORMAT");
//		tareaRecibos.setFechaHasta(new Date());
//		SQLSelect select = new SQLSelect();
//
//		//añadimos todos los campos de la salida
//		//con alias SQL para el mapeo a otra clase distinta que las indicadas aquí
//		select.addSelectField(DetalleSuceso.class, "numeroDetalle", "numeroDetalle")
//				.addSelectField(Expediente.class, "reciboAs400", "reciboAs400")
//				.addSelectField(Expediente.class, "ciaRecibo", "ciaRecibo")
//				.addSelectField(Expediente.class, "ramo", "ramo")
//				.addSelectField(Expediente.class, "modalidad", "modalidad")
//				.addSelectField(Expediente.class, "poliza", "poliza")
//				.addSelectField(Expediente.class, "certificado", "certificado")
//				.addSelectField(DetalleSuceso.class, "codigoSuceso", "codigoSuceso")
//				.addSelectField(DetalleSuceso.class, "descripcion", "descSuceso")
//				.addSelectField(DetalleSuceso.class, "usuarioRevision", "usuarioRevision")
//				.addSelectField(DetalleSuceso.class, "fechaRevision", "fechaRevision")
//				.addSelectField(DetalleSuceso.class, "fechaSuceso", "fechaSuceso");
//		
//		//añadimos las tablas
//		select.addFrom(Expediente.class).addFrom(DetalleSuceso.class);
//		
//		//añadimos las restricciones
//		select.addCondition(new SQLJoinCondition(Expediente.class,"expediente",DetalleSuceso.class,"expediente"))
//			.addCondition(SQLCondition.getAND(DetalleSuceso.class, "tipoSuceso", 1));
//		
//		if (bFechaRevisionNull.booleanValue()){
//			select.addCondition(SQLCondition.getAND_IS_NULL(DetalleSuceso.class,"fechaRevision"));
//		}else{
//			select.addCondition(SQLCondition.getAND_IS_NOT_NULL(DetalleSuceso.class,"fechaRevision"));
//		}
//		
//		select.addCondition(SQLCondition.getAND(DetalleSuceso.class, "responsable", tareaRecibos.getGrupoResponsable()));
//			
//		if (tareaRecibos.getFechaDesde()!=null){
//			select.addCondition(SQLCondition.getAND(DetalleSuceso.class,"fechaSuceso",tareaRecibos.getFechaDesde(),SQLExpresion.GREATER_EQUALS));
//		}
//		
//		if (tareaRecibos.getFechaHasta()!=null){
//			select.addCondition(SQLCondition.getAND(DetalleSuceso.class,"fechaSuceso",tareaRecibos.getFechaHasta(),SQLExpresion.LOWER_EQUALS));
//		}
//		
//		select.addCondition(new SQLBetweenCondition(Expediente.class,"inicioExped","finExped"));
//		select.addCondition(SQLCondition.getAND_IS_NOT_NULL(Expediente.class,"expediente"));
//		List<Long> notExpdList = new ArrayList<Long>(3);
//		notExpdList.add( new Long(33335));
//		notExpdList.add( new Long(33235));
//		notExpdList.add( new Long(553335));
//		select.addCondition(SQLCondition.getANDFunction(Expediente.class, "expediente", SQLFunction.NOT_IN,notExpdList));
//		
//		select.setOutputModel(outputModel);
//		List result = DAOUtilityExample.execute(select);
//		System.out.println(result);
//	}
//	@org.junit.Test
//	public void testInsertComplexPK(){
//		ProTmp pt = new ProTmp();
//		pt.setCia("X");
//		pt.setRamo("X");
//		pt.setModalidad("X");
//		pt.setSubmodalidad("X");
//		pt.setWm("X");
//		
//		DAOUtilityExample.insert(pt);
//		
//	}
//	@org.junit.Test
//	public void testUpdateComplexPK(){
//		ProTmp pt = new ProTmp();
//		pt.setCia("X");
//		pt.setRamo("X");
//		pt.setModalidad("X");
//		pt.setSubmodalidad("X");
//		pt.setWm("cccX");
//		
//		DAOUtilityExample.update(pt);
//		
//	}
//	@org.junit.Test
//	public void testInsertSequence(){
//		DetalleSuceso ds = new DetalleSuceso();
//		ds.setCodigoSuceso("1");
//		ds.setDesTipoSuceso("1");
//		ds.setExpediente(new Long(2876));
//		ds.setFechaRevision(new Date());
//		ds.setTipoSuceso(new Integer(1));
//		DAOUtilityExample.insert(ds);
//	}
//	@org.junit.Test(expected=PersistanceException.class)
//	public void testNoExisteTabla(){
//		DAOUtilityExample.find(new NoExiste());
//	}
//	@org.junit.Test
//	public void testObjetoNoMapeado(){
//		DAOUtilityExample.find(new Long(1));
//	}
//	@org.junit.Test
//	public void testTransaction(){
//		try{
//			DAOUtilityExample.beginTransaction();
//			testInsertSequence();
////			if (true){
////				throw new Throwable("ASKEK");
////			}
//			
//			
//			DAOUtilityExample.commitTransaction();
//		}catch(Throwable t){
//			DAOUtilityExample.rollbackTransaction();
//		}
//	}
//	@org.junit.Test
//	public void testExpedienteR(){
//		Long id = new Long(1766);
//		ExpedienteR exp = new  ExpedienteR();
//		exp.setExpediente(id);
//		
////		DetalleSuceso ds = new DetalleSuceso();
////		ds.setResponsable("INFORMAT");
////		List<DetalleSuceso> dsl = new ArrayList<DetalleSuceso>(1);
////		dsl.add(ds);
////		exp.setDetalleSuceso(dsl);
//		exp = DAOUtilityExample.get(exp);
//		System.out.println("getConversationIdBpm " + exp.getConversationIdBpm());
//		System.out.println("------------------EAGER----------------");		
//		System.out.println(exp.getDetalleSuceso());
//		System.out.println("--------------------------------------------------------");
//		
//		System.out.println("------------------LAZY----------------");		
//		System.out.println(exp.getEstadosExpediente());
//		System.out.println("--------------------------------------------------------");
//		
////		System.out.println(DAOUtilityExample.find(exp));
////		DAOUtilityExample.update(exp);
//
//	}
//	@org.junit.Test(expected=ValidationException.class)
//	public void testMandatory(){
//		DetalleSuceso ds = new DetalleSuceso();
//		ds.setExpediente(new Long(3333));
//		ds.setCodigoSuceso("12345");//MAXLENGT puesto a 2
//		DAOUtilityExample.insert(ds);
//		
//	}
//	
//	@org.junit.Test
//	public void testInnerjoin(){
//
//		Long idExpediente = new Long(1172L);
//		SQLSelect select = new SQLSelect();
//		//añadimos todos los campos de la salida
//		select.addSelectField(EstadoExpediente.class, "fechaDetalle")
//				.addSelectField(EstadoExpediente.class, "estadoDetalle")
//				.addSelectField(EstadoExpediente.class, "numeroBloque")
//				.addSelectField(TipoBloque.class, "textoGui", "descripcion");
//		//añadimos las tablas
//		select.addFrom(EstadoExpediente.class);
//		select.setInnerJoin(new SQLInnerJoin(EstadoExpediente.class,TipoBloque.class,"numeroBloque","numeroBloque"));
//		//añadimos las restricciones
//		select.addCondition(SQLCondition.getAND(EstadoExpediente.class, "expediente", idExpediente));
//
//		SQLOrderBy orderBy =  new SQLOrderBy();
//		orderBy.addField(EstadoExpediente.class, "fechaDetalle");
//		orderBy.addField(EstadoExpediente.class, "numeroBloque");
//
//		select.setOrderBy(orderBy);
//
//		select.setOutputModel(EstadoExpediente.class);
//		DAOUtilityExample.execute(select);
//
//	}	
//	@org.junit.Test
//	public void testReciboPolizaCertificado(){
//		String queryKey = "recibo400.poliza.or.certificado";
//		Expediente exp = new Expediente();
//		exp.setPoliza("11111");
//		exp.setReciboAs400(1245);
//		System.out.println(DAOUtilityExample.executeNamedQuery(queryKey, exp));
//	}
//	@org.junit.Test
//	public void testFechaEfectoOrNull(){
//		String queryKey = "expediente.fecha.efecto.or.null";
//		Expediente exp = new Expediente();
//		exp.setCia("0001");
//		exp.setRamo("20");
//		exp.setModalidad("55");
//		exp.setSubmodalidad("34");
//		exp.setPoliza("11111");
//		exp.setCertificado("54546589");
//		exp.setFechaEfectoPoliza(new Date());
//		System.out.println("**************");
//		System.out.println(DAOUtilityExample.executeNamedQuery(queryKey, exp));
//		System.out.println("**************");
//	}
//	@org.junit.Test
//	public void testCache(){
//		CacheImpl cache = new CacheImpl();
//		cache.setMaxCapacity(30);
//		cache.addEntry("1", "1");
//		cache.addEntry("2", "2");
//		cache.addEntry("3", "3");
//		cache.addEntry("4", "4");
//	}
//	@org.junit.Test
//	public void testCount(){
//		System.out.println(DAOUtilityExample.count(Expediente.class));
//	}
//	
//	public void testHaving(){
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = null;
//		try {
//			date = (Date) sdf.parseObject("12/10/2009");
//		} catch (ParseException e) {
//			throw new RuntimeException(e);
//		}
//		SQLSelect select = new SQLSelect();
//		select.addFrom(Expediente.class);
//		select.addSelectField(Expediente.class, "cia") 
//		.addSelectField(Expediente.class, "ramo")
//		.addSelectField(Expediente.class, "modalidad")
//		.addSelectField(Expediente.class, "submodalidad")
//		.addSelectField(Expediente.class, "poliza")
//		.addSelectField(Expediente.class, "certificado")
//		.addSelectField(new SQLField(Expediente.class, "*", SQLFunction.COUNT))
//		.addCondition(SQLCondition.getAND("inicioExped",date , SQLExpresion.GREATER));
//
//		
//		SQLGroupBy groupBy = new SQLGroupBy();
//		groupBy.addField(Expediente.class, "cia") 
//		.addField(Expediente.class, "ramo")
//		.addField(Expediente.class, "modalidad")
//		.addField(Expediente.class, "submodalidad")
//		.addField(Expediente.class, "poliza")
//		.addField(Expediente.class, "certificado");
//		
//		select.setGroupBy(groupBy);
//		
//		SQLHaving having = new SQLHaving(SQLCondition.getANDFunction(Expediente.class,"*", SQLFunction.COUNT,new Integer(2),SQLExpresion.GREATER));
//		select.setHaving(having);
//		//DAOUtilityExample.execute(select);
//		
//		//
//		String sql = "select cia, ramo, modalidad, submodalidad, poliza, certificado, count(*) from "+
//						" Expediente where inicioExped > ? "+
//						" group by cia, ramo, modalidad, submodalidad, poliza, certificado " +
//						" having count(*) > 2";
//		
//		select = new SQLSelect();
//		select.setObjectQuery(sql,date);
//		//se interpreta al vuelo
//	System.out.println(DAOUtilityExample.execute(select));
//	}
}
