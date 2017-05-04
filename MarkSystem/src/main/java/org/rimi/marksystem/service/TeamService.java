package org.rimi.marksystem.service;

import java.util.List;

import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;
@Component
public interface TeamService {

		//查询
		public List<Team> getAllTeam();
		//分页查询
		public List<Team> getTeam(int start,int count);
		//根据班级名称搜索
		public List<Team> getTeam(int start,int count,String name);
		//查询总数
		public int getTeam();
		public int getTeam(String name);
		//增加班级
		public void addTeam(Team team);
		//修改班级
		public void modifyTeam();
		//删除班级
		public void dropTeam(int id);
		//得到班级名称
		public List<String> getTeamName();
		//添加人员
		public void addUser(User user);
		//通过职位名称查roleID
		public int getRoleId(String name);
		//添加班级学生和教师
		public void addtTeam(int userId,int roleId,int teamId );
		//删除本班学生或老师
		public void dropTeam(int userId,int roleId,int teamId );
		//根据账号获得userId
		public int getUserId(String userAccount);
		//通过班级ID得到userID
		public int getUserId(int teamId);
		//通过班级ID和roleID得到userID
		public int getUserId(int teamId,int roleId);
		//根据账号获得roleId
		public int getUsersRoleId(String userAccount);
		//得到用户账号
		public List<String> getUserAccount();
}
