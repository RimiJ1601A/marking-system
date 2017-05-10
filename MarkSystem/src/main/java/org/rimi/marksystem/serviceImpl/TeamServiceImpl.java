package org.rimi.marksystem.serviceImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.dao.TeamDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.TeamService;
import org.rimi.marksystem.util.MSSheet;
import org.rimi.marksystem.util.PathCostant;
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
	
	public void createTeamExcel(String path,String name){
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
			MSSheet msSheet = new MSSheet(titles, this.getAllTeam(),needProperties, path + name, "班级表", 0);
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

	public List<Team> getTeam(int start, int count) {
		// TODO Auto-generated method stub
		return teamDaoImpl.selectTeam(start, count);
	}

	public List<Team> getTeam(int start,int count,String name) {
	
		return teamDaoImpl.selectTeam(start,count,name);
	}

	public int getTeam() {
		// TODO Auto-generated method stub
		return teamDaoImpl.selectTeam();
	}

	public void addTeam(Team team) {
		// TODO Auto-generated method stub
		try {
			teamDaoImpl.insertTeam(team);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	public void modifyTeam() {
		// TODO Auto-generated method stub
		try {
			teamDaoImpl.updateTeam();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	public void dropTeam(int id) {
		// TODO Auto-generated method stub
		try {
			teamDaoImpl.deleteTeam(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		try {
			userdaoimp.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
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
			
		}
	}

	public void dropTeam(int userId, int roleId, int teamId) {
		// TODO Auto-generated method stub
		try {
			teamDaoImpl.deleteTeam(userId, roleId, teamId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	public int getUserId(String userAccount) {
		// TODO Auto-generated method stub
		int i ;
		try {
			i=	userdaoimp.selectUserId(userAccount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			i=-1;
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
			i=-1;
		}
		return i;
	}

	@Override
	public int getTeam(String name) {
		// TODO Auto-generated method stub
		return teamDaoImpl.selectTeam(name);
	}

	@Override
	public List<String> getUserAccount() {
		// TODO Auto-generated method stub
		return userdaoimp.selectAllUserAccount();
	}

}
