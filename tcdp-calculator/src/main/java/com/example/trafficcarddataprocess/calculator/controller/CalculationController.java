package com.example.trafficcarddataprocess.calculator.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
public class CalculationController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);
	
	@RequestMapping(value="/calculation", method=RequestMethod.POST)
    public ModelAndView echo(@RequestParam("taskId") String taskIdParam, @RequestParam("roadId") String roadIdParam) {  
		logger.debug("task id: " + taskIdParam);
		logger.debug("road id: " + roadIdParam);
		List<Result> list = Lists.newArrayList();
		for (int i = 1; i < 11; ++i) {
			Result e = new Result();
			long id = i;
			long taskId = i;
			long roadId = i;
			double speed = i;
			double speedConfi = i;
			int flow = i;
			double flowConfi = i;
			e.setId(id);
			e.setTaskId(taskId);
			e.setRoadId(roadId);
			e.setAverageSpeed(speed);
			e.setAverageSpeedConfidence(speedConfi);
			e.setTrafficFlow(flow);
			e.setTrafficFlowConfidence(flowConfi);
			list.add(e);
		}
		Map<String, Object> model = Maps.newHashMap();
		model.put("results", list);
        ModelAndView mav = new ModelAndView("calculation_result", model);  
        return mav;  
    }

}
