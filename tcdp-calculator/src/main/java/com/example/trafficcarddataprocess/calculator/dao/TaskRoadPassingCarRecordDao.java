package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;

public interface TaskRoadPassingCarRecordDao {
	
	public List<TaskRoadPassingCarRecord> findAllByTaskAndRoad(long taskId, long roadId);

}
