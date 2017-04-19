package org.rimi.marksystem.controller;

import org.rimi.marksystem.exception.BusinessException;
import org.rimi.marksystem.util.LoggingAspect;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	
	@RequestMapping("/test")
	public String test(){	
		try {
			int[] a = new int[10];
			a[11]=89;
			
		} catch (Exception e) {
			// TODO: handle exception

			throw new BusinessException("30");
		};
		return "test2";
	}
	
	@RequestMapping("/role2")
	public String test1(){
		int[] a = new int[10];
		a[11]=89;
		return "role2";
	}
	
	@RequestMapping("*")
	public String noFound(){
		
		return "noFound";
	}
}
