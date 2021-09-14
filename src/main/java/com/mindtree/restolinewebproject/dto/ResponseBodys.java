package com.mindtree.restolinewebproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class ResponseBodys<T> {

	private T data;

	private ErrorDTO error;

	private String message;

	private boolean success;

	public ResponseBodys() {
	}

	public ResponseBodys(T data, ErrorDTO error, String message, boolean success) {
		this.data = data;
		this.error = error;
		this.message = message;
		this.success = success;
	}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ErrorDTO getError() {
		return error;
	}

	public void setError(ErrorDTO error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
