package org.rimi.marksystem.service;

import java.util.List;
import org.rimi.marksystem.eneity.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleService {

	//查询所有职位
	public List<Role> getRoleAll();
	//查询总数
	public int getRoleCount();
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
	public String getRoleFunction(int id);
}
