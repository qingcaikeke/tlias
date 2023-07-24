package com.yjy.exception;

import com.yjy.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//处理一切异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败");
    }
}
