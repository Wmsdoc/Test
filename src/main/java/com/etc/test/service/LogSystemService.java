package com.etc.test.service;


import com.etc.test.entity.LogSystem;

import java.util.List;

public interface LogSystemService {
    /**
     * 查询所有系统日志信息
     */
    List<LogSystem> queryAll();

    /**
     * 新增系统日志
     * @param id
     * @param docId
     * @param docName
     * @param content
     * @return
     */
    int insert(String id, String docId,String docName, String content);
}
