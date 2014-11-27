package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;

public interface TaskRoadPassingCarRecordMapper {
	
	public List<TaskRoadPassingCarRecord> selectByTaskId(Long taskId);
	
	public List<TaskRoadPassingCarRecord> selectAll();

}
