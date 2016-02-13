package com.ogm.persistance.test;

import com.ogm.persistance.model.annotation.DBColumn;



public class ScalarResult {
	@Override
	public String toString() {
		return "value = " + value;
	}

	@DBColumn(column="res")
	private Long value = null;
	public ScalarResult(){}
	public Long getValue() {
		return value;
	}

	public void setValue(Long newValue) {
		this.value = newValue;
	}
}
