package org.rimi.marksystem.serviceImpl;

import java.util.List;

import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDaoImpl;
	
	public List<User> getAllUser() {
		try{
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return userDaoImpl.selectAllUser();
	}

	public List<String> getAllUserAccount() {
		try{
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return userDaoImpl.selectAllUserAccount();
	}

	public List<String> getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDaoImpl.selectAllUserAccount();
	}
	
	//判断是否包含该账户
	public User getUserByUserAccountAndPassword(String userAccount, String passWord) {
		User user = new User();
		user = userDaoImpl.selectUserByUserAccountAndPassWord(userAccount, passWord);
		return user;
	}
	
	
}
