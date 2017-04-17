package org.rimi.marksystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.TeamService;
import org.rimi.marksystem.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamServiceImpl;
	
	@RequestMapping("/team")
	public String goTeam(@RequestParam(value="dangqianye",required=false)String pageNum,Model model){
		int totalPage;//总页数
		int start;
		int total = teamServiceImpl.getTeam();
		model.addAttribute("total", total);
		totalPage = (total+10-1)/10;
		//分页查询
		if(pageNum == null || pageNum.isEmpty()){
			start = 0;
		}else{
			start = Integer.parseInt(pageNum)-1;
			if(start<0){
				start =0;
			}
			if(start>totalPage){
				start = totalPage-1;
			}
		}
		List<Team> team = teamServiceImpl.getTeam(start, 10);
		model.addAttribute("team", team);
		model.addAttribute("dangqianye", start+1);
		model.addAttribute("next", totalPage);
		return "team";
	}
	
	//搜索
	@RequestMapping(value="/teamselect",method=RequestMethod.GET)
	public String selectTeam(@RequestParam(value="selectName",required=false)String name,Model model){
		
		List<Team> team = teamServiceImpl.getTeam(0,10,name);
		model.addAttribute("team", team);
		model.addAttribute("total", team.size());
		model.addAttribute("dangqianye", 1);
		model.addAttribute("next", 2);
		return "team";
	}
	//增加
	@RequestMapping(value="/teamadd",method=RequestMethod.GET)
	public String teamAdd(@RequestParam("teamName")String name,Model model){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sj = sdf.format(date);
		Team team = new Team();
		team.setTeamName(name);
		team.setBuildTime(sj);
		if(name == null || name.isEmpty()){
			return "redirect:/team";
		}else{
			teamServiceImpl.addTeam(team);
		}
		return "redirect:/team";
	}
	//修改
	@RequestMapping(value="/team_modify",method=RequestMethod.GET)
	public String modifyTeam(){
		
		return "redirect:/team";
	}
	//删除
	@RequestMapping(value="/teamdelete")
	public String teamDelete(@RequestParam("teamId")int id){
		teamServiceImpl.dropTeam(id);
		return "redirect:/team";
	}
	//批量添加学生到班级
	@RequestMapping(value="/adddefaultstudent",method=RequestMethod.GET)
	public String addStudentDefault(@RequestParam("teamId")int teamId,@RequestParam("studentPref")String studentPref,@RequestParam("studentCount")String studentCount,Model model){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sj = sdf.format(date);
		int roleId = teamServiceImpl.getRoleId("学生");
		int Count = Integer.parseInt(studentCount);
		String userAccount; 
		for(int i = 1;i<=Count;i++){
			if(i<10){
				userAccount = studentPref +"00"+ i;
			}
			else if(i>10 && i<100){
				userAccount = studentPref +"0"+ i;
			}else{
				userAccount = studentPref + i;
			}
			User user = new User();
			user.setUserAccount(userAccount);
			user.setAge(20);
			user.setPassword("123456");
			user.setUserName("张三");
			user.setRoleId(roleId);
			user.setBulidTime(sj);
			user.setSex(Sex.MAN);
			//添加新学生
			teamServiceImpl.addUser(user);
			//获得学生userID
			int userId = teamServiceImpl.getUserId(userAccount);
			//插入学生到班级
			teamServiceImpl.addtTeam(userId, roleId, teamId);
		}
		return "redirect:/team";
	}
	//添加学生
	@RequestMapping(value="/addstu",method=RequestMethod.GET)
	public String addstu(@RequestParam("teamId")int teamId,@RequestParam("userAccount")String userAccount){
		int userId = teamServiceImpl.getUserId(userAccount);
		int roleId = teamServiceImpl.getRoleId("学生");
		//插入学生到班级
		teamServiceImpl.addtTeam(userId, roleId, teamId);
		return "redirect:/team";
	}
	//删除学生
	@RequestMapping(value="/deletestu",method=RequestMethod.GET)
	public String dropstu(@RequestParam("teamId")int teamId,@RequestParam("userAccount")String userAccount){
		int userId = teamServiceImpl.getUserId(userAccount);
		int roleId = teamServiceImpl.getRoleId("学生");
		teamServiceImpl.dropTeam(userId, roleId, teamId);
		return "redirect:/team";
	}
	//添加教师
	@RequestMapping(value="/addteacher",method=RequestMethod.GET)
	public String addteacher(@RequestParam("teamId")int teamId,@RequestParam("userAccount")String userAccount){
		int userId = teamServiceImpl.getUserId(userAccount);
		int roleId = teamServiceImpl.getRoleId("教师");
		//插入教师到班级
		teamServiceImpl.addtTeam(userId, roleId, teamId);
		return "redirect:/team";
	}
	//删除教师
	@RequestMapping(value="/deleteteacher",method=RequestMethod.GET)
	public String dropteacher(@RequestParam("teamId")int teamId,@RequestParam("userAccount")String userAccount){
		int userId = teamServiceImpl.getUserId(userAccount);
		int roleId = teamServiceImpl.getRoleId("教师");
		teamServiceImpl.dropTeam(userId, roleId, teamId);
		return "redirect:/team";
	}
}
