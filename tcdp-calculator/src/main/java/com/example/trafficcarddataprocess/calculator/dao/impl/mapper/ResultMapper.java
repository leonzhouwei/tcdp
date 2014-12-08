package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Result;

public interface ResultMapper {
	
	public Integer insert(Result result);
	
	public List<Result> selectAll();

}
