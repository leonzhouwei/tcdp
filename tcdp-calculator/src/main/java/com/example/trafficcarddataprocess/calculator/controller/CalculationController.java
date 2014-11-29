package com.example.trafficcarddataprocess.calculator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculationController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);
	
	@RequestMapping(value="/calculation", method=RequestMethod.POST)
    public ModelAndView echo(@RequestParam("taskId") String taskId, @RequestParam("roadId") String roadId) {  
		logger.debug("task id: " + taskId);
		logger.debug("road id: " + roadId);
        ModelAndView mav = new ModelAndView();  
        mav.setViewName("calculation_result");  
        return mav;  
    }

}
