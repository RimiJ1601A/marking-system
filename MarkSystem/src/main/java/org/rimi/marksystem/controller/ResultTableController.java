package org.rimi.marksystem.controller;

import org.rimi.marksystem.service.ResultTableService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ResultTableController {

	
	private ResultTableService resultTableService;
	
	@RequestMapping("/result")
	public String resultTableView(Model model ){
		
		return "result";
	}
	
	
}
