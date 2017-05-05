package org.rimi.marksystem.util;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	private static final Logger logger = Logger.getLogger(LoggingAspect.class); 
	
		
	@Pointcut("execution(* org.rimi.marksystem.serviceImpl.UserServiceImpl.getUserByUserAccountAndPassword(..)) && target(target) && args(userAccount,passWord)")
	public void point(Object target,String userAccount,String passWord){
		
	}
	@Pointcut("execution(* org.rimi.marksystem.serviceImpl.UserServiceImpl.insertUser(..))")
	public void pointInsertUser(){}
	
	
	@After("point(target,userAccount,passWord)")
	public void after(Object target,String userAccount,String passWord){
		//logger.info("this is test log"); //\wtpwebapps\MarkSystem\WEB-INF\logs路径下
		System.out.println(target);
		System.out.println(userAccount);
		System.out.println(passWord);
		logger.info("");
	}
	//插入用户
	@Before("pointInsertUser()")
	public void before(){
		System.out.println("插入了一个用户");
		logger.info("插入了一个用户");
	}
	
	//修改用户
	@After("execution(* org.rimi.marksystem.serviceImpl.UserServiceImpl.updateUser(..))")
	public void  updateUser(){
		System.out.println("修改了一个用户");
		logger.info("修改一个用户");
	}
	
	//修改职位
	@After("execution(* org.rimi.marksystem.serviceImpl.RoleServiceImpl.modifyRole(..))")
	public void updateRole(){
		System.out.println("修改职位");
		logger.info("修改职位");
	}
	//添加职位
	@After("execution(* org.rimi.marksystem.serviceImpl.RoleServiceImpl.addRole(..))")
	public void addRole(){
		System.out.println("增加职位");
		logger.info("增加职位");
	}
	
	
	//增加班级
	@After("execution(* org.rimi.marksystem.serviceImpl.TeamServiceImpl.addTeam(..))")
	public void addTeam(){
		System.out.println("增加班级");
		logger.info("创建班级");
	}
	//添加学生到班级
	@After("execution(* org.rimi.marksystem.serviceImpl.TeamServiceImpl.addtTeam(..))")
	public void addStudent(){
		System.out.println("增加学生或老师到班级");
		logger.info("添加学生或老师到班级");
	}
	//从班级删除学生
	@After("execution(* org.rimi.marksystem.serviceImpl.TeamServiceImpl.dropTeam(..)) && args(userId)")
	public void deleteStudent(int userId){
		System.out.println("移除学生或老师到班级");
		logger.info("从班级移除学生或老师");
	}
}
