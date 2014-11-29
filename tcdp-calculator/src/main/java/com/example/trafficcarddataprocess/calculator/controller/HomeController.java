package com.example.trafficcarddataprocess.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public ModelAndView home() {  
        ModelAndView mav = new ModelAndView();  
        mav.setViewName("home");  
        return mav;  
    }

}
