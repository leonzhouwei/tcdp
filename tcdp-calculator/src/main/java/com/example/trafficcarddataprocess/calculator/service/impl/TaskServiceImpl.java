package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskDao;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.service.TaskService;

@Component
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;

	@Override
	public Task findTask(long id) {
		return taskDao.selectTask(id);
	}
	
	@Override
	public List<Task> findUndoneTasksAndSetStatusAsInProgess() {
		return taskDao.findUndoneTasksAndSetStatusAsInProgess();
	}
	
}
