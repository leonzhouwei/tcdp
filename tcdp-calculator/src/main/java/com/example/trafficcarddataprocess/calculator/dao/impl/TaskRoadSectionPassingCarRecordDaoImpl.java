package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadSectionPassingCarRecordDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskRoadSectionPassingCarRecordMapper;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;
import com.google.common.collect.Maps;

@Component
public class TaskRoadSectionPassingCarRecordDaoImpl implements TaskRoadSectionPassingCarRecordDao {

	public static final String TASK_ID = "taskId";
	public static final String ROAD_SECTION_ID = "roadSectionId";
	
	@Autowired
	private TaskRoadSectionPassingCarRecordMapper mapper;
	
	@Override
	public List<TaskRoadSectionPassingCarRecord> findAllByTaskIdAndRoadSectionId(long taskId,
			long roadSectionId) {
		Map<String, String> map = Maps.newHashMap();
		map.put(TASK_ID, Long.toString(taskId));
		map.put(ROAD_SECTION_ID, Long.toString(roadSectionId));
		return mapper.selectByTaskIdAndRoadSectionId(map);
	}
	
	@Override
	public List<TaskRoadSectionPassingCarRecord> findUndoneByTaskId(long taskId) {
		return mapper.selectUndoneByTaskId(taskId);
	}

}
