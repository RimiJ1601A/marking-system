package org.rimi.marksystem.service;

import java.util.List;

import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserMessage;
import org.rimi.marksystem.util.PageShow;
import org.springframework.stereotype.Component;
@Component
public interface TeamService {

		//查询
		public List<Team> getAllTeam();
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
		/**
		 * 保存team的Excel
		 * @param path 路径
		 * @param name 文件名
		 * @return
		 */
		public void createTeamExcel(String path,String name);
		/**
		 * 获得分页的参数
		 * @param name 查询的名称
		 * @param pageNum 当前页的页码
		 * @return
		 */
		public PageShow getPage(String name,String pageNum);
		
		public void addTeamByName(String name);
		/**
		 * 批量添加学生到班级
		 * @param teamId 班级ID
		 * @param studentPref 学生前缀
		 * @param studentCount 学生数量
		 */
		public void addDefaultStudents(int teamId , String studentPref,String studentCount);
		/**
		 * 添加默认的学生账号到user表
		 * @param userAccount 学生账号
		 * @param roleId 职位ID
		 */
		public void addDefaultUser(String userAccount,int roleId);
		/**
		 * 添加学生或老师进班级
		 * @param userAccount 用户账号
		 * @param roleName 职位名称,输入教师或学生
		 * @param teamId 班级ID
		 */
		public void addStudentsOrTeacher(String userAccount,String roleName ,int teamId);
		/**
		 * 获取账号相关信息
		 * @param userAccount 用户账号
		 * @param roleName 职位名称,输入教师或学生
		 * 
		 * @return 
		 */
		public UserMessage getUserMessage(String userAccount,String roleName);
		/**
		 * 添加学生或老师进班级
		 * @param userAccount 用户账号
		 * @param roleName 职位名称,输入教师或学生
		 * @param teamId 班级ID
		 */
		public void deleteStudentsOrTeacher(String userAccount,String roleName ,int teamId);
}
