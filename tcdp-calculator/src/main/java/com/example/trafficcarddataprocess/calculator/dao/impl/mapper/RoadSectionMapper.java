package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import com.example.trafficcarddataprocess.calculator.domain.RoadSection;

public interface RoadSectionMapper {
	
	public static final String TASK_ID = "taskId";
	public static final String ROAD_SECTION_ID = "roadSectionId";
	
	public RoadSection selectRoad(Long id);

}
