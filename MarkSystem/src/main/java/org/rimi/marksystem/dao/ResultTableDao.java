package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.User;
import org.springframework.stereotype.Component;

@Component
public interface ResultTableDao {
	
	/*
	 * 插入一张试卷的问题回答结果
	 */
	public void insertResultTable(List<ResultTable> resultTable);
	
	/*
	 * 根据评分人查询评分结果
	 */
	public ResultTable selectResultTableByEvaluationId(MarkTable markTable,User user);
	
	
	/*
	 * 根据被评分人查询评分结果
	 */
	public List<ResultTable> selectResultTableByEvaluatedId(MarkTable markTable,User user);


}
