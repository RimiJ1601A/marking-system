package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
	
	public void insertUser(User user);
	
	public List<User> selectAllUser();
	
	public List<String> selectAllUserAccount();
	
	public User selectUserByUserAccountAndPassWord(String userName,String passWord);
}
