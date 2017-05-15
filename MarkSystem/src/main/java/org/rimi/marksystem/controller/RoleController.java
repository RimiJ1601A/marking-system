package org.rimi.marksystem.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.rimi.marksystem.eneity.Function;
import org.rimi.marksystem.eneity.Role;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.RoleService;
import org.rimi.marksystem.util.ConstantClassField;
import org.rimi.marksystem.util.PageShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleServiceImpl;
	
	@RequestMapping(value="/role")
	public String getRole(@RequestParam(value="value",required=false)String name,@RequestParam(value="currentPageName",required=false)String pageNum,Model model){
		PageShow page = roleServiceImpl.getPage(name, pageNum);
		List<Role> rolePage = roleServiceImpl.getRole(page.getStart(), ConstantClassField.COUNT, page.getName());
		List<Function> function = roleServiceImpl.getFuntion();
		model.addAttribute("rolePage", rolePage);
		model.addAttribute("page", page);
		model.addAttribute("function", function);
		return "role";
	}
	//增加职位
	@RequestMapping(value="roleadd",method = RequestMethod.GET)
	public String addRole(@RequestParam(value="functionId",required=false)String functionId,@RequestParam(value="functionName",required=false)String name,Model model){
		
		roleServiceImpl.addSuccessOrError(name, functionId);
		return "redirect:/role";
		
	}
	//修改职位
		@RequestMapping(value="rolemodify",method = RequestMethod.GET)
		public String modifyRole(@RequestParam(value="functionId",required=false)String functionId,@RequestParam(value="functionName",required=false)String name,Model model){
			
			roleServiceImpl.modifyRole(name, functionId);
			return "redirect:/role";
		}
		
	//删除
		@RequestMapping(value="roledelete",method = RequestMethod.GET)
		public String deleteRole(@RequestParam("roleId")int id,Model model){
			roleServiceImpl.deleteRole(id);
			return "redirect:/role";
		}
		
		//导出Excel表
		@RequestMapping(value="role_export",method = RequestMethod.GET)
		public String export(@RequestParam(value="name",required=false)String name,@RequestParam(value="path",required=false)String path,Model model) throws IOException, WriteException{
			roleServiceImpl.exportRoleEcel(path, name);
			return "redirect:/role";
		}
}
