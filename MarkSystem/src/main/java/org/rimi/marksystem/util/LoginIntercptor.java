package org.rimi.marksystem.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rimi.marksystem.dao.FunctionUrlDao;
import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.eneity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 登陆访问拦截
 */
public class LoginIntercptor  implements HandlerInterceptor{
	
	
	@Autowired
	private RoleDao roleDaoImpl;
	
	@Autowired
	private FunctionUrlDao functionUrlDaoImpl;
	/*
	 * 进入controller访问路径之前调用，return true进入controller,return false不进入controller
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setCharacterEncoding("utf-8");
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
		}else if(uri.contains("fonts")||uri.contains("css") || uri.contains("js") || uri.contains("png") || uri.contains("jpg") || uri.contains("jpeg")){
			return true;
		}else if(uri.equals("/forgetpassword")){
			
			return true;
		}else{
			if(user != null){
				int roleId = user.getRoleId();
				String functionName = roleDaoImpl.selectFunctionNameByRoleId(roleId);
				String [] functionNames = functionName.split(",");
				
/*				String url = null;
				for(int i=0;i<functionNames.length;i++){
					url = url+functionUrlDaoImpl.selectUrlByFunctionName(functionNames[i])+",";//所有小链接的集合
				}
				if(url.contains(uri)){
					return true;
				}else{
					return false;
				}*/	
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
		

	}
	
}
