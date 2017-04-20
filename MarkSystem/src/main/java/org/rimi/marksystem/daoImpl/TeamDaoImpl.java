package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.rimi.marksystem.dao.TeamDao;
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
	public List<Team> selectAllTeam() {
		List<Team> teams = new ArrayList<Team>(); 
		teams = jdbcTemplate.query("select * from team ", new ResultSetExtractor<List<Team>>(){
			public List<Team> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Team> result = new ArrayList<Team>(); 
				while(rs.next()){
					Team team = new Team();
					int userId;
					int roleIdStu;
					int roleIdTeacher;
					roleIdStu = selectRoleId("学生");
					roleIdTeacher = selectRoleId("教师");
					int teamId = rs.getInt(1);
					team.setId(teamId);
					team.setTeamName(rs.getString(2));
					team.setBuildTime(rs.getString(3));
					//查学生
					List<User> students = selectUserId(teamId,roleIdStu);//查userID
					List<String> studentNames = new ArrayList<String>();//存学生名字
					ListIterator<User> it = students.listIterator();
					while(it.hasNext()){
						User user = it.next();
						userId = user.getId();
//						User student = new User();
						String name = selectName(userId);//查学生名字
//						student.setUserName(name);
//						studentNames.add(student);
						studentNames.add(name);
					}
					team.setStudentCount(studentNames.size());
					team.setStudents(studentNames);
					//查老师
					List<User> teachers = selectUserId(teamId,roleIdTeacher);//查老师userID
					List<String> teachersName = new ArrayList<String>();//存老师名字
					ListIterator<User> item = teachers.listIterator();
					while(item.hasNext()){
						User user = item.next();
						userId = user.getId();
						String name = selectName(userId);//查教师名字
						teachersName.add(name);
					}
					team.setTeacherName(teachersName);
					result.add(team);
				}
				return result;
			}
			
		});
		return teams;
	}

	public List<Team> selectTeam(final int start, final int count) {
		List<Team> teams = new ArrayList<Team>(); 
		teams = jdbcTemplate.query("select * from team limit ?,?", new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, start);
				ps.setInt(2, count);
			}
			},new ResultSetExtractor<List<Team>>(){

			public List<Team> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Team> result = new ArrayList<Team>(); 
				while(rs.next()){
					Team team = new Team();
					int userId;
					int roleIdStu;
					int roleIdTeacher;
					roleIdStu = selectRoleId("学生");
					roleIdTeacher = selectRoleId("教师");
					int teamId = rs.getInt(1);
					team.setId(teamId);
					team.setTeamName(rs.getString(2));
					team.setBuildTime(rs.getString(3));
					//查学生
					List<User> students = selectUserId(teamId,roleIdStu);//查userID
					List<String> studentNames = new ArrayList<String>();//存学生名字
					ListIterator<User> it = students.listIterator();
					while(it.hasNext()){
						User user = it.next();
						userId = user.getId();
//						User student = new User();
						String name = selectName(userId);//查学生名字
//						student.setUserName(name);
//						studentNames.add(student);
						studentNames.add(name);
					}
					team.setStudentCount(studentNames.size());
					team.setStudents(studentNames);
					//查老师
					List<User> teachers = selectUserId(teamId,roleIdTeacher);//查老师userID
					List<String> teachersName = new ArrayList<String>();//存老师名字
					ListIterator<User> item = teachers.listIterator();
					while(item.hasNext()){
						User user = item.next();
						userId = user.getId();
						String name = selectName(userId);//查教师名字
						teachersName.add(name);
					}
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
					int roleIdStu;
					int roleIdTeacher;
					roleIdStu = selectRoleId("学生");
					roleIdTeacher = selectRoleId("教师");
					int teamId = rs.getInt(1);
					team.setId(teamId);
					team.setTeamName(rs.getString(2));
					team.setBuildTime(rs.getString(3));
					//查学生
					List<User> students = selectUserId(teamId,roleIdStu);//查userID
					List<String> studentNames = new ArrayList<String>();//存学生名字
					ListIterator<User> it = students.listIterator();
					while(it.hasNext()){
						User user = it.next();
						userId = user.getId();
//						User student = new User();
						String name = selectName(userId);//查学生名字
//						student.setUserName(name);
//						studentNames.add(student);
						studentNames.add(name);
					}
					team.setStudentCount(studentNames.size());
					team.setStudents(studentNames);
					//查老师
					List<User> teachers = selectUserId(teamId,roleIdTeacher);//查老师userID
					List<String> teachersName = new ArrayList<String>();//存老师名字
					ListIterator<User> item = teachers.listIterator();
					while(item.hasNext()){
						User user = item.next();
						userId = user.getId();
						String name = selectName(userId);//查教师名字
						teachersName.add(name);
					}
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

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO user(user_account,password,user_name,age,sex,role_id,bulid_time)VALUES (?,?,?,?,?,?,?)", user.getUserAccount(),user.getPassword(),user.getUserName(),user.getAge(),user.getSex().getValue(),user.getRoleId(),user.getBulidTime());
	}

	public int selectRoleId(String name) {
		// TODO Auto-generated method stub
		int roleId = jdbcTemplate.queryForObject("select id from role where role_name = ?", new Object[] {name}, Integer.class);
		return roleId;
	}

	public void insertTeam(int userId, int roleId, int teamId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO u_p_t(user_id,team_id,role_id) VALUES (?,?,?) ", userId,teamId,roleId);
	}

	public void deleteTeam(int userId, int roleId, int teamId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from u_p_t where user_id = ? and team_id = ?",userId,teamId);
	}

	public int selectUserId(String userAccount) {
		int userId = jdbcTemplate.queryForObject("select id from user where user_account = ?", new Object[] {userAccount}, Integer.class);
		return userId;
	}

	public String selectName(int userId) {
		String name = jdbcTemplate.queryForObject("select user_name from user where id = ? ", new Object[]{userId}, String.class);
		return name;
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

	public int selectUsersRoleId(String userAccount) {
		int roleId = jdbcTemplate.queryForObject("select role_id from user where user_account = ?", new Object[] {userAccount}, Integer.class);
		return roleId;
	}
}
