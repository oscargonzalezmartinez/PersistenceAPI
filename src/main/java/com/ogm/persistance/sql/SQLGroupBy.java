package com.ogm.persistance.sql;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Esta clase representa la clausula <b>group by</b></p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public class SQLGroupBy {

	/**
	 * 
	 */
	private List<SQLField> fields = new ArrayList<SQLField>();

	public SQLGroupBy(){}
	public SQLGroupBy(Class clazz , String field){
		this();
		addField(clazz, field);
	}

	public SQLGroupBy addField(SQLField newField){
		fields.add(newField);
		return this;
	}
	
	public SQLGroupBy addField(Class clazz , String field){
		fields.add(new SQLField(clazz,field));
		return this;
	}
	
	public SQLGroupBy addField(Object object , String field){
		return addField(object.getClass(), field);
	}

	public List<SQLField> getFields() {
		return fields;
	}
}
