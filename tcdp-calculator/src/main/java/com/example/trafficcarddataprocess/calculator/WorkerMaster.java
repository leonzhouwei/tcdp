package com.example.trafficcarddataprocess.calculator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.service.TaskService;
import com.google.common.collect.Lists;

@Component
public class WorkerMaster implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkerMaster.class);

	@Value("${master.sleep.millis}")
	private long SLEEP_MILLIS;

	@Autowired
	private TaskService taskService;
	private LinkedList<Worker> workers = Lists.newLinkedList();
	
	public void setWorkers(Collection<Worker> workers) {
		synchronized (this) {
			if (!this.workers.isEmpty()) {
				String msg = "worker count must be greater than 0! please check the configurations! exiting now...";
				logger.error(msg);
				System.exit(-1);
			}
			this.workers.addAll(workers);
		}
	}
	
	@Override
	public void run() {
		logger.info("worker master sleep millis: " + SLEEP_MILLIS);
		for (Worker e : workers) {
			Thread thread = new Thread(e);
			thread.start();
		}
		//
		final int workerCount = workers.size();
		int workerIndex = 0;
		while (true) {
			try {
				List<Task> tasks = taskService.findUndoneTasksAndSetStatusAsInProgess();
				if (tasks.isEmpty()) {
					Thread.sleep(SLEEP_MILLIS);
					continue;
				}
				//
				for (Task e : tasks) {
					workerIndex = workerIndex % workerCount;
					Worker worker = workers.get(workerIndex);
					logger.debug("task#" + e.getId() + " shall be done by " + worker);
					worker.addTask(e.getId());
					workerIndex += 1;
				}
			} catch (Exception e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
}
