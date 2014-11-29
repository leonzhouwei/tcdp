package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;

public interface TaskRoadSectionPassingCarRecordDao {
	
	public List<TaskRoadSectionPassingCarRecord> findAllByTaskIdAndRoadId(long taskId, long roadId);

	public List<TaskRoadSectionPassingCarRecord> findUndoneByTaskId(long taskId);

}
