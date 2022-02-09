package com.tms.exception;

public class NotAValidPhoneNo extends Exception{
	
	private String msg;

	private NotAValidPhoneNo() {
		this.msg = "Enter a valid phone no. not inlcude +91";
	}

	public NotAValidPhoneNo(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String toString() {
		return "NotAValidPhoneNo [msg=" + msg + "]";
	}
	
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