package org.rimi.marksystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarkController {
	@Autowired
	private MarkService markServiceImpl;

	
	@RequestMapping("/mark")
	public String markView(Model model,HttpServletRequest request){
		
		//id->teamid
		User user = (User)request.getSession().getAttribute("user");
		List<Integer> integers = markServiceImpl.getTeamId(user.getId());
		List<RequestMarkTableQuiz> rmtqs = markServiceImpl.getTableInfo(integers);
		model.addAttribute("Listrmtq",rmtqs);
		return "mark";
	}
	
	@RequestMapping("/stuGetQuiz")
	@ResponseBody
	public List<Quiz> getQuizs(HttpServletRequest request){
		String mtid = request.getParameter("markTableId");
//		System.out.println(mtid);
		Integer markTable_id = null;
		try {
			markTable_id = Integer.valueOf(mtid);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<Integer> markTable_ids = markServiceImpl.getQuizId(markTable_id);
		List<Quiz> quizs = markServiceImpl.getQuizs(markTable_ids);
		return quizs;
	}
}
