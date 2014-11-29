package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlow;

public interface TaskRoadTrafficFlowMapper {

//	public List<TaskRoadTrafficFlowMapper> selectByTaskIdAndRoadId(long taskId, long roadId);
	
	public List<TaskRoadTrafficFlow> selectAll();
	
}
