package com.etc.test.mapper;

import com.etc.test.entity.LogSystem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogSystemMapper {
    /**
     * 查询所有日志
     */
    List<LogSystem> queryAll();

    /**
     * 新增系统日志
     * @return
     */
    int insert(String id, String docId,String docName, String content);

}
