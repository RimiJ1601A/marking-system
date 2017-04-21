package org.rimi.marksystem.daoImpl;

import java.util.List;

import org.rimi.marksystem.dao.MarkTableDao;
import org.rimi.marksystem.eneity.MarkTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class MarkTableDaoImpl implements MarkTableDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * 插入一张评分表
	 */
	public void insertMarkeTable(MarkTable marktable) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * 查询所有评分表
	 */
	public List<MarkTable> selectMarkeTable() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
