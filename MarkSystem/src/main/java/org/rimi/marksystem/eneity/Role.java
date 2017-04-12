package org.rimi.marksystem.eneity;

import java.util.Date;

/*
 * 职位类
 */
public class Role {    
    private int id;
    private String roleName;		//职位名称
    private String functionId;			//功能ID
    private String buildTime;			//创建时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
    
}
