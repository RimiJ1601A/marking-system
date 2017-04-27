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
            // index-admin顶部卡片统计数据，在校学生、本月新增学生、在校老师
            int studentsSum = userServiceImpl.getUsersSumByRoleId(3);
            int studentsMonthlySum = userServiceImpl.getMonthlyUsersSumByBuildTime(3);
            int teachersSum = userServiceImpl.getUsersSumByRoleId(2);
            model.addAttribute("studentsSum", studentsSum);
            model.addAttribute("studentsMonthlySum", studentsMonthlySum);
            model.addAttribute("teachersSum", teachersSum);
            
            // 获取登录系统时间
            long currentLoginTime = System.currentTimeMillis();
            Date logindate = new Date(currentLoginTime);
            
            // 显示统计图表的展示时间
            
            SimpleDateFormat formatter = new SimpleDateFormat("MMM dd,YYYY");// 统一格式
            String nowdate = formatter.format(logindate);// 显示的最终时间
            String startdate = formatter.format(countServiceImpl.countBegintime());// 统计的开始时间
            model.addAttribute("startdate", startdate);
            model.addAttribute("nowdate", nowdate);
            
            
            
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
