package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlow;

public interface TaskRoadTrafficFlowMapper {

	public List<TaskRoadTrafficFlow> selectAll();

	public List<TaskRoadTrafficFlow> selectByTaskIdAndRoadId(
			Map<String, String> map);
	
}
