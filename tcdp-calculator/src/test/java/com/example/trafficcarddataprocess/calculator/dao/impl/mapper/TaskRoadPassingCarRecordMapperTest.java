package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

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
public class TaskRoadPassingCarRecordMapperTest {
	
	@Autowired
	private TaskRoadPassingCarRecordMapper mapper;

	@Test
	public void testSelectByTaskId() {
		final Long taskId = 1L;
		List<TaskRoadPassingCarRecord> result = mapper.selectByTaskId(taskId);
		System.out.println(result.size());
	}

}
