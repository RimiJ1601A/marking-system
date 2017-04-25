package org.rimi.marksystem.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.rimi.marksystem.dao.ResultTableDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class ResultTableDaoImpl implements ResultTableDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * 插入一张试卷的问题回答结果
	 */
	public void insertResultTable(List<ResultTable> resultTable) {
		// TODO Auto-generated method stub
		for (ResultTable resultTable2 : resultTable) {
			jdbcTemplate.update("INSERT INTO resulttable (quiz_id,answer,answer_score,evaluated_id,evaluation_id,marktable_id,team_id) VALUES(?,?,?,?,?,?,?)",
					resultTable2.getQuizId(),resultTable2.getAnswer(),resultTable2.getAnswerScore(),resultTable2.getEvaluatedId(),resultTable2.getEvaluationId(),resultTable2.getMarktableId(),resultTable2.getTeamId());
		}
	}
	
	/*
	 * 根据评分人查询评分结果
	 */
	public ResultTable selectResultTableByEvaluationId(MarkTable markTable, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 根据被评分人查询评分结果
	 */
	public List<ResultTable> selectResultTableByEvaluatedId(MarkTable markTable, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectTeamId(String teamName) {
		// TODO Auto-generated method stub
		int teamId = jdbcTemplate.query("select id from team where team_name = "+teamName+"", new ResultSetExtractor<Integer>(){

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Integer teamId = null;
				while(rs.next()){
					teamId = rs.getInt(1);
				}
				return teamId;
			}
			
		});
		return teamId;
	}

	
	
}
