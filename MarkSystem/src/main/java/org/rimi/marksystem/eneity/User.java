package org.rimi.marksystem.eneity;


/*
 * 用户类
 */
import org.rimi.marksystem.util.Sex;

public class User {
    private int id;
    private String userAccount;			//用户登陆账号
    private String password;			//用户登陆密码
    private String userName;			//用户名称
    private int age;					//年龄
    private Sex sex;					//性别(1代表男，2代表女)
    private int roleId;					//用户所在职位ID
    private String bulidTime;				//用户注册时间
    private String headPhotoUrl;
	public String getHeadPhotoUrl() {
		return headPhotoUrl;
	}
	public void setHeadPhotoUrl(String headPhotoUrl) {
		this.headPhotoUrl = headPhotoUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getBulidTime() {
		return bulidTime;
	}
	public void setBulidTime(String bulidTime) {
		this.bulidTime = bulidTime;
	}
    
}
