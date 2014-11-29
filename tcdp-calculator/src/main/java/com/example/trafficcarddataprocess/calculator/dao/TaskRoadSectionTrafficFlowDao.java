package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;

public interface TaskRoadSectionTrafficFlowDao {
	
	public List<TaskRoadSectionTrafficFlow> findAllByTaskIdAndRoadId(long taskId, long roadId);

}
