package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TaskRoadSectionPassingCarRecordDaoImplTest {
	
	@Autowired
	private TaskRoadSectionPassingCarRecordDaoImpl dao;

	@Test
	public void testFindAllByTaskAndRoad() {
		final long taskId = 1L;
		final long roadSectionId = 1L;
		List<TaskRoadSectionPassingCarRecord> result = dao.findAllByTaskIdAndRoadSectionId(taskId, roadSectionId);
		System.out.println(result.size());
	}

}
