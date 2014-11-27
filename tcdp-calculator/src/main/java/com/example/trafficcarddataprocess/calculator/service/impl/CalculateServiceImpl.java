package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadPassingCarRecordDao;
import com.example.trafficcarddataprocess.calculator.domain.Road;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecordPassInfo;
import com.example.trafficcarddataprocess.calculator.service.CalculateService;
import com.google.common.collect.Lists;

@Component
public class CalculateServiceImpl implements CalculateService {

	@Autowired
	private TaskRoadPassingCarRecordDao dao;

	@Override
	public Double calculateAverageSpeed(Task task, Road road) {
		long taskId = task.getId();
		long roadId = road.getId();
		List<TaskRoadPassingCarRecord> result = dao.findAllByTaskAndRoad(
				taskId, roadId);
		if (result.isEmpty()) {
			return null;
		}

		return calculateAverageSpeed(result, road.getLength());
	}

	/**
	 * 
	 * @param result
	 * @param length  in kilometers
	 * @return  speed in km/h
	 */
	static Double calculateAverageSpeed(List<TaskRoadPassingCarRecord> result,
			final double length) {
		// filter
		TaskRoadPassingCarRecord first = result.get(0);
		final int cardCount = first.getCardCount();
		List<String> jsonList = Lists.newArrayList();
		for (TaskRoadPassingCarRecord e : result) {
			if (e.getCardCount() != cardCount) {
				continue;
			}
			String json = e.getPassInfoJson();
			jsonList.add(json);
		}
		// calculate
		if (cardCount == 1) {
			List<TaskRoadPassingCarRecordPassInfo> list = Lists.newArrayList();
			for (String e : jsonList) {
				list.addAll(TaskRoadPassingCarRecordPassInfo.parseList(e));
			}
			return TaskRoadPassingCarRecordPassInfo
					.calculateSingleCardTaskRoadAverageSpeed(list);
		} else if (cardCount == 2) {
			List<List<TaskRoadPassingCarRecordPassInfo>> list = Lists
					.newArrayList();
			for (String e : jsonList) {
				list.add(TaskRoadPassingCarRecordPassInfo.parseList(e));
			}
			return TaskRoadPassingCarRecordPassInfo
					.calculateDoubleCardTaskRoadAverageSpeed(length, list);
		} else {
			return null;
		}
	}

}
