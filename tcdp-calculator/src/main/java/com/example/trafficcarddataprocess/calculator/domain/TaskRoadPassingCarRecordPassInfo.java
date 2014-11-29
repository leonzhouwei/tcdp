package com.example.trafficcarddataprocess.calculator.domain;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class TaskRoadPassingCarRecordPassInfo {

	private static final String DEVICE_NUMBER_FIELD_NAME = "sbbh";
	private static final String TIME_FIELD_NAME = "gcsj";
	private static final String SPEED_FIELD_NAME = "clsd";

	private String deviceNumber;
	private Date time;
	private Double speed; // km/h
	
	public static List<TaskRoadPassingCarRecordPassInfo> parseList(String json) {
		return JSONObject.parseArray(json,
				TaskRoadPassingCarRecordPassInfo.class);
	}

	@JSONField(name = DEVICE_NUMBER_FIELD_NAME)
	public String getDeviceNumber() {
		return deviceNumber;
	}

	@JSONField(name = DEVICE_NUMBER_FIELD_NAME)
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	@JSONField(name = TIME_FIELD_NAME)
	public Date getTime() {
		return time;
	}

	@JSONField(name = TIME_FIELD_NAME)
	public void setTime(Date time) {
		this.time = time;
	}

	@JSONField(name = SPEED_FIELD_NAME)
	public Double getSpeed() {
		return speed;
	}

	@JSONField(name = SPEED_FIELD_NAME)
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	
}
