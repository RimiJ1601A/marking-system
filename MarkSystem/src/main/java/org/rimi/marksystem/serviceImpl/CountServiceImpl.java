package org.rimi.marksystem.serviceImpl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.rimi.marksystem.dao.MarkTableDao;
import org.rimi.marksystem.dao.ResultTableDao;
import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.dao.TeamDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.daoImpl.RoleDaoImpl;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.TeacherResults;
import org.rimi.marksystem.eneity.TeamAndUser;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserMarke;
import org.rimi.marksystem.service.CountService;
import org.rimi.marksystem.service.ResultTableService;
import org.rimi.marksystem.util.QuizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountServiceImpl implements CountService {

	@Autowired
	private UserDao userDaoImpl;
	@Autowired
	private MarkTableDao markTableDaoImpl;
	@Autowired
	private TeamDao teamDaoImpl;
	@Autowired
	private ResultTableDao resultTableDaoImpl;
	@Autowired
	private RoleDao roleDaoImpl;
	
	@Override
    /**
     * 统计图表开始时间
     */
	public Date countBegintime() {
		List<User> users = new ArrayList<>();
		Date date = null;
		users = userDaoImpl.selectAllUser();

		Collections.sort(users, new Comparator() {
			@Override
			// 比较方法
			public int compare(Object arg0, Object arg1) {

				User user0 = (User) arg0;
				User user1 = (User) arg1;
				int flag = user0.getBulidTime().compareTo(user1.getBulidTime());
				return flag;

			}

		});
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strdate = users.get(0).getBulidTime();
		try {
			date = sdf.parse(strdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

    
    @Override
    // 获得指定年的月份数据
    
    public List<String> getXaxis(int year) {
        List<String> month = new ArrayList<>();
        List<Map<String, Object>> lists = userDaoImpl.selectNewUsers(year);
        for (Map<String, Object> map : lists) {
            
            month.add((String) map.values().toArray()[0]);
            
        }
        return month;
    }
    
    
    @Override
    // 获得指定年的人数统计数据
    
    public List<Long> getYaxis(int year) {
        List<Long> newSum = new ArrayList<>();
        List<Map<String, Object>> lists = userDaoImpl.selectNewUsers(year);
        for (Map<String, Object> map : lists) {
            
            newSum.add((Long) map.values().toArray()[1]);
            
        }
        return newSum;
    }
    
    @Override
    // 获得指定年前一年的人数统计数据
    
    public List<Long> getLastYaxis(int lastyear) {
        List<Long> newLastSum = new ArrayList<>();
        List<Map<String, Object>> lists = userDaoImpl.selectlastNewUsers(lastyear);
        for (Map<String, Object> map : lists) {
            
            newLastSum.add((Long) map.values().toArray()[1]);
            
        }
        
        return newLastSum;
    }
    
    
   
    
	@Override
	public List<TeamAndUser> getTeamAndUser() {
		List<TeamAndUser> tulist = new ArrayList<>();
		List<MarkTable> mtlist = new ArrayList<>();
		mtlist = markTableDaoImpl.selectMarkeTable();
		for(int i =0;i<mtlist.size();i++){
			List<UserMarke> um = markTableDaoImpl.selectUserMarkeBymarktableId(mtlist.get(i).getId());
			mtlist.get(i).setUserMarke(um);
			for(int j =0;j<um.size();j++){
				TeamAndUser tu = new TeamAndUser();
				tu.setStartTime(mtlist.get(i).getStartTime());
				tu.setEndTime(mtlist.get(i).getEndTime());
				tu.setTeam(teamDaoImpl.getTeamByiId(mtlist.get(i).getUserMarke().get(j).getTeamId()));
				User user = userDaoImpl.selectUserByid(mtlist.get(i).getUserMarke().get(j).getEvaluatedId());
				user.setRoleName(roleDaoImpl.selectRoleNameByRoleId(user.getRoleId()));
				
				tu.setEvaluatedUser(user);
				
				tulist.add(tu);
				if(tulist.size()>=3){
					return tulist;
				}
			}				
		}	
		return tulist;
	}


	@Override
	public TeacherResults getTeachersResults(int userId) {
		// TODO Auto-generated method stub

		int MarktableId = -1;				//考核表ID
		User user = userDaoImpl.selectUserByid(userId);
		user.setRoleName(roleDaoImpl.selectRoleNameByRoleId(user.getRoleId()));
		List<Integer> MarktableIdlist = new ArrayList<>();
		
		List<ResultTable> rtlist = resultTableDaoImpl.getResultTables(userId);
		
		Map<String, List<String>> contentmap = new TreeMap<>((Collections.reverseOrder()));
		
		
		for(int i =0;i<rtlist.size();i++){		
			if(rtlist.get(i).getMarktableId()>MarktableId){
				MarktableId=rtlist.get(i).getMarktableId();
				MarktableIdlist.add(MarktableId);		
			}
		}
		List<String> xEndTime = new ArrayList<>();					//x轴坐标		
		for(int i =0;i<MarktableIdlist.size();i++){
			xEndTime.add(resultTableDaoImpl.getEndTimeById(i+1));
		}
		List<Float> averagelist = new ArrayList<>();
		List<Float> recentlist = new ArrayList<>();
		Float average = 0f;
		
		for(int i =0;i<MarktableIdlist.size();i++){
			
			List<ResultTable> nowlist = resultTableDaoImpl.getResultTablesByUserAndMarkId(user.getId(), MarktableIdlist.get(i));
			Float recent = getRecent(nowlist);		
			recentlist.add(recent);
			average = Float.parseFloat(new DecimalFormat("0.00").format((average*i+recent)/(i+1)));
			averagelist.add(average);
			contentmap.put(xEndTime.get(i), getContent(nowlist));			
		}
		TeacherResults tr = new TeacherResults();
		tr.setUser(user);
		tr.setxEndTime(xEndTime);
		tr.setAveragelist(averagelist);
		tr.setRecentlist(recentlist);
		if(averagelist.size()==0){
			tr.setAverage(0f);
		}else{
			tr.setAverage(averagelist.get(averagelist.size()-1));		
		}
		if(recentlist.size()==0){
			tr.setRecent(0f);		
		}else{
			tr.setRecent(recentlist.get(recentlist.size()-1));			
		}
		tr.setContentmap(contentmap);
		return tr;
	}

	
	
	public Float getRecent(List<ResultTable> nowlist){
		int sum = 0;
		String recent = "-1";
		int count = 0 ;
		for(int j =0;j<nowlist.size();j++){
			if(resultTableDaoImpl.selectQuizById(nowlist.get(j).getQuizId()).getQuizType().equals(QuizType.CHOICE_QUESTION)){
				sum+=Integer.valueOf(nowlist.get(j).getAnswerScore());
				count++;
			}
			if(nowlist.size()!=0){
				if(count == 0){
					recent = new DecimalFormat("0.00").format(sum);	
				}else{
					recent = new DecimalFormat("0.00").format(sum/count);
				}
			}
		}
		Float f = Float.parseFloat(recent);
		return f;
	}
	
	public List<String> getContent(List<ResultTable> nowlist){
		List<String> content = new ArrayList<>();
		for(int j =0;j<nowlist.size();j++){
			if(resultTableDaoImpl.selectQuizById(nowlist.get(j).getQuizId()).getQuizType().equals(QuizType.ESSAY_QUESTION)){
				content.add(nowlist.get(j).getAnswer());			
			}
		}
		return content;
	}
	
}
