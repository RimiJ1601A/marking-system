package org.rimi.marksystem.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.rimi.marksystem.dao.MarkDao;
import org.rimi.marksystem.dao.MarkTableDao;
import org.rimi.marksystem.dao.ResultTableDao;
import org.rimi.marksystem.dao.TeamDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.ResultScore;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserMarke;
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
	@Autowired
	private MarkDao markDao;
	
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
	@Override
	public List<ResultScore> getResultScoreByevalutedId(int evalutedId,int start,int num) {	
		List<UserMarke> umlist = markDao.selectUserMarkeByEvalutedId(evalutedId,start,num);
		return getRes(umlist);
	}
	@Override
	public List<ResultScore> getResultScoreAll(int start, int num) {
		List<UserMarke> umlist = markDao.selectUserMarkeAll(start,num);
		return getRes(umlist);
	}
	
	public List<ResultScore> getRes(List<UserMarke> umlist){
		List<ResultScore> rtlist = new ArrayList<ResultScore>();
		for (UserMarke userMarke : umlist) {
			MarkTable mt = markTableDapImpl.selectMarkTableByMarkTableId(userMarke.getMarktableId());
			User user = userDaoImpl.selectUserByid(userMarke.getEvaluatedId());
			Team team = teamDaoImpl.getTeamByiId(userMarke.getTeamId());		
			List<User> userlist = teamDaoImpl.selectUserId(team.getId(), 3);
			
			List<User> evalutionedUserlist = getEvalutionStudentByTeam(userMarke.getMarktableId(),userMarke.getEvaluatedId(),userMarke.getTeamId());		
			List<User> unUserlist = new ArrayList<User>();
			if(evalutionedUserlist!=null){
				for(int i = 0;i< userlist.size() ; i++) {
						for (User user3 : evalutionedUserlist) {
							if(userlist.get(i).getId()==user3.getId()){
								userlist.remove(i);
							}
						}
					}
			}
			for (int i=0 ;i<userlist.size() ; i++) {
				if(userlist.get(i).getId()!=-1){				
					unUserlist.add(userDaoImpl.selectUserByid(userlist.get(i).getId()));
				}
			}
			if(evalutionedUserlist!=null){
				userlist.removeAll(evalutionedUserlist);				
			}
			ResultScore rscore = new ResultScore(mt,user,team,evalutionedUserlist,unUserlist);
			rtlist.add(rscore);
		}
		return rtlist;
	}
}
