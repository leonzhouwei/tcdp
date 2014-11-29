package com.example.trafficcarddataprocess.calculator.domain;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class TaskRoadSectionTrafficFlowPassInfo {
	private static final String DEVICE_NUMBER_FIELD_NAME = "sbbh";
	private static final String PASSING_CAR_COUNT_FIELD_NAME = "gcsl";

	private String deviceNumber;
	private Integer passCarCount;
	
	public static List<TaskRoadSectionTrafficFlowPassInfo> parseList(String json) {
		return JSONObject.parseArray(json, TaskRoadSectionTrafficFlowPassInfo.class);
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
