package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.trafficcarddataprocess.calculator.dao.TaskDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskMapper;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Component
public class TaskDaoImpl implements TaskDao {
	
	private static final String OLD_STATUS = "oldStatus";
	private static final String NEW_STATUS = "newStatus";
	
	@Autowired
	private TaskMapper taskMapper;

	@Override
	public Task selectTask(long id) {
		return taskMapper.selectTask(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Task> findUndoneTasksAndSetStatusAsInProgess() {
		List<Task> undone = taskMapper.selectUndoneTasks();
		updateStatusAsDone(taskMapper, undone);
		return undone;
	}
	
	public static void updateStatusByIds(TaskMapper taskMapper, Collection<Long> taskIds, int oldStatus, int newStatus) {
		String oldStatusString = Integer.toString(oldStatus);
		String newStatusString = Integer.toString(newStatus);
		for (Long e : taskIds) {
			Map<String, String> map = Maps.newHashMap();
			map.put(TaskMapper.ID, e.toString());
			map.put(OLD_STATUS, oldStatusString);
			map.put(NEW_STATUS, newStatusString);
			taskMapper.updateStatus(map);
		}
	}
	
	public static void updateStatusAsDoneByIds(TaskMapper taskMapper, Collection<Long> taskIds) {
		updateStatusByIds(taskMapper, taskIds, TaskMapper.STATUS_IN_PROGRESS, TaskMapper.STATUS_UNDONE);
	}
	
	public static void updateStatusAsDoneById(TaskMapper taskMapper, Long id) {
		List<Long> list = Lists.newArrayList();
		list.add(id);
		updateStatusAsDoneByIds(taskMapper, list);
	}
	
	public static void updateStatusAsDone(TaskMapper taskMapper, Collection<Task> tasks) {
		List<Long> ids = Lists.newArrayList();
		for (Task e : tasks) {
			ids.add(e.getId());
		}
		updateStatusAsDoneByIds(taskMapper, ids);
	}

}
