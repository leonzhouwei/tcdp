package com.example.trafficcarddataprocess.calculator.domain;

public class TaskRoadPassingCarRecord {

	private Long id;
	private Long taskId;
	private Long roadId;
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

	public Long getRoadId() {
		return roadId;
	}

	public void setRoadId(Long roadId) {
		this.roadId = roadId;
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
