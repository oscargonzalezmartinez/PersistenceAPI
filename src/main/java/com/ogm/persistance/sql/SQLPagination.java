package com.ogm.persistance.sql;

/**
 * <p>Clase que representa la paginaciçon en una query.</p> 
 * @author Oscar González (latest modification by $LastChangedBy: OGOMAR01 $)
 * @version 1.0 $LastChangedRevision: 5451 $ $LastChangedDate: 2014-04-10 16:44:50 +0200 (jue, 10 abr 2014) $
 *
 */
public class SQLPagination {
	/**
	 * 
	 */
	private Long minRow = null;
	/**
	 * 
	 */
	private Long maxRow = null;
	
	/**
	 * @param newMinRow
	 * @param newMaxRow
	 */
	public SQLPagination(Long newMinRow, Long newMaxRow) {
		super();
		this.minRow = newMinRow;
		this.maxRow = newMaxRow;
	}
	public Long getMinRow() {
		return minRow;
	}
	public void setMinRow(Long newMinRow) {
		this.minRow = newMinRow;
	}
	public Long getMaxRow() {
		return maxRow;
	}
	public void setMaxRow(Long newMaxRow) {
		this.maxRow = newMaxRow;
	}
}
