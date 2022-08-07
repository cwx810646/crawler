package com.chenjie.util;

import lombok.Data;

@Data
public class Result<T> {
    public static final int SUCCESS_CODE = 200;
    public static final int ERROR_CODE = 500;
    public static final String ERROR_MESSAGE = "Unknown exception. Contact the administrator!";

    private String message;
    private  Integer code;
    private T data;

    public static<T> Result<T> ok(){
        return ok(null);
    }

    public static<T> Result<T> ok(T data){
        Result<T> result = new Result();
        result.code = SUCCESS_CODE;
        return result;
    }

    public static<T> Result<T> error(){
        return error(ERROR_MESSAGE);
    }

    public static<T> Result<T> error(String message){
        Result<T> result = new Result();
        result.message = ERROR_MESSAGE;
        return result;
    }
}
