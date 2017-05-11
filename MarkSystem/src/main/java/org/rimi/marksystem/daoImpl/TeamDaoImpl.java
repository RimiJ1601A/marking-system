package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.dao.TeamDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
@Component
public class TeamDaoImpl implements TeamDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RoleDao roledaoimp;
	@Autowired
	private UserDao userdaoimp;
	
	public List<Team> selectAllTeam() {
		List<Team> teams = new ArrayList<Team>(); 
		teams = jdbcTemplate.query("select * from team ", new ResultSetExtractor<List<Team>>(){
			public List<Team> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Team> result = new ArrayList<Team>(); 
				while(rs.next()){
					Team team = new Team();
					int userId;
					int roleIdStu = 3;
					int roleIdTeacher = 2;
					try {
						roleIdStu = roledaoimp.selectRoleId("学生");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
					}
					try {
						roleIdTeacher = roledaoimp.selectRoleId("教师");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
					}
					int teamId = rs.getInt(1);
					//查学生
					List<String> studentNames = selectStudentsOrTeachter(teamId, roleIdStu);
					//查老师
					List<String> teachersName = selectStudentsOrTeachter(teamId, roleIdTeacher);
					team.setId(teamId);
					team.setTeamName(rs.getString(2));
					team.setBuildTime(rs.getString(3));
					team.setStudentCount(studentNames.size());
					team.setStudents(studentNames);
					team.setTeacherName(teachersName);
					result.add(team);
				}
				return result;
			}
			
		});
		return teams;
	}

	
	public List<Team> selectTeam(final int start,final int count,final String name) {
		List<Team> teams = new ArrayList<Team>();
		teams = jdbcTemplate.query("select * from team where team_name like ? limit ?,?", new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, "%"+name+"%");
				ps.setInt(2, start);
				ps.setInt(3, count);
			}
			
		}, new ResultSetExtractor<List<Team>>() {

			public List<Team> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Team> result = new ArrayList<Team>();
				while(rs.next()){
					Team team = new Team();
					int userId;
					int roleIdStu = 3;
					int roleIdTeacher = 2;
					try {
						roleIdStu = roledaoimp.selectRoleId("学生");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
					}
					try {
						roleIdTeacher = roledaoimp.selectRoleId("教师");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						
					}
					int teamId = rs.getInt(1);
					//查学生
					List<String> studentNames = selectStudentsOrTeachter(teamId, roleIdStu);
					//查老师
					List<String> teachersName = selectStudentsOrTeachter(teamId, roleIdTeacher);
					team.setId(teamId);
					team.setTeamName(rs.getString(2));
					team.setBuildTime(rs.getString(3));
					team.setStudentCount(studentNames.size());
					team.setStudents(studentNames);
					team.setTeacherName(teachersName);
					result.add(team);
				}
				return result;
			}
		});
		return teams;
	}

	public int selectTeam() {
		int count = jdbcTemplate.queryForObject("select count(*) from team", Integer.class);
		return count;
	}

	public void insertTeam(Team team) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO team(team_name,bulid_time) VALUES(?,?)", team.getTeamName(),team.getBuildTime());
	}

	public void updateTeam() {
		// TODO Auto-generated method stub
		
	}

	public void deleteTeam(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from team where id = ?",id);
	}

	public void insertTeam(int userId, int roleId, int teamId) {
		// TODO Auto-generated method stub
		int i = jdbcTemplate.queryForObject("select count(*) from u_p_t where user_id = ? and team_id =? and role_id=?", new Object[]{userId,teamId,roleId}, Integer.class);
		if(i>0){
			return;
		}
		jdbcTemplate.update("INSERT INTO u_p_t(user_id,team_id,role_id) VALUES (?,?,?) ", userId,teamId,roleId);
	}

	public void deleteTeam(int userId, int roleId, int teamId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from u_p_t where user_id = ? and team_id = ?",userId,teamId);
	}

	public List<User> selectUserId(final int teamId, final int roleId) {
		List<User> users = new ArrayList<User>();
		users = jdbcTemplate.query("select user_id from u_p_t where team_id = ? and role_id = ?", new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, teamId);
				ps.setInt(2, roleId);
			}
			
		}, new ResultSetExtractor<List<User>>() {

			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> result = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getInt(1));
					result.add(user);
				}
				return result;
			}
		});
		return users;
	}

	public List<String> selectTeamName() {
		List<String> teamname = new ArrayList<String>();
		teamname = jdbcTemplate.query("select team_name from team", new ResultSetExtractor<List<String>>(){

			public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<String> result = new ArrayList<String>();
				while(rs.next()){
					result.add(rs.getString(1));
				}
				return result;
			}
			
		});
		return teamname;
	}

	@Override
	public Team getTeamByiId(int id) {
		Team team = new Team();
		team = jdbcTemplate.query("select * from team where id =?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, id);
			}
		}, new ResultSetExtractor<Team>() {

			@Override
			public Team extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Team team = new Team();
				while(rs.next()){
					team.setId(rs.getInt(1));
					team.setTeamName(rs.getString(2));
					team.setBuildTime(rs.getString(3));
				}
				return team;
			}
		});
		return team;
	}

	@Override
	public int selectTeam(String name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from team where team_name like ?", new Object[]{"%"+name+"%"} ,Integer.class);
	}


	@Override
	public List<String> selectStudentsOrTeachter(int teamId, int roleId) {
		List<User> users = selectUserId(teamId,roleId);//查userID
		List<String> studentNames = new ArrayList<String>();//存user名字
		ListIterator<User> it = users.listIterator();
		while(it.hasNext()){
			User user = it.next();
			int userId = user.getId();
			String name = "";
			try {
				name = userdaoimp.selectName(userId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			studentNames.add(name);
		}
		return studentNames;
	}

}
