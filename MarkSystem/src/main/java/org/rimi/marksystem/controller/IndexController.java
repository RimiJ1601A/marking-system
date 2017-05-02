package org.rimi.marksystem.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.rimi.marksystem.eneity.TeacherResults;
import org.rimi.marksystem.eneity.TeamAndUser;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.CountService;
import org.rimi.marksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 个人主页
 */

@Controller
public class IndexController {
	
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private CountService countServiceImpl;
	
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
            
            //显示统计图的具体数据
            Calendar c = Calendar.getInstance();
            c.setTime(logindate);
            int thisyear=c.get(Calendar.YEAR);
            
            model.addAttribute("thisyear", thisyear);
            model.addAttribute("Xaxis",countServiceImpl.getXaxis(thisyear));//获得登录年份时间的横坐标
            model.addAttribute("Yaxis", countServiceImpl.getYaxis(thisyear));//获得登录年份时间的纵坐标
            model.addAttribute("oldYaxis", countServiceImpl.getLastYaxis(thisyear-1));//获得前一年的纵坐标
            
            
            
            List<TeamAndUser> tulist = countServiceImpl.getTeamAndUser();
            model.addAttribute("tulist", tulist);
            List<TeacherResults> teacherResultslist = new ArrayList<TeacherResults>(); 
           
           // List<User> uslist =    获取最近的3个被评分的不同的教师
            
            for(int i=0;i<tulist.size();i++){          	
            	TeacherResults tr = countServiceImpl.getTeachersResults(tulist.get(i).getEvaluatedUser().getId());
            	int count=0;
            	for(int j=0;j<tr.getContentmap().size();j++){
            		count +=tr.getContentmap().get(tr.getxEndTime().get(j)).size();
            	}
            	tr.setCount(count);
            	teacherResultslist.add(tr);          	
            }
            model.addAttribute("teacherlist", teacherResultslist);
            System.out.println(teacherResultslist.size());
            
            return "index-admin";
		} else if (user.getRoleId() == 2) {
            List<TeamAndUser> tulist = countServiceImpl.getTeamAndUser();
            model.addAttribute("tulist", tulist);
            List<TeacherResults> teacherResultslist = new ArrayList<TeacherResults>(); 
            for(int i=0;i<tulist.size();i++){          	
            	TeacherResults tr = countServiceImpl.getTeachersResults(tulist.get(i).getEvaluatedUser().getId());
            	teacherResultslist.add(tr);          	
            }
            model.addAttribute("teacherlist", teacherResultslist);
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
