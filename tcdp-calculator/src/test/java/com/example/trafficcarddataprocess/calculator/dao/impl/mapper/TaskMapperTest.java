package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TaskMapperTest {
	
	@Autowired
	private TaskMapper taskMapper;

	@Test
	public void nop() {
	}
	
	public void testSelectAll() {
		List<Task> result = taskMapper.selectAllTasks();
		for (Task e : result) {
			System.out.print(e.getId());
			System.out.print(", ");
			System.out.print(e.getStartTime());
			System.out.print(", ");
			System.out.print(e.getEndTime());
			System.out.print(", ");
			System.out.print(e.getCreateTime());
			System.out.print(", ");
			System.out.print(e.getMinuteInterval());
			System.out.print(", ");
			System.out.print(e.getProcessStatus());
			System.out.print(", ");
			System.out.print(e.getOutputStatus());
			System.out.println();
		}
	}
	
	public void testSelectTask() {
		final Long id = 1L;
		Task task = taskMapper.selectTask(id);
		System.out.println(JSONObject.toJSONString(task));
	}
	
	public void testUpdateAsDone() {
		final Long id = 39L;
		taskMapper.updateAsDone(id);
	}

}
