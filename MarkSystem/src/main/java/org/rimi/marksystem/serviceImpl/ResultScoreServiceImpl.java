package org.rimi.marksystem.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.rimi.marksystem.dao.MarkTableDao;
import org.rimi.marksystem.dao.ResultTableDao;
import org.rimi.marksystem.dao.TeamDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserRseultTable;
import org.rimi.marksystem.service.ResultScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.fabric.xmlrpc.base.Array;

@Component
public class ResultScoreServiceImpl implements ResultScoreService{
	
	@Autowired
	private ResultTableDao resultTableDaoImpl;
	@Autowired
	private UserDao userDaoImpl;
	@Autowired
	private MarkTableDao markTableDapImpl;
	@Autowired
	private TeamDao teamDaoImpl;
	
	@Override
	public User getEndEvalutedTeacherId() {
		// TODO Auto-generated method stub
		List<User> templist = resultTableDaoImpl.selectEndEvalutedTeacherId();
		List<User> userlist = new ArrayList<User>();
		if(templist!=null && templist.size()!=0){
			for(int i=0;i<templist.size();i++){
				User user = userDaoImpl.selectUserByid(templist.get(i).getId());		
				userlist.add(user);
			}
			for(int i=0;i<templist.size();i++){
				if(userlist.get(i).getRoleId()==2){
					return userlist.get(i);
				}
			}				
		}	
		return null;
		
	}
	@Override
	public List<MarkTable> getMarkTableByEvalutedId(int evalutedUserId) {
		List<MarkTable> mtlist = markTableDapImpl.getMarkTableByEvalutedId(evalutedUserId);
		if(mtlist.size()==0){
			return null;
		}else{
			return mtlist;
		}
	}
	
	@Override
	public List<Team> getTeamByMarkTableId(int markTableId,int teacherId) {
		List<Integer> teamListId = resultTableDaoImpl.selectTeamByMarkTableId(markTableId,teacherId);
		List<Team> teamList = new ArrayList<Team>();
		if(teamListId.size()!=0){
			for (Integer teamId : teamListId) {
				Team team = new Team();
				team = teamDaoImpl.getTeamByiId(teamId);
				teamList.add(team);
			}
		}else{
			return null;
		}
		return teamList;
	}
	
	@Override
	public List<User> getEvalutionStudentByTeam(int markTableId,int teacherId,int teamId) {
		List<Integer> userIdlist = resultTableDaoImpl.selectEvalutionStudentEvalutionStudentByTeam(markTableId,teacherId,teamId);
		List<User> userlist = new ArrayList<User>();
		for (Integer userId : userIdlist) {
			User user = userDaoImpl.selectUserByid(userId);
			userlist.add(user);
		}
		if(userlist.size()!=0){
			return userlist;
		}else{
			return null;
		}
	}
	@Override
	public List<UserRseultTable> getMarkResult(int teacherId, int markTableId, int teamId, int evalutionUserId) {
		
		List<ResultTable> rtlist = resultTableDaoImpl.getMarkResult(teacherId,markTableId,teamId,evalutionUserId);	
		List<UserRseultTable> urtlist = new ArrayList<UserRseultTable>();
		for (ResultTable rt : rtlist) {
			UserRseultTable urt = new UserRseultTable();
			Quiz quiz = markTableDapImpl.getQuizById(rt.getQuizId());		
			urt.setQuiz(quiz);
			urt.setRt(rt);
			urtlist.add(urt);
		}
		
		return urtlist;
	}
	
}
