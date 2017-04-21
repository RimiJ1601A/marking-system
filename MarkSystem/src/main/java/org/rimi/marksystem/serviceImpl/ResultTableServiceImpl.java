package org.rimi.marksystem.serviceImpl;

import java.util.List;

import org.rimi.marksystem.dao.ResultTableDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.ResultTableService;
import org.springframework.stereotype.Component;

@Component
public class ResultTableServiceImpl implements ResultTableService{
	
	private ResultTableDao resultTableDaoImpl;
	
	/*
	 * 插入一张试卷的问题回答结果
	 */
	public void addResultTable(List<ResultTable> resultTable) {
		// TODO Auto-generated method stub		
	}

	/*
	 * 根据评分人查询评分结果
	 */
	public ResultTable getResultTableByEvaluationId(MarkTable markTable, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 根据被评分人查询评分结果
	 */
	public List<ResultTable> getResultTableByEvaluatedId(MarkTable markTable, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
