package org.rimi.marksystem.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rimi.marksystem.dao.FunctionDao;
import org.rimi.marksystem.eneity.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
@Component
public class FunctionDaoImpl implements FunctionDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Function> selectFunction() {
		List<Function> function = new ArrayList<>();
		function = jdbcTemplate.query("select * from function", new ResultSetExtractor<List<Function>>(){

			public List<Function> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Function> result = new ArrayList<>();
				while(rs.next()){
					Function f = new Function();
					f.setId(rs.getInt(1));
					f.setFunctionName(rs.getString(2));
					result.add(f);
				}
				return result;
			}
			
		});
		return function;
	}

}
