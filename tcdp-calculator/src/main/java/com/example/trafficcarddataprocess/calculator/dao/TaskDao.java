package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Task;

public interface TaskDao {
	
	public Task selectTask(long id);

	public List<Task> findUndoneTasksAndSetStatusAsInProgess();

}
