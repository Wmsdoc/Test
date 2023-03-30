package com.etc.test.exception;

import com.etc.test.exception.enums.ErrorEnums;
import lombok.Data;

@Data
public class MyException extends RuntimeException{
    private Integer code;

    public MyException(ErrorEnums enums) {
        super(enums.getMessage());
        this.code = enums.getCade();
    }
    public MyException(ErrorEnums enums,String message) {
        super(message);
        this.code = enums.getCade();
    }
}
