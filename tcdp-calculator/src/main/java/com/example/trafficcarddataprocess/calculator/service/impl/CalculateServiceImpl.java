package com.example.trafficcarddataprocess.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskRoadPassingCarRecordMapper;
import com.example.trafficcarddataprocess.calculator.domain.Road;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.service.CalculateService;

@Component
public class CalculateServiceImpl implements CalculateService {
	
	@Autowired
	private TaskRoadPassingCarRecordMapper mapper;

	@Override
	public double calculateAverageSpeed(Task task, Road road) {
		final long taskId = task.getId();
		final long roadId = road.getId();
		mapper.selectByTaskId(taskId);
		// TODO
		return 0.0;
	}

}
