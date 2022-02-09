package com.tms.exception;

@SuppressWarnings("serial")
public class InvalidEmailException extends Exception{
	
	private String msg;
	
	private InvalidEmailException() {
		this.msg = "Email is not vaid please enter a valid email Address";
		
	}
	
	public InvalidEmailException(String msg) {
		this.msg=msg;
	}

	@Override
	public String toString() {
		return "InvalidEmailException [msg=" + msg + "]";
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "MESSAGE: " + msg;
	}

}


/**
*
*@author Ashish
*
*/