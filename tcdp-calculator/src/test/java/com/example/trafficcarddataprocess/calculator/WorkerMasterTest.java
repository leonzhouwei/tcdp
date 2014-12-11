package com.example.trafficcarddataprocess.calculator;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class WorkerMasterTest {
	
	@Value("${worker.count}")
	private int workerCount;
	
	@Autowired
	private Worker worker1;
	@Autowired
	private Worker worker2;
	@Autowired
	private WorkerMaster master;

	@Test
	public void test() throws InterruptedException {
		List<Worker> workers = Lists.newArrayList(worker1);
		master.setWorkers(workers);
		Thread thread = new Thread(master);
		thread.start();
		thread.join();
	}

}
