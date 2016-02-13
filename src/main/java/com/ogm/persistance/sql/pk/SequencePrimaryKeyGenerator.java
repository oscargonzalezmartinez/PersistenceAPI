package com.ogm.persistance.sql.pk;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;

/**
 * <p>Generador de claves primarias basado en secuencias</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 */
public class SequencePrimaryKeyGenerator implements PrimaryKeyGenerator{
//
//	private static final String SQL = "SELECT {0}.{1}.NEXTVAL AS "+SEQUENCE+" FROM DUAL";
//	private static final String SQL_SIN_SCHEMA = "SELECT {0}.NEXTVAL AS "+SEQUENCE+" FROM DUAL";
//	private static final ModelDefinition OUT_MODEL = ModelDefinition.newModel(SequenceResult.class);
	
	public Long generate(ModelManager modelManager, ModelDefinition model) {
		return modelManager.getDialect().getSequenceValue(modelManager, model);
//		String schema = modelManager.getSchemaName();
//		String sql = null;
//		if (schema==null){
//			sql = MessageFormat.format(SQL_SIN_SCHEMA, model.getSequence());
//		}
//		else{
//			sql = MessageFormat.format(SQL, modelManager.getSchemaName(),model.getSequence());
//		}
//		
//		SQLSelect select = new SQLSelect();
//		select.setSqlQuery(sql);
//		select.setOutputModel(OUT_MODEL);
//		return ((List<SequenceResult>)modelManager.getSelectProcessor().execute(select)).get(0).getValue();
	}

}
