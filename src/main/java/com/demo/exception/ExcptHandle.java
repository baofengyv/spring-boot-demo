package com.demo.exception;

import com.demo.dto.Msg;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常处理 处理特定类型的异常
 */
@ControllerAdvice
public class ExcptHandle extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Excpt.class)
    public final ResponseEntity handleExcpt(Excpt e) {
        Msg msg = new Msg(e.getCode(), e.getMessage(), e.getData());
        return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.OK);
    }
}