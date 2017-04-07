package org.rimi.marksystem.service;

import java.util.List;

import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
	
	public List<User> getAllUser();
	
	public List<String> getAllUserAccount();
	
	public List<String> getUserByName(String name);
	
	public User getUserByUserAccountAndPassword(String userName,String passWord);
}	
