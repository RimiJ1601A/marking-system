package org.rimi.marksystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.rimi.marksystem.eneity.ResultTable;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.MarkService;
import org.rimi.marksystem.service.ResultTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ResultTableController {

	@Autowired
	private ResultTableService resultTableService;
	

	@RequestMapping("/result")
	@ResponseBody
	public void resultTableView(@RequestBody List<ResultTable> resultTables,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute("user");
		int user_id = user.getId();
		for (ResultTable resultTable : resultTables) {
			//赋值 班级ID 评分人ID
			resultTable.setEvaluationId(user_id);
			String teamName = "'"+resultTable.getTeamName()+"'";
			resultTable.setTeamId(resultTableService.getTeamId(teamName));
		}
		resultTableService.addResultTable(resultTables);
	}
	
	
}
