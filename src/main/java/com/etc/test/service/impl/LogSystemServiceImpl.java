package com.etc.test.service.impl;

import com.etc.test.entity.LogSystem;
import com.etc.test.mapper.LogSystemMapper;
import com.etc.test.service.LogSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogSystemServiceImpl implements LogSystemService {

    @Autowired
    private LogSystemMapper logSystemMapper;

    /**
     * 查询所有系统日志
     */
    public List<LogSystem> queryAll() {
        return logSystemMapper.queryAll();
    }

    /**
     * 新增系统日志
     *
     * @param id
     * @param docId
     * @param docName
     * @param content
     * @return
     */
    public int insert(String id, String docId, String docName, String content) {
        return logSystemMapper.insert(id, docId, docName, content);
    }

}
