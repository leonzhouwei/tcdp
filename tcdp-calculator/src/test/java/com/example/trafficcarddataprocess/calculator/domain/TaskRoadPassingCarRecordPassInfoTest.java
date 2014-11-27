package com.example.trafficcarddataprocess.calculator.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

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
	
	@Test
	public void testCalculateSingleCardTaskRoadAverageSpeed() {
		final Double expected = 80.0;
		String json = "[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 08:14:00\", \"clsd\":\"80\"}]";
		List<TaskRoadPassingCarRecordPassInfo> result = TaskRoadPassingCarRecordPassInfo
				.parseList(json);
		Double actual = TaskRoadPassingCarRecordPassInfo.calculateSingleCardTaskRoadAverageSpeed(result);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDoubleCardTaskRoadAverageSpeed() {
		final Double expected = 80.0;
		String json = "[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"},{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}]";
		List<TaskRoadPassingCarRecordPassInfo> list = TaskRoadPassingCarRecordPassInfo
				.parseList(json);
		List<List<TaskRoadPassingCarRecordPassInfo>> input = Lists.newArrayList();
		input.add(list);
		Double actual = TaskRoadPassingCarRecordPassInfo.calculateDoubleCardTaskRoadAverageSpeed(80.0, input);
		Assert.assertEquals(expected, actual);
	}

}
