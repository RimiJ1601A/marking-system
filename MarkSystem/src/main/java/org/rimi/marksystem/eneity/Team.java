package org.rimi.marksystem.eneity;


import java.util.List;

/*
 * 团队类
 */
public class Team {
    private int id;
    private String teamName;		//班级名称
    private String buildTime;			//创建时间
    private int studentCount;		//学生人数
    private List<String> teacherName;		//教师姓名
    private List<String> students;	//学生姓名
    public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	
	public List<String> getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(List<String> teacherName) {
		this.teacherName = teacherName;
	}
	public List<String> getStudents() {
		return students;
	}
	public void setStudents(List<String> students) {
		this.students = students;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(String buildTime) {
		this.buildTime = buildTime;
	}
    
}
