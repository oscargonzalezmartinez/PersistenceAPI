package com.ogm.persistance.sql.antlr;
/**
 * <p>Operaciones a realizar.</p>
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 10 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 * @since 2.0
 *
 */
public class Operation {

	protected String payLoad = null;
	protected OperationType type = null;
	public Operation(String newPayLoad, OperationType newType) {
		super();
		this.payLoad = newPayLoad;
		this.type = newType;
	}
	public String getPayLoad() {
		return payLoad;
	}
	public OperationType getType() {
		return type;
	}

	@Override
	public String toString() {
		return new StringBuilder("type ").append(type).append(" payload ").append(payLoad).toString(); 
	}
}
