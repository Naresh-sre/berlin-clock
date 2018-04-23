package com.ubs.opsit.interviews;

public enum ViolationVariableKey {
	NO_TIME_PROVIDED ("No time provided"),
	INVALID_TIME ("Invalid time provided."),
	NUMERIC_TIME ("Time values must be numeric.");

	private String key;

	public String getkey(){
		return this.key;
	}

	private ViolationVariableKey(String key){
		this.key = key;
	}
}
