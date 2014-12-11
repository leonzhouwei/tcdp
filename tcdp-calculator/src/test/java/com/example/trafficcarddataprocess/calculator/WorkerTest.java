package com.example.trafficcarddataprocess.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class WorkerTest {
	
	@Autowired
	private Worker worker;
	@Autowired
	private Worker worker2;
	
	@Test
	public void nop() {
	}

	@Test
	public void testWork() {
		final Long taskId = 39L;
		worker.work(taskId);
	}
	
	public void testMultiInstance() {
		System.out.println(worker);
		System.out.println(worker2);
	}
	
}
