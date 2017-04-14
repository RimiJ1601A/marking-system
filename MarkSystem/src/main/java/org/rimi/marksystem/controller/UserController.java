package org.rimi.marksystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.UserService;
import org.rimi.marksystem.util.CommonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
 	
	//登陆页面
	@RequestMapping("/loginPage")
	public String loginPage(Model model){
		return "login";
	}
	//登陆判断逻辑
	@RequestMapping("/login")
	public String login(@RequestParam("userAccount") String userAccount,@RequestParam("password") String password,Model model,HttpServletRequest request){
		User user = new User();
		user = userServiceImpl.getUserByUserAccountAndPassword(userAccount, password);
		if(user == null){
			model.addAttribute("error","用户名密码错误");
			return "login";
		}else{
			request.getSession().setAttribute("user", user);
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/user")
	public String getUser(Model model){
	
		List<User> userlist = new ArrayList<User>();
		userlist = userServiceImpl.getAllUser();
		return "user";
	}

//	@RequestMapping("/requestQuiz")
//	@ResponseBody
//	public void requestQuiz(@RequestBody List<Quiz> quizs){
//		
//		System.out.println(quizs.size());
//		System.out.println("_______________");
//	}
	
	
	
	@RequestMapping(value="photo")
	public String headPhoto(){
		return "headphoto";
	}
	
}
