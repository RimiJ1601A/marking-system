package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.rimi.marksystem.dao.MarkDao;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.QuizContent;
import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.rimi.marksystem.eneity.UserMarke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class MarkDaoImpl implements MarkDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Integer> selectTeamId(int id) {
		// TODO Auto-generated method stub
		
		List<Integer>  teamIds = jdbcTemplate.query("select team_id from u_p_t where user_id = "+id+"", new ResultSetExtractor<List<Integer>>(){

			public List<Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Integer> teamids = new ArrayList<Integer>();
				while(rs.next()){
					Integer teamId = rs.getInt(1);
					teamids.add(teamId);
				}
				return teamids;
			}
			
		});
		return teamIds;
	}

	public List<RequestMarkTableQuiz> selectRequestMarkTableQuiz(int id) {
		// TODO Auto-generated method stub
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = dFormat.format(new Date());
		List<RequestMarkTableQuiz> requestMarkTableQuizs = jdbcTemplate.query("select team_name,evaluated_id,user_name,marktable_id,name,start_time,end_time from user,team,user_marke,marktable where user_marke.marktable_id = marktable.id and user_marke.team_id = team.id and user_marke.evaluated_id = user.id and user.id = user_marke.evaluated_id and team_id = "+id+" HAVING end_time >= '"+datetime+"' order by end_time DESC", new ResultSetExtractor<List<RequestMarkTableQuiz>>(){

			public List<RequestMarkTableQuiz> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<RequestMarkTableQuiz> rmtqs = new ArrayList<RequestMarkTableQuiz>();
				while(rs.next()){
					RequestMarkTableQuiz rmtq = new RequestMarkTableQuiz();
					rmtq.setTeamName(rs.getString(1));
					rmtq.setEvalueateId(rs.getInt(2));
					rmtq.setEvaluatedName(rs.getString(3));
					rmtq.setMarktableId(rs.getInt(4));
					rmtq.setName(rs.getString(5));
					rmtq.setStartTime(rs.getString(6));
					rmtq.setEndTime(rs.getString(7));
					rmtqs.add(rmtq);
				}
				return rmtqs;
			}
			
		});
		return requestMarkTableQuizs;
	}

	public List<Integer> selectQuiz_id(int id) {
		// TODO Auto-generated method stub
		
		List<Integer> quizids = jdbcTemplate.query("select quiz_id from marktable_quiz where marktable_id = "+id+"", new ResultSetExtractor<List<Integer>>(){

			public List<Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Integer> quizIds = new ArrayList<Integer>();
				while(rs.next()){
					int id = rs.getInt(1);
					quizIds.add(id);
				}
				return quizIds;
			}
			
		});
		return quizids;
	}

	public Quiz selectQuiz(final int id) {
		// TODO Auto-generated method stub
		Quiz qz = jdbcTemplate.query("select * from quiz where id = "+id+"", new ResultSetExtractor<Quiz>(){

			public Quiz extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Quiz quiz = new Quiz();
				while(rs.next()){
					quiz.setId(rs.getInt(1));
					quiz.setQuizTitle(rs.getString(2));
					quiz.setQuizContent(selectquizContent(id));
				}
				return quiz;
			}
			
		});
		return qz;
	}

	public List<QuizContent> selectquizContent(int id) {
		// TODO Auto-generated method stub
		
		List<QuizContent> quizContents = jdbcTemplate.query("select quiz_id,quiz_content,quiz_score from quiz_content where quiz_id = "+id+"", new ResultSetExtractor<List<QuizContent>>(){

			public List<QuizContent> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<QuizContent> qcs = new ArrayList<QuizContent>();
				while(rs.next()){
					QuizContent qc = new QuizContent();
					qc.setQuizId(rs.getInt(1));
					qc.setContent(rs.getString(2));
					qc.setQuizCore(rs.getInt(3));
					qcs.add(qc);
				}
				return qcs;
			}
			
		});
		return quizContents;
	}

	@Override
	public List<Integer> selectResultInfo(int user_id, int marktable_id) {
		List<Integer> count = jdbcTemplate.query("select id from resulttable where evaluation_id = "+user_id+" and marktable_id = "+marktable_id+"", new ResultSetExtractor<List<Integer>>(){

			@Override
			public List<Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Integer> integers = new ArrayList<>();
				while(rs.next()){
					int id = rs.getInt(1);
					integers.add(id);
				}
				return integers;
			}

		});
		return count;
	}

	@Override
	public List<UserMarke> selectUserMarkeByEvalutedId(int evalutedId,int start,int num) {
		List<UserMarke> umlist = jdbcTemplate.query("select * from user_marke where evaluated_id = ? order by id desc limit ?,?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, evalutedId);
					ps.setInt(2, start);
					ps.setInt(3, num);
			}
		}, new ResultSetExtractor<List<UserMarke>>() {

			@Override
			public List<UserMarke> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserMarke> umlist = new ArrayList<UserMarke>();
				while(rs.next()){
					UserMarke um = new UserMarke();
					um.setId(rs.getInt(1));
					um.setTeamId(rs.getInt(2));
					um.setEvaluatedId(rs.getInt(3));
					um.setMarktableId(rs.getInt(4));
					umlist.add(um);
				}
				return umlist;
			}
		});
		
		return umlist;
	}

	@Override
	public List<UserMarke> selectUserMarkeAll(int start, int num) {
		List<UserMarke> umlist = jdbcTemplate.query("select * from user_marke order by id desc limit ?,?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
					ps.setInt(1, start);
					ps.setInt(2, num);
			}
		}, new ResultSetExtractor<List<UserMarke>>() {

			@Override
			public List<UserMarke> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserMarke> umlist = new ArrayList<UserMarke>();
				while(rs.next()){
					UserMarke um = new UserMarke();
					um.setId(rs.getInt(1));
					um.setTeamId(rs.getInt(2));
					um.setEvaluatedId(rs.getInt(3));
					um.setMarktableId(rs.getInt(4));
					umlist.add(um);
				}
				return umlist;
			}
		});		
		return umlist;
	}

	@Override
	public Integer selectAllCountUserMarke() {
		return jdbcTemplate.queryForObject("select count(*) from user_marke", Integer.class);
	}
	
}
