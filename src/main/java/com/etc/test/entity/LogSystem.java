package com.etc.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class LogSystem {

    private String logId;   //日志编号

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date operatorTime; //操作时间

    private String operatorId;  //操作人id

    private String operatorName;    //操作人姓名

    private String operatorContent; //操作内容

}
