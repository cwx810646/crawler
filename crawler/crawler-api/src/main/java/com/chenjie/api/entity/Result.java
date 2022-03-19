package com.chenjie.api.entity;

import lombok.Data;

@Data
public class Result<T> {
    private static int SUCCESS_CODE = 200;
    private static int ERROR_CODE = 500;
    private static String ERROR_MESSAGE = "System error, please contact administrator";
    private T data;
    private String message;
    private int code;

    public static <T> Result<T> ok(T data) {
        Result result = new Result();
        result.data = data;
        result.code = SUCCESS_CODE;
        return result;
    }

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> error(String message) {
        Result result = new Result();
        result.message = message;
        result.code = ERROR_CODE;
        return result;
    }

    public static <T> Result<T> error() {
        return error(ERROR_MESSAGE);
    }
}
