package org.rimi.marksystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.UserService;
import org.rimi.marksystem.util.CommonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			String roleName = CommonMap .roleNameMap.get(user.getRoleId());
			String functionName = CommonMap.roleFunctionMap.get(user.getRoleId());
			request.getSession().setAttribute("functions", functionName);
			request.getSession().setAttribute("roleName", roleName);
			return "redirect:/index";
		}
	}
	

	@RequestMapping(value="/user")
	public String getUser(Model model){	
		List<User> userlist = new ArrayList<User>();
		userlist = userServiceImpl.getAllUser();
		return "user";
	}
	
	

	@RequestMapping("/signOut")
	public String signOut(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "redirect:/loginPage";
	}
}
