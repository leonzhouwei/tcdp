package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;

public interface TaskRoadSectionPassingCarRecordDao {
	
	public List<TaskRoadSectionPassingCarRecord> findByTaskIdAndRoadSectionId(long taskId, long roadSectionId);
	
	public List<TaskRoadSectionPassingCarRecord> findByTaskId(long taskId);

}
