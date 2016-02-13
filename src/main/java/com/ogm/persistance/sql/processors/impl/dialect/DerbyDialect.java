package com.ogm.persistance.sql.processors.impl.dialect;

import java.text.MessageFormat;
import java.util.List;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLSelect;
import com.ogm.persistance.sql.pk.SequenceResult;
import com.ogm.persistance.sql.processors.SQLDialect;

/**
 * <p>Dialecto para Deby.</p>
 * <a href="http://db.apache.org/derby/">http://db.apache.org/derby/</a>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class DerbyDialect implements SQLDialect {

	private static final String FETCH = " FETCH ";
	private static final String ROWS = " ROWS ";
	private static final String OFFSET = " OFFSET ";
	private static final ModelDefinition OUT_MODEL = ModelDefinition.newModel(SequenceResult.class);
	/* (non-Javadoc)
	 * @see es.caser.persistance.sql.processors.SQLDialect#pagination(java.lang.StringBuilder, long, long)
	 */
	public void pagination(StringBuilder sql, long min, long max) {
		// http://db.apache.org/derby/docs/10.5/ref/rrefsqljoffsetfetch.html

//		SELECT * FROM T FETCH FIRST ROW ONLY
//		SELECT * FROM T ORDER BY I OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY
//		SELECT * FROM T OFFSET 100 ROWS

		long rowCount = max - min;
		long offset = min;
		sql.append(OFFSET).append(offset).append(ROWS).append(FETCH).append(rowCount).append(ROWS);
	}

	public Long getSequenceValue(ModelManager modelManager, ModelDefinition model) {

		String schema = modelManager.getSchemaName();
		String sql = "call NEXT VALUE FOR " + model.getSequence();
//		if (schema==null){
//			sql = MessageFormat.format(SQL_SIN_SCHEMA, model.getSequence());
//		}
//		else{
//			sql = MessageFormat.format(SQL, modelManager.getSchemaName(),model.getSequence());
//		}
//		
		SQLSelect select = new SQLSelect();
		select.setSqlQuery(sql);
		select.setOutputModel(OUT_MODEL);
		return ((List<SequenceResult>)modelManager.getSelectProcessor().execute(select)).get(0).getValue();
	}
}
