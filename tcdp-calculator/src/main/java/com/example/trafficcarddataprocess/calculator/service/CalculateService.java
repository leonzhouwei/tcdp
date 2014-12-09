package com.example.trafficcarddataprocess.calculator.service;

import java.util.List;

import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.domain.RoadSection;
import com.example.trafficcarddataprocess.calculator.domain.Task;

public interface CalculateService {
	
	public List<Result> calculate(long taskId);
	
	public List<Result> calculate(Task task);
	
	public Result calculate(Task task, RoadSection roadSection);
	
	public Result calculateAverageSpeedAndTravelTime(Task task, RoadSection roadSection);

	/**
	 * 
	 * @param task
	 * @param roadSection
	 * @return speed in km/h
	 */
	public Double calculateAverageSpeed(Task task, RoadSection roadSection);
	
	/**
	 * 
	 * @param task
	 * @param roadSection
	 * @return  
	 */
	public Long calculateTrafficFlow(Task task, RoadSection roadSection);

}
