package com.etc.test.advice;

import com.etc.test.exception.MyException;
import com.etc.test.exception.enums.ErrorEnums;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorThrowAspect {
    private final static Logger logger = LoggerFactory.getLogger(ErrorThrowAspect.class);
    @Pointcut("execution(public * com.etc.test.service.*.*(..))")
    public void error() {
    }
    @Around("error()")
    public Object catchException(ProceedingJoinPoint point) {
        Object object = null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            logger.info("error()={}", throwable);
            String methodName = point.getSignature().getName().toLowerCase();
            if(methodName.indexOf("add") != -1 || methodName.indexOf("insert") != -1){
                throw new MyException(ErrorEnums.ADD_ERROR);
            }else if(methodName.indexOf("remove") != -1 || methodName.indexOf("delete") != -1){
                throw new MyException(ErrorEnums.REMOVE_ERROR);
            }else if(methodName.indexOf("find") != -1 || methodName.indexOf("query") != -1){
                throw new MyException(ErrorEnums.FIND_ERROR);
            }else if(methodName.indexOf("edit") != -1 || methodName.indexOf("update") != -1){
                throw new MyException(ErrorEnums.EDIT_ERROR);
            }else{
                throw new MyException(ErrorEnums.UNKNOWN_ERROR);
            }
        }
        return object;
    }
}
