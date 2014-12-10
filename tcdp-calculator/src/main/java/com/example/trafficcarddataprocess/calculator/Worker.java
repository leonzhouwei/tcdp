package com.example.trafficcarddataprocess.calculator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.example.trafficcarddataprocess.calculator.common.CommonDefine;
import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.service.CalculateService;
import com.example.trafficcarddataprocess.calculator.service.ResultService;

@Component
@Scope(CommonDefine.BEAN_SCOPE_PROTOTYPE)
public class Worker {
	
	private static final Logger logger = LoggerFactory.getLogger(Worker.class);
	
	@Autowired
	private CalculateService calculateService;
	@Autowired
	private ResultService resultService;
	
	public List<Result> work(long taskId) {
		List<Result> results = calculateService.calculate(taskId);
		if (results.isEmpty()) {
			return results;
		}
	
		for (Result e : results) {
			String json = JSONObject.toJSONString(e);
			logger.debug(json);
		}
		
		resultService.save(taskId, results);
		return results;
	}

}
