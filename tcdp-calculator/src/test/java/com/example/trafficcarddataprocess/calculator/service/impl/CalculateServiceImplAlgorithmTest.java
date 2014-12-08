package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecordPassInfo;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlowPassInfo;
import com.google.common.collect.Lists;

public class CalculateServiceImplAlgorithmTest {
	
	@Test
	public void testCalculateSingleCardTaskRoadAverageSpeed() {
		final Double expected = new Double(80.0);
		String json = "[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 08:14:00\", \"clsd\":\"80\"}]";
		List<TaskRoadSectionPassingCarRecordPassInfo> result = TaskRoadSectionPassingCarRecordPassInfo
				.parseList(json);
		Double actual = CalculateServiceImpl.calculateSingleCardTaskRoadAverageSpeed(result);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDoubleCardTaskRoadAverageSpeed() {
		final Double expected = new Double(80.0);
		String json = "[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"},{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}]";
		List<TaskRoadSectionPassingCarRecordPassInfo> list = TaskRoadSectionPassingCarRecordPassInfo
				.parseList(json);
		List<List<TaskRoadSectionPassingCarRecordPassInfo>> input = Lists.newArrayList();
		input.add(list);
		Double length = new Double(80.0);
		Double actual = CalculateServiceImpl.calculateDoubleCardTaskRoadAverageSpeed(length, input);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateSingleCardTaskRoadTrafficFlow() {
		final Long expected = 6L;
		String json = "[{\"sbbh\":\"1\", \"gcsl\":\"2\"}, {\"sbbh\":\"1\", \"gcsl\":\"4\"}]";
		List<TaskRoadSectionTrafficFlowPassInfo> list = TaskRoadSectionTrafficFlowPassInfo.parseList(json);
		Long actual = CalculateServiceImpl.calculateSingleCardTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateDoubleCardTaskRoadTrafficFlow() {
		final Long expected = 6L;
		String json = "[{\"sbbh\":\"1\", \"gcsl\":\"4\"}, {\"sbbh\":\"2\", \"gcsl\":\"8\"}]";
		List<TaskRoadSectionTrafficFlowPassInfo> list = TaskRoadSectionTrafficFlowPassInfo.parseList(json);
		Long actual = CalculateServiceImpl.calculateDoubleCardTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}

	/**
	 * single card task road section, one passing car
	 */
	@Test
	public void testCalculateAverageSpeedTaskRoad_1() {
		TaskRoadSectionPassingCarRecord instance = new TaskRoadSectionPassingCarRecord();
		instance.setId(1L);
		instance.setTaskId(1L);
		instance.setRoadSectionId(1L);
		instance.setCarNumber("test");
		instance.setCardCount(1);
		instance.setPassInfoJson("[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 08:14:00\", \"clsd\":\"80\"}]");
		List<TaskRoadSectionPassingCarRecord> result = Lists.newArrayList(instance);
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
		TaskRoadSectionPassingCarRecord instance = new TaskRoadSectionPassingCarRecord();
		instance.setId(1L);
		instance.setTaskId(1L);
		instance.setRoadSectionId(1L);
		instance.setCarNumber("test_car_num");
		instance.setCardCount(1);
		instance.setPassInfoJson(sb.toString());
		List<TaskRoadSectionPassingCarRecord> result = Lists.newArrayList(instance);
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
		TaskRoadSectionPassingCarRecord instance = new TaskRoadSectionPassingCarRecord();
		instance.setId(1L);
		instance.setTaskId(1L);
		instance.setRoadSectionId(1L);
		instance.setCarNumber("test_car_num_1");
		instance.setCardCount(2);
		instance.setPassInfoJson(sb.toString());
		List<TaskRoadSectionPassingCarRecord> result = Lists.newArrayList(instance);
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
		final long roadSectionId = 1L;
		final int cardCount = 2;
		StringBuilder sb1 = new StringBuilder();
		sb1.append("[");
		sb1.append("{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"}");
		sb1.append(",");
		sb1.append("{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}");
		sb1.append("]");
		TaskRoadSectionPassingCarRecord instance1 = new TaskRoadSectionPassingCarRecord();
		instance1.setId(1L);
		instance1.setTaskId(taskId);
		instance1.setRoadSectionId(roadSectionId);
		instance1.setCarNumber("test_car_num_1");
		instance1.setCardCount(cardCount);
		instance1.setPassInfoJson(sb1.toString());
		StringBuilder sb2 = new StringBuilder();
		sb2.append("[");
		sb2.append("{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"}");
		sb2.append(",");
		sb2.append("{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}");
		sb2.append("]");
		TaskRoadSectionPassingCarRecord instance2 = new TaskRoadSectionPassingCarRecord();
		instance2.setId(1L);
		instance2.setTaskId(taskId);
		instance2.setRoadSectionId(roadSectionId);
		instance2.setCarNumber("test_car_num_1");
		instance2.setCardCount(cardCount);
		instance2.setPassInfoJson(sb2.toString());
		List<TaskRoadSectionPassingCarRecord> result = Lists.newArrayList(instance1, instance2);
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
		final long roadSectionId = 1L;
		final int cardCount = 1;
		final String json = "[{\"sbbh\":\"1\", \"gcsl\":\"1\"}]";
		TaskRoadSectionTrafficFlow instance = new TaskRoadSectionTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadSectionId(roadSectionId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadSectionTrafficFlow> list = Lists.newArrayList(instance);
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
		final long roadSectionId = 1L;
		final int cardCount = 1;
		final String json = "[{\"sbbh\":\"1\", \"gcsl\":\"2\"}]";
		TaskRoadSectionTrafficFlow instance = new TaskRoadSectionTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadSectionId(roadSectionId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadSectionTrafficFlow> list = Lists.newArrayList(instance);
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
		final long roadSectionId = 1L;
		final int cardCount = 2;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{\"sbbh\":\"1\", \"gcsl\":\"1\"}");
		sb.append(",");
		sb.append("{\"sbbh\":\"2\", \"gcsl\":\"1\"}");
		sb.append("]");
		final String json = sb.toString();
		TaskRoadSectionTrafficFlow instance = new TaskRoadSectionTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadSectionId(roadSectionId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadSectionTrafficFlow> list = Lists.newArrayList(instance);
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
		final long roadSectionId = 1L;
		final int cardCount = 2;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{\"sbbh\":\"1\", \"gcsl\":\"2\"}");
		sb.append(",");
		sb.append("{\"sbbh\":\"2\", \"gcsl\":\"2\"}");
		sb.append("]");
		final String json = sb.toString();
		TaskRoadSectionTrafficFlow instance = new TaskRoadSectionTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadSectionId(roadSectionId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadSectionTrafficFlow> list = Lists.newArrayList(instance);
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
		final long roadSectionId = 1L;
		final int cardCount = 2;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("{\"sbbh\":\"1\", \"gcsl\":\"4\"}");
		sb.append(",");
		sb.append("{\"sbbh\":\"2\", \"gcsl\":\"6\"}");
		sb.append("]");
		final String json = sb.toString();
		TaskRoadSectionTrafficFlow instance = new TaskRoadSectionTrafficFlow();
		instance.setId(1L);
		instance.setTaskId(taskId);
		instance.setRoadSectionId(roadSectionId);
		instance.setCardCount(cardCount);
		instance.setPassInfoJson(json);
		List<TaskRoadSectionTrafficFlow> list = Lists.newArrayList(instance);
		final Long expected = 5L;
		Long actual = CalculateServiceImpl.calculateTaskRoadTrafficFlow(list);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testCalculateTravelTime() {
		final Long expected = 3600L;
		String passInfoJson = "[{\"sbbh\":\"1\", \"gcsj\":\"2014-11-19 00:00:00\", \"clsd\":\"-75\"},{\"sbbh\":\"2\", \"gcsj\":\"2014-11-19 01:00:00\", \"clsd\":\"-85\"}]";
		TaskRoadSectionPassingCarRecord record = new TaskRoadSectionPassingCarRecord();
		record.setId(1L);
		record.setTaskId(1L);
		record.setRoadSectionId(1L);
		record.setCardCount(2);
		record.setCarNumber("TEST");
		record.setPassInfoJson(passInfoJson);
		List<TaskRoadSectionPassingCarRecord> list = Lists.newArrayList(record);
		Long actual = CalculateServiceImpl.calculateTravelTime(list);
		Assert.assertEquals(expected, actual);
	}

}
