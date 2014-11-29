package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecordPassInfo;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlow;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlowPassInfo;
import com.google.common.collect.Lists;

public class CalculateServiceImplAlgorithmTest {
	
	@Test
	public void testCalculateSingleCardTaskRoadAverageSpeed() {
		final Double expected = new Double(80.0);
		String json = "[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 08:14:00\", \"clsd\":\"80\"}]";
		List<TaskRoadPassingCarRecordPassInfo> result = TaskRoadPassingCarRecordPassInfo
				.parseList(json);
		Double actual = CalculateServiceImpl.calculateSingleCardTaskRoadAverageSpeed(result);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDoubleCardTaskRoadAverageSpeed() {
		final Double expected = new Double(80.0);
		String json = "[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"},{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}]";
		List<TaskRoadPassingCarRecordPassInfo> list = TaskRoadPassingCarRecordPassInfo
				.parseList(json);
		List<List<TaskRoadPassingCarRecordPassInfo>> input = Lists.newArrayList();
		input.add(list);
		Double length = new Double(80.0);
		Double actual = CalculateServiceImpl.calculateDoubleCardTaskRoadAverageSpeed(length, input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateSingleCardTaskRoadTrafficFlow() {
		final Long expected = 6L;
		String json = "[{\"sbbh\":\"1\", \"gcsl\":\"2\"}, {\"sbbh\":\"1\", \"gcsl\":\"4\"}]";
		List<TaskRoadTrafficFlowPassInfo> list = TaskRoadTrafficFlowPassInfo.parseList(json);
		Long actual = CalculateServiceImpl.calculateSingleCardTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDoubleCardTaskRoadTrafficFlow() {
		final Long expected = 6L;
		String json = "[{\"sbbh\":\"1\", \"gcsl\":\"4\"}, {\"sbbh\":\"2\", \"gcsl\":\"8\"}]";
		List<TaskRoadTrafficFlowPassInfo> list = TaskRoadTrafficFlowPassInfo.parseList(json);
		Long actual = CalculateServiceImpl.calculateDoubleCardTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}

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
		final Double expected = new Double(80.0); 
		Double length = new Double(800.0);
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
		instance.setCarNumber("test_car_num");
		instance.setCardCount(1);
		instance.setPassInfoJson(sb.toString());
		List<TaskRoadPassingCarRecord> result = Lists.newArrayList(instance);
		final Double expected = new Double(80.0); 
		Double length = new Double(800.0);
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
		instance.setCarNumber("test_car_num_1");
		instance.setCardCount(2);
		instance.setPassInfoJson(sb.toString());
		List<TaskRoadPassingCarRecord> result = Lists.newArrayList(instance);
		final Double expected = new Double(80.0); 
		Double length = new Double(80.0);
		Double actual = CalculateServiceImpl.calculateAverageSpeed(result, length);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * double card task road section, two passing cars
	 */
	@Test
	public void testCalculateAverageSpeedTaskRoad_4() {
		final long taskId = 1L;
		final long roadId = 1L;
		final int cardCount = 2;
		StringBuilder sb1 = new StringBuilder();
		sb1.append("[");
		sb1.append("{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"}");
		sb1.append(",");
		sb1.append("{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}");
		sb1.append("]");
		TaskRoadPassingCarRecord instance1 = new TaskRoadPassingCarRecord();
		instance1.setId(1L);
		instance1.setTaskId(taskId);
		instance1.setRoadId(roadId);
		instance1.setCarNumber("test_car_num_1");
		instance1.setCardCount(cardCount);
		instance1.setPassInfoJson(sb1.toString());
		StringBuilder sb2 = new StringBuilder();
		sb2.append("[");
		sb2.append("{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"}");
		sb2.append(",");
		sb2.append("{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}");
		sb2.append("]");
		TaskRoadPassingCarRecord instance2 = new TaskRoadPassingCarRecord();
		instance2.setId(1L);
		instance2.setTaskId(taskId);
		instance2.setRoadId(roadId);
		instance2.setCarNumber("test_car_num_1");
		instance2.setCardCount(cardCount);
		instance2.setPassInfoJson(sb2.toString());
		List<TaskRoadPassingCarRecord> result = Lists.newArrayList(instance1, instance2);
		final Double expected = new Double(80.0); 
		Double length = new Double(80.0);
		Double actual = CalculateServiceImpl.calculateAverageSpeed(result, length);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * single card task road section, one passing car
	 */
	@Test
	public void testCalculateTaskRoadTrafficFlow_1() {
		final long taskId = 1L;
		final long roadId = 1L;
		final int cardCount = 1;
		final String json = "[{\"sbbh\":\"1\", \"gcsl\":\"1\"}]";
		TaskRoadTrafficFlow instance = new TaskRoadTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadId(roadId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadTrafficFlow> list = Lists.newArrayList(instance);
		final Long expected = 1L;
		Long actual = CalculateServiceImpl.calculateTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * single card task road section, two passing cars
	 */
	@Test
	public void testCalculateTaskRoadTrafficFlow_2() {
		final long taskId = 1L;
		final long roadId = 1L;
		final int cardCount = 1;
		final String json = "[{\"sbbh\":\"1\", \"gcsl\":\"2\"}]";
		TaskRoadTrafficFlow instance = new TaskRoadTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadId(roadId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadTrafficFlow> list = Lists.newArrayList(instance);
		final Long expected = 2L;
		Long actual = CalculateServiceImpl.calculateTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * double card task road section, one passing car
	 */
	@Test
	public void testCalculateTaskRoadTrafficFlow_3() {
		final long taskId = 1L;
		final long roadId = 1L;
		final int cardCount = 2;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{\"sbbh\":\"1\", \"gcsl\":\"1\"}");
		sb.append(",");
		sb.append("{\"sbbh\":\"2\", \"gcsl\":\"1\"}");
		sb.append("]");
		final String json = sb.toString();
		TaskRoadTrafficFlow instance = new TaskRoadTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadId(roadId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadTrafficFlow> list = Lists.newArrayList(instance);
		final Long expected = 1L;
		Long actual = CalculateServiceImpl.calculateTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * double card task road section, two passing cars
	 */
	@Test
	public void testCalculateTaskRoadTrafficFlow_4() {
		final long taskId = 1L;
		final long roadId = 1L;
		final int cardCount = 2;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{\"sbbh\":\"1\", \"gcsl\":\"2\"}");
		sb.append(",");
		sb.append("{\"sbbh\":\"2\", \"gcsl\":\"2\"}");
		sb.append("]");
		final String json = sb.toString();
		TaskRoadTrafficFlow instance = new TaskRoadTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadId(roadId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadTrafficFlow> list = Lists.newArrayList(instance);
		final Long expected = 2L;
		Long actual = CalculateServiceImpl.calculateTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * double card task road section, not equal
	 */
	@Test
	public void testCalculateTaskRoadTrafficFlow_5() {
		final long taskId = 1L;
		final long roadId = 1L;
		final int cardCount = 2;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{\"sbbh\":\"1\", \"gcsl\":\"4\"}");
		sb.append(",");
		sb.append("{\"sbbh\":\"2\", \"gcsl\":\"6\"}");
		sb.append("]");
		final String json = sb.toString();
		TaskRoadTrafficFlow instance = new TaskRoadTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadId(roadId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadTrafficFlow> list = Lists.newArrayList(instance);
		final Long expected = 5L;
		Long actual = CalculateServiceImpl.calculateTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}

}
