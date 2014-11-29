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

	private static final String TASK_ID = "taskId";
	private static final String ROAD_ID = "roadId";
	
	@Autowired
	private TaskRoadSectionPassingCarRecordMapper mapper;
	
	@Override
	public List<TaskRoadSectionPassingCarRecord> findAllByTaskIdAndRoadId(long taskId,
			long roadId) {
		Map<String, String> map = Maps.newHashMap();
		map.put(TASK_ID, Long.toString(taskId));
		map.put(ROAD_ID, Long.toString(roadId));
		return mapper.selectByTaskIdAndRoadId(map);
	}
	
	@Override
	public List<TaskRoadSectionPassingCarRecord> findUndoneByTaskId(long taskId) {
		return mapper.selectUndoneByTaskId(taskId);
	}

}
