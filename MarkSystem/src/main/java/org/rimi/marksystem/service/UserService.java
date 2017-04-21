package org.rimi.marksystem.service;

import java.util.List;

import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

	public List<User> getAllUser();

	public List<String> getAllUserAccount();

	public List<String> getUserByName(String name);

	public User getUserByUserAccountAndPassword(String userAccount, String passWord);

	// 增加用户
	public void addUser(User user);

	// 删除用户(根据账号删除)
	public void deleteUser(String account);

	// 修改用户信息(根据账号修改,账号不能变)
	public void updateUserRole(String account, int role_id);

	public void updateUser(String account, User user);

	public void updatePassword(String account, String password);
	// 修改密码

	// 判断旧密码是否正确
	public boolean checkPassWordIsTrue(String account, String password);

	public void insertUser(User user);
	// 删除用户(根据账号删除)

	// 重置密码
	public void resetPassword(String account, String password);
	
	
    //分页查询
    public List<User> getUsersByPage(int page,int account);

}
