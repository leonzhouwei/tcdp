package com.example.trafficcarddataprocess.webapi.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class TaskRoadPassingCarRecordPassInfo {

	private static final String DEVICE_NUMBER_FIELD_NAME = "sbbh";
	private static final String TIME_FIELD_NAME = "gcsj";
	private static final String SPEED_FIELD_NAME = "clsd";
	private static final Double DOUBLE_ZERO = 0.0;

	private String deviceNumber;
	private Date time;
	private Double speed; // km/h
	
	public static Double calculateSingleCardTaskRoadAverageSpeed(Collection<TaskRoadPassingCarRecordPassInfo> c) {
		if (c.isEmpty()) {
			return null;
		}
		
		Double result = 0.0;
		for (TaskRoadPassingCarRecordPassInfo e : c) {
			Double speed = e.getSpeed();
			result += speed;
		}
		result /= c.size();
		return result;
	}
	
	/**
	 * inner list whose size is less than 2 will be ignored
	 */
	public static Double calculateDoubleCardTaskRoadAverageSpeed(final Double length, Collection<List<TaskRoadPassingCarRecordPassInfo>> c) {
		if (c.isEmpty() || length.compareTo(DOUBLE_ZERO) <= 0) {
			return null;
		}
		
		Double result = 0.0;
		int effectiveCount = 0;
		for (List<TaskRoadPassingCarRecordPassInfo> e : c) {
			if (e.size() < 2) {
				continue;
			}
			TaskRoadPassingCarRecordPassInfo one = e.get(0);
			TaskRoadPassingCarRecordPassInfo another = e.get(1);
			// time cost
			long millisOne = one.getTime().getTime();
			long millisAnother = another.getTime().getTime();
			double deltaHours = Math.abs(millisAnother - millisOne) / 3600000;
			// average speed
			double averageSpeed = length / deltaHours;
			result += averageSpeed;
			effectiveCount += 1;
		}
		
		if (effectiveCount > 0) {
			result /= effectiveCount;
		} else {
			result = 0.0;
		}
		
		return result;
	}

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
