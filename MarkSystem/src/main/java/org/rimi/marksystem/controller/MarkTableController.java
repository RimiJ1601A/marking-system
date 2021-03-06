package org.rimi.marksystem.controller;

import java.util.List;

import org.rimi.marksystem.eneity.MarkTable;
import org.rimi.marksystem.eneity.MarkTableTeam;
import org.rimi.marksystem.eneity.Quiz;
import org.rimi.marksystem.eneity.RequestMarkTableQuiz;
import org.rimi.marksystem.service.MarkeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarkTableController {
	
	
	@Autowired
	private MarkeTableService markTableServiceImpl;
	
	
	
	@RequestMapping("/markTable")
	public String markeTableView(Model model){
		List<RequestMarkTableQuiz> requestMarkTableQuizs = markTableServiceImpl.getEightInfo();
		model.addAttribute("eightInfo",requestMarkTableQuizs);
		List<Quiz> quizs = markTableServiceImpl.getQuizs(0, 5);
		Integer totalPage = markTableServiceImpl.getQuizCount();
		model.addAttribute("quizsList", quizs);
		model.addAttribute("totalPage", totalPage);
		return "marktable";
	}
	
	
	@RequestMapping("/submitmarketable")
	@ResponseBody
	public void  submitMarketable(@RequestBody MarkTable marktable){
		markTableServiceImpl.addMarkeTable(marktable);

	}
	
	@RequestMapping("/getQuizs")
	@ResponseBody
	public List<Quiz> getQuizs(){
		List<Quiz> quizs = markTableServiceImpl.getQuizs();
		return quizs;
	}
	
	
	@RequestMapping("/getTeams")
	@ResponseBody
	public List<MarkTableTeam> getTeams(){
		List<MarkTableTeam> teams = markTableServiceImpl.getMarkTableTeam();
		return teams;
	}
	
	
	@RequestMapping("/addQuizs")
	@ResponseBody
	public void addQuizs(@RequestBody List<Quiz> quizs){
		markTableServiceImpl.addQuizs(quizs);
	}
	
	@RequestMapping("/addEssayQuestion")
	@ResponseBody
	public void addEssayQuestion(@RequestBody Quiz quiz){
		markTableServiceImpl.addEssayQuestion(quiz);
	}
	
	@RequestMapping("/deleteMarkTable")
	@ResponseBody
	public void deleteInfo(@RequestParam(value= "MarktableId") int marktableId){
		
		markTableServiceImpl.deleteMark(marktableId);
	}
}
