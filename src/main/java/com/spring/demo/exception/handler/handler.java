package com.spring.demo.exception.handler;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.spring.demo.response.ErrorResponse;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * IO
 * Created by jie.a.xie on 8/27/2020.
 * ctrl+Alt+l快速排版代码
 */
//@ControllerAdvice
@RestControllerAdvice//@ControllerAdvice和@RestControllerAdvice统一异常处理
public class handler {
    @ExceptionHandler(value = ArrayStoreException.class)
    @ResponseBody
    public ErrorResponse allException(Exception e) {
        return new ErrorResponse("ArrayStore");
    }
    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public ErrorResponse arrayIndexOutOfBoundsException(Exception e){
        return new ErrorResponse("arrayIndexOutOfBoundsException");
    }
    @ExceptionHandler(value = MismatchedInputException.class)
    @ResponseBody
    public ErrorResponse restException(Exception e){
        return  new ErrorResponse("MismatchedInputException");
    }
}
