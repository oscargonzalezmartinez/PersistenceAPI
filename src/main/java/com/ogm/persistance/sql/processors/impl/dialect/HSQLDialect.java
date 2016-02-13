package com.ogm.persistance.sql.processors.impl.dialect;

import java.util.List;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLSelect;
import com.ogm.persistance.sql.pk.PrimaryKeyGenerator;
import com.ogm.persistance.sql.pk.SequenceResult;
import com.ogm.persistance.sql.processors.SQLDialect;

public class HSQLDialect implements SQLDialect{

	private static final ModelDefinition OUT_MODEL = ModelDefinition.newModel(SequenceResult.class);
	
	public void pagination(StringBuilder sql, long ini, long max) {
		// TODO Auto-generated method stub
		
	}

	public Long getSequenceValue(ModelManager modelManager, ModelDefinition model) {

		String schema = modelManager.getSchemaName();
		String sql = "CALL NEXT VALUE FOR " + modelManager.getSchemaName() + "." + model.getSequence() ;
//		String sql = "select next value FOR " + modelManager.getSchemaName() + "." + model.getSequence() + " AS " + PrimaryKeyGenerator.SEQUENCE;
//		if (schema==null){
//			sql = MessageFormat.format(SQL_SIN_SCHEMA, model.getSequence());
//		}
//		else{
//			sql = MessageFormat.format(SQL, modelManager.getSchemaName(),model.getSequence());
//		}
//		
		SQLSelect select = new SQLSelect();
		select.setSqlQuery(sql);
		java.util.Map m = (java.util.Map)modelManager.getSelectProcessor().execute(select).get(0);
		return ((Number)m.values().iterator().next()).longValue();
	}
}
