package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;

public interface TaskRoadPassingCarRecordDao {
	
	public List<TaskRoadPassingCarRecord> findAllByTaskIdAndRoadId(long taskId, long roadId);

}
