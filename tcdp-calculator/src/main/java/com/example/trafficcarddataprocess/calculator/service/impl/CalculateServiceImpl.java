package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadPassingCarRecordDao;
import com.example.trafficcarddataprocess.calculator.dao.TaskRoadTrafficFlowDao;
import com.example.trafficcarddataprocess.calculator.domain.Road;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecord;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadPassingCarRecordPassInfo;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlow;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadTrafficFlowPassInfo;
import com.example.trafficcarddataprocess.calculator.service.CalculateService;
import com.google.common.collect.Lists;

@Component
public class CalculateServiceImpl implements CalculateService {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculateServiceImpl.class);
	private static Double DOUBLE_ZERO = 0.0;
	private static int SECONDS_PER_HOUR = 3600;
	
	@Autowired
	private TaskRoadPassingCarRecordDao passCarDao;
	@Autowired
	private TaskRoadTrafficFlowDao trafficFlowDao;

	@Override
	public Double calculateAverageSpeed(Task task, Road road) {
		long taskId = task.getId();
		long roadId = road.getId();
		List<TaskRoadPassingCarRecord> result = passCarDao.findAllByTaskIdAndRoadId(
				taskId, roadId);
		if (result.isEmpty()) {
			return null;
		}

		Double length = new Double(road.getLength());
		return calculateAverageSpeed(result, length);
	}
	
	public Long calculateTrafficFlow(Task task, Road road) {
		// TODO
		return null;
	}
	
	/**
	 * 
	 * @param result
	 * @param length  in kilometers
	 * @return  speed in km/h
	 */
	static Double calculateAverageSpeed(List<TaskRoadPassingCarRecord> result,
			Double length) {
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
			logger.debug("single card task road section");
			List<TaskRoadPassingCarRecordPassInfo> list = Lists.newArrayList();
			for (String e : jsonList) {
				list.addAll(TaskRoadPassingCarRecordPassInfo.parseList(e));
			}
			return calculateSingleCardTaskRoadAverageSpeed(list);
		} else if (cardCount == 2) {
			logger.debug("double card task road section");
			List<List<TaskRoadPassingCarRecordPassInfo>> list = Lists
					.newArrayList();
			for (String e : jsonList) {
				list.add(TaskRoadPassingCarRecordPassInfo.parseList(e));
			}
			return calculateDoubleCardTaskRoadAverageSpeed(length, list);
		} else {
			logger.debug("invalid-card-number task road section");
			return null;
		}
	}
	
	static Long calculateTaskRoadTrafficFlow(List<TaskRoadTrafficFlow> list) {
		// filter
		TaskRoadTrafficFlow first = list.get(0);
		final int cardCount = first.getCardCount();
		List<TaskRoadTrafficFlow> filtered = Lists.newArrayList();
		for (TaskRoadTrafficFlow e : list) {
			if (e.getCardCount() == cardCount) {
				filtered.add(e);
			}
		}
		// calculate
		if (cardCount == 1) {
			List<TaskRoadTrafficFlowPassInfo> infoList = Lists.newArrayList();
			for (TaskRoadTrafficFlow e : filtered) {
				List<TaskRoadTrafficFlowPassInfo> info = TaskRoadTrafficFlowPassInfo.parseList(e.getPassInfoJson());
				infoList.addAll(info);
			}
			return calculateSingleCardTaskRoadTrafficFlow(infoList);
		} else if (cardCount == 2) {
			List<TaskRoadTrafficFlowPassInfo> infoList = Lists.newArrayList();
			for (TaskRoadTrafficFlow e : filtered) {
				List<TaskRoadTrafficFlowPassInfo> info = TaskRoadTrafficFlowPassInfo.parseList(e.getPassInfoJson());
				infoList.addAll(info);
			}
			return calculateDoubleCardTaskRoadTrafficFlow(infoList);
		} else {
			return null;
		}
	}
	
	/**
	 * 
	 * @param c
	 * @return  speed in km/h
	 */
	public static Double calculateSingleCardTaskRoadAverageSpeed(Collection<TaskRoadPassingCarRecordPassInfo> c) {
		if (c.isEmpty()) {
			return null;
		}
		
		Double result = DOUBLE_ZERO;
		for (TaskRoadPassingCarRecordPassInfo e : c) {
			Double speed = new Double(e.getSpeed());
			result += speed;
		}
		result /= c.size();
		
		return result;
	}
	
	/**
	 * inner list whose size is less than 2 will be ignored
	 * 
	 * @param length  in kilometers
	 * @param c
	 * @return  speed in km/h
	 */
	public static Double calculateDoubleCardTaskRoadAverageSpeed(Double length, Collection<List<TaskRoadPassingCarRecordPassInfo>> c) {
		logger.debug("road length(km): " + length);
		if (c.isEmpty() || length.compareTo(DOUBLE_ZERO) <= 0) {
			return null;
		}
		
		Double result = DOUBLE_ZERO;
		int effectiveCount = 0;
		for (List<TaskRoadPassingCarRecordPassInfo> e : c) {
			if (e.size() < 2) {
				continue;
			}
			TaskRoadPassingCarRecordPassInfo one = e.get(0);
			TaskRoadPassingCarRecordPassInfo another = e.get(1);
			// time cost
			long millisOne = one.getTime().getTime();
			long millisAnother = another.getTime().getTime();
			long absDeltaMillis = Math.abs(millisAnother - millisOne);
			// average speed
			long absDeltaSeconds = absDeltaMillis / 1000;
			logger.debug("delta seconds: " + absDeltaSeconds);
			Double averageSpeed = length * SECONDS_PER_HOUR / absDeltaSeconds ;
			result += averageSpeed;
			effectiveCount += 1;
		}
		
		if (effectiveCount > 0) {
			result = result / effectiveCount;
		} else {
			result = DOUBLE_ZERO;
		}
		
		return result;
	}
	
	public static Long calculateSingleCardTaskRoadTrafficFlow(Collection<TaskRoadTrafficFlowPassInfo> c) {
		if (c.isEmpty()) {
			return null;
		}
		
		long sum = 0;
		for (TaskRoadTrafficFlowPassInfo e : c) {
			sum += e.getPassCarCount();
		}
		return sum;
	}
	
	public static Long calculateDoubleCardTaskRoadTrafficFlow(Collection<TaskRoadTrafficFlowPassInfo> c) {
		Long result = calculateSingleCardTaskRoadTrafficFlow(c);
		if (result == null) {
			return result;
		}
		result /= 2;
		return result;
	}

}
