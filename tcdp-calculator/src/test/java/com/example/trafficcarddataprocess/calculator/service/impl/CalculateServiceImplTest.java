package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.RoadSection;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class CalculateServiceImplTest {

	@Autowired
	private TaskServiceImpl taskService;
	@Autowired
	private RoadSectionServiceImpl roadService;
	@Autowired
	private CalculateServiceImpl service;

	public void testCalculateAverageSpeedTaskRoad_1() {
		final long taskId = 39L;
		final long roadId = 42595701381L;
		Task task = taskService.findTask(taskId);
		RoadSection road = roadService.findRoad(roadId);
		System.out.println(road.getLength());
		Double result = service.calculateAverageSpeed(task, road);
		System.out.println(result);
	}

	public void testCalculateAverageSpeedTaskRoad_2() {
		final long taskId = 39L;
		final long roadId = 42595701382L;
		Task task = taskService.findTask(taskId);
		RoadSection road = roadService.findRoad(roadId);
		System.out.println(road.getLength());
		Double result = service.calculateAverageSpeed(task, road);
		System.out.println(result);
	}

	@Test
	public void testCalculateAverageSpeedTaskRoad_3() {
		final long taskId = 39L;
		Task task = taskService.findTask(taskId);
		List<Long> roadIds = Lists.newArrayList();
		roadIds.add(42595700565L);
		roadIds.add(42595702101L);
		roadIds.add(42595703250L);
		roadIds.add(42595703296L);
		roadIds.add(42595703779L);
		roadIds.add(42595704091L);
		roadIds.add(42595704092L);
		roadIds.add(42595704519L);
		roadIds.add(42595704530L);
		roadIds.add(42595701382L);
		roadIds.add(42595701474L);
		roadIds.add(42595703120L);
		roadIds.add(42595703257L);
		roadIds.add(42595704511L);
		roadIds.add(42595700564L);
		roadIds.add(42595701329L);
		roadIds.add(42595703254L);
		roadIds.add(42595704525L);
		roadIds.add(42595704529L);
		roadIds.add(42595701053L);
		roadIds.add(42595702118L);
		roadIds.add(42595703297L);
		roadIds.add(42595704391L);
		roadIds.add(42595704528L);
		roadIds.add(42595700579L);
		roadIds.add(42595703062L);
		roadIds.add(42595704513L);
		roadIds.add(42595704527L);
		roadIds.add(42595700560L);
		roadIds.add(42595701216L);
		roadIds.add(42595701368L);
		roadIds.add(42595701557L);
		roadIds.add(42595702117L);
		roadIds.add(42595702176L);
		roadIds.add(42595702899L);
		roadIds.add(42595704538L);
		roadIds.add(42595701370L);
		roadIds.add(42595701381L);
		roadIds.add(42595701558L);
		roadIds.add(42595703109L);
		roadIds.add(42595703119L);
		roadIds.add(42595704055L);
		roadIds.add(42595704380L);
		roadIds.add(42595702108L);
		roadIds.add(42595702177L);
		roadIds.add(42595703060L);
		roadIds.add(42595704054L);
		roadIds.add(42595704540L);

		for (Long e : roadIds) {
			RoadSection road = roadService.findRoad(e);
			Double result = service.calculateAverageSpeed(task, road);
//			System.out.println(road.getId() + ", " + road.getLength() + ", "
//					+ result);
			System.out.println(result);
		}
	}
}
