package com.exceptions;

public class InvalidEmailException {
	private static final long serialVersionUID = 1L;
	private String msg;

	public InvalidEmailException() {
		//this.msg = "Sorry! Name too short!";
	}

	public InvalidEmailException(String msg) {
	this.msg = msg;
	}

	public String toString() {
		return "InvalidEmailExceptionn [msg=" + msg + "]";
	}

	public String getMessage() {
		return "MESSAGE: " + msg;
	}

}
