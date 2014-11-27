package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;
import com.google.common.collect.Lists;

public class CalculateServiceImplAlgorithmTest {

	/**
	 * single card task road section, one passing car
	 */
	@Test
	public void testCalculateAverageSpeedTaskRoad_1() {
		TaskRoadPassingCarRecord instance = new TaskRoadPassingCarRecord();
		instance.setId(1L);
		instance.setTaskId(1L);
		instance.setRoadId(1L);
		instance.setCarNumber("test");
		instance.setCardCount(1);
		instance.setPassInfoJson("[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 08:14:00\", \"clsd\":\"80\"}]");
		List<TaskRoadPassingCarRecord> result = Lists.newArrayList(instance);
		double length = 800.0;
		final Double expected = 80.0; 
		Double actual = CalculateServiceImpl.calculateAverageSpeed(result, length);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * single card task road section, two passing cars
	 */
	@Test
	public void testCalculateAverageSpeedTaskRoad_2() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 08:14:00\", \"clsd\":\"75\"}");
		sb.append(",");
		sb.append("{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 08:14:00\", \"clsd\":\"85\"}");
		sb.append("]");
		TaskRoadPassingCarRecord instance = new TaskRoadPassingCarRecord();
		instance.setId(1L);
		instance.setTaskId(1L);
		instance.setRoadId(1L);
		instance.setCarNumber("test");
		instance.setCardCount(1);
		instance.setPassInfoJson(sb.toString());
		List<TaskRoadPassingCarRecord> result = Lists.newArrayList(instance);
		double length = 800.0;
		final Double expected = 80.0; 
		Double actual = CalculateServiceImpl.calculateAverageSpeed(result, length);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * double card task road section, one passing car
	 */
	@Test
	public void testCalculateAverageSpeedTaskRoad_3() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"}");
		sb.append(",");
		sb.append("{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}");
		sb.append("]");
		TaskRoadPassingCarRecord instance = new TaskRoadPassingCarRecord();
		instance.setId(1L);
		instance.setTaskId(1L);
		instance.setRoadId(1L);
		instance.setCarNumber("test_1");
		instance.setCardCount(2);
		instance.setPassInfoJson(sb.toString());
		List<TaskRoadPassingCarRecord> result = Lists.newArrayList(instance);
		double length = 80.0;
		final Double expected = 80.0; 
		Double actual = CalculateServiceImpl.calculateAverageSpeed(result, length);
		Assert.assertEquals(expected, actual);
	}

}
