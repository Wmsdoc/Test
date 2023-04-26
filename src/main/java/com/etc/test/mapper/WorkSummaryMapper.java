package com.etc.test.mapper;

import com.etc.test.entity.WorkSummary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkSummaryMapper {

    /**
     * 新增工作总结
     *
     */
    int insert(WorkSummary workSummary);

    int update();

    int delete();
}
