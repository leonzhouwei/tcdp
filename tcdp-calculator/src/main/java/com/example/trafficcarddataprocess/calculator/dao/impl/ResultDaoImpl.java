package com.example.trafficcarddataprocess.calculator.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Result> findAll() {
		return resultMapper.selectAll();
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void save(long taskId, Collection<Result> results) {
		for (Result e : results) {
			resultMapper.insert(e);
		}
		taskMapper.updateAsDone(taskId);
	}

}
