 package org.rimi.marksystem.serviceImpl;

import java.util.List;

import org.rimi.marksystem.dao.MarkTableDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.MarkTableQuiz;
import org.rimi.marksystem.eneity.MarkTableTeam;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.UserMarke;
import org.rimi.marksystem.service.MarkeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MarkTableServiceImpl implements MarkeTableService{
	
	@Autowired
	private MarkTableDao MarkTableDaoImpl;
	
	/*
	 * 插入一张评分表
	 */
	public void addMarkeTable(MarkTable marktable) {
		// TODO Auto-generated method stub
		
		/**
		 * 首先插入 表名 开始时间 结束时间
		 */
		MarkTableDaoImpl.insertMarkeTable(marktable);
		
		//获取当前评分表的ID字段
		int ID = MarkTableDaoImpl.selectCurrentMarketTableID();
		
		/**
		 * 插入问题ID，表ID
		 */
		List<MarkTableQuiz> mtq = marktable.getMarkTableQuiz();
		for (MarkTableQuiz markTableQuiz : mtq) {
			MarkTableDaoImpl.insertMarkeTable_quiz(markTableQuiz.getQuizId(),ID);
		}
		
		/**
		 * 插入评分班级ID，评分人ID，评分表ID
		 */
		List<UserMarke> um = marktable.getUserMarke();
		for (UserMarke userMarke : um) {
			MarkTableDaoImpl.insertUsermarke(userMarke.getTeamId(), userMarke.getEvaluatedId(), ID);
		}
	}
	
	
	/*
	 * 查询所有评分表
	 */
	public List<MarkTable> getAllMarkeTable() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 插入问题
	 */
	public void addQuizs(List<Quiz> quizs) {
		// TODO Auto-generated method stub
		MarkTableDaoImpl.insertQuizs(quizs);
	}


	/*
	 * 查询所有问题
	 */
	public List<Quiz> getQuizs() {
		return MarkTableDaoImpl.selectQuizs();
	}


	public List<MarkTableTeam> getMarkTableTeam() {
		return MarkTableDaoImpl.selectAllMarkeTableTeam();
	}


	@Override
	public void addEssayQuestion(Quiz quiz) {
		// TODO Auto-generated method stub
		MarkTableDaoImpl.insertEssayQuestion(quiz);
	}

}
