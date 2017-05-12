package org.rimi.marksystem.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.rimi.marksystem.eneity.Role;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.RoleService;
import org.rimi.marksystem.service.UserService;
import org.rimi.marksystem.serviceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

  
public class Start{  
	
	@Autowired
	private RoleService roleServiceImpl;
	
	@Autowired
	private UserService userServiceImpl;
	
	/*
	 * spring bean 注入完成后运行代码
	 */
    @PostConstruct  
    public void  init(){  
        if(userServiceImpl.getUserByUserAccountAndPassword("root", "123456") == null){
        	User user = new User();
        	user.setAge(22);
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	String date = dateFormat.format(new Date());
        	user.setBulidTime(date);
        	user.setHeadPhotoUrl("/images/defaultHeadPhoto.png");
        	user.setPassword("123456");
        	user.setRoleId(1);
        	user.setSex(Sex.MAN);
        	user.setUserName("RIMIadmin");
        	user.setUserAccount("root");
        	userServiceImpl.addUser(user);
        }
    }  
       
} 
