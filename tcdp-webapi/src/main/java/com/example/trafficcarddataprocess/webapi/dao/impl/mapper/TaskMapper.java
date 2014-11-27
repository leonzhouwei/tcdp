package com.example.trafficcarddataprocess.webapi.dao.impl.mapper;

import java.util.List;

import com.example.trafficcarddataprocess.webapi.domain.Task;

public interface TaskMapper {
	
	List<Task> selectAll();

}
