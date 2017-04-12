package org.rimi.marksystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	
	
	@RequestMapping("/index")
	public String index(User user,Model model,HttpServletRequest request){
		//写判断权限生成功能逻辑
		User tempuser = new User();
		tempuser = (User)request.getSession().getAttribute("user");
		
		
		
		return "index";
	}
	
}
