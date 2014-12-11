package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import com.example.trafficcarddataprocess.calculator.domain.Task;

public interface TaskMapper {
	
	public static final String ID = "id";
	public static final String TASK_ID = "taskId";
	public static final String ROAD_SECTION_ID = "roadSectionId";
	
	public static final Integer STATUS_UNDONE = 0;
	public static final Integer STATUS_IN_PROGRESS = STATUS_UNDONE + 1;
	public static final Integer STATUS_DONE = STATUS_IN_PROGRESS + 1;
	
	public List<Task> selectAllTasks();
	
	public Task selectTask(Long id);

	public List<Task> selectUndoneTasks();
	
	public void updateStatus(Map<String, String> map);

}
