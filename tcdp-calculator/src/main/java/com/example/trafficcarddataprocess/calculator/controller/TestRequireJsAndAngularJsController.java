package com.example.trafficcarddataprocess.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestRequireJsAndAngularJsController {
	
	@RequestMapping("/test")
    public ModelAndView home() {  
        ModelAndView mav = new ModelAndView();  
        mav.setViewName("test");  
        return mav;  
    }

}
