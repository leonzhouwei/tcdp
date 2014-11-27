package com.example.trafficcarddataprocess.calculator.domain;

import java.util.Date;

public class Task {

	private Long id;
	private Date startTime;
	private Date endTime;
	private Integer minuteInterval;
	private Date createTime;
	private Integer processStatus;
	private Integer outputStatus;
	private Integer expectedSampleCapacity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getMinuteInterval() {
		return minuteInterval;
	}

	public void setMinuteInterval(Integer minuteInterval) {
		this.minuteInterval = minuteInterval;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}

	public Integer getOutputStatus() {
		return outputStatus;
	}

	public void setOutputStatus(Integer outputStatus) {
		this.outputStatus = outputStatus;
	}

	public Integer getExpectedSampleCapacity() {
		return expectedSampleCapacity;
	}

	public void setExpectedSampleCapacity(Integer expectedSampleCapacity) {
		this.expectedSampleCapacity = expectedSampleCapacity;
	}

}
