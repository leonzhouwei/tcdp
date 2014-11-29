package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadTrafficFlowDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskRoadTrafficFlowMapper;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlow;
import com.google.common.collect.Maps;

@Component
public class TaskRoadTrafficFlowDaoImpl implements TaskRoadTrafficFlowDao {
	
	private static final String TASK_ID = "taskId";
	private static final String ROAD_ID = "roadId";
	
	@Autowired
	private TaskRoadTrafficFlowMapper mapper;

	@Override
	public List<TaskRoadTrafficFlow> findAllByTaskIdAndRoadId(long taskId,
			long roadId) {
		Map<String, String> map = Maps.newHashMap();
		map.put(TASK_ID, Long.toString(taskId));
		map.put(ROAD_ID, Long.toString(roadId));
		return mapper.selectByTaskIdAndRoadId(map);
	}

}
