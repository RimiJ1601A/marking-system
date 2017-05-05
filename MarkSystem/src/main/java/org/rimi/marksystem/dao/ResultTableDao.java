package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;

@Component
public interface ResultTableDao {
	
	/*
	 * 插入一张试卷的问题回答结果
	 */
	public void insertResultTable(List<ResultTable> resultTable);
	
	/*
	 * 根据评分人查询评分结果
	 */
	public ResultTable selectResultTableByEvaluationId(MarkTable markTable,User user);
	
	
	/*
	 * 根据被评分人查询评分结果
	 */
	public List<ResultTable> selectResultTableByEvaluatedId(MarkTable markTable,User user);


	
	/*
	 * 根据班级名查询班级ID
	 */
	
	public int selectTeamId(String teamName);
	
	
	public List<ResultTable> getResultTables(int userId);
	
	public Quiz selectQuizById(int id);
	
	public String getEndTimeById(int marktableId);
	
	public List<ResultTable> getResultTablesByUserAndMarkId(int userId,int markTableId);
	
	
	/***
	 * 获取最后一次被评分的老师Id
	 * @return
	 */
	public List<User> selectEndEvalutedTeacherId();
	
	/***
	 * 根据评分表ID获取评分班级Id
	 * @param markTableId
	 * @return
	 */
	public List<Integer> selectTeamByMarkTableId(int markTableId,int teacherId);
	
	/***
	 * 获取已评价学生
	 * @param markTableId
	 * @param teacherId
	 * @param teamId
	 * @return
	 */
	public List<Integer> selectEvalutionStudentEvalutionStudentByTeam(int markTableId,int teacherId,int teamId);
	
	/***
	 * 获取评价的具体信息
	 * @param teacherId
	 * @param markTableId
	 * @param teamId
	 * @param evalutionUserId
	 * @return
	 */
	public List<ResultTable> getMarkResult(int teacherId, int markTableId, int teamId, int evalutionUserId);
	
}
