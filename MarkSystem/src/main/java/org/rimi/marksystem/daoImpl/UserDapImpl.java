package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class UserDapImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//查询所有用户信息
	public List<User> selectAllUser() {
		List<User> userlist = new ArrayList<User>();
		userlist = jdbcTemplate.query("select * from user",new ResultSetExtractor<List<User>>(){
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> tempUser = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getInt(1));
					user.setUserAccount(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setUserName(rs.getString(4));
					user.setAge(rs.getInt(5));
					user.setSex(Sex.getSexByValue(rs.getInt(6)));
					user.setRoleId(rs.getInt(7));
					user.setBulidTime(rs.getDate(8));
					tempUser.add(user);
				}
				return tempUser;
			}		
		});
		return userlist;
	}
	
	//插入单个用户
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	//查询所有用户账号
	public List<String> selectAllUserAccount() {
		List<String> usernamelist = new ArrayList<String>();
		usernamelist = jdbcTemplate.query("select user_account from user",new ResultSetExtractor<List<String>>(){
			public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<String> nameList = new ArrayList<String>();
				while(rs.next()){
					nameList.add(rs.getString(1));
				}
				return nameList;
			}		
		});
		return usernamelist;	
	}
	
	
	//
	public User selectUserByUserAccountAndPassWord(final String userName,final String passWord) {
		User user = new User();
		
		
		user = jdbcTemplate.query("select * from user where user_account = ? and password = ?", new PreparedStatementSetter(){

		public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, userName);	 
				ps.setString(2, passWord);
			}			
		}, new ResultSetExtractor<User>() {

			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User tempuser = new User();
				if(rs == null){
					return null;
				}
				while(rs.next()){
					tempuser.setId(rs.getInt(1));
					tempuser.setUserAccount(rs.getString(2));
					tempuser.setPassword(rs.getString(3));
					tempuser.setUserName(rs.getString(4));
					tempuser.setAge(rs.getInt(5));
					tempuser.setSex(Sex.getSexByValue(rs.getInt(6)));
					tempuser.setRoleId(rs.getInt(7));
					tempuser.setBulidTime(rs.getDate(8));
				}
				return tempuser;
			}
			
		});
		if(user.getUserAccount() == null){
			return null;
		}else{
			return user;			
		}
	}

}
