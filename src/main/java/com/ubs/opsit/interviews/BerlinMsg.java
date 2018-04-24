package com.ubs.opsit.interviews;

public enum BerlinMsg {
	HOUR("Hour"),
	MINUTE("Minute"),
	SECOND("Second"),
	NO_TIME_PROVIDED ("No time provided"),
	NUMERIC_TIME ("Time values must be Integer: "),
	INVALID_TIME_FORMAT ("Invalid time format. Correct time format is hh:mm:ss."),
	TIME_UNIT_OUT_OF_RANGE("Time unit out of range: ") ;

	private String key;

	public String getkey(){
		return key;
	}

	private BerlinMsg(String key){
		this.key = key;
	}
}
