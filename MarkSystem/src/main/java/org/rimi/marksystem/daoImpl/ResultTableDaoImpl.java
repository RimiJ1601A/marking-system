package org.rimi.marksystem.daoImpl;

import java.util.List;

import org.rimi.marksystem.dao.ResultTableDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ResultTableDaoImpl implements ResultTableDao{
	
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * 插入一张试卷的问题回答结果
	 */
	public void insertResultTable(List<ResultTable> resultTable) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 根据评分人查询评分结果
	 */
	public ResultTable selectResultTableByEvaluationId(MarkTable markTable, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 根据被评分人查询评分结果
	 */
	public List<ResultTable> selectResultTableByEvaluatedId(MarkTable markTable, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
