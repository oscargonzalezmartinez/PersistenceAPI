package com.ogm.persistance.sql.processors.impl.dialect;

import java.text.MessageFormat;
import java.util.List;

import com.ogm.persistance.model.ModelDefinition;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.sql.SQLSelect;
import com.ogm.persistance.sql.pk.PrimaryKeyGenerator;
import com.ogm.persistance.sql.pk.SequenceResult;
import com.ogm.persistance.sql.processors.SQLDialect;
/**
 * <p>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class OracleDialect implements SQLDialect {


	private static final String WHERE_RNUM = " ) WHERE rnum > ";
	private static final String SELECT_FROM_SELECT_FIRST_ROWS_N = "SELECT *   FROM ( SELECT /*+ FIRST_ROWS(n) */ ";
	private static final String A_PAGINATION_ROWNUM_RNUM_FROM = "  a_pagination.*, ROWNUM rnum from ( ";
	private static final String A_PAGINATION = " ) a_pagination  ";
	private static final String WHERE_ROWNUM = " WHERE ROWNUM <= ";
	
	private static final String SQL = "SELECT {0}.{1}.NEXTVAL AS "+PrimaryKeyGenerator.SEQUENCE+" FROM DUAL";
	private static final String SQL_SIN_SCHEMA = "SELECT {0}.NEXTVAL AS "+PrimaryKeyGenerator.SEQUENCE+" FROM DUAL";
	private static final ModelDefinition OUT_MODEL = ModelDefinition.newModel(SequenceResult.class);
	
	public void pagination(StringBuilder sql, long min, long max) {
		StringBuilder sb = new StringBuilder (SELECT_FROM_SELECT_FIRST_ROWS_N); 
		sb.append(A_PAGINATION_ROWNUM_RNUM_FROM);
		sb.append(sql);
		sb.append(A_PAGINATION);
		sb.append(WHERE_ROWNUM).append(max);
		sb.append(WHERE_RNUM).append(min);
		sql.setLength(0);
		sql.append(sb);

	}

	public Long getSequenceValue(ModelManager modelManager, ModelDefinition model) {

		String schema = modelManager.getSchemaName();
		String sql = null;
		if (schema==null){
			sql = MessageFormat.format(SQL_SIN_SCHEMA, model.getSequence());
		}
		else{
			sql = MessageFormat.format(SQL, modelManager.getSchemaName(),model.getSequence());
		}
		
		SQLSelect select = new SQLSelect();
		select.setSqlQuery(sql);
		select.setOutputModel(OUT_MODEL);
		return ((List<SequenceResult>)modelManager.getSelectProcessor().execute(select)).get(0).getValue();
	}

}
