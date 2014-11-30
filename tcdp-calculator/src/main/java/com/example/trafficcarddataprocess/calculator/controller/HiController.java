package com.example.trafficcarddataprocess.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	
	private static final Logger logger = LoggerFactory.getLogger(HiController.class);
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String hi() {
		logger.debug("oops");
		return "{\"msg\":\"hello, world\"}";
	}
	
}
