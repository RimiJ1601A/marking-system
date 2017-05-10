package org.rimi.marksystem.service;

import java.util.List;
import java.util.Map;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.ResultScore;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserRseultTable;
import org.springframework.stereotype.Component;

@Component
public interface ResultScoreService {
	
	
	/***
	 * 获取最后一次被评分的老师
	 * @return
	 */
	public User getEndEvalutedTeacherId();
	
	/***
	 * 获取被评分人的考核
	 * @param evalutedUserId
	 * @return
	 */
	public List<MarkTable> getMarkTableByEvalutedId(int evalutedUserId);

	/***
	 * 根据被评分人获取考核的班级
	 * @param markTableId
	 * @return
	 */
	public List<Team> getTeamByMarkTableId(int markTableId,int teacherId);
	
	/***
	 * 根据考核班级获取已评价人
	 * @param teamId
	 * @return
	 */
	public List<User> getEvalutionStudentByTeam(int markTableId,int teacherId,int teamId);
	
	/***
	 * 查询某次学生的具体考核分数
	 * @param teacherId
	 * @param markTableId
	 * @param teamId
	 * @param evalutionUserId
	 * @return
	 */
	public List<UserRseultTable> getMarkResult(int teacherId,int markTableId,int teamId,int evalutionUserId);
	
	
	public List<ResultScore> getResultScoreByevalutedId(int evalutedId);
}
