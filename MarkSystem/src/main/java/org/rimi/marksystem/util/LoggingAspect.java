package org.rimi.marksystem.util;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	private static final Logger logger = Logger.getLogger(LoggingAspect.class); 
	
/*	@Pointcut("execution(* org.rimi.marksystem.serviceImpl.UserServiceImpl.getUserByUserAccountAndPassword(..)) && target(target) && args(userAccount,passWord)")
	public void point(Object target,String userAccount,String passWord){
		
	}
	
	@After("point(target,userAccount,passWord)")
	public void after(Object target,String userAccount,String passWord){
		//logger.info("this is test log"); //\wtpwebapps\MarkSystem\WEB-INF\logs路径下
		System.out.println(target);
		System.out.println(userAccount);
		System.out.println(passWord);
	}*/
		
}
