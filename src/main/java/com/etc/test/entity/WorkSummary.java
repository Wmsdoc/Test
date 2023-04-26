package com.etc.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class WorkSummary {

    private String summaryId;   //工作总结编号

    private String docId;   //医生编号

    private String patientId;   //病人编号

    private String summaryTitle;    //工作总结标题

    private String summaryContent;  //工作总结内容

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date summaryTime; //工作总结时间

    private String summaryState;    //工作总结状态 (0暂存 1完结)
}
