package com.ubs.opsit.interviews;

public class BerlinClockImpl implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		if(aTime ==null || aTime.trim().isEmpty())
			throw new BerlinTimeException(ViolationVariableKey.NO_TIME_PROVIDED.getkey());
		
		
		return null;
	}

}
