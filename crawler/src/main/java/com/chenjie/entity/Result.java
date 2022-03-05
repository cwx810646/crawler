package com.chenjie.entity;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class Result<T> {  
	private String message;
	
	private HttpStatus code;
	
	private T data;
	
	private Result() {};
	
	public static<T> Result<T> ok() {
		return Result.ok(null);
	}
	
	public static<T> Result<T> ok(T data) {
		Result<T> result = new Result<T>();
		result.data = data;
		result.code = HttpStatus.OK;
		return result;
	}
	
	public static<T> Result<T> error() {
		return Result.error(null);
	}
	
	public static<T> Result<T> error(String message) {
		Result<T> result = new Result<T>();
		result.message = message;
		result.code = HttpStatus.INTERNAL_SERVER_ERROR;
		return result;
	}
}
