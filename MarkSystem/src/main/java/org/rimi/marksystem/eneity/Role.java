package org.rimi.marksystem.eneity;

import java.util.List;

/*
 * 职位类
 */
public class Role {    
    public String getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
	private int id;
    private String roleName;		//职位名称
    private String functionId;			//功能ID
    private String buildTime;			//创建时间
    private List<String> function; //功能名称
	
	public List<String> getFunction() {
		return function;
	}
	public void setFunction(List<String> function) {
		this.function = function;
	}
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
    
}
