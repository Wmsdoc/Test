package com.etc.test.entity;

import lombok.Data;

import java.util.List;
@Data
public class JsonResult<T>{
    private static final int SCCESSS = 0;
    private int state;
    private String massage = "";
    private T data;
    private List<T> datas;

    //对象处理
    public JsonResult(T data) { //正常情况
        this.state = SCCESSS;
        this.data = data;
    }
    public JsonResult(String massage) { //正常情况
        this.state = SCCESSS;
        this.massage = massage;
    }
    public JsonResult(int state,String massage) { //非正常情况
        this.state = state;
        this.massage = massage;
    }

    //集合处理
    public JsonResult(List<T> datas) { //正常情况
        this.state = SCCESSS;
        this.datas = datas;
    }
    public JsonResult(String massage,List<T> datas) { //正常情况
        this.state = SCCESSS;
        this.massage = massage;
        this.datas = datas;
    }
    public JsonResult(int state,String massage,List<T> datas) { //非正常情况
        this.state = state;
        this.massage = massage;
        this.datas = datas;
    }

}