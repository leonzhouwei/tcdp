package com.example.trafficcarddataprocess.calculator.domain;

public class TaskRoadSectionTrafficFlow {
	
	private Long id;
	private Long taskId;
	private Long roadSectionId;
	private Integer cardCount;
	private String passInfoJson;
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

	public void setRoadSectionId(Long roadId) {
		this.roadSectionId = roadId;
	}

	public Integer getCardCount() {
		return cardCount;
	}

	public void setCardCount(Integer cardCount) {
		this.cardCount = cardCount;
	}

	public String getPassInfoJson() {
		return passInfoJson;
	}

	public void setPassInfoJson(String passInfoJson) {
		this.passInfoJson = passInfoJson;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
