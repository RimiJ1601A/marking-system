package org.rimi.marksystem.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.rimi.marksystem.dao.MarkTableDao;
import org.rimi.marksystem.dao.RoleDao;
import org.rimi.marksystem.dao.TeamDao;
import org.rimi.marksystem.dao.UserDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.TeamAndUser;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.eneity.UserMarke;
import org.rimi.marksystem.service.CountService;
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
	
	
	@Override
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
				tu.setEvaluatedUser(userDaoImpl.selectUserByid(mtlist.get(i).getUserMarke().get(j).getEvaluatedId()));
				tulist.add(tu);
				if(tulist.size()>=3){
					return tulist;
				}
			}				
		}	
		return tulist;
	}

}
