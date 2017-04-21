package org.rimi.marksystem.eneity;

import java.util.List;
import java.util.Map;

/*
 * 评分表类
 */
public class MarkTable { 
    
	private int id;
    private String name;			//评分表名字
    private String startTime;			//评分开始时间
    private String endTime;			//评分结束时间    
    
    private List<MarkTableQuiz> markTableQuiz;			//评分问题list   
    private List<UserMarke> userMarke;					//评分班级和评分人list
 
    
    
    Map<team_Id, map<MarkTable_id,marktable>
    
    
    public List<MarkTableQuiz> getMarkTableQuiz() {
		return markTableQuiz;
	}
	public void setMarkTableQuiz(List<MarkTableQuiz> markTableQuiz) {
		this.markTableQuiz = markTableQuiz;
	}
	public List<UserMarke> getUserMarke() {
		return userMarke;
	}
	public void setUserMarke(List<UserMarke> userMarke) {
		this.userMarke = userMarke;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
    
}
