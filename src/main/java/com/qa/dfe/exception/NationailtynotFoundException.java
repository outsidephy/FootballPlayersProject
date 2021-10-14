package com.qa.dfe.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No player found with that id")
public class NationailtynotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1940901405300647555L;

	public NationailtynotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NationailtynotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NationailtynotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NationailtynotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NationailtynotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
