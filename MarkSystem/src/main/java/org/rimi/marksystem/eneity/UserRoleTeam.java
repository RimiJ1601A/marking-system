package org.rimi.marksystem.eneity;

/*
 * 用户，团队，职位数据类
 */
public class UserRoleTeam {
     
    private int id;
    private int userId;			//用户ID
    private int teamId;			//用户所在班级ID
    private int roleId;			//用户所在职位ID；
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
    
    
}
