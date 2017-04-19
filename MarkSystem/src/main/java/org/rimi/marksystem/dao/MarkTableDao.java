package org.rimi.marksystem.dao;

import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.springframework.stereotype.Component;

/*
 * 评分表DAO
 */
@Component
public interface MarkTableDao {
	
	/*
	 * 插入一张评分表
	 */
	public void insertMarkeTable(MarkTable marktable);
	
	/*
	 * 查询所有评分表
	 */
	public List<MarkTable> selectMarkeTable();
	
	
	
}
