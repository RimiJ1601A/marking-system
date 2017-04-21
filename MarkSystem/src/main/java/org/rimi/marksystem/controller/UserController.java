package org.rimi.marksystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.UserService;
import org.rimi.marksystem.util.CommonMap;
import org.rimi.marksystem.util.Sex;
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
	private final int account = 10; // 每页显示的数据

	// 登陆页面
	@RequestMapping("/loginPage")
	public String loginPage(Model model) {
		return "login";
	}

	// 登陆判断逻辑
	@RequestMapping("/login")
	public String login(@RequestParam("userAccount") String userAccount, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		User user = new User();
		user = userServiceImpl.getUserByUserAccountAndPassword(userAccount, password);
		if (user == null) {
			model.addAttribute("error", "用户名密码错误");
			return "login";
		} else {
			request.getSession().setAttribute("user", user);
			String roleName = CommonMap.roleNameMap.get(user.getRoleId());
			String functionName = CommonMap.roleFunctionMap.get(user.getRoleId());
			request.getSession().setAttribute("functions", functionName);
			request.getSession().setAttribute("roleName", roleName);
			return "redirect:/index";
		}
	}

	@RequestMapping(value = "/user")
	public String getUser(Model model, HttpServletRequest request) {
		String obj = request.getParameter("page");
		List<String> userAllnum = userServiceImpl.getAllUserAccount();
		model.addAttribute("userAllnum", userAllnum.size());
		int page = 0;
		if (obj != null) {
			try {
				page = Integer.valueOf(obj) - 1;				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		page = page * 10;
		if((page+account) > userAllnum.size()){
			page = 0;
		}
		List<User> userlist = new ArrayList<User>();
		userlist = userServiceImpl.getUsersByPage(page, account);
		model.addAttribute("userlist", userlist);
		return "user";
	}

	@RequestMapping("/signOut")
	public String signOut(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:/loginPage";
	}

	@RequestMapping("/changePassword")
	public String changePassword(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		String msg = "";
		boolean isTrue = userServiceImpl.checkPassWordIsTrue(user.getUserAccount(), oldPassword);
		if (isTrue == false) {
			msg = "密码错误";
			model.addAttribute("msg", msg);
			return "redirect:/index";
		} else {
			msg = "修改成功";
			model.addAttribute("msg", msg);
			userServiceImpl.updatePassword(user.getUserAccount(), newPassword);
			return "redirect:/index";
		}
	}

	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam("userName") String userName, @RequestParam("age") String age,
			@RequestParam("sex") String sex,HttpServletRequest request, Model model) {
		String msg = "";
		User user = (User)request.getSession().getAttribute("user");
		User updaUser = new User();
		updaUser.setUserName(userName);
		updaUser.setSex(Sex.getSexByValue(Integer.valueOf(sex)));
		int userAge = 0;
		try {
			userAge = Integer.valueOf(age);
		} catch (Exception e) {
			// TODO: handle exception
			msg="请输入正确的年龄";
			model.addAttribute("msg",msg);
			return "redirect:/profile";
		}		
		updaUser.setAge(Integer.valueOf(userAge));
		userServiceImpl.updateUser(user.getUserAccount(), updaUser);
		user.setUserName(userName);
		user.setAge(userAge);
		user.setSex(Sex.getSexByValue(Integer.valueOf(sex)));
		msg="修改成功";
		model.addAttribute("msg",msg);
		return "redirect:/profile";
	}

	@RequestMapping("/updatePassword")
	public String updatePassword(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {

		userServiceImpl.updatePassword(account, password);

		return "reirect:/index";
	}

	@RequestMapping("/updateUserRole")
	public String updateUserRole(@RequestParam("role_id") int role_id, @RequestParam("account") String account,
			HttpServletRequest request, Model model) {

		userServiceImpl.updateUserRole(account, role_id);

		return "reirect:/index";
	}

	@RequestMapping("/insertUser")
	public String insertUser(User user) {

		userServiceImpl.insertUser(user);

		return "reirect:/index";
	}

	@RequestMapping("/resetPassword")
	public String resetPassword(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {

		userServiceImpl.resetPassword(account, password);

		return "reirect:/index";
	}

}
