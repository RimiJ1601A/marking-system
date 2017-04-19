package org.rimi.marksystem.controller;

import java.util.List;

import org.rimi.marksystem.service.MarkeTableService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MarkTableController {
	
	
	private MarkeTableService markTableServiceImpl;
	
	@RequestMapping("/markTable")
	public String markeTableView(){
		
		return "markTable";
	}
	
	
}
