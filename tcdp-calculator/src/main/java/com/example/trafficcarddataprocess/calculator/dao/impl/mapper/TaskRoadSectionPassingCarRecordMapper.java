package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;

public interface TaskRoadSectionPassingCarRecordMapper {
	
	public List<TaskRoadSectionPassingCarRecord> selectByTaskIdAndRoadSectionId(Map<String, String> map);
	
	public List<TaskRoadSectionPassingCarRecord> selectByTaskId(Long taskId);
	
	public List<TaskRoadSectionPassingCarRecord> selectAll();
	
	public List<TaskRoadSectionPassingCarRecord> selectUndoneByTaskId(Long taskId);

}
