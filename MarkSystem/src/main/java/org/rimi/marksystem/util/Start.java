package org.rimi.marksystem.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.rimi.marksystem.eneity.Role;
import org.rimi.marksystem.service.RoleService;
import org.rimi.marksystem.serviceImpl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

  
public class Start{  
	
	@Autowired
	private RoleService roleServiceImpl;
	
	
	/*
	 * spring bean 注入完成后运行代码
	 */
    @PostConstruct  
    public void  init(){  
        System.out.println("I'm  init  method  using  @PostConstrut....");
        
        System.out.println("加载完成");
    }  
      
} 
