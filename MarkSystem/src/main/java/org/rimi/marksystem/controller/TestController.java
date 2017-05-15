package org.rimi.marksystem.controller;

import org.rimi.marksystem.util.LoggingAspect;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("*")
	public String noFound(){
		
		return "404Error";
	}
}
