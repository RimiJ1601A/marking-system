package org.rimi.marksystem.eneity;

public class RequestMarkTableQuiz {
    private int marktableId; //评分表ID
    private String startTime;			//评分开始时间
    private String endTime;			//评分结束时间
    private String name; //评分表name
    private String teamName;   //需要评分的 班级名字
    private String evaluatedName; //被评分人名字
	public int getMarktableId() {
		return marktableId;
	}
	public void setMarktableId(int marktableId) {
		this.marktableId = marktableId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getEvaluatedName() {
		return evaluatedName;
	}
	public void setEvaluatedName(String evaluatedName) {
		this.evaluatedName = evaluatedName;
	}
    
}
