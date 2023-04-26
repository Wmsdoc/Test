package com.etc.test.service.impl;

import com.etc.test.entity.WorkSummary;
import com.etc.test.mapper.WorkSummaryMapper;
import com.etc.test.service.WorkSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkSummaryServiceImpl implements WorkSummaryService {


    @Autowired
    private WorkSummaryMapper workSummaryMapper;

    public int insert(WorkSummary workSummary) {
        return workSummaryMapper.insert(workSummary);
    }
}
