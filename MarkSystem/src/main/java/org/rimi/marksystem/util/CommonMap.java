package org.rimi.marksystem.util;

import java.util.HashMap;
import java.util.Map;

import org.rimi.marksystem.eneity.Role;

public class CommonMap {	
	
	/*
	 * 存职位名称
	 */
	public static Map<Integer,String> roleNameMap = new HashMap<Integer,String>();
	
	/*
	 * 存方法名称
	 */
	public static Map<Integer,String> roleFunctionMap = new HashMap<Integer,String>();
	
	
	public static Map<Integer,Map<Role,String>> roleMap = new HashMap<>();
}
