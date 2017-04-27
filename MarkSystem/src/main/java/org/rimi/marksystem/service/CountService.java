package org.rimi.marksystem.service;

import java.util.Date;
import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.TeamAndUser;

public interface CountService {
	
	public Date countBegintime();
	
	public List<TeamAndUser> getTeamAndUser();
	
}
