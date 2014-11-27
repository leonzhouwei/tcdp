package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadPassingCarRecordDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskRoadPassingCarRecordMapper;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;
import com.google.common.collect.Maps;

@Component
public class TaskRoadPassingCarRecordDaoImpl implements TaskRoadPassingCarRecordDao {

	private static final String TASK_ID = "taskId";
	private static final String ROAD_ID = "roadId";
	
	@Autowired
	private TaskRoadPassingCarRecordMapper mapper;
	
	@Override
	public List<TaskRoadPassingCarRecord> findAllByTaskAndRoad(long taskId,
			long roadId) {
		Map<String, String> map = Maps.newHashMap();
		map.put(TASK_ID, Long.toString(taskId));
		map.put(ROAD_ID, Long.toString(roadId));
		return mapper.selectByTaskIdAndRoadId(map);
	}

}
