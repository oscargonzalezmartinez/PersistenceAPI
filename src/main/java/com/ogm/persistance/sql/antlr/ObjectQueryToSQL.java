package com.ogm.persistance.sql.antlr;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ogm.persistance.exceptions.PersistanceException;
import com.ogm.persistance.model.ModelManager;
import com.ogm.persistance.model.NamedQuery;
import com.ogm.persistance.util.ErrorMessageID;


/**
 * <p>Clase encargada de realizar la transformación entre Object query y sql.</p>
 * <p>Esta implementación se basa en <a href="http://www.antlr.org/">ANTLR 3</a>.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 10 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 * @see <a>http://www.antlr.org/</a>
 */
public final class ObjectQueryToSQL {
	
	/**
	 * Logger.
	 */
	private static Log log = LogFactory.getLog(ObjectQueryToSQL.class); 
	/**
	 * Constructor privado.
	 */
	private ObjectQueryToSQL(){
		
	}
	/**
	 * <p>Transforma la objectsql a una named query en el ámbito definido por <code>modelManager</code>.</p>
	 * @param objectQuery object sql a transformar en sql pura.
	 * @param modelManager definición del modelo
	 * @return NamedQuery.
	 */
	public static NamedQuery process(String objectQuery, ModelManager modelManager) {
		
		SQLGrammarParser sqlParser = null;
		try {
			ANTLRInputStream input = new ANTLRInputStream(
						new ByteArrayInputStream(objectQuery.getBytes()));

			SQLGrammarLexer sqlLexer = new SQLGrammarLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(sqlLexer);
			sqlParser = new SQLGrammarParser(tokens);

			sqlParser.prog();
			GrammarUtil grammarUtil = sqlParser.getGrammarUtil();
			NamedQuery namedQuery = grammarUtil.getOut(modelManager);
			namedQuery.setAttributes(grammarUtil.getAttributes());
			
			return namedQuery;
		} catch (RecognitionException e) {
			PersistanceException  pException = new PersistanceException(ErrorMessageID.PE_00017,e,objectQuery,sqlParser.getErrorMessage(e, sqlParser.getTokenNames()));
			log.error("process", e);
			throw pException;
		} catch (IOException e) {
			PersistanceException  pException = new PersistanceException(ErrorMessageID.PE_00017,e,objectQuery,e.getMessage());
			log.error("process", e);
			throw pException;
		}
	}
}
