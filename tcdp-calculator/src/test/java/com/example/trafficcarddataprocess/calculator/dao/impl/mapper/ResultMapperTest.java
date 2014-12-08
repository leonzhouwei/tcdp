package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.Result;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class ResultMapperTest {
	
	@Autowired
	private ResultMapper mapper;

	public void testInsert() {
		Result result = new Result();
		result.setTaskId(1L);
		result.setRoadSectionId(1L);
		result.setTravelTime(1L);
		result.setAverageSpeed(1.1);
		result.setAverageSpeedConfidence(0.1);
		result.setTrafficFlow(1L);
		result.setTrafficFlowConfidence(0.1);
		mapper.insert(result);
	}

}
