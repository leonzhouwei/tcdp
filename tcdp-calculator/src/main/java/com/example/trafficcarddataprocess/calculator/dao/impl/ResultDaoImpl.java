package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.ResultDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.ResultMapper;
import com.example.trafficcarddataprocess.calculator.domain.Result;

@Component
public class ResultDaoImpl implements ResultDao {
	
	@Autowired
	private ResultMapper resultMapper;

	@Override
	public void save(Result result) {
		resultMapper.insert(result);
	}

	@Override
	public List<Result> findAll() {
		return resultMapper.selectAll();
	}

	@Override
	public void save(List<Result> results) {
		if (results.isEmpty()) {
			return;
		}
		for (Result e : results) {
			resultMapper.insert(e);
		}
	}

}
