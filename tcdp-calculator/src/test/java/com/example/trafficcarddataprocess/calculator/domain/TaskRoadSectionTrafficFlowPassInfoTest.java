package com.example.trafficcarddataprocess.calculator.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlowPassInfo;

public class TaskRoadSectionTrafficFlowPassInfoTest {

	@Test
	public void nop() {
	}
	
	@Test
	public void testParseList() {
		final String expectedDeviceNumber = "1";
		final Integer expectedPassCarCount = 177;
		String json = "[{\"sbbh\":\"1\", \"gcsl\":\"177\"}]";
		List<TaskRoadSectionTrafficFlowPassInfo> list = TaskRoadSectionTrafficFlowPassInfo.parseList(json);
		TaskRoadSectionTrafficFlowPassInfo actual = list.get(0);
		Assert.assertEquals(expectedDeviceNumber, actual.getDeviceNumber());
		Assert.assertEquals(expectedPassCarCount, actual.getPassCarCount());
	}
	
}
