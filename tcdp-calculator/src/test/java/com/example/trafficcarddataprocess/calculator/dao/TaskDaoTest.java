package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TaskDaoTest {
	
	@Autowired
	private TaskDao taskDao;
	
	@Test
	public void nop() {
	}

	@Test
	public void testFindUndoneTasksAndSetStatusAsInProgess() {
		List<Task> undone = taskDao.findUndoneTasksAndSetStatusAsInProgess();
		System.out.println("undone tasks count: " + undone.size());
	}

}
