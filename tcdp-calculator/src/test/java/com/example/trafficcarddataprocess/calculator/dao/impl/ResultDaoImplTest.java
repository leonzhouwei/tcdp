package com.example.trafficcarddataprocess.calculator.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.dao.ResultDao;
import com.example.trafficcarddataprocess.calculator.domain.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class ResultDaoImplTest {

	@Autowired
	private ResultDao dao;

	@Test
	public void nop() {
	}

	public void testSave() {
		Result result = new Result();
		result.setTaskId(1L);
		result.setRoadSectionId(1L);
		result.setTravelTime(1L);
		result.setAverageSpeed(1.1);
		result.setAverageSpeedConfidence(0.1);
		result.setTrafficFlow(1L);
		result.setTrafficFlowConfidence(0.1);
		dao.save(result);
	}

}
