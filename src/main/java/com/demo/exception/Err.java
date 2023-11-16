package com.demo.exception;

public enum Err {
    用户名密码校验失败(1,"用户名密码校验失败"),
    用户名密码错误(2,"用户名密码错误"),
    无权限(3,"无权限"),
    未登录(4,"未登录");

    final int code;
    final String text;

    Err(int code,String text){
        this.code = code;
        this.text = text;
    }
}
