package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.MarkTableTeam;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.UserMarke;
import org.springframework.stereotype.Component;

/*
 * 评分表DAO
 */
@Component
public interface MarkTableDao {
	
	/*
	 * 插入一张评分表
	 */
	public void insertMarkeTable(MarkTable marktable);
	
	/*
	 * 查询所有评分表
	 */
	public List<MarkTable> selectMarkeTable();
	
	/*
	 * 插入问题ID，表ID
	 */
	public int insertMarkeTable_quiz(int quizId,int marktableId);
	
	/**
	 * 查询所有问题
	 * @return
	 */
	public List<Quiz> selectQuizs();
	
	/**
	 * 插入 u_p_t表
	 * @param teamId
	 * @param evaluatedId
	 * @param marktableId
	 */
	public void insertUsermarke(int teamId,int evaluatedId,int marktableId);
	
	
	/*
	 * 查询当前评分表ID
	 */
	public int selectCurrentMarketTableID();
	
	public MarkTableTeam selectMarkeTableTeam(int teamId);
	
	public List<MarkTableTeam> selectAllMarkeTableTeam();
	
	/*
	 * 插入 问题List
	 */
	public void insertQuizs(List<Quiz> quizs);
	
	/*
	 * 单条插入选择题问题
	 */
	public void insertQuiz(Quiz quiz);
	
	/*
	 * 插入quiz_content
	 */
	public void insertQuiz_content(int quizId,Quiz quiz);
	
	/*
	 * 查询当前Quiz ID
	 */
	public int selectCurrentQuizID();
	
	

	/**
	 * 插入问答题
	 */
	public void insertEssayQuestion(Quiz quiz);


	public List<UserMarke> selectUserMarkeBymarktableId(int id); 

	
	public List<MarkTable> getMarkTableByEvalutedId(int evalutedUserId);
	
	public Quiz getQuizById(int quizId);
	
}
