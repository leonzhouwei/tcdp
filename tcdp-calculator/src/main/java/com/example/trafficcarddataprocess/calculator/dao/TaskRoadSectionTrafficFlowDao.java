package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;

public interface TaskRoadSectionTrafficFlowDao {
	
	public List<TaskRoadSectionTrafficFlow> findByTaskIdAndRoadSectionId(long taskId, long roadSectionId);

	public List<TaskRoadSectionTrafficFlow> findByTaskId(long taskId);
	
}
