package org.rimi.marksystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.QuizContent;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
 	
	@RequestMapping(value="/user")
	public String getUser(){
		List<User> userlist = new ArrayList<User>();
		userlist = userServiceImpl.getAllUser();
		return "user";
	}
	
	@RequestMapping("/index")
	public String login(){
		return "index";
	}
	@RequestMapping("/requestQuiz")
	@ResponseBody
	public void requestQuiz(@RequestBody List<Quiz> quizs){
		
/*		System.out.println(quizs.size());*/
		System.out.println("_______________");
	}
}
