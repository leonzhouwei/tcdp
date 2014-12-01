package com.example.trafficcarddataprocess.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadSectionPassingCarRecordDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskMapper;
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
	
	public Task findFirstUndoneTask() {
		// task
		Task task = taskMapper.selectFirstWaitingTask();
		return task;
	}
	
	public void findFirstUndoneTaskAndHandle() {
		// task
		Task task = findFirstUndoneTask();
		if (task == null) {
			return;
		}
		// TODO
		// List<Result> results = calucateService.calculate(task);
	}

}
