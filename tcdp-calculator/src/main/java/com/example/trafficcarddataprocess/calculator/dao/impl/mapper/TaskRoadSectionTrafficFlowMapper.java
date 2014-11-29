package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;

public interface TaskRoadSectionTrafficFlowMapper {

	public List<TaskRoadSectionTrafficFlow> selectAll();

	public List<TaskRoadSectionTrafficFlow> selectByTaskIdAndRoadId(
			Map<String, String> map);
	
}
