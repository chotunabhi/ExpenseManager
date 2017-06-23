package com.abhi.expenseManager.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response<T>{
	private Error error;
	private T response;
	private Exception exception;

	public Response(){
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}


	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}
