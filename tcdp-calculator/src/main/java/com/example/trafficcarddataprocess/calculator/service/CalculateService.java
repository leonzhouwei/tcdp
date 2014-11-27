package com.example.trafficcarddataprocess.calculator.service;

import com.example.trafficcarddataprocess.calculator.domain.Road;
import com.example.trafficcarddataprocess.calculator.domain.Task;

public interface CalculateService {
	
	public double calculateAverageSpeed(Task task, Road road);
	
}
