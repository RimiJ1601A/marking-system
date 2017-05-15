package org.rimi.marksystem.serviceImpl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.rimi.marksystem.dao.FunctionDao;
import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.eneity.Function;
import org.rimi.marksystem.eneity.Role;
import org.rimi.marksystem.service.RoleService;
import org.rimi.marksystem.util.ConstantClassField;
import org.rimi.marksystem.util.MSSheet;
import org.rimi.marksystem.util.PageShow;
import org.rimi.marksystem.util.PathCostant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jxl.write.WriteException;
@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDaoImpl;
	@Autowired
	private FunctionDao functionDaoImpl;
	private Logger logger = Logger.getLogger(RoleServiceImpl.class);
	//查询所有职位
	public List<Role> getRoleAll() {
		return roleDaoImpl.selectRoleAll();
	}
	//查询总数
	public int getRoleCount() {
		
		return roleDaoImpl.selectRoleCount();
	}

	//分页查询
	public List<Role> getRolePage(int start, int count) {
		
		return roleDaoImpl.selectRolePage(start, count);
	}

	//插入
	public void addRole(Role role) {		
		// TODO Auto-generated method stub
		try {
			roleDaoImpl.insertRole(role);
		} catch (Exception e) {
			
			logger.error(e);
		}
	}

	//修改
	public void modifyRole(String name, String funcitonId) {
		
		try {
			roleDaoImpl.updateRole(name, funcitonId);
		} catch (Exception e) {
			
			logger.error(e);
		}
	}

	//删除
	public void deleteRole(int id) {
		// TODO Auto-generated method stub
		try {
			roleDaoImpl.dropRole(id);
		} catch (Exception e) {
			
			logger.error(e);
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
	@Override
	public List<Function> getFuntion() {
		// TODO Auto-generated method stub
		return functionDaoImpl.selectFunction();
	}
	@Override
	public void addSuccessOrError(String name,String functionId) {
		//判断是否存在此职位名称
				boolean exits = false;
				List<String> roleNames = this.getRoleName();
				if(roleNames.contains(name)){
					exits = true;
				}
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String sj = sdf.format(date);
				Role role = new Role();
				role.setRoleName(name);
				role.setFunctionId(functionId);
				role.setBuildTime(sj);
				if(exits == true || name == null || name.isEmpty() || functionId == null || functionId.isEmpty()){
					logger.error("添加职位不成功,输入为空或已存在");
				}else{
					this.addRole(role);
				}
	}
	
	public void exportRoleEcel(String path, String name) {
		if (name == null || name.isEmpty()) {
			name = PathCostant.ROLE_DEFAULT_NAME;
		}
		if (path == null || path.isEmpty()) {
			path = PathCostant.DEFAULT_PATH;
		}

		List<String> titles = new ArrayList<>();
		titles.add("职位名称");
		titles.add("功能名称");
		titles.add("创建日期");
		
		List<String> needProperties = new ArrayList<>();
		needProperties.add("roleName");
		needProperties.add("function");
		needProperties.add("buildTime");
		
		try {
			MSSheet msSheet = new MSSheet(titles, this.getRoleAll(),needProperties, path + name, "职位表", 0);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			logger.error(e);
		} catch (WriteException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
	}
	

}
