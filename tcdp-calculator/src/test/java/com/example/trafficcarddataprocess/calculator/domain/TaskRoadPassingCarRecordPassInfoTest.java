package com.example.trafficcarddataprocess.calculator.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TaskRoadPassingCarRecordPassInfoTest {

	@Test
	public void testParseList() throws ParseException {
		final String expectedDeviceNumber = "1";
		final Date expectedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.parse("2014-11-19 08:14:00");
		final Double expectedSpeed = 78.0;
		String json = "[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 08:14:00\", \"clsd\":\"78\"}]";
		List<TaskRoadPassingCarRecordPassInfo> result = TaskRoadPassingCarRecordPassInfo
				.parseList(json);
		TaskRoadPassingCarRecordPassInfo actual = result.get(0);
		Assert.assertEquals(expectedDeviceNumber, actual.getDeviceNumber());
		Assert.assertEquals(expectedDate.getTime(), actual.getTime().getTime());
		Assert.assertEquals(expectedSpeed, actual.getSpeed());
	}
	
}
