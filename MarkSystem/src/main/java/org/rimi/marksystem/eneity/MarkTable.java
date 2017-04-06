package org.rimi.marksystem.eneity;

import java.util.Date;

/*
 * 评分表类
 */
public class MarkTable { 
    private int id;
    private String name;			//评分表名字
    private Date startTime;			//评分开始时间
    private Date endTime;			//评分结束时间
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
    
}
