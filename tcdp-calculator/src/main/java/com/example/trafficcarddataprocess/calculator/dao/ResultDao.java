package com.example.trafficcarddataprocess.calculator.dao;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Result;

public interface ResultDao {
	
	public void save(Result result);
	
	public List<Result> findAll();

}