package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.Road;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class RoadMapperTest {
	
	@Autowired
	private RoadMapper roadMapper;

	@Test
	public void testSelectRoad() {
		final Long id = 42595700548L;
		Road road = roadMapper.selectRoad(id);
		System.out.println(JSONObject.toJSONString(road));
	}

}
