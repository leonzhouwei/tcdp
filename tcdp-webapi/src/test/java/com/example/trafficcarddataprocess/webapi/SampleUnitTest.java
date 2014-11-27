package com.example.trafficcarddataprocess.webapi;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class SampleUnitTest {
	
	@Test
	public void nothing() {
	}
	
	public static <T> void println(Collection<T> collection) {
		for (T e : collection) {
			System.out.println(JSONObject.toJSONString(e));
		}
	}

}
