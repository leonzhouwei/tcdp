package com.example.trafficcarddataprocess.webapi.domain;

import java.util.Collection;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class TaskRoadTrafficFlowPassInfo {
	private static final String DEVICE_NUMBER_FIELD_NAME = "sbbh";
	private static final String PASSING_CAR_COUNT_FIELD_NAME = "gcsl";

	private String deviceNumber;
	private Integer passCarCount;
	
	public static Integer calculateSingleCardTaskRoadTrafficFlow(final int seconds, Collection<TaskRoadTrafficFlowPassInfo> c) {
		if (c.isEmpty() || seconds < 0) {
			return null;
		}
		
		long sum = 0;
		for (TaskRoadTrafficFlowPassInfo e : c) {
			sum += e.getPassCarCount();
		}
		int result = (int) (sum / seconds);
		return result;
	}
	
	public static Integer calculateTwoCardTaskRoadTrafficFlow(final int seconds, Collection<TaskRoadTrafficFlowPassInfo> c) {
		Integer result = calculateSingleCardTaskRoadTrafficFlow(seconds, c);
		if (result == null) {
			return result;
		}
		result /= 2;
		return result;
	}

	public static List<TaskRoadTrafficFlowPassInfo> parseList(String json) {
		return JSONObject.parseArray(json, TaskRoadTrafficFlowPassInfo.class);
	}

	@JSONField(name = DEVICE_NUMBER_FIELD_NAME)
	public String getDeviceNumber() {
		return deviceNumber;
	}

	@JSONField(name = DEVICE_NUMBER_FIELD_NAME)
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	@JSONField(name = PASSING_CAR_COUNT_FIELD_NAME)
	public Integer getPassCarCount() {
		return passCarCount;
	}

	@JSONField(name = PASSING_CAR_COUNT_FIELD_NAME)
	public void setPassCarCount(Integer passCarCount) {
		this.passCarCount = passCarCount;
	}
	
}
