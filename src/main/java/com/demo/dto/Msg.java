package com.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // 返回序列化时不返回null的属性
public class Msg {
    private Integer code;
    private String message;
    private Object data;

    public Msg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

