package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;

@Component
public interface TeamDao {

	//查询
	public List<Team> selectAllTeam();
	//分页查询
	public List<Team> selectTeam(int start,int count);
	//根据班级名称搜索
	public List<Team> selectTeam(int start,int count,String name);
	//获得班级名称
	public List<String> selectTeamName();
	//查询总数
	public int selectTeam();
	public int selectTeam(String name);
	//增加班级
	public void insertTeam(Team team);
	//修改班级
	public void updateTeam();
	//删除班级
	public void deleteTeam(int id);
	//添加班级学生和教师
	public void insertTeam(int userId,int roleId,int teamId );
	//删除本班学生或老师
	public void deleteTeam(int userId,int roleId,int teamId );
	
	//通过班级ID和roleID得到userID
	public List<User> selectUserId(int teamId,int roleId);
	
	public Team getTeamByiId(int id);
}
