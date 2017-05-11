package org.rimi.marksystem.eneity;
/**
 * 封装几个需要的ID
 * @author rimi
 *
 */
public class UserMessage {

	private int userId;
	private int roleId;
	private int usersRoleId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getUsersRoleId() {
		return usersRoleId;
	}
	public void setUsersRoleId(int usersRoleId) {
		this.usersRoleId = usersRoleId;
	}
	
}
