package org.rimi.marksystem.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.rimi.marksystem.dao.MarkTableDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.MarkTableTeam;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.QuizContent;
import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserMarke;
import org.rimi.marksystem.util.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;


@Component
public class MarkTableDaoImpl implements MarkTableDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * 插入一张评分表
	 */
	public void insertMarkeTable(MarkTable marktable) {
		// TODO Auto-generated method stub
		
		/*
		 * 首先插入markTable 一条数据
		 */
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = df.format(new Date()); 
		jdbcTemplate.update("INSERT INTO marktable(name,start_time,end_time) VALUES(?,?,?)",marktable.getName(),datetime,marktable.getEndTime());
		
		//获取当前评分表的ID字段
/*		int ID = selectCurrentMarketTableID();
		List<MarkTableQuiz> mtq = marktable.getMarkTableQuiz();
		for (MarkTableQuiz markTableQuiz : mtq) {
			insertMarkeTable_quiz(markTableQuiz.getQuizId(),ID);
		}
		
		List<UserMarke> um = marktable.getUserMarke();
		for (UserMarke userMarke : um) {
			insertUsermarke(userMarke.getTeamId(), userMarke.getEvaluatedId(), ID);
		}*/
	}
	
	/*
	 * 查询所有评分表
	 */
	public List<MarkTable> selectMarkeTable() {
		List<MarkTable> mtlist = new ArrayList<MarkTable>();
		mtlist = jdbcTemplate.query("select * from marktable order by id desc",new ResultSetExtractor<List<MarkTable>>(){

			@Override
			public List<MarkTable> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<MarkTable> templist = new ArrayList<MarkTable>();
				while(rs.next()){
					MarkTable mt = new MarkTable();
					mt.setId(rs.getInt(1));
					mt.setName(rs.getString(2));
					mt.setStartTime(rs.getString(3));
					mt.setEndTime(rs.getString(4));
					templist.add(mt);
				}
				return templist;
			}
		
		});
		return mtlist;
	}

	
	/**
	 * 插入
	 */
	public int insertMarkeTable_quiz(int quizId, int marktableId) {
		// TODO Auto-generated method stub
		
		int i = jdbcTemplate.update("INSERT INTO marktable_quiz (quiz_id,marktable_id) VALUES(?,?)", quizId,marktableId);
		return i;
	}

	public List<Quiz> selectQuizs() {
		// TODO Auto-generated method stub
		final List<Quiz> quizs = jdbcTemplate.query("select * from Quiz", new ResultSetExtractor<List<Quiz>>(){

			public List<Quiz> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<Quiz> qs = new ArrayList<Quiz>();
				while(rs.next()){
					Quiz quiz = new Quiz();
					quiz.setId(rs.getInt(1));
					quiz.setQuizTitle(rs.getString(2));
					qs.add(quiz);
				}
				return qs;
			}
		});
		return quizs;
	}

	public int selectCurrentMarketTableID(){
		int mtId = jdbcTemplate.query("select max(id) from marktable", new ResultSetExtractor<Integer>(){

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Integer id = null;
				while(rs.next()){
					id = rs.getInt(1);
				}
				return id;
			}
			
		});
		return mtId;
	}

	
	/**
	 * 评分班级 被评分人 评分表ID 插入
	 */
	public void insertUsermarke(int teamId, int evaluatedId, int marktableId) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO user_marke (team_id,evaluated_id,marktable_id) VALUES(?,?,?)", teamId,evaluatedId,marktableId);
	}

	public MarkTableTeam selectMarkeTableTeam(final int teamId) {
		// TODO Auto-generated method stub
		MarkTableTeam markTableTeam = jdbcTemplate.query("select user_name,user_id,user.role_id,team_id,team_name from u_p_t,user,team where user.id = u_p_t.user_id and u_p_t.team_id = team.id and team_id = ?", new PreparedStatementSetter() {
			
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, teamId);
			}
		}, new ResultSetExtractor<MarkTableTeam>() {

			public MarkTableTeam extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<User> users = new ArrayList<User>();
				MarkTableTeam mtt = new MarkTableTeam();
				while(rs.next()){
					User user = new User();
					user.setUserName(rs.getString(1));
					user.setId(rs.getInt(2));
					user.setRoleId(rs.getInt(3));
					users.add(user);
					mtt.setUsers(users);
					mtt.setTeamId(rs.getInt(4));
					mtt.setTeamName(rs.getString(5));
				}
				return mtt;
			}
			
		});
		return markTableTeam;
	}

	//查询所有班级 及对应 人
	public List<MarkTableTeam> selectAllMarkeTableTeam() {
		// TODO Auto-generated method stub
		List<MarkTableTeam> mttss = jdbcTemplate.query("select * from team", new ResultSetExtractor<List<MarkTableTeam>>(){

			public List<MarkTableTeam> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<MarkTableTeam> mtts = new ArrayList<MarkTableTeam>();
				while(rs.next()){
					MarkTableTeam mtt = new MarkTableTeam();
					mtt.setTeamId(rs.getInt(1));
					mtt.setTeamName(rs.getString(2));
					mtt.setUsers(selectMarkeTableTeam(mtt.getTeamId()).getUsers());
					mtts.add(mtt);
				}
				return mtts;
			}
			
		});
		return mttss;
	}
	public void insertQuizs(List<Quiz> quizs) {
		// TODO Auto-generated method stub
		for (Quiz quiz : quizs) {
			insertQuiz(quiz);
		}
	}

	public void insertQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO quiz (quiz_title,quiz_type) VALUE(?,?)", quiz.getQuizTitle(),QuizType.CHOICE_QUESTION.getType());
		int id = selectCurrentQuizID();
		insertQuiz_content(id, quiz);
	}

	public void insertQuiz_content(int quizId,Quiz quiz) {
		// TODO Auto-generated method stub
		for (QuizContent qc  : quiz.getQuizContent()) {
			jdbcTemplate.update("INSERT INTO quiz_content (quiz_id,quiz_content,quiz_score) VALUES (?,?,?)", 
					quizId,qc.getContent(),qc.getQuizCore());
		}
	}

	public int selectCurrentQuizID() {
		// TODO Auto-generated method stub
		int Id = jdbcTemplate.query("select max(id) from quiz", new ResultSetExtractor<Integer>(){

			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				Integer id = null;
				while(rs.next()){
					id = rs.getInt(1);
				}
				return id;
			}
			
		});
		return Id;
	}

	@Override

	public void insertEssayQuestion(Quiz quiz) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("INSERT INTO quiz (quiz_title,quiz_type) VALUE(?,?)", quiz.getQuizTitle(),QuizType.ESSAY_QUESTION.getType());
	}

	public List<UserMarke> selectUserMarkeBymarktableId(int id) {
		List<UserMarke> umlist = new ArrayList<>();
		umlist = jdbcTemplate.query("select * from user_marke where marktable_id = ?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, id);
			}
		}, new ResultSetExtractor<List<UserMarke>>() {

			@Override
			public List<UserMarke> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<UserMarke> templist = new ArrayList<>();
				while(rs.next()){
					UserMarke um = new UserMarke();
					um.setId(rs.getInt(1));
					um.setTeamId(rs.getInt(2));
					um.setEvaluatedId(rs.getInt(3));
					um.setMarktableId(rs.getInt(4));
					templist.add(um);	
				}
				return templist;
			}
		});
		return umlist;
	}

	@Override
	public List<RequestMarkTableQuiz> selectEightInfo() {
		List<RequestMarkTableQuiz> rMarkTableQuizs = jdbcTemplate.query("select team_name,evaluated_id,user_name,marktable_id,name,start_time,end_time from user,team,user_marke,marktable where user_marke.marktable_id = marktable.id and user_marke.team_id = team.id and user_marke.evaluated_id = user.id and user.id = user_marke.evaluated_id order by start_time DESC limit 0,8", new ResultSetExtractor<List<RequestMarkTableQuiz>>(){

			@Override
			public List<RequestMarkTableQuiz> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<RequestMarkTableQuiz> rmtqs = new ArrayList<>();
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
		return rMarkTableQuizs;
	}	
}
