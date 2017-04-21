package org.rimi.marksystem.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

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
			if(start>=totalPage){
				start = totalPage-1;
			}
		}
		List<Team> team = teamServiceImpl.getTeam(start*10, 10);
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
		model.addAttribute("next", 1);
		return "team";
	}
	//增加
	@RequestMapping(value="/teamadd",method=RequestMethod.GET)
	public String teamAdd(@RequestParam("teamName")String name,Model model){
		//判断是否存在此班级名称
		boolean exits = false;
		List<String> teamName = teamServiceImpl.getTeamName();
		if(teamName.contains(name)){
			exits = true;
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sj = sdf.format(date);
		Team team = new Team();
		team.setTeamName(name);
		team.setBuildTime(sj);
		if(name == null || name.isEmpty() || exits == true){
			return "redirect:/team";
		}else{
			teamServiceImpl.addTeam(team);
			return "redirect:/team";
		}
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
		int usersRoleId = teamServiceImpl.getUsersRoleId(userAccount);
		//插入学生到班级
		if(usersRoleId == roleId){
			teamServiceImpl.addtTeam(userId, roleId, teamId);
		}
		return "redirect:/team";			
	}
	//删除学生
	@RequestMapping(value="/deletestu",method=RequestMethod.GET)
	public String dropstu(@RequestParam("teamId")int teamId,@RequestParam("userAccount")String userAccount){
		int userId = teamServiceImpl.getUserId(userAccount);
		int usersRoleId = teamServiceImpl.getUsersRoleId(userAccount);
		int roleId = teamServiceImpl.getRoleId("学生");
		if(usersRoleId == roleId){
			teamServiceImpl.dropTeam(userId, roleId, teamId);
		}
		return "redirect:/team";
	}
	//添加教师
	@RequestMapping(value="/addteacher",method=RequestMethod.GET)
	public String addteacher(@RequestParam("teamId")int teamId,@RequestParam("userAccount")String userAccount){
		int userId = teamServiceImpl.getUserId(userAccount);
		int roleId = teamServiceImpl.getRoleId("教师");
		int usersRoleId = teamServiceImpl.getUsersRoleId(userAccount);
		//插入教师到班级
		if(usersRoleId == roleId){
			teamServiceImpl.addtTeam(userId, roleId, teamId);			
		}
		return "redirect:/team";
	}
	//删除教师
	@RequestMapping(value="/deleteteacher",method=RequestMethod.GET)
	public String dropteacher(@RequestParam("teamId")int teamId,@RequestParam("userAccount")String userAccount){
		int userId = teamServiceImpl.getUserId(userAccount);
		int roleId = teamServiceImpl.getRoleId("教师");
		int usersRoleId = teamServiceImpl.getUsersRoleId(userAccount);
		if(usersRoleId == roleId){
			teamServiceImpl.dropTeam(userId, roleId, teamId);
		}
		return "redirect:/team";
	}
	//导出Excel表
			@RequestMapping(value="team_export",method = RequestMethod.GET)
			public String export(@RequestParam(value="name",required=false)String name,@RequestParam(value="path",required=false)String path,Model model) throws IOException, WriteException{
				if(name == null || name.isEmpty()){
					name="team.xsl";
				}
				if(path == null || path.isEmpty()){
					path = "C:/";
				}
				OutputStream os = new FileOutputStream(path+name);
				//创建工作薄
		        WritableWorkbook workbook = Workbook.createWorkbook(os);
		        //创建新的一页
		        WritableSheet sheet = workbook.createSheet("班级表",0);
		        List<Team> team = teamServiceImpl.getAllTeam();
		        int size = team.size();
		        Label bjmc = new Label(0,0,"班级名称");
		        sheet.addCell(bjmc);
		        Label xsrs = new Label(1,0,"学生人数");
		        sheet.addCell(xsrs);
		        Label xsxm = new Label(2,0,"学生姓名");
		        sheet.addCell(xsxm);
		        Label jsxm = new Label(3,0,"教师姓名");
		        sheet.addCell(jsxm);
		        Label cjrq = new Label(4,0,"创建日期");
		        sheet.addCell(cjrq);
		        for(int i=1;i<=size;i++){
		        	Label a = new Label(0,i,team.get(i-1).getTeamName());
		        	sheet.addCell(a);
		        	Label b = new Label(1,i,team.get(i-1).getStudentCount()+"");
		        	sheet.addCell(b);
		        	Label c = new Label(2,i,team.get(i-1).getStudents().toString());
		        	sheet.addCell(c);
		        	Label d = new Label(3,i,team.get(i-1).getTeacherName().toString());
		        	sheet.addCell(d);
		        	Label f = new Label(4,i,team.get(i-1).getBuildTime());
		        	sheet.addCell(f);
		        }
		        workbook.write();
		        workbook.close();
		        os.close();
			return "redirect:/team";
		}
}
