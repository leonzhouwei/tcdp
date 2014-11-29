package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionTrafficFlow;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TaskRoadSectionTrafficFlowMapperTest {
	
	@Autowired
	private TaskRoadSectionTrafficFlowMapper mapper;

	@Test
	public void testSelectAll() {
		List<TaskRoadSectionTrafficFlow> result = mapper.selectAll();
		for (TaskRoadSectionTrafficFlow e : result) {
			String json = JSONObject.toJSONString(e);
			System.out.println(json);
		}
	}

}
