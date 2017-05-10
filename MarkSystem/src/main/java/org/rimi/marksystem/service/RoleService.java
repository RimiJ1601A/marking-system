package org.rimi.marksystem.service;

import java.util.List;
import org.rimi.marksystem.eneity.Role;
import org.rimi.marksystem.util.PageShow;
import org.springframework.stereotype.Component;

@Component
public interface RoleService {

	//查询所有职位
	public List<Role> getRoleAll();
	//查询总数
	public int getRoleCount();
	//查询的总数
	public int getRole(String name);
	//根据职位名称查
	public List<Role> getRole(int start,int count,String name);
	//分页查询
	public List<Role> getRolePage(int start,int count);
	//插入
	public void addRole(Role role);
	//修改
	public void modifyRole(String name, String funcitonId);
	//删除(根据ID删除)
	public void deleteRole(int id);
	//根据ID查询功能名称
//	public String getRoleFunction(int id);
	public String getRoleFunction(int functionId);
	//获取职位名
	public List<String> getRoleName();
	//根据id获取职位名称
	public String getRoleNameByRoleId(int roleId);
	//根据roleId获取所有function名字
	public String getFunctionNameByRoleId(int roleId);
	//根据role名称查roleId
	public int getRoleId(String roleName);
	//分页查询
	public PageShow getPage(String name,String pageNum);
}
