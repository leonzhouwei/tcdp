package com.example.trafficcarddataprocess.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskMapper;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskMapper taskMapper;

	@Override
	public Task findTask(long id) {
		return taskMapper.selectTask(id);
	}

}
