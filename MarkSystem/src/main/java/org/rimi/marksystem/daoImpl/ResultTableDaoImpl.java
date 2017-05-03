package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rimi.marksystem.dao.ResultTableDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.util.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
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

	@Override
	public List<ResultTable> getResultTables(int id) {
		 List<ResultTable> rtlist = new ArrayList<>();
		 rtlist = jdbcTemplate.query("select * from resulttable where evaluated_id = ?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, id);
				
			}
		}, new ResultSetExtractor<List<ResultTable>>() {

			@Override
			public List<ResultTable> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				 List<ResultTable> temprtlist = new ArrayList<>();
				while(rs.next()){
					ResultTable temtrt = new ResultTable();
					temtrt.setId(rs.getInt(1));
					temtrt.setQuizId(rs.getInt(2));
					temtrt.setAnswer(rs.getString(3));
					temtrt.setAnswerScore(String.valueOf( rs.getInt(4)));
					temtrt.setEvaluatedId(rs.getInt(5));
					temtrt.setEvaluationId(rs.getInt(6));
					temtrt.setMarktableId(rs.getInt(7));
					temtrt.setTeamId(rs.getInt(8));
					temprtlist.add(temtrt);
				}
				return temprtlist;
			}
		});
			
		return rtlist;
	}

	@Override
	public Quiz selectQuizById(int id) {
		Quiz quiz = new Quiz();
		quiz = jdbcTemplate.query("select * from quiz where id = ?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, id);
			}
		}, new ResultSetExtractor<Quiz>() {

			@Override
			public Quiz extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Quiz tempquiz = new Quiz();
				while(rs.next()){
					tempquiz.setId(rs.getInt(1));
					tempquiz.setQuizTitle(rs.getString(2));
					tempquiz.setQuizType(QuizType.getQuizType(rs.getString(3)));
				}
				return tempquiz;
			}
		});
		return quiz;
	}

	@Override
	public String getEndTimeById(int marktableId) {
		String endTime = "";
		endTime = jdbcTemplate.query("select end_time from marktable where id = ?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, marktableId);
			}
		}, new ResultSetExtractor<String>() {

			@Override
			public String extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				String endTime = "";
				while(rs.next()){
					endTime = rs.getString(1);
				}
				return endTime;
			}
		});
		return endTime;
	}

	@Override
	public List<ResultTable> getResultTablesByUserAndMarkId(int userId, int markTableId) {
		 List<ResultTable> rtlist = new ArrayList<>();
		 rtlist = jdbcTemplate.query("select * from resulttable where evaluated_id = ? and marktable_id =?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, userId);
				ps.setInt(2, markTableId);				
			}
		}, new ResultSetExtractor<List<ResultTable>>() {

			@Override
			public List<ResultTable> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				 List<ResultTable> temprtlist = new ArrayList<>();
				while(rs.next()){
					ResultTable temtrt = new ResultTable();
					temtrt.setId(rs.getInt(1));
					temtrt.setQuizId(rs.getInt(2));
					temtrt.setAnswer(rs.getString(3));
					temtrt.setAnswerScore(String.valueOf( rs.getInt(4)));
					temtrt.setEvaluatedId(rs.getInt(5));
					temtrt.setEvaluationId(rs.getInt(6));
					temtrt.setMarktableId(rs.getInt(7));
					temtrt.setTeamId(rs.getInt(8));
					temprtlist.add(temtrt);
				}
				return temprtlist;
			}
		});
			
		return rtlist;
	}

	
	
}
