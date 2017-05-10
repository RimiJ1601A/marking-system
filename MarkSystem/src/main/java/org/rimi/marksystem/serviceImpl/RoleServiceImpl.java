package org.rimi.marksystem.serviceImpl;

import java.util.List;

import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.eneity.Role;
import org.rimi.marksystem.service.RoleService;
import org.rimi.marksystem.util.ConstantClassField;
import org.rimi.marksystem.util.PageShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDaoImpl;
	
	//查询所有职位
	public List<Role> getRoleAll() {
		return roleDaoImpl.selectRoleAll();
	}
	//查询总数
	public int getRoleCount() {
		// TODO Auto-generated method stub
		return roleDaoImpl.selectRoleCount();
	}

	//分页查询
	public List<Role> getRolePage(int start, int count) {
		// TODO Auto-generated method stub
		return roleDaoImpl.selectRolePage(start, count);
	}

	//插入
	public void addRole(Role role) {		
		// TODO Auto-generated method stub
		try {
			roleDaoImpl.insertRole(role);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	//修改
	public void modifyRole(String name, String funcitonId) {
		// TODO Auto-generated method stub
		try {
			roleDaoImpl.updateRole(name, funcitonId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	//删除
	public void deleteRole(int id) {
		// TODO Auto-generated method stub
		try {
			roleDaoImpl.dropRole(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	}

	//根据ID查询功能名称
	public String getRoleFunction(int id) {
		// TODO Auto-generated method stub
		return roleDaoImpl.selectRoleFunction(id);
	}
	public PageShow getPage(String name,String pageNum){
		if (name == null || name.isEmpty()) {
			name="";
		}
		int total = this.getRole(name);
		PageShow page = new PageShow(total,pageNum,name);
		return page;
	}
	public List<Role> getRole(int start,int count,String name) {
		// TODO Auto-generated method stub
		return roleDaoImpl.selectRole(start, count, name);
	}
	public List<String> getRoleName() {
		
		return roleDaoImpl.selectRoleName();
	}

	public String getRoleNameByRoleId(int id) {
	String roleName = roleDaoImpl.selectRoleNameByRoleId(id);
		if(roleName == null){
			return "暂无职位";
		}else{
			return roleName;
		}	
	}

	public String getFunctionNameByRoleId(int roleId) {
		String functionsName = roleDaoImpl.selectFunctionNameByRoleId(roleId);
		if(functionsName == null){
			functionsName = "没有职位";
		}
		return functionsName;
	}
	public int getRoleId(String roleName) {
		// TODO Auto-generated method stub
		return roleDaoImpl.selectRoleId(roleName);
	}
	@Override
	public int getRole(String name) {
		
		return roleDaoImpl.selectRole(name);
	}
	

}
