package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;

public interface TaskRoadSectionTrafficFlowMapper {
	
	public static final String TASK_ID = "taskId";
	public static final String ROAD_SECTION_ID = "roadSectionId";
	
	public List<TaskRoadSectionTrafficFlow> selectAll();

	public List<TaskRoadSectionTrafficFlow> selectByTaskIdAndRoadSectionId(
			Map<String, String> map);
	
}
