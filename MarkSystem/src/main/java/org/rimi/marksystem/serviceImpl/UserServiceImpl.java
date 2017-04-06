package org.rimi.marksystem.serviceImpl;

import java.util.ArrayList;
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
		return userDaoImpl.selectAllUser();
	}
	
	
}
