package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.QuizContent;
import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.rimi.marksystem.eneity.UserMarke;
import org.springframework.stereotype.Component;


@Component
public interface MarkDao {
	/**
	 * 根据用户ID 查询班级ID
	 */
	public List<Integer> selectTeamId(int id);
	
	
	/**
	 * 根据班级ID 返回表
	 *   select marktable.id,name,start_time,end_time from user_marke,marktable where user_marke.marktable_id = marktable.id and team_id = 1;
	 *   
	 */
	public List<RequestMarkTableQuiz> selectRequestMarkTableQuiz(int id);
	
	
	/**
	 *  根据marktable_id 返回quiz_id
	 */
	public List<Integer> selectQuiz_id(int id);
	
	/**
	 * 根据quiz_id 返回 Quiz
	 *   select quiz_content,quiz_score from quiz_content where quiz_id =1;
	 */
	
	public Quiz selectQuiz(int id);
	
	
	/**
	 * 根据quiz_id 返回 List<quizContent>
	 */
	
	public List<QuizContent> selectquizContent(int id);
	
	/**
	 * 根据 user_id 和marktable_id 去结果表查看是否有评价的数据，如果没有返回false，如果有返回true
	 */
	
	public List<Integer> selectResultInfo(int user_id,int marktable_id);
	
	
	public List<UserMarke> selectUserMarkeByEvalutedId(int evalutedId);
	
}
