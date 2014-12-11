package com.example.trafficcarddataprocess.calculator;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.example.trafficcarddataprocess.calculator.common.CommonDefine;
import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.service.CalculateService;
import com.example.trafficcarddataprocess.calculator.service.ResultService;
import com.google.common.collect.Queues;

@Component
@Scope(CommonDefine.BEAN_SCOPE_PROTOTYPE)
public class Worker implements Runnable {
	
	private static final Logger logger = LoggerFactory.getLogger(Worker.class);
	
	@Autowired
	private CalculateService calculateService;
	@Autowired
	private ResultService resultService;
	private AtomicBoolean saveEnabled = new AtomicBoolean(false);
	
	private ConcurrentLinkedQueue<Long> taskIds = Queues.newConcurrentLinkedQueue();
	
	List<Result> work(long taskId) {
		logger.debug("----- task#" + taskId + " START -----");
		List<Result> results = calculateService.calculate(taskId);
		if (results.isEmpty()) {
			return results;
		}
	
		for (Result e : results) {
			String json = JSONObject.toJSONString(e);
			logger.debug(json);
		}
		
		if (this.saveEnabled.get()) {
			resultService.save(taskId, results);
		}
		logger.debug("===== task#" + taskId + "  END  -----");
		return results;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Long taskId = taskIds.poll();
				if (taskId == null) {
					continue;
				}
				work(taskId);
			} catch (Exception e) {
				logger.warn(e.getMessage());
			}
		}
	}
	
	public boolean addTask(Long taskId) {
		return taskIds.add(taskId);
	}
	
	public void enableSave() {
		this.saveEnabled.set(true);
	}
	
}
