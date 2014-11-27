package com.example.trafficcarddataprocess.webapi.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TaskRoadTrafficFlowPassInfoTest {

	@Test
	public void testParseList() {
		final String expectedDeviceNumber = "3307010507";
		final Integer expectedPassCarCount = 177;
		String json = "[{\"sbbh\":\"3307010507\", \"gcsl\":\"177\"}]";
		List<TaskRoadTrafficFlowPassInfo> list = TaskRoadTrafficFlowPassInfo.parseList(json);
		TaskRoadTrafficFlowPassInfo actual = list.get(0);
		Assert.assertEquals(expectedDeviceNumber, actual.getDeviceNumber());
		Assert.assertEquals(expectedPassCarCount, actual.getPassCarCount());
	}
	
	@Test
	public void testCalculateSingleCardTaskRoadTrafficFlow() {
		int seconds = 2;
		final Integer expected = 3;
		String json = "[{\"sbbh\":\"3307010507\", \"gcsl\":\"2\"}, {\"sbbh\":\"3307010507\", \"gcsl\":\"4\"}]";
		List<TaskRoadTrafficFlowPassInfo> list = TaskRoadTrafficFlowPassInfo.parseList(json);
		Integer actual = TaskRoadTrafficFlowPassInfo.calculateSingleCardTaskRoadTrafficFlow(seconds, list);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateTwoCardTaskRoadTrafficFlow() {
		int seconds = 2;
		final Integer expected = 3;
		String json = "[{\"sbbh\":\"3307010507\", \"gcsl\":\"4\"}, {\"sbbh\":\"3307010507\", \"gcsl\":\"8\"}]";
		List<TaskRoadTrafficFlowPassInfo> list = TaskRoadTrafficFlowPassInfo.parseList(json);
		Integer actual = TaskRoadTrafficFlowPassInfo.calculateTwoCardTaskRoadTrafficFlow(seconds, list);
		Assert.assertEquals(expected, actual);
	}

}
