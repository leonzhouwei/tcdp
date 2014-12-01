package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Task;

public interface TaskMapper {
	
	public static final String TASK_ID = "taskId";
	public static final String ROAD_SECTION_ID = "roadSectionId";
	
	public List<Task> selectAllTasks();
	
	public Task selectTask(Long id);

	public Task selectFirstWaitingTask();

}
