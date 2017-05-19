package com.abhi.expenseManager.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response<T>{
	private Error error;
	private List response;
	private Exception exception;

	public Response(){
	}

	public List getResponse() {
		return response;
	}
	public void setResponse(T response) {
		if(response instanceof List)
			this.response.addAll((List)response);
		else{
			this.response = new ArrayList();
			this.response.add(response);
		}
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
