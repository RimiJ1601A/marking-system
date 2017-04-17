package org.rimi.marksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@RequestMapping("/role2")
	public String test1(){
		return "role2";
	}
}
