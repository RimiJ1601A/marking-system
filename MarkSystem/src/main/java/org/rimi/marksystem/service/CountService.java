package org.rimi.marksystem.service;

import java.util.Date;
import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.TeacherResults;
import org.rimi.marksystem.eneity.TeamAndUser;

public interface CountService {
	
	
	public List<TeamAndUser> getTeamAndUser();
    
    
    //统计图表的开始时间
    public Date countBegintime();
    //获得指定年的月份数据
    public List<String> getXaxis(int year);
    //获得指定年的人数统计数据
    public List<Long> getYaxis(int year);
    //获得指定年前一年的人数统计数据
    public List<Long> getLastYaxis(int lastyear);
    
    /***
     * 获取被评老师最新数据
     * @return
     */
    public TeacherResults getTeachersResults(int id);
	
}
