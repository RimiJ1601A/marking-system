package org.rimi.marksystem.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver{
	
	
	private static final Logger logger = Logger.getLogger(MyExceptionHandler.class); 
	
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", ex); 
        if(ex instanceof Exception){
        	logger.error(ex);
        	return new ModelAndView("error-business", model);
        }else{
        	logger.error(ex);
        	return new ModelAndView("error", model);
        }
	}

}
