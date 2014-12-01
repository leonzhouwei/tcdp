package com.example.trafficcarddataprocess.calculator.domain;

public class TaskRoadSectionPassingCarRecord {

	private Long id;
	private Long taskId;
	private Long roadSectionId;
	private String carNumber;
	private String passInfoJson;
	private Integer cardCount;
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getPassInfoJson() {
		return passInfoJson;
	}

	public void setPassInfoJson(String passInfoJson) {
		this.passInfoJson = passInfoJson;
	}

	public Integer getCardCount() {
		return cardCount;
	}

	public void setCardCount(Integer cardCount) {
		this.cardCount = cardCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
