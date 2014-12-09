package com.example.trafficcarddataprocess.calculator.domain;

public class Result {
	
	public static final Double DEFAULT_AVERAGE_SPEED = -1.0;
	public static final Double DEFAULT_CONFIDENCE = -1.0;
	public static final Long DEFAULT_TRAFFIC_FLOW = -1L;
	public static final Long DEFAULT_TRAVEL_TIME = -1L;

	private Long id = -1L;
	private Long taskId = -1L;
	private Long roadSectionId = -1L;
	private Long travelTime = -1L; // in seconds
	private Double averageSpeed = DEFAULT_AVERAGE_SPEED;
	private Double averageSpeedConfidence = DEFAULT_CONFIDENCE;
	private Long trafficFlow = DEFAULT_TRAFFIC_FLOW;
	private Double trafficFlowConfidence = DEFAULT_CONFIDENCE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(Double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public Double getAverageSpeedConfidence() {
		return averageSpeedConfidence;
	}

	public void setAverageSpeedConfidence(Double averageSpeedConfidence) {
		this.averageSpeedConfidence = averageSpeedConfidence;
	}

	public Long getTrafficFlow() {
		return trafficFlow;
	}

	public void setTrafficFlow(Long trafficFlow) {
		this.trafficFlow = trafficFlow;
	}

	public Double getTrafficFlowConfidence() {
		return trafficFlowConfidence;
	}

	public void setTrafficFlowConfidence(Double trafficFlowConfidence) {
		this.trafficFlowConfidence = trafficFlowConfidence;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getRoadSectionId() {
		return roadSectionId;
	}

	public void setRoadSectionId(Long roadSectionId) {
		this.roadSectionId = roadSectionId;
	}

	public Long getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(Long travelTime) {
		this.travelTime = travelTime;
	}

}
