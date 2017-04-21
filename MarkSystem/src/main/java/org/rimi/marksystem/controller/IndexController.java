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
	public String index(User user, Model model, HttpServletRequest request) {

		user = (User) request.getSession().getAttribute("user");
		if (user.getRoleId() == 1) {
			return "index-admin";
		} else if (user.getRoleId() == 2) {
			return "index-teacher";
		} else if (user.getRoleId() == 3) {
			return "index-student";
		} else {
			return "index";
		}

	}
	@RequestMapping("/profile")
	public String profileView() {

		return "profile";
	}

}
