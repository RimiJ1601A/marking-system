package org.rimi.marksystem.serviceImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.dao.TeamDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserMessage;
import org.rimi.marksystem.service.TeamService;
import org.rimi.marksystem.util.MSSheet;
import org.rimi.marksystem.util.PageShow;
import org.rimi.marksystem.util.PathCostant;
import org.rimi.marksystem.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jxl.write.WriteException;

@Component
public class TeamServiceImpl implements TeamService {

	private Logger logger = Logger.getLogger(TeamServiceImpl.class);

	@Autowired
	private TeamDao teamDaoImpl;
	@Autowired
	private UserDao userdaoimp;
	@Autowired
	private RoleDao roledaoimp;

	public List<Team> getAllTeam() {
		// TODO Auto-generated method stub
		return teamDaoImpl.selectAllTeam();
	}

	public void createTeamExcel(String path, String name) {
		if (name == null || name.isEmpty()) {
			name = PathCostant.TEAM_DEFAULT_NAME;
		}
		if (path == null || path.isEmpty()) {
			path = PathCostant.DEFAULT_PATH;
		}

		List<String> titles = new ArrayList<>();
		titles.add("班级名称");
		titles.add("学生人数");
		titles.add("学生姓名");
		titles.add("教师姓名");
		titles.add("创建日期");

		List<String> needProperties = new ArrayList<>();
		needProperties.add("teamName");
		needProperties.add("studentCount");
		needProperties.add("students");
		needProperties.add("teacherName");
		needProperties.add("buildTime");

		try {
			MSSheet msSheet = new MSSheet(titles, this.getAllTeam(), needProperties, path + name, "班级表", 0);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (WriteException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	public List<Team> getTeam(int start, int count, String name) {

		return teamDaoImpl.selectTeam(start, count, name);
	}

	public int getTeam() {
		// TODO Auto-generated method stub
		return teamDaoImpl.selectTeam();
	}

	public void addTeam(Team team) {

		try {
			teamDaoImpl.insertTeam(team);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}

	}

	public void modifyTeam() {
		// TODO Auto-generated method stub
		try {
			teamDaoImpl.updateTeam();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}

	public void dropTeam(int id) {
		// TODO Auto-generated method stub
		try {
			teamDaoImpl.deleteTeam(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}

	public int getRoleId(String name) {
		// TODO Auto-generated method stub
		return roledaoimp.selectRoleId(name);
	}

	public void addtTeam(int userId, int roleId, int teamId) {
		// TODO Auto-generated method stub
		try {
			teamDaoImpl.insertTeam(userId, roleId, teamId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}

	public void dropTeam(int userId, int roleId, int teamId) {
		// TODO Auto-generated method stub
		try {
			teamDaoImpl.deleteTeam(userId, roleId, teamId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}

	public int getUserId(String userAccount) {
		// TODO Auto-generated method stub
		int i;
		try {
			i = userdaoimp.selectUserId(userAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			i = -1;
		}
		return i;
	}

	public int getUserId(int teamId, int roleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getUserId(int teamId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<String> getTeamName() {
		// TODO Auto-generated method stub
		return teamDaoImpl.selectTeamName();
	}

	public int getUsersRoleId(String userAccount) {
		int i;
		try {
			i = userdaoimp.selectUsersRoleId(userAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			i = -1;
		}
		return i;
	}

	public int getTeam(String name) {
		// TODO Auto-generated method stub
		return teamDaoImpl.selectTeam(name);
	}

	public List<String> getUserAccount() {
		// TODO Auto-generated method stub
		return userdaoimp.selectAllUserAccount();
	}

	public PageShow getPage(String name, String pageNum) {
		if (name == null || name.isEmpty()) {
			name = "";
		}
		PageShow page = new PageShow(getTeam(name), pageNum, name);
		return page;
	}

	public void addTeamByName(String name) {
		boolean exits = false;
		List<String> teamName = getTeamName();
		if (teamName.contains(name)) {
			exits = true;
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sj = sdf.format(date);
		Team team = new Team();
		team.setTeamName(name);
		team.setBuildTime(sj);
		if (name == null || name.isEmpty() || exits == true) {
			logger.error("插入失败");
		} else {
			addTeam(team);
		}
	}

	@Override
	public void addDefaultStudents(int teamId, String studentPref, String studentCount) {
		if (studentPref == null || studentPref.isEmpty() || studentCount == null || studentCount.isEmpty()) {
			logger.error("插入学生失败,输入为空");
		} else {
			int roleId = getRoleId("学生");
			int Count = Integer.parseInt(studentCount);
			String userAccount;
			for (int i = 1; i <= Count; i++) {
				if (i < 10) {
					userAccount = studentPref + "00" + i;
				} else if (i >= 10 && i < 100) {
					userAccount = studentPref + "0" + i;
				} else {
					userAccount = studentPref + i;
				}
				// 获得学生userID
				int userId = getUserId(userAccount);
				// 插入学生到班级
				addtTeam(userId, roleId, teamId);
			}
		}
	}

	@Override
	public void addDefaultUser(String userAccount, int roleId) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sj = sdf.format(date);
		List<String> userAccounts = getUserAccount();
		if (userAccounts.contains(userAccount)) {
			logger.error("已经存在此账号");
		} else {
			User user = new User();
			user.setUserAccount(userAccount);
			user.setAge(20);
			user.setPassword("123456");
			user.setUserName("张三");
			user.setRoleId(roleId);
			user.setBulidTime(sj);
			user.setSex(Sex.MAN);
			user.setHeadPhotoUrl("/images/defaultHeadPhoto.png");
			// 添加新学生
			userdaoimp.insertUser(user);
		}
	}

	public void addStudentsOrTeacher(String userAccount, String roleName, int teamId) {
		UserMessage userMessage = getUserMessage(userAccount, roleName);
		if (userMessage.getUsersRoleId() == userMessage.getRoleId()) {
			addtTeam(userMessage.getUserId(), userMessage.getRoleId(), teamId);
		}
	}

	public UserMessage getUserMessage(String userAccount, String roleName) {
		UserMessage userMessage = new UserMessage();
		if (userAccount == null || userAccount.isEmpty()) {
			userMessage = null;
		}else{			
			userMessage.setUserId(getUserId(userAccount));
			userMessage.setRoleId(getRoleId(roleName));
			userMessage.setUsersRoleId(getUsersRoleId(userAccount));
		}
		return userMessage;
	}

	@Override
	public void deleteStudentsOrTeacher(String userAccount, String roleName, int teamId) {
		UserMessage userMessage = getUserMessage(userAccount, roleName);
		if (userMessage.getUsersRoleId() == userMessage.getRoleId()) {
			dropTeam(userMessage.getUserId(), userMessage.getRoleId(), teamId);
		}
	}

}
