package com.example.trafficcarddataprocess.calculator.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.trafficcarddataprocess.calculator.domain.Result;
import com.example.trafficcarddataprocess.calculator.domain.RoadSection;
import com.example.trafficcarddataprocess.calculator.domain.Task;
import com.example.trafficcarddataprocess.calculator.service.CalculateService;
import com.example.trafficcarddataprocess.calculator.service.RoadSectionService;
import com.example.trafficcarddataprocess.calculator.service.TaskService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
public class CalculationController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);
	
	private static final String BASE_ROUTE = RouteDefine.UI + "/calculations";
	
	@Autowired
	private RoadSectionService roadSectionService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private CalculateService calculateService;
	
	@RequestMapping(value=BASE_ROUTE, method=RequestMethod.POST)
    public ModelAndView echo(@RequestParam("taskId") String taskIdParam, @RequestParam("roadSectionId") String roadSectionIdParam) {  
		logger.debug("task id: " + taskIdParam);
		logger.debug("road section id: " + roadSectionIdParam);
		List<Result> list = Lists.newArrayList();
		Map<String, Object> model = Maps.newHashMap();
		model.put("results", list);
        ModelAndView mav = new ModelAndView("calculation_result", model);  
        //
        if (taskIdParam == null || taskIdParam.trim().isEmpty()) {
        	return mav;
        }
        //
        if (roadSectionIdParam == null || roadSectionIdParam.trim().isEmpty()) {
    		Task task = taskService.findTask(Long.parseLong(taskIdParam));
    		if (task == null) {
    			return mav; 
    		}
    		List<Result> results = calculateService.calculate(task);
    		list.clear();
    		list.addAll(results);
    		return mav; 
        }
        //
        taskIdParam = taskIdParam.trim();
        final Long taskId = Long.parseLong(taskIdParam);
		Task task = taskService.findTask(taskId);
		if (task == null) {
			return mav; 
		}
		roadSectionIdParam = roadSectionIdParam.trim();
		final Long roadSectionId = Long.parseLong(roadSectionIdParam);
		RoadSection roadSection = roadSectionService.findRoadSection(roadSectionId);
		if (roadSection == null) {
			return mav; 
		}
		Result result = calculateService.calculate(task, roadSection);
		list.clear();
		list.add(result);
        return mav;  
    }
	
	@RequestMapping(value="/calculations/tasks/{taskId}/roads/{roadSectionId}", method=RequestMethod.GET)
    public ModelAndView get(@PathVariable("taskId") String taskIdParam, @PathVariable("roadSectionId") String roadSectionIdParam) {  
		logger.debug("task id: " + taskIdParam);
		logger.debug("road id: " + roadSectionIdParam);
		List<Result> list = Lists.newArrayList();
		for (int i = 1; i < 11; ++i) {
			Result e = new Result();
			long id = i;
			long taskId = i;
			long roadSectionId = i;
			double speed = i;
			double speedConfi = i;
			long flow = i;
			double flowConfi = i;
			e.setId(id);
			e.setTaskId(taskId);
			e.setRoadSectionId(roadSectionId);
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
