package org.rimi.marksystem.service;

import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.Quiz;
import org.springframework.stereotype.Component;

/*
 * 评分表service
 */
@Component
public interface MarkeTableService {
	
	
	/*
	 * 插入一张评分表
	 */
	public void addMarkeTable(MarkTable marktable);
	
	/*
	 * 查询所有评分表
	 */
	public List<MarkTable> getAllMarkeTable();
	
	/*
	 * 插入问题
	 */
	public void addQuizs(List<Quiz> quizs);

}