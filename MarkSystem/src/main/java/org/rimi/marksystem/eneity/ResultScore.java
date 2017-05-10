package org.rimi.marksystem.eneity;

import java.util.List;

public class ResultScore {
	
	private MarkTable markTable;			//考核试卷
	
	private User user;						//被评分人
	
	private Team team;						//考核班级
	
	private List<User> evaluationStudent;		//已评价学生
		
	private List<User> unevaluationStudent;		//未评价学生

	
	public ResultScore(){
		
	}
	public ResultScore(MarkTable markTable,User user,Team team,List<User> evaluationStudent,List<User> unevaluationStudent){
		this.markTable=markTable;
		this.user=user;
		this.team=team;
		this.evaluationStudent=evaluationStudent;
		this.unevaluationStudent=unevaluationStudent;
	}
	public MarkTable getMarkTable() {
		return markTable;
	}

	public void setMarkTable(MarkTable markTable) {
		this.markTable = markTable;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<User> getEvaluationStudent() {
		return evaluationStudent;
	}

	public void setEvaluationStudent(List<User> evaluationStudent) {
		this.evaluationStudent = evaluationStudent;
	}

	public List<User> getUnevaluationStudent() {
		return unevaluationStudent;
	}

	public void setUnevaluationStudent(List<User> unevaluationStudent) {
		this.unevaluationStudent = unevaluationStudent;
	}
	
	
	
}
