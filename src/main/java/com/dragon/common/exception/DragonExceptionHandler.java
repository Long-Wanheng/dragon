package com.dragon.common.exception;

import com.dragon.util.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 龙万恒
 * @CreateTime: 2019-10-13 18:07
 * @Description: ${Description}
 */
@ControllerAdvice
@RestControllerAdvice
public class DragonExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(DragonExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultSet errorMsg(Exception ex) {
        ex.printStackTrace();
        if (ex instanceof DragonException) {
            return new ResultSet(-1, ex.getMessage());
        } else {
            return new ResultSet(-1, "未知错误");
        }
    }
}
