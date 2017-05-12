package org.rimi.marksystem.service;

import java.util.List;

import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.springframework.stereotype.Component;

@Component
public interface MarkService {
	public List<RequestMarkTableQuiz> getTableInfo(List<Integer> in);
	
	public List<Quiz> getQuizs(List<Integer> in);
	
	public List<Integer> getQuizId(int id);
	
	public List<Integer> getTeamId(int id);
	
	public List<Integer> getInfo(int userid,int marktableid);
	
	public Integer getAllCountUserMarke();
}
