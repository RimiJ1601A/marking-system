 package org.rimi.marksystem.serviceImpl;

import java.util.List;

import org.rimi.marksystem.dao.MarkTableDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.service.MarkeTableService;
import org.springframework.stereotype.Component;


@Component
public class MarkTableServiceImpl implements MarkeTableService{
	
	
	private MarkTableDao MarkTableDaoImpl;
	
	/*
	 * 插入一张评分表
	 */
	public void addMarkeTable(MarkTable marktable) {
		// TODO Auto-generated method stub
		
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
		
	}

}
