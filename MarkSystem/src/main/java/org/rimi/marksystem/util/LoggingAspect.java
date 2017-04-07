package org.rimi.marksystem.util;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	private static final Logger logger = Logger.getLogger(LoggingAspect.class); 
	
/*	@Pointcut("execution(* org.rimi.marksystem.serviceImpl.UserServiceImpl.*(..))")
	public void point(){
		
	}
	
	@Before("point()")
	public void before(){
		logger.info("this is test log"); //\wtpwebapps\MarkSystem\WEB-INF\logs路径下
	}*/
	
	
}
