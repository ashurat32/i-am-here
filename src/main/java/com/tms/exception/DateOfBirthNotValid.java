package com.tms.exception;

@SuppressWarnings("serial")
public class DateOfBirthNotValid extends Exception{
	
	private String msg;

	private DateOfBirthNotValid() {
		this.msg = "Invalid type please try Format = dd/mm/yyy";
	}

	public DateOfBirthNotValid(String msg) {
		this.msg=msg;
	}

	@Override
	public String toString() {
		return "DateOfBirthNotValid [msg=" + msg + "]";
	}
	
	public String getMessage() {
		return "MESSAGE: " + msg;
	}
}


/**
*
*@author Ashish
*
*/