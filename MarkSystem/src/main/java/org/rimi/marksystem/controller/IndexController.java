package org.rimi.marksystem.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.RoleService;
import org.rimi.marksystem.util.CommonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 个人主页
 */

@Controller
public class IndexController {
	
	
	@RequestMapping("/index")
	public String index(User user,Model model,HttpServletRequest request){
		//写判断权限生成功能逻辑
		User tempuser = new User();
		tempuser = (User)request.getSession().getAttribute("user");
		String roleName = CommonMap .roleNameMap.get(tempuser.getRoleId());
		String functionName = CommonMap.roleFunctionMap.get(tempuser.getRoleId());
		request.getSession().setAttribute("functions", functionName);
		request.getSession().setAttribute("roleName", roleName);
		return "index";
	}
	
}
