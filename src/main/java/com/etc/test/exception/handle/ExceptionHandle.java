package com.etc.test.exception.handle;

import com.etc.test.entity.JsonResult;
import com.etc.test.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult handle(Exception e) {
        logger.error("系统异常:", e);
        return new JsonResult(-1,"系统异常:" + e.getMessage());
    }
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public JsonResult myHandle(MyException e) {
        logger.error("系统异常:",e);
        return new JsonResult(e.getCode(),"系统异常:"+e.getMessage());

    }
}
