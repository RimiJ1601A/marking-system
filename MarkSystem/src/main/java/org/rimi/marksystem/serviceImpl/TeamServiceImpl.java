package org.rimi.marksystem.serviceImpl;

import java.util.List;

import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.dao.TeamDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TeamServiceImpl implements TeamService {

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
