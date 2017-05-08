package org.rimi.marksystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.TeacherResults;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserRseultTable;
import org.rimi.marksystem.service.CountService;
import org.rimi.marksystem.service.MarkService;
import org.rimi.marksystem.service.ResultScoreService;
import org.rimi.marksystem.service.TeamService;
import org.rimi.marksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResultScoreController {
	
	@Autowired
	private CountService countServiceImpl;
	@Autowired
	private ResultScoreService resultScoreServiceImpl;
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private MarkService markServiceImpl;
	@Autowired
	private TeamService teamServiceImpl;
	
	private static final int TeacherChartLength=6;				//图表显示宽度
	
	
	@RequestMapping("/resultscore")
	public String resultScoreView(Model model,@RequestParam(value="teacherId",required=false)Integer teacherId){
		if(teacherId==null || teacherId == 0){
			User tempUser = resultScoreServiceImpl.getEndEvalutedTeacherId();
			if(tempUser!=null){
				teacherId=tempUser.getId();			
			}else{
				model.addAttribute("msg", "暂无数据");
				return "resultScore";
			}
		}
		if(teacherId<0){
			model.addAttribute("msg", "请输入正确的老师");
			return "resultScore";
		}
		List<User> userlist = userServiceImpl.getUsersByRoleId(2);
		boolean isTeacher = true;
		for(int i=0;i<userlist.size();i++){
			if(userlist.get(i).getId() == teacherId){
				isTeacher=false;
			}
		}
		if(isTeacher){
			model.addAttribute("msg", "请输入正确的老师");
			return "resultScore";
		}
        TeacherResults tr = countServiceImpl.getTeachersResults(teacherId);
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
        model.addAttribute("teacherlist", userlist);

		return "resultScore";
	}
	
	@RequestMapping("/getMarkTable")
	@ResponseBody
	public List<MarkTable> getTeacherAllResult(Model model,@RequestParam("teacherId") int teacherId){
		List<MarkTable> mtlist = resultScoreServiceImpl.getMarkTableByEvalutedId(teacherId);
		if(mtlist==null){
			model.addAttribute("msg", "没有该数据");
		}
		return mtlist;
	}
	
	@RequestMapping("/getMarkTeam")
	@ResponseBody
	public List<Team> getMarkTeam(Model model,@RequestParam("markNameId") int markNameId,@RequestParam("teacherId") int teacherId){	
		List<Team> teamlist = new ArrayList<Team>();
		teamlist = resultScoreServiceImpl.getTeamByMarkTableId(markNameId,teacherId);
		if(teamlist==null){
			model.addAttribute("msg", "没有该数据");
		}
		return teamlist;
	}
	
	@RequestMapping("/getTeamStudent")
	@ResponseBody
	public List<User> getTeamStudent(Model model,@RequestParam("markNameId") int markNameId,@RequestParam("teacherId") int teacherId,@RequestParam("teamId") int teamId){	
		List<User> userlist = new ArrayList<User>();
		userlist = resultScoreServiceImpl.getEvalutionStudentByTeam(markNameId,teacherId,teamId);
		if(userlist==null){
			model.addAttribute("msg", "没有该数据");
		}
		return userlist;
	}
	
	
	@RequestMapping("/getMarkResult")
	@ResponseBody
	public List<UserRseultTable> getMarkResultByUser(Model model,@RequestParam("markNameId") int markNameId,@RequestParam("teacherId") int teacherId,@RequestParam("teamId") int teamId,@RequestParam("evalutionId") int evalutionId){
		List<UserRseultTable> urtlist = resultScoreServiceImpl.getMarkResult(teacherId,markNameId,teamId,evalutionId);
		User user = userServiceImpl.getUserById(evalutionId);
		for (UserRseultTable userRseultTable : urtlist) {
			userRseultTable.setUser(user);
		}
		return urtlist;
	}
	
}
