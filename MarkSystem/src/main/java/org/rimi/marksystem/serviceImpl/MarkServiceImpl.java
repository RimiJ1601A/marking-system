package org.rimi.marksystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.rimi.marksystem.dao.MarkDao;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.rimi.marksystem.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MarkServiceImpl implements MarkService{
	
	
	@Autowired
	private MarkDao markDaoImpl;
	
	public List<RequestMarkTableQuiz> getTableInfo(List<Integer> in) {
		List<RequestMarkTableQuiz> finalrmtqs = new ArrayList<RequestMarkTableQuiz>();
		for (Integer teamId : in) {
			List<RequestMarkTableQuiz> rmtqs = markDaoImpl.selectRequestMarkTableQuiz(teamId);
			finalrmtqs.addAll(rmtqs);
		}
		return finalrmtqs;
	}

	public List<Quiz> getQuizs(List<Integer> in) {
		// TODO Auto-generated method stub
		List<Quiz> qs = new ArrayList<Quiz>();
		for (Integer quiz_id : in) {
			Quiz quiz = markDaoImpl.selectQuiz(quiz_id);
			qs.add(quiz);
		}
		return qs;
	}

	public List<Integer> getQuizId(int id) {
		// TODO Auto-generated method stub
		return markDaoImpl.selectQuiz_id(id);
	}

	@Override
	public List<Integer> getTeamId(int id) {
		
		return markDaoImpl.selectTeamId(id);
	}
	
}
