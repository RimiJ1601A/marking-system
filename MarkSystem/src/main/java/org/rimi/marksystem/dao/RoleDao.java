package org.rimi.marksystem.dao;

import java.util.List;
import org.rimi.marksystem.eneity.Role;
import org.springframework.stereotype.Component;

@Component
public interface RoleDao {

	//查询所有职位
	public List<Role> selectRoleAll();
	//查询总数
	public int selectRoleCount();
	//根据职位名称查
	public List<Role> selectRole(int start,int count,String name);
	//分页查询
	public List<Role> selectRolePage(int start,int count);
	//增加
	public void insertRole(Role role);
	//修改(根据名字修改功能)
	public void updateRole(String name,String funcitonId);
	//删除(根据ID删除)
	public void dropRole(int id);
	//根据ID查功能名称
	public String selectRoleFunction(int id);
	//获取职位名
	public List<String> selectRoleName();
	//根据ID查找职位名称
	public String selectRoleNameByRoleId(int id);
	
	//根据roleId查找function名称
	public String selectFunctionNameByRoleId(int roleId);
	//通过职位名称查roleID
		public int selectRoleId(String name);
}
