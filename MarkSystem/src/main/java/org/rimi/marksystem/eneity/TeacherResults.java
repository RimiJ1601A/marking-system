package org.rimi.marksystem.eneity;

import java.util.List;
import java.util.Map;

public class TeacherResults {
	
	private User user;
	private Float average;
	private Float recent;
	
	private Map<String, List<String>> contentmap;				//评语
	
	private List<String> xEndTime;
	private List<Float> averagelist;
	private List<Float> recentlist;
	
	private int count;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Float getAverage() {
		return average;
	}
	public void setAverage(Float average) {
		this.average = average;
	}
	public Float getRecent() {
		return recent;
	}
	public void setRecent(Float recent) {
		this.recent = recent;
	}
	public Map<String, List<String>> getContentmap() {
		return contentmap;
	}
	public void setContentmap(Map<String, List<String>> contentmap) {
		this.contentmap = contentmap;
	}
	public List<String> getxEndTime() {
		return xEndTime;
	}
	public void setxEndTime(List<String> xEndTime) {
		this.xEndTime = xEndTime;
	}
	public List<Float> getAveragelist() {
		return averagelist;
	}
	public void setAveragelist(List<Float> averagelist) {
		this.averagelist = averagelist;
	}
	public List<Float> getRecentlist() {
		return recentlist;
	}
	public void setRecentlist(List<Float> recentlist) {
		this.recentlist = recentlist;
	}

	
	

	
	
}
