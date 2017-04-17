package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.eneity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	//查询所有职位
	public List<Role> selectRoleAll() {
		List<Role> result = new ArrayList<Role>();
		result = jdbcTemplate.query("select * from role", new ResultSetExtractor<List<Role>>(){

			public List<Role> extractData(ResultSet arg0) throws SQLException, DataAccessException {
				List<Role> s = new ArrayList<Role>();
				while(arg0.next()){
					Role role = new Role();
					List<String> function = new ArrayList<String>();
					role.setId(arg0.getInt(1));
					role.setRoleName(arg0.getString(2));
					role.setFunctionId(arg0.getString(3));
					String roleArray = arg0.getString(3);
					String[] idArray = roleArray.split(",");
					for (int i = 0; i < idArray.length; i++) {
						int id = Integer.parseInt(idArray[i]);
						String functionName = selectRoleFunction(id);
						function.add(functionName);
					}
					role.setFunction(function);
					role.setBuildTime(arg0.getString(4));
					s.add(role);
				}
				
				return s;
			}		
			
		});
		return result;
	}
	//查询总数
	public int selectRoleCount() {
		int result = jdbcTemplate.queryForObject("select count(*) from role", Integer.class);
		return result;
	}
	//分页查询
	public List<Role> selectRolePage(final int start, final int count) {
		List<Role> result = new ArrayList<Role>();
		result = jdbcTemplate.query("select * from role limit ?,?", new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, start);
				ps.setInt(2, count);
			}
			
		}, new ResultSetExtractor<List<Role>>(){

			public List<Role> extractData(ResultSet arg0) throws SQLException, DataAccessException {
				List<Role> s = new ArrayList<Role>();
				while(arg0.next()){
					Role role = new Role();
					List<String> function = new ArrayList<String>();
					role.setId(arg0.getInt(1));
					role.setRoleName(arg0.getString(2));
					role.setFunctionId(arg0.getString(3));
					String roleArray = arg0.getString(3);
					String[] idArray = roleArray.split(",");
					for (int i = 0; i < idArray.length; i++) {
						int id = Integer.parseInt(idArray[i]);
						String functionName = selectRoleFunction(id);
						function.add(functionName);
					}
					role.setFunction(function);
					role.setBuildTime(arg0.getString(4));
					s.add(role);
				}
				
				return s;
			}
			
		});
		return result;
	}
	//插入
	public void insertRole(Role role) {
		jdbcTemplate.update("INSERT INTO role(role_name,function_id,bulid_time)VALUES(?,?,?)", role.getRoleName(),role.getFunctionId(),role.getBuildTime());
		
	}
	//删除
	public void dropRole(int id) {
		jdbcTemplate.update("delete from role where id =?", id);
		
	}
	//根据ID查功能名称
	public String selectRoleFunction(final int id) {
		String relust = null;
		relust = jdbcTemplate.query("select * from function where id = ?", new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, id);
			}
			
		}, new ResultSetExtractor<String>(){
			public String extractData(ResultSet arg0) throws SQLException, DataAccessException {
				String s = new String();
				while(arg0.next()){
					s= arg0.getString(2);
				}
				return s;
			}
			
		});
		return relust;
	}
	public List<Role> selectRole(final int start,final int count,final String name) {
		List<Role> relust = new ArrayList<Role>();
		relust = jdbcTemplate.query("select * from role where role_name like ? limit ?,?", new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, "%"+name+"%");
				ps.setInt(2, start);
				ps.setInt(3, count);
			}
			
		}, new ResultSetExtractor<List<Role>>() {
			List<Role> s = new ArrayList<Role>();
			public List<Role> extractData(ResultSet arg0) throws SQLException, DataAccessException {
				while(arg0.next()){
					Role role = new Role();
					List<String> function = new ArrayList<String>();
					role.setId(arg0.getInt(1));
					role.setRoleName(arg0.getString(2));
					role.setFunctionId(arg0.getString(3));
					String roleArray = arg0.getString(3);
					String[] idArray = roleArray.split(",");
					for (int i = 0; i < idArray.length; i++) {
						int id = Integer.parseInt(idArray[i]);
						String functionName = selectRoleFunction(id);
						function.add(functionName);
					}
					role.setFunction(function);
					role.setBuildTime(arg0.getString(4));
					s.add(role);
				}
				return s;
			}
		});
		return relust;
	}
	//修改
	public void updateRole(String name, String funcitonId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("update role set function_id = ? where role_name = ?", funcitonId,name);
	}

}
