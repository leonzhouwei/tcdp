package com.example.trafficcarddataprocess.calculator.dao;

import java.util.Collection;
import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Result;

public interface ResultDao {
	
	public void save(Result result);
	
	public List<Result> findAll();

	public void save(long taskId, Collection<Result> results);

}
