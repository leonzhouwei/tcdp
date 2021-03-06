package com.example.trafficcarddataprocess.calculator.dao;

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
public class TaskRoadSectionPassingCarRecordDaoTest {
	
	@Autowired
	private TaskRoadSectionPassingCarRecordDao dao;

	@Test
	public void nop() {
	}
	
	public void testFindByTaskId() {
		final long taskId = 39L;
		List<TaskRoadSectionPassingCarRecord> result = dao.findByTaskId(taskId);
		System.out.println("testFindByTaskId(): " + result.size());
	}
	
	public void testFindByTaskIdAndRoadSectionId() {
		final long taskId = 39L;
		final long roadSectionId = 42595700560L;
		List<TaskRoadSectionPassingCarRecord> result = dao.findByTaskIdAndRoadSectionId(taskId, roadSectionId);
		System.out.println("testFindByTaskIdAndRoadSectionId(): " + result.size());
	}

}
