package com.ogm.persistance.sql;

import java.util.ArrayList;
import java.util.List;

import com.ogm.persistance.model.ModelDefinition;

/**
 * <p>Esta clase representa la clausula <code>FROM</code> de una sql. Permite añadir
 * tantos objetos java del modelo como se quiera.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 1.0
 */
public class SQLFrom {
	/**
	 * 
	 */
	private List<Class> tables = new ArrayList<Class>();

	/**
	 * Constructor.
	 */
	public SQLFrom(){}
	
	/**
	 * <p>.</p>
	 * @param model
	 * @return
	 */
	public SQLFrom addTable(ModelDefinition model){
		return addTable(model.getClazz());
	}
	
	/**
	 * <p>.</p>
	 * @param obj
	 * @return
	 */
	public SQLFrom addTable(Object obj){
		return addTable(obj.getClass());
	}
	
	/**
	 * <p>.</p>
	 * @param clazz
	 * @return
	 */
	public SQLFrom addTable(Class clazz){
		tables.add(clazz);
		return this;
	}


	/**
	 * <p>.</p>
	 * @return
	 */
	public List<Class> getTables() {
		return tables;
	}

}
