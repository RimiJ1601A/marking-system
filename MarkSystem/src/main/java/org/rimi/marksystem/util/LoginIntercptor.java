package org.rimi.marksystem.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rimi.marksystem.eneity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 登陆访问拦截
 */
public class LoginIntercptor  implements HandlerInterceptor{
	
	
	/*
	 * 进入controller访问路径之前调用，return true进入controller,return false不进入controller
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//    request.getRequestURI()路径/loginPage
		//    request.getRequestURL()路径http://localhost:8080/loginPage
		String uri = request.getRequestURI();
		User user = (User)request.getSession().getAttribute("user");
		if(uri.equals("/loginPage") || uri.equals("/login")){		
			if(user!=null){
				response.sendRedirect("/index");
				return false;
			}else{
					return true;		
			}
		}else{
			if(user != null){
				
				return true;				
			}else{
				response.sendRedirect("/loginPage");
				return false;
			}
		}
		//return true;
	}
	/*
	 *进入controller访问路径，返回试图后,视图渲染前调用 
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 视图渲染后调用
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}
