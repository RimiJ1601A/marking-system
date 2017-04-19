package org.rimi.marksystem.service;

import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;

@Component
public interface ResultTableService {
	
	
	/*
	 * 插入一张试卷的问题回答结果
	 */
	public void addResultTable(List<ResultTable> resultTable);
	
	/*
	 * 根据评分人查询评分结果
	 */
	public ResultTable getResultTableByEvaluationId(MarkTable markTable,User user);
	
	
	/*
	 * 根据被评分人查询评分结果
	 */
	public List<ResultTable> getResultTableByEvaluatedId(MarkTable markTable,User user);

	
}
