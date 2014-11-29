package com.example.trafficcarddataprocess.calculator.domain;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlowPassInfo;

public class TaskRoadTrafficFlowPassInfoTest {

	@Test
	public void testParseList() {
		final String expectedDeviceNumber = "1";
		final Integer expectedPassCarCount = 177;
		String json = "[{\"sbbh\":\"1\", \"gcsl\":\"177\"}]";
		List<TaskRoadTrafficFlowPassInfo> list = TaskRoadTrafficFlowPassInfo.parseList(json);
		TaskRoadTrafficFlowPassInfo actual = list.get(0);
		Assert.assertEquals(expectedDeviceNumber, actual.getDeviceNumber());
		Assert.assertEquals(expectedPassCarCount, actual.getPassCarCount());
	}
	
}
