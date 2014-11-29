package com.example.trafficcarddataprocess.calculator.service;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.domain.Road;
import com.example.trafficcarddataprocess.calculator.domain.Task;

public interface CalculateService {
	
	public List<Result> calculate(Task task);
	
	public Result calculate(Task task, Road road);

	/**
	 * 
	 * @param task
	 * @param road
	 * @return speed in km/h
	 */
	public Double calculateAverageSpeed(Task task, Road road);
	
	/**
	 * 
	 * @param task
	 * @param road
	 * @return  
	 */
	public Long calculateTrafficFlow(Task task, Road road);

}
