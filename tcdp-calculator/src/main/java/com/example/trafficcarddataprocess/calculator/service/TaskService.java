package com.example.trafficcarddataprocess.calculator.service;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Task;

public interface TaskService {

	public Task findTask(long id);

	public List<Task> findUndoneTasksAndSetStatusAsInProgess();

}
