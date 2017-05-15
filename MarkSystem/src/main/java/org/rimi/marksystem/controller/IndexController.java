package org.rimi.marksystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.rimi.marksystem.eneity.TeacherResults;
import org.rimi.marksystem.eneity.TeamAndUser;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.CountService;
import org.rimi.marksystem.service.MarkService;
import org.rimi.marksystem.service.TeamService;
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
	@Autowired
	private MarkService markServiceImpl;
	@Autowired
	private TeamService teamServiceImpl;
	private final int TeacherChartLength = 6;
	
	@RequestMapping("/index")
	public String index(User user, Model model, HttpServletRequest request) {

		user = (User) request.getSession().getAttribute("user");
		if (user.getRoleId() == 1) {
            // index-admin顶部卡片统计数据，已注册学生、本月注册学生、已注册老师、已经注册班级
            int studentsSum = userServiceImpl.getUsersSumByRoleId(3);
            int studentsMonthlySum = userServiceImpl.getMonthlyUsersSumByBuildTime(3);
            int teachersSum = userServiceImpl.getUsersSumByRoleId(2);
            int calssesSum = teamServiceImpl.getTeam();

            model.addAttribute("studentsSum", studentsSum);
            model.addAttribute("studentsMonthlySum", studentsMonthlySum);
            model.addAttribute("teachersSum", teachersSum);
            model.addAttribute("calssesSum", calssesSum);

            
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
            int thismonth=c.get(Calendar.MONTH)+1;

            model.addAttribute("thisyear", thisyear);
            model.addAttribute("Xaxis",countServiceImpl.getNewXaxis(thismonth));//获得登录年份时间的横坐标
            
            model.addAttribute("Yaxis", countServiceImpl.getLastYaxis(thisyear));//获得登录年份时间的纵坐标
            model.addAttribute("oldYaxis", countServiceImpl.getLastYaxis(thisyear-1));//获得前一年的纵坐标
            
            
            
            List<TeamAndUser> tulist = countServiceImpl.getTeamAndUser();
            model.addAttribute("tulist", tulist);
            List<TeacherResults> teacherResultslist = new ArrayList<TeacherResults>(); 
           
           List<User> uslist = userServiceImpl.getUsersByRoleId(2);
            
            for(int i=0;i<uslist.size();i++){          	
            	TeacherResults tr = countServiceImpl.getTeachersResults(uslist.get(i).getId());
            	int count=0;
            	for(int j=0;j<tr.getContentmap().size();j++){
            		count +=tr.getContentmap().get(tr.getxEndTime().get(j)).size();
            	}
            	tr.setCount(count);
            	teacherResultslist.add(tr);          	
            }
            model.addAttribute("teacherlist", teacherResultslist);           
            return "index-admin";
		} else if (user.getRoleId() == 2) {
            TeacherResults tr = countServiceImpl.getTeachersResults(user.getId());
            List<String> x = tr.getxEndTime();
            List<Float> avrage = tr.getAveragelist();
            List<Float> recent = tr.getRecentlist();
            if(x.size()>TeacherChartLength){
            	x = x.subList(x.size()-TeacherChartLength, x.size());
            	avrage=avrage.subList(avrage.size()-TeacherChartLength, avrage.size());
            	recent =recent.subList(recent.size()-TeacherChartLength, recent.size());
            	tr.setxEndTime(x);
            	tr.setAveragelist(avrage);
            	tr.setRecentlist(recent);
            }
            model.addAttribute("TeacherResults", tr);

			return "index-teacher";
		} else if (user.getRoleId() == 3) {
			
			int user_id = user.getId();
			List<Integer> integers = markServiceImpl.getTeamId(user.getId());
			List<RequestMarkTableQuiz> rmtqs = markServiceImpl.getTableInfo(integers);
			
			for (RequestMarkTableQuiz requestMarkTableQuiz : rmtqs) {
				List<Integer> count = markServiceImpl.getInfo(user_id, requestMarkTableQuiz.getMarktableId());
				if(count.size() == 0){
					requestMarkTableQuiz.setMarked(true);//没有被评价
				}else{
					requestMarkTableQuiz.setMarked(false);//已被评价
				}
			}
			model.addAttribute("rmtqs", rmtqs);		
			return "index-student";
		} else {
			return "index";
		}

	}
	@RequestMapping("/profile")
	public String profileView() {

		return "profile";
	}
	@RequestMapping("/404")
	public String test404() {

		return "404Error";
	}

	@RequestMapping("/forgetpassword")
	public String forgetpw(){
		return "forgetpassword";
	}
	
}
