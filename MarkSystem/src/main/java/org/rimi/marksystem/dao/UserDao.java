package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
	
	public List<User> selectAllUser();
	
	public List<String> selectAllUserAccount();
	
	public User selectUserByUserAccountAndPassWord(String userAccount,String passWord);
	//条件搜索
	public List<User> selectUser(String name);
	//增加用户
	public void insertUser(User user);
	//删除用户(根据账号删除)
	public void deleteUser(String account);
	//修改用户信息(根据账号修改,账号不能变)
	public void updateUserRole(String account, int role_id);
	
	//更新用户
	public void updateUser(String account,User user);
	
	//修改密码
    public void updatePassword(String account,String password);
    
    //判断旧密码是否正确
    public boolean checkPassWordIsTrue(String account,String password);

    //重置密码
    public void resetPassword(String account,String password);
    
    //分页查询
    public List<User> getUsersByPage(int page,int account);
  //根据账号获得userId
  	public int selectUserId(String userAccount);
  //根据用户ID获得学生或教师姓名
  	public String selectName(int userId);
  //根据账号获得roleID
  	public int selectUsersRoleId(String userAccount);
    
}
