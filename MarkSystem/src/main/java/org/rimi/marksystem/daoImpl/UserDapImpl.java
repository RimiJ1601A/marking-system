package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class UserDapImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private RoleDao roleDaoImpl;

	// 查询所有用户信息
	public List<User> selectAllUser() {
		List<User> userlist = new ArrayList<User>();
		userlist = jdbcTemplate.query("select * from user", new ResultSetExtractor<List<User>>() {
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> tempUser = new ArrayList<User>();
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt(1));
					user.setUserAccount(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setUserName(rs.getString(4));
					user.setAge(rs.getInt(5));
					user.setSex(Sex.getSexByValue(rs.getInt(6)));
					user.setRoleId(rs.getInt(7));
					
					user.setBulidTime(rs.getDate(8).toString());
					user.setHeadPhotoUrl(rs.getString(9));
					user.setRoleName(roleDaoImpl.selectRoleNameByRoleId(rs.getInt(7)));
					tempUser.add(user);
				}
				return tempUser;
			}
		});
		return userlist;
	}

	// 插入单个用户
	public void insertUser(final User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(
				"insert into user (user_account,password,user_name,age,sex,role_id,bulid_time,headphoto_url) values(?,?,?,?,?,?,?,?) ",
				new PreparedStatementSetter() {

					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, user.getUserAccount());
						ps.setString(2, user.getPassword());
						ps.setString(3, user.getUserName());
						ps.setInt(4, user.getAge());
						ps.setInt(5, user.getSex().getValue());
						ps.setInt(6, user.getRoleId());
						ps.setString(7, user.getBulidTime());
						ps.setString(8, user.getHeadPhotoUrl());
					}

				});

	}

	// 查询所有用户账号
	public List<String> selectAllUserAccount() {
		List<String> usernamelist = new ArrayList<String>();
		usernamelist = jdbcTemplate.query("select user_account from user", new ResultSetExtractor<List<String>>() {
			public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<String> nameList = new ArrayList<String>();
				while (rs.next()) {
					nameList.add(rs.getString(1));
				}
				return nameList;
			}
		});
		return usernamelist;
	}

	//
	public User selectUserByUserAccountAndPassWord(final String userName, final String passWord) {
		User user = new User();

		user = jdbcTemplate.query("select * from user where user_account = ? and password = ?",
				new PreparedStatementSetter() {

					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, userName);
						ps.setString(2, passWord);
					}
				}, new ResultSetExtractor<User>() {

					public User extractData(ResultSet rs) throws SQLException, DataAccessException {
						User tempuser = new User();
						if (rs == null) {
							return null;
						}
						while (rs.next()) {
							tempuser.setId(rs.getInt(1));
							tempuser.setUserAccount(rs.getString(2));
							tempuser.setPassword(rs.getString(3));
							tempuser.setUserName(rs.getString(4));
							tempuser.setAge(rs.getInt(5));
							tempuser.setSex(Sex.getSexByValue(rs.getInt(6)));
							tempuser.setRoleId(rs.getInt(7));
							tempuser.setBulidTime(rs.getDate(8).toString());
							tempuser.setHeadPhotoUrl(rs.getString(9));
						}
						return tempuser;
					}

				});
		if (user.getUserAccount() == null) {
			return null;
		} else {
			return user;
		}
	}

	public List<User> selectUser(final String name) {
		List<User> username = new ArrayList<User>();
		username = jdbcTemplate.query("select * from user where user_name like ? limit 0,10",
				new PreparedStatementSetter() {

					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, "%"+name+"%");
					}
				}, new ResultSetExtractor<List<User>>() {

					public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
						List<User> ab = new ArrayList<User>();

						if (rs == null) {
							return null;
						}
						while (rs.next()) {
							User visitor = new User();
							visitor.setId(rs.getInt(1));
							visitor.setUserAccount(rs.getString(2));
							visitor.setPassword(rs.getString(3));
							visitor.setUserName(rs.getString(4));
							visitor.setAge(rs.getInt(5));
							visitor.setSex(Sex.getSexByValue(rs.getInt(6)));
							visitor.setRoleId(rs.getInt(7));
							visitor.setBulidTime(rs.getDate(8).toString());
							visitor.setRoleName(roleDaoImpl.selectRoleNameByRoleId(rs.getInt(7)));
							ab.add(visitor);
						}
						return ab;
					}
				});
		return username;
	}

	public void deleteUser(String account) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from user where user_account = ?", account);
	}

	public void updateUserRole(final String account, final int role_id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update user set role_id = ? where user_account = ? ", new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, role_id);
				ps.setString(2, account);
			}
		});

	}

	public void updatePassword(final String account, final String password) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update user set password =? where user_account = ?", new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, password);
				ps.setString(2, account);
			}
		});
	}

	public boolean checkPassWordIsTrue(final String account, final String password) {
		// TODO Auto-generated method stub
		User user = new User();
		user = jdbcTemplate.query("select * from user where user_account = ? and password = ?",
				new PreparedStatementSetter() {

					public void setValues(PreparedStatement ps) throws SQLException {
						// TODO Auto-generated method stub
						ps.setString(1, account);
						ps.setString(2, password);

					}
				}, new ResultSetExtractor<User>() {

					public User extractData(ResultSet rs) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						User user = new User();
						while (rs.next()) {
							user.setUserAccount(rs.getString(2));
						}
						return user;
					}
				});
		if (user.getUserAccount() == null) {
			return false;
		} else {
			return true;
		}
	}

	public void updateUser(String account, User user) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update user set user_name = ?,age = ?,sex = ?,role_id = ?,bulid_time = ? where user_account = ?", user.getUserName(),user.getAge(),user.getSex().getValue(),user.getRoleId(),user.getBulidTime(),user.getUserAccount());
	}

	public void resetPassword(final String account, final String password) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update user set password = ? where user_account = ?", new PreparedStatementSetter() {

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, "123456");
				ps.setString(2, account);
			}
		});

	}

	public List<User> getUsersByPage(final int page, final int account) {
		List<User> userlist = new ArrayList<User>();
		
		userlist = jdbcTemplate.query("select * from user limit ?,?", new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, page);
				ps.setInt(2, account);
			}
		}, new ResultSetExtractor<List<User>>() {

			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> tempuserlist = new ArrayList<User>();
				while(rs.next()){
					User user = new User();
					user.setId(rs.getInt(1));
					user.setUserAccount(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setUserName(rs.getString(4));
					user.setAge(rs.getInt(5));
					user.setSex(Sex.getSexByValue(rs.getInt(6)));
					user.setRoleId(rs.getInt(7));
					user.setBulidTime(rs.getDate(8).toString());
					user.setHeadPhotoUrl(rs.getString(9));							
					tempuserlist.add(user);
				}
				return tempuserlist;
			}
		});	
		return userlist;
	}

	public int selectUserId(String userAccount) {
		int userId = jdbcTemplate.queryForObject("select id from user where user_account = ?", new Object[] {userAccount}, Integer.class);
		return userId;
	}


	public String selectName(int userId) {
		String name = jdbcTemplate.queryForObject("select user_name from user where id = ? ", new Object[]{userId}, String.class);
		return name;
	}
	
	public int selectUsersRoleId(String userAccount) {
		int roleId = jdbcTemplate.queryForObject("select role_id from user where user_account = ?", new Object[] {userAccount}, Integer.class);
		return roleId;
	}

	@Override
	public void updateUserHeadPhoto(String imgUrl, String userAccount) {
			
		jdbcTemplate.update("update user set headphoto_url  = ? where user_account = ? ", new Object[]{imgUrl,userAccount});
	
	}
    
    
    @Override
    //根据roleid查询用户数量
    public int selectUsersSum(int roleId) {
        int sum=jdbcTemplate.queryForObject("select count(*) from user where role_id =?", new Object[]{roleId},Integer.class );
        return sum;
    }
    
    @Override
    //根据用户的roleid查用户当月注册数量
    public int selectMonthlyUsersSum(int roleId) {
        //DATE_ADD(curdate(),interval -day(curdate())+1 day)获取本月第一天
        String sql="select count(*) from user where role_id=? and bulid_time >=(DATE_ADD(curdate(),interval -day(curdate())+1 day))";
        int sum =jdbcTemplate.queryForObject(sql, new Object[]{roleId},Integer.class);
        return sum;
    }
    
    @Override
    //按月查相应年度新增用户,查当年，无新用户不统计
    public List<Map<String, Object>> selectNewUsers(int year) {
        
        String sql="select date_format(bulid_time,'%m') as month,count(*) as userssum from user where date_format(bulid_time,'%Y')=? group by month order by month ";
        return jdbcTemplate.queryForList(sql,new Object[]{year});
    }

    
    @Override
    //按月查相应年度注册用户，查前一年，无注册用户，记为零
    public List<Map<String, Object>> selectlastNewUsers(int lastyear) {
        String sql="select MT.MONTH_NUM,ifnull(total_num,0) as newusers from MONTH_TABLE MT left join (select date_format(bulid_time,'%m') as month,count(*) as TOTAL_NUM from user  where date_format(bulid_time,'%Y')=? group by month) u on u.month = MT.MONTH_NUM order by MT.MONTH_NUM";
        return jdbcTemplate.queryForList(sql,new Object[]{lastyear});
        
    }
    
    
    
    
    
    
	@Override
	public User selectUserByid(int id) {
		User user = new User();
		user = jdbcTemplate.query("select * from user where id =?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, id);
			}
		}, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				User user = new User();
				while(rs.next()){
					user.setId(rs.getInt(1));
					user.setUserName(rs.getString(4));
					user.setAge(rs.getInt(5));
					user.setSex(Sex.getSexByValue(rs.getInt(6)));
					user.setRoleId(rs.getInt(7));
					user.setHeadPhotoUrl(rs.getString(9));
				}
				return user;
			}
		});
		return user;
	}

}
