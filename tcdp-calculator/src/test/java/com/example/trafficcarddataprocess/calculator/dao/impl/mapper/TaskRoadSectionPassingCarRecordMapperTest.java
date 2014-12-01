package com.example.trafficcarddataprocess.calculator.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.example.trafficcarddataprocess.calculator.App;
import com.example.trafficcarddataprocess.calculator.domain.TaskRoadSectionPassingCarRecord;
import com.google.common.collect.Maps;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class TaskRoadSectionPassingCarRecordMapperTest {
	
	@Autowired
	private TaskRoadSectionPassingCarRecordMapper mapper;

	@Test
	public void testSelectByTaskId() {
		final Long taskId = 39L;
		List<TaskRoadSectionPassingCarRecord> result = mapper.selectByTaskId(taskId);
		System.out.println("testSelectByTaskId(): " + result.size());
	}
	
	@Test
	public void testSelectByTaskIdAndRoadSectionId() {
		final Long taskId = 39L;
		final Long roadSectionId = 42595700560L;
		Map<String, String> map = Maps.newHashMap();
		map.put(TaskRoadSectionPassingCarRecordMapper.TASK_ID, taskId.toString());
		map.put(TaskRoadSectionPassingCarRecordMapper.ROAD_SECTION_ID,
				roadSectionId.toString());
		List<TaskRoadSectionPassingCarRecord> result = mapper
				.selectByTaskIdAndRoadSectionId(map);
		for (TaskRoadSectionPassingCarRecord e : result) {
			String json = JSONObject.toJSONString(e);
			System.out.println(json);
		}
		System.out.println("testSelectByTaskIdAndRoadSectionId(): " + result.size());
	}

}
