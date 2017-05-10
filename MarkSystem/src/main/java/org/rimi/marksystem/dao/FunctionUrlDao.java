package org.rimi.marksystem.dao;

import org.springframework.stereotype.Component;

@Component
public interface FunctionUrlDao {
	
	public String selectUrlByFunctionName(String name);
}
