package com.example.trafficcarddataprocess.calculator;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.example.trafficcarddataprocess.calculator.domain.Result;

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

	public void testWork() {
		final Long taskId = 39L;
		List<Result> c = worker.work(taskId);
		for (Result e : c) {
			String json = JSONObject.toJSONString(e);
			System.out.println(json);
		}
	}
	
	public void testMultiInstance() {
		System.out.println(worker);
		System.out.println(worker2);
	}
	
}
