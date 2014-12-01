package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadSectionTrafficFlowDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskRoadSectionTrafficFlowMapper;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;
import com.google.common.collect.Maps;

@Component
public class TaskRoadSectionTrafficFlowDaoImpl implements TaskRoadSectionTrafficFlowDao {
	
	private static final String TASK_ID = "taskId";
	private static final String ROAD_SECTION_ID = "roadSectionId";
	
	@Autowired
	private TaskRoadSectionTrafficFlowMapper mapper;

	@Override
	public List<TaskRoadSectionTrafficFlow> findAllByTaskIdAndRoadSectionId(long taskId,
			long roadSectionId) {
		Map<String, String> map = Maps.newHashMap();
		map.put(TASK_ID, Long.toString(taskId));
		map.put(ROAD_SECTION_ID, Long.toString(roadSectionId));
		return mapper.selectByTaskIdAndRoadSectionId(map);
	}

}
