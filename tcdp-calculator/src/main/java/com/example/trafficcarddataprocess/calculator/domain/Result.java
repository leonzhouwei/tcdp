package com.example.trafficcarddataprocess.calculator.domain;

public class Result {

	private Long id;
	private Long taskId;
	private Long roadSectionId;
	private Long travelTime; // in seconds
	private Double averageSpeed;
	private Double averageSpeedConfidence;
	private Long trafficFlow;
	private Double trafficFlowConfidence;

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
