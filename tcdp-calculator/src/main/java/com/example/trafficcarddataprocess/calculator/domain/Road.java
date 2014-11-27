package com.example.trafficcarddataprocess.calculator.domain;

public class Road {

	private Long id;
	private Integer cardCount;
	private Double length; // in kilometers

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCardCount() {
		return cardCount;
	}

	public void setCardCount(Integer cardCount) {
		this.cardCount = cardCount;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

}
