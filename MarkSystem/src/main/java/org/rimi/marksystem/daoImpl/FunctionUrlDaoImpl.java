package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.rimi.marksystem.dao.FunctionUrlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;


@Component
public class FunctionUrlDaoImpl implements FunctionUrlDao{

	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	
	@Override
	public String selectUrlByFunctionName(String name) {
		// TODO Auto-generated method stub
		String url = JdbcTemplate.query("select url from functionUrl where function_name = ?", new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1,name);
			}
			
		}, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				String urlName = null;
				while(rs.next()){
					urlName = rs.getString(1);
				}
				return urlName;
			}
		});
		return url;
	}
}
