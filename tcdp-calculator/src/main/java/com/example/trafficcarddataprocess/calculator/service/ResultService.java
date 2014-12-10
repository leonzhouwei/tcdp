package com.example.trafficcarddataprocess.calculator.service;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Result;

public interface ResultService {

	public void save(long taskId, List<Result> results);

}
