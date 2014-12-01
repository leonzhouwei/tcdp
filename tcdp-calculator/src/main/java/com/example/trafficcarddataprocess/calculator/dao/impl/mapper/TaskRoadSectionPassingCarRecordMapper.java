package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;

public interface TaskRoadSectionPassingCarRecordMapper {
	
	public static final String TASK_ID = "taskId";
	public static final String ROAD_SECTION_ID = "roadSectionId";
	
	public List<TaskRoadSectionPassingCarRecord> selectByTaskIdAndRoadSectionId(Map<String, String> map);
	
	public List<TaskRoadSectionPassingCarRecord> selectByTaskId(Long taskId);
	
	public List<TaskRoadSectionPassingCarRecord> selectAll();
	
	public List<TaskRoadSectionPassingCarRecord> selectUndoneByTaskId(Long taskId);

}
