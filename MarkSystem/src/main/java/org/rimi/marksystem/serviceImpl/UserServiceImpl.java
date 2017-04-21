package org.rimi.marksystem.serviceImpl;

import java.util.List;

import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDaoImpl;
	@Autowired
	private RoleDao roleDaoImpl;
	
	public List<User> getAllUser() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return userDaoImpl.selectAllUser();
	}

	public List<String> getAllUserAccount() {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return userDaoImpl.selectAllUserAccount();
	}

	public List<String> getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDaoImpl.selectAllUserAccount();
	}

	// 判断是否包含该账户
	public User getUserByUserAccountAndPassword(String userAccount, String passWord) {
		User user = new User();
		user = userDaoImpl.selectUserByUserAccountAndPassWord(userAccount, passWord);
		return user;
	}

	public List<User> getUser(String account, String name) {
		// TODO Auto-generated method stub
		return userDaoImpl.selectAllUser();
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDaoImpl.insertUser(user);
	}

	public void deleteUser(String account) {
		// TODO Auto-generated method stub

	}

	public void updateUserRole(String account, int role_id) {
		// TODO Auto-generated method stub
		userDaoImpl.updateUserRole(account, role_id);
	}

	public void updateUser(String account, User user) {
		// TODO Auto-generated method stub
		userDaoImpl.updateUser(account, user);
	}

	public void updatePassword(String account, String password) {
		// TODO Auto-generated method stub
		userDaoImpl.updatePassword(account, password);
	}

	public boolean checkPassWordIsTrue(String account, String password) {
		// TODO Auto-generated method stub
		return userDaoImpl.checkPassWordIsTrue(account, password);
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userDaoImpl.insertUser(user);
	}

	public void resetPassword(String account, String password) {
		// TODO Auto-generated method stub
		userDaoImpl.resetPassword(account, password);
	}

	public List<User> getUsersByPage(int page, int account) {
		// TODO Auto-generated method stub
		List<User> userlist = userDaoImpl.getUsersByPage(page, account);
		for(int i =0;i<userlist.size();i++){
			String roleName = roleDaoImpl.selectRoleNameByRoleId(userlist.get(i).getRoleId());
			userlist.get(i).setRoleName(roleName);
		}
		return userlist;
	}

}
