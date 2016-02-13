package com.ogm.persistance.sql.functions;

import com.ogm.persistance.sql.SQLFunction;

public abstract class SQLPatternFunction extends SQLFunction{

	private String pattern = null;
	public SQLPatternFunction(String function,String newPattern) {
		super(function);
		pattern = newPattern;
	}

	public String getPattern() {
		return pattern;
	}
	public void setPattern(String newPattern) {
		pattern = newPattern;
	}
}
