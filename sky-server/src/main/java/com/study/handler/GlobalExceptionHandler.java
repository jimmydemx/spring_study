package com.study.handler;
import com.study.exception.BaseException;
import com.study.constant.MessageConstant;
import com.study.result.Result;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {



    @ExceptionHandler
    public Result exceptionHandler(BaseException ex){
        return Result.error(ex.getMessage());

    }
    /**
     *  SQL Exception handler
     * @params
     */
    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
        if(message.contains("Duplicate entry")){
            String[] split = message.split(" ");
            String username = split[2];
            String msg = username+ MessageConstant.ALREADY_EXISTS;
            return Result.error(msg);
        }else {
            return Result.error((MessageConstant.UNKNOWN_ERROR));
        }
    }
}
