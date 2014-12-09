package com.example.trafficcarddataprocess.calculator.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.trafficcarddataprocess.calculator.dao.TaskRoadSectionPassingCarRecordDao;
import com.example.trafficcarddataprocess.calculator.dao.TaskRoadSectionTrafficFlowDao;
import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.domain.RoadSection;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecordPassInfo;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlowPassInfo;
import com.example.trafficcarddataprocess.calculator.service.CalculateService;
import com.example.trafficcarddataprocess.calculator.service.RoadSectionService;
import com.example.trafficcarddataprocess.calculator.service.TaskService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@Component
public class CalculateServiceImpl implements CalculateService {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculateServiceImpl.class);
	private static Double DOUBLE_ZERO = 0.0;
	private static int SECONDS_PER_HOUR = 3600;
	
	@Autowired
	private TaskRoadSectionPassingCarRecordDao passCarDao;
	@Autowired
	private TaskRoadSectionTrafficFlowDao trafficFlowDao;
	@Autowired
	private RoadSectionService roadService;
	@Autowired
	private TaskService taskService;
	
	@Override
	public List<Result> calculate(Task task) {
		List<Result> ret = Lists.newArrayList();
		final long taskId = task.getId();
		// task and its related road sections
		List<TaskRoadSectionPassingCarRecord> list = passCarDao.findByTaskId(taskId);
		if (list.isEmpty()) {
			return ret;
		}
		Set<Long> roadSectionIds = Sets.newHashSet();
		for (TaskRoadSectionPassingCarRecord e : list) {
			// road section
			Long roadSectionId = e.getRoadSectionId();
			if (roadSectionIds.contains(roadSectionId)) {
				continue;
			} else {
				roadSectionIds.add(roadSectionId);
			}
			RoadSection roadSection = roadService.findRoadSection(roadSectionId);
			Result result = calculate(task, roadSection);
			ret.add(result);
		}
		return ret;
	}
	
	@Override
	public Result calculate(Task task, RoadSection roadSection) {
		Result speedAndTime = calculateAverageSpeedAndTravelTime(task, roadSection);
		long trafficFlow = calculateTrafficFlow(task, roadSection);
		Result result = new Result();
		result.setId(-1L);
		result.setTaskId(task.getId());
		result.setRoadSectionId(roadSection.getId());
		result.setAverageSpeed(speedAndTime.getAverageSpeed());
		result.setTrafficFlow(trafficFlow);
		result.setTravelTime(speedAndTime.getTravelTime());
		return result;
	}

	@Override
	public Double calculateAverageSpeed(Task task, RoadSection roadSection) {
		long taskId = task.getId();
		long roadSectionId = roadSection.getId();
		List<TaskRoadSectionPassingCarRecord> result = passCarDao.findByTaskIdAndRoadSectionId(
				taskId, roadSectionId);
		if (result.isEmpty()) {
			return null;
		}

		Double length = new Double(roadSection.getLength());
		double ret = calculateAverageSpeed(result, length);
		return ret;
	}
	
	@Override
	public Result calculateAverageSpeedAndTravelTime(Task task, RoadSection roadSection) {
		long taskId = task.getId();
		long roadSectionId = roadSection.getId();
		List<TaskRoadSectionPassingCarRecord> result = passCarDao.findByTaskIdAndRoadSectionId(
				taskId, roadSectionId);
		if (result.isEmpty()) {
			return null;
		}

		Double length = new Double(roadSection.getLength());
		final Double averageSpeed = calculateAverageSpeed(result, length);
		Result ret = new Result();
		ret.setAverageSpeed(averageSpeed);
		final Long travelSeconds = calculateTravelTime(result);
		ret.setTravelTime(travelSeconds);
		return ret;
	}
	
	public static Long calculateTravelTime(List<TaskRoadSectionPassingCarRecord> result) {
		// filter
		List<List<TaskRoadSectionPassingCarRecordPassInfo>> samples = Lists.newArrayList();
		for (TaskRoadSectionPassingCarRecord e : result) {
			if (e.getCardCount() != 2) {
				continue;
			}
			String json = e.getPassInfoJson();
			List<TaskRoadSectionPassingCarRecordPassInfo> temp = TaskRoadSectionPassingCarRecordPassInfo.parseList(json);
			if (temp.size() != 2) {
				continue;
			}
			samples.add(temp);
		}
		if (samples.isEmpty()) {
			return Result.DEFAULT_TRAVEL_TIME;
		}
		// calculate
		long travelMillis = 0;
		for (List<TaskRoadSectionPassingCarRecordPassInfo> e : samples) {
			TaskRoadSectionPassingCarRecordPassInfo one = e.get(0);
			TaskRoadSectionPassingCarRecordPassInfo another = e.get(1);
			long millisOne = one.getTime().getTime();
			long millisAnother = another.getTime().getTime();
			long deltaMillis = millisAnother - millisOne;
			travelMillis += Math.abs(deltaMillis);
		}
		long travelSeconds = travelMillis / 1000 / samples.size();
		return travelSeconds;
	}
	
	@Override
	public Long calculateTrafficFlow(Task task, RoadSection roadSection) {
		long taskId = task.getId();
		long roadSectionId = roadSection.getId();
		List<TaskRoadSectionTrafficFlow> result = trafficFlowDao.findByTaskIdAndRoadSectionId(taskId, roadSectionId);
		if (result.isEmpty()) {
			return Result.DEFAULT_TRAFFIC_FLOW;
		}
		long ret = calculateTaskRoadTrafficFlow(result);
		return ret;
	}
	
	/**
	 * 
	 * @param result
	 * @param length  in kilometers
	 * @return  speed in km/h
	 */
	static Double calculateAverageSpeed(List<TaskRoadSectionPassingCarRecord> result,
			Double length) {
		// filter
		TaskRoadSectionPassingCarRecord first = result.get(0);
		final int cardCount = first.getCardCount();
		List<String> jsonList = Lists.newArrayList();
		for (TaskRoadSectionPassingCarRecord e : result) {
			if (e.getCardCount() != cardCount) {
				continue;
			}
			String json = e.getPassInfoJson();
			jsonList.add(json);
		}
		// calculate
		if (cardCount == 1) {
			logger.debug("single card task road section");
			List<TaskRoadSectionPassingCarRecordPassInfo> list = Lists.newArrayList();
			for (String e : jsonList) {
				list.addAll(TaskRoadSectionPassingCarRecordPassInfo.parseList(e));
			}
			return calculateSingleCardTaskRoadAverageSpeed(list);
		} else if (cardCount == 2) {
			logger.debug("double card task road section");
			List<List<TaskRoadSectionPassingCarRecordPassInfo>> list = Lists
					.newArrayList();
			for (String e : jsonList) {
				list.add(TaskRoadSectionPassingCarRecordPassInfo.parseList(e));
			}
			return calculateDoubleCardTaskRoadAverageSpeed(length, list);
		} else {
			logger.debug("invalid-card-number task road section");
			return Result.DEFAULT_AVERAGE_SPEED;
		}
	}
	
	static Long calculateTaskRoadTrafficFlow(List<TaskRoadSectionTrafficFlow> list) {
		// filter
		TaskRoadSectionTrafficFlow first = list.get(0);
		final int cardCount = first.getCardCount();
		List<TaskRoadSectionTrafficFlow> filtered = Lists.newArrayList();
		for (TaskRoadSectionTrafficFlow e : list) {
			if (e.getCardCount() == cardCount) {
				filtered.add(e);
			}
		}
		// calculate
		if (cardCount == 1) {
			List<TaskRoadSectionTrafficFlowPassInfo> infoList = Lists.newArrayList();
			for (TaskRoadSectionTrafficFlow e : filtered) {
				List<TaskRoadSectionTrafficFlowPassInfo> info = TaskRoadSectionTrafficFlowPassInfo.parseList(e.getPassInfoJson());
				infoList.addAll(info);
			}
			return calculateSingleCardTaskRoadTrafficFlow(infoList);
		} else if (cardCount == 2) {
			List<TaskRoadSectionTrafficFlowPassInfo> infoList = Lists.newArrayList();
			for (TaskRoadSectionTrafficFlow e : filtered) {
				List<TaskRoadSectionTrafficFlowPassInfo> info = TaskRoadSectionTrafficFlowPassInfo.parseList(e.getPassInfoJson());
				infoList.addAll(info);
			}
			return calculateDoubleCardTaskRoadTrafficFlow(infoList);
		} else {
			return Result.DEFAULT_TRAFFIC_FLOW;
		}
	}
	
	/**
	 * 
	 * @param c
	 * @return  speed in km/h
	 */
	public static Double calculateSingleCardTaskRoadAverageSpeed(Collection<TaskRoadSectionPassingCarRecordPassInfo> c) {
		if (c.isEmpty()) {
			return Result.DEFAULT_AVERAGE_SPEED;
		}
		
		Double result = DOUBLE_ZERO;
		for (TaskRoadSectionPassingCarRecordPassInfo e : c) {
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
	public static Double calculateDoubleCardTaskRoadAverageSpeed(Double length, Collection<List<TaskRoadSectionPassingCarRecordPassInfo>> c) {
		logger.debug("road length(km): " + length);
		if (c.isEmpty() || length.compareTo(DOUBLE_ZERO) <= 0) {
			return Result.DEFAULT_AVERAGE_SPEED;
		}
		
		Double result = DOUBLE_ZERO;
		int effectiveCount = 0;
		for (List<TaskRoadSectionPassingCarRecordPassInfo> e : c) {
			if (e.size() < 2) {
				continue;
			}
			TaskRoadSectionPassingCarRecordPassInfo one = e.get(0);
			TaskRoadSectionPassingCarRecordPassInfo another = e.get(1);
			// time cost
			long millisOne = one.getTime().getTime();
			long millisAnother = another.getTime().getTime();
			long absDeltaMillis = Math.abs(millisAnother - millisOne);
			// average speed
			long absDeltaSeconds = absDeltaMillis / 1000;
			logger.debug("delta seconds: " + absDeltaSeconds);
			if (absDeltaSeconds == 0L) {
				continue;
			}
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
	
	public static Long calculateSingleCardTaskRoadTrafficFlow(Collection<TaskRoadSectionTrafficFlowPassInfo> c) {
		if (c.isEmpty()) {
			return Result.DEFAULT_TRAFFIC_FLOW;
		}
		
		long sum = 0;
		for (TaskRoadSectionTrafficFlowPassInfo e : c) {
			sum += e.getPassCarCount();
		}
		return sum;
	}
	
	public static Long calculateDoubleCardTaskRoadTrafficFlow(Collection<TaskRoadSectionTrafficFlowPassInfo> c) {
		Long result = calculateSingleCardTaskRoadTrafficFlow(c);
		if (result == null) {
			return result;
		}
		result /= 2;
		return result;
	}

	@Override
	public List<Result> calculate(long taskId) {
		List<Result> ret = Lists.newArrayList();
		Task task = taskService.findTask(taskId);
		if (task == null) {
			return ret;
		}
		return calculate(task);
	}

}
