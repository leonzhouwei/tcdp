package com.example.trafficcarddataprocess.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.RoadMapper;
import com.example.trafficcarddataprocess.calculator.domain.Road;
import com.example.trafficcarddataprocess.calculator.service.RoadService;

@Component
public class RoadServiceImpl implements RoadService {

	@Autowired
	private RoadMapper roadMapper;
	
	@Override
	public Road findRoad(long id) {
		return roadMapper.selectRoad(id);
	}

}
