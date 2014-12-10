package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.ResultDao;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.ResultMapper;
import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.TaskMapper;
import com.example.trafficcarddataprocess.calculator.domain.Result;

@Component
public class ResultDaoImpl implements ResultDao {
	
	@Autowired
	private ResultMapper resultMapper;
	@Autowired
	private TaskMapper taskMapper;

	@Override
	public void save(Result result) {
		resultMapper.insert(result);
	}

	@Override
	public List<Result> findAll() {
		return resultMapper.selectAll();
	}

	@Override
	public void save(Collection<Result> results) {
		if (results.isEmpty()) {
			return;
		}
		for (Result e : results) {
			resultMapper.insert(e);
		}
	}

	@Override
	public void save(long taskId, Collection<Result> results) {
		save(results);
		taskMapper.updateAsDone(taskId);
	}

}
