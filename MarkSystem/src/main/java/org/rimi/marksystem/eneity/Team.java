package org.rimi.marksystem.eneity;

import java.util.Date;

/*
 * 团队类
 */
public class Team {
    private int id;
    private String teamName;		//班级名称
    private Date buildTime;			//创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Date getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Date buildTime) {
		this.buildTime = buildTime;
	}
    
}
