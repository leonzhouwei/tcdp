package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TaskRoadSectionTrafficFlowDaoImplTest {
	
	@Autowired
	private TaskRoadSectionTrafficFlowDaoImpl dao;

	@Test
	public void nop() {
	}
	
	public void testFindByTaskId() {
		final long taskId = 39L;
		List<TaskRoadSectionTrafficFlow> result = dao.findByTaskId(taskId);
		System.out.println("testFindByTaskId(): " + result.size());
	}

	public void testFindByTaskIdAndRoadSectionId() {
		final long taskId = 39L;
		final long roadSectionId = 42595700548L;
		List<TaskRoadSectionTrafficFlow> result = dao
				.findByTaskIdAndRoadSectionId(taskId, roadSectionId);
		System.out.println("testFindByTaskIdAndRoadSectionId(): "
				+ result.size());
	}

}
