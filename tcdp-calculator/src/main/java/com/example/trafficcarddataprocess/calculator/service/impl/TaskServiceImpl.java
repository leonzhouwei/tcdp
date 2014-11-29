package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadSectionPassingCarRecordDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskMapper;
import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.service.CalculateService;
import com.example.trafficcarddataprocess.calculator.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private TaskRoadSectionPassingCarRecordDao passCarDao;
	@Autowired
	private CalculateService calucateService;

	@Override
	public Task findTask(long id) {
		return taskMapper.selectTask(id);
	}
	
	public Task findOneUndoneTask() {
		// task
		Task task = taskMapper.selectFirstWaitingTask();
		return task;
	}
	
	public void findOneUndoneTaskAndHandle() {
		// task
		Task task = findOneUndoneTask();
		if (task == null) {
			return;
		}
		// TODO
		List<Result> results = calucateService.calculate(task);
	}

}
