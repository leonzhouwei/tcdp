package com.example.trafficcarddataprocess.calculator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.impl.mapper.RoadSectionMapper;
import com.example.trafficcarddataprocess.calculator.domain.RoadSection;
import com.example.trafficcarddataprocess.calculator.service.RoadSectionService;

@Component
public class RoadSectionServiceImpl implements RoadSectionService {

	@Autowired
	private RoadSectionMapper roadMapper;
	
	@Override
	public RoadSection findRoadSection(long id) {
		return roadMapper.selectRoad(id);
	}

}
