package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.domain.RoadSection;
import com.example.trafficcarddataprocess.calculator.domain.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class CalculateServiceImplTest {

	@Autowired
	private TaskServiceImpl taskService;
	@Autowired
	private RoadSectionServiceImpl roadSectionService;
	@Autowired
	private CalculateServiceImpl calculateService;

	public void testCalculateAverageSpeedTaskRoad_1() {
		final long taskId = 39L;
		final long roadSectionId = 42595701381L;
		Task task = taskService.findTask(taskId);
		RoadSection road = roadSectionService.findRoadSection(roadSectionId);
		System.out.println(road.getLength());
		Double result = calculateService.calculateAverageSpeed(task, road);
		System.out.println(result);
	}

	public void testCalculateAverageSpeedTaskRoad_2() {
		final long taskId = 39L;
		final long roadSectionId = 42595701382L;
		Task task = taskService.findTask(taskId);
		RoadSection road = roadSectionService.findRoadSection(roadSectionId);
		System.out.println(road.getLength());
		Double result = calculateService.calculateAverageSpeed(task, road);
		System.out.println(result);
	}

	public void testCalculate_1() {
		final long taskId = 39L;
		Task task = taskService.findTask(taskId);
		List<Result> results = calculateService.calculate(task);
		for (Result e : results) {
			String json = JSONObject.toJSONString(e);
			System.out.println(json);
		}
	}
	
	@Test
	public void testCalculate_2() {
		final long taskId = 39L;
		final long roadSectionId = 42595701381L;
		Task task = taskService.findTask(taskId);
		RoadSection roadSection = roadSectionService.findRoadSection(roadSectionId);
		Result result = calculateService.calculate(task, roadSection);
		System.out.println(JSONObject.toJSONString(result));
	}
	
}
