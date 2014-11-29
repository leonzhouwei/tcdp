package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlow;

public interface TaskRoadTrafficFlowDao {
	
	public List<TaskRoadTrafficFlow> findAllByTaskAndRoad(long taskId, long roadId);

}
