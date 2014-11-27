package com.example.trafficcarddataprocess.calculator.domain;

public class Road {

	private Long id;
	private Integer cardCount;
	private Double lenth; // in kilometers

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

	public Double getLenth() {
		return lenth;
	}

	public void setLenth(Double lenth) {
		this.lenth = lenth;
	}

}
