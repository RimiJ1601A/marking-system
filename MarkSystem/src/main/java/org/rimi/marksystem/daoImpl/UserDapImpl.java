package org.rimi.marksystem.daoImpl;

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
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component
public class UserDapImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<User> selectAllUser() {
		List<User> userlist = new ArrayList<User>();
		userlist = jdbcTemplate.query("select * from user",new ResultSetExtractor<List<User>>(){
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> tempUser = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getInt(1));
					user.setUserAccount(rs.getString(2));
					user.setUserName(rs.getString(4));
					user.setSex(Sex.getSexByValue(rs.getInt(6)));
					user.setBulidTime(rs.getDate(8));
					tempUser.add(user);
				}
				return tempUser;
			}		
		});
		return userlist;
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
