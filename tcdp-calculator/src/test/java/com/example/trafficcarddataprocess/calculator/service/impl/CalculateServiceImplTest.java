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
		final long roadSectionId = 42595701381L;
		Task task = taskService.findTask(taskId);
		RoadSection road = roadService.findRoad(roadSectionId);
		System.out.println(road.getLength());
		Double result = service.calculateAverageSpeed(task, road);
		System.out.println(result);
	}

	public void testCalculateAverageSpeedTaskRoad_2() {
		final long taskId = 39L;
		final long roadSectionId = 42595701382L;
		Task task = taskService.findTask(taskId);
		RoadSection road = roadService.findRoad(roadSectionId);
		System.out.println(road.getLength());
		Double result = service.calculateAverageSpeed(task, road);
		System.out.println(result);
	}

	@Test
	public void testCalculateAverageSpeedTaskRoad_3() {
		final long taskId = 39L;
		Task task = taskService.findTask(taskId);
		List<Long> roadSectionIds = Lists.newArrayList();
		roadSectionIds.add(42595700565L);
		roadSectionIds.add(42595702101L);
		roadSectionIds.add(42595703250L);
		roadSectionIds.add(42595703296L);
		roadSectionIds.add(42595703779L);
		roadSectionIds.add(42595704091L);
		roadSectionIds.add(42595704092L);
		roadSectionIds.add(42595704519L);
		roadSectionIds.add(42595704530L);
		roadSectionIds.add(42595701382L);
		roadSectionIds.add(42595701474L);
		roadSectionIds.add(42595703120L);
		roadSectionIds.add(42595703257L);
		roadSectionIds.add(42595704511L);
		roadSectionIds.add(42595700564L);
		roadSectionIds.add(42595701329L);
		roadSectionIds.add(42595703254L);
		roadSectionIds.add(42595704525L);
		roadSectionIds.add(42595704529L);
		roadSectionIds.add(42595701053L);
		roadSectionIds.add(42595702118L);
		roadSectionIds.add(42595703297L);
		roadSectionIds.add(42595704391L);
		roadSectionIds.add(42595704528L);
		roadSectionIds.add(42595700579L);
		roadSectionIds.add(42595703062L);
		roadSectionIds.add(42595704513L);
		roadSectionIds.add(42595704527L);
		roadSectionIds.add(42595700560L);
		roadSectionIds.add(42595701216L);
		roadSectionIds.add(42595701368L);
		roadSectionIds.add(42595701557L);
		roadSectionIds.add(42595702117L);
		roadSectionIds.add(42595702176L);
		roadSectionIds.add(42595702899L);
		roadSectionIds.add(42595704538L);
		roadSectionIds.add(42595701370L);
		roadSectionIds.add(42595701381L);
		roadSectionIds.add(42595701558L);
		roadSectionIds.add(42595703109L);
		roadSectionIds.add(42595703119L);
		roadSectionIds.add(42595704055L);
		roadSectionIds.add(42595704380L);
		roadSectionIds.add(42595702108L);
		roadSectionIds.add(42595702177L);
		roadSectionIds.add(42595703060L);
		roadSectionIds.add(42595704054L);
		roadSectionIds.add(42595704540L);

		for (Long e : roadSectionIds) {
			RoadSection road = roadService.findRoad(e);
			Double result = service.calculateAverageSpeed(task, road);
//			System.out.println(road.getId() + ", " + road.getLength() + ", "
//					+ result);
			System.out.println(result);
		}
	}
}
