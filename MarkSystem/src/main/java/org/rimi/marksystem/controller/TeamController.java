package org.rimi.marksystem.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.parser.Entity;

import org.rimi.marksystem.eneity.Team;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.TeamService;
import org.rimi.marksystem.util.ConstantClassField;
import org.rimi.marksystem.util.EntityHandle;
import org.rimi.marksystem.util.MSSheet;
import org.rimi.marksystem.util.PageShow;
import org.rimi.marksystem.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Controller
public class TeamController {

	@Autowired
	private TeamService teamServiceImpl;
	private final int account = 10; // 每页显示的数据

	@RequestMapping("/team")
	public String goTeam(@RequestParam(value = "value", required = false) String name,@RequestParam(value = "currentPageName", required = false) String pageNum, Model model) {
		PageShow page = teamServiceImpl.getPage(name, pageNum);
		List<Team> team = teamServiceImpl.getTeam(page.getStart(), ConstantClassField.COUNT, page.getName());
		model.addAttribute("team", team);
		model.addAttribute("page", page);
		return "team";
	}

	// 增加
	@RequestMapping(value = "/teamadd", method = RequestMethod.GET)
	public String teamAdd(@RequestParam("teamName") String name, Model model) {
		// 判断是否存在此班级名称
		teamServiceImpl.addTeamByName(name);
		return "redirect:/team";
	}

	// 修改
	@RequestMapping(value = "/team_modify", method = RequestMethod.GET)
	public String modifyTeam() {

		return "redirect:/team";
	}

	// 删除
	@RequestMapping(value = "/teamdelete")
	public String teamDelete(@RequestParam("teamId") int id) {
		teamServiceImpl.dropTeam(id);
		return "redirect:/team";
	}

	// 批量添加学生到班级
	@RequestMapping(value = "/adddefaultstudent", method = RequestMethod.GET)
	public String addStudentDefault(@RequestParam("teamId") int teamId, @RequestParam("studentPref") String studentPref,
			@RequestParam("studentCount") String studentCount, Model model) {

		teamServiceImpl.addDefaultStudents(teamId, studentPref, studentCount);
		return "redirect:/team";
	}

	// 添加学生
	@RequestMapping(value = "/addstu", method = RequestMethod.GET)
	public String addstu(@RequestParam("teamId") int teamId, @RequestParam("userAccount") String userAccount) {

		teamServiceImpl.addStudentsOrTeacher(userAccount, "学生", teamId);
		return "redirect:/team";
	}

	// 删除学生
	@RequestMapping(value = "/deletestu", method = RequestMethod.GET)
	public String dropstu(@RequestParam("teamId") int teamId, @RequestParam("userAccount") String userAccount) {
		teamServiceImpl.deleteStudentsOrTeacher(userAccount, "学生", teamId);
		return "redirect:/team";
	}

	// 添加教师
	@RequestMapping(value = "/addteacher", method = RequestMethod.GET)
	public String addteacher(@RequestParam("teamId") int teamId, @RequestParam("userAccount") String userAccount) {

		teamServiceImpl.addStudentsOrTeacher(userAccount, "教师", teamId);
		return "redirect:/team";
	}

	// 删除教师
	@RequestMapping(value = "/deleteteacher", method = RequestMethod.GET)
	public String dropteacher(@RequestParam("teamId") int teamId, @RequestParam("userAccount") String userAccount) {
		teamServiceImpl.deleteStudentsOrTeacher(userAccount, "教师", teamId);
		return "redirect:/team";
	}

	// 导出Excel表
	@RequestMapping(value = "team_export", method = RequestMethod.GET)
	public String export(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "path", required = false) String path, Model model)
			throws IOException, WriteException {
		teamServiceImpl.createTeamExcel(path, name);
		return "redirect:/team";
	}
	
}
