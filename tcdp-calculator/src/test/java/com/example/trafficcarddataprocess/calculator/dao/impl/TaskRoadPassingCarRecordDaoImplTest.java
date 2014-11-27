package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TaskRoadPassingCarRecordDaoImplTest {
	
	@Autowired
	private TaskRoadPassingCarRecordDaoImpl dao;

	@Test
	public void testFindAllByTaskAndRoad() {
		final long taskId = 1L;
		final long roadId = 1L;
		List<TaskRoadPassingCarRecord> result = dao.findAllByTaskAndRoad(taskId, roadId);
		System.out.println(result.size());
	}

}
