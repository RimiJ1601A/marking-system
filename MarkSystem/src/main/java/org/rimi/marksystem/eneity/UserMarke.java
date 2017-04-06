package org.rimi.marksystem.eneity;

/*
 * 选定评分Team,评分人和被评分人
 */
public class UserMarke {
    private int id;
    private int teamId;						//评分班级ID
    private int evaluatedId;				//被评分人ID
    private int marktableId;				//评分表ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getEvaluatedId() {
		return evaluatedId;
	}
	public void setEvaluatedId(int evaluatedId) {
		this.evaluatedId = evaluatedId;
	}
	public int getMarktableId() {
		return marktableId;
	}
	public void setMarktableId(int marktableId) {
		this.marktableId = marktableId;
	}
    
    
}
