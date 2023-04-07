package com.etc.test.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnums {
    /**
     * 错误类型
     */
    UNKNOWN_ERROR(1, "未知错误"),
    FIND_NULL(0, "未查询到任何数据"),
    FIND_ERROR(101, "查询异常"),
    ADD_ERROR(102, "添加异常"),
    EDIT_ERROR(103, "修改异常"),
    REMOVE_ERROR(104, "删除异常"),
    CHECK_ERROR(110, "检查异常");


    private Integer cade;
    private String message;
}
