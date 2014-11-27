package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Task;

public interface TaskMapper {
	
	List<Task> selectAllTasks();

}
