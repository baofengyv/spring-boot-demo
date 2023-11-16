package com.demo.exception;

import lombok.Data;

/**
 * 自定义异常
 */
@Data
public class Excpt extends RuntimeException {
    private Integer code;
    private String message;
    private Object data;

    public Excpt(Err err) {
        this.code = err.code;
        this.message = err.text;
    }
}
