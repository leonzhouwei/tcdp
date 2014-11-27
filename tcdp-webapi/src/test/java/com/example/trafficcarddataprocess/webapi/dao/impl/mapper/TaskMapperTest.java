package com.example.trafficcarddataprocess.webapi.dao.impl.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.trafficcarddataprocess.webapi.App;
import com.example.trafficcarddataprocess.webapi.domain.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TaskMapperTest {
	
	@Autowired
	private TaskMapper taskMapper;

	@Test
	public void testSelectAll() {
		List<Task> result = taskMapper.selectAll();
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

}
