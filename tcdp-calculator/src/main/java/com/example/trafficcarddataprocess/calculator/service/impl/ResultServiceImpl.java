package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.ResultDao;
import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.service.ResultService;

@Component
public class ResultServiceImpl implements ResultService {
	
	@Autowired
	private ResultDao resultDao;

	@Override
	public void save(long taskId, List<Result> results) {
		resultDao.save(taskId, results);
	}

}
