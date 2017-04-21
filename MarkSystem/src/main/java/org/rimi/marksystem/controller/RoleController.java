package org.rimi.marksystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.rimi.marksystem.eneity.Role;
import org.rimi.marksystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleServiceImpl;
	
	@RequestMapping(value="/role")
	public String getRole(@RequestParam(value="dangqianye",required=false)String pageNum,Model model){
		int totalPage;//总页数
		int start;
		//查总共
		int total = roleServiceImpl.getRoleCount();
		model.addAttribute("total", total);
		totalPage = (total+10-1)/10;
		//分页查询
		if(pageNum == null || pageNum.isEmpty()){
			start = 0;
		}else{
			start = Integer.parseInt(pageNum)-1;
			if(start<0){
				start =0;
			}
			if(start>=totalPage){
				start = totalPage-1;
			}
		}
		List<Role> rolePage = roleServiceImpl.getRolePage(start*10, 10);
		model.addAttribute("rolePage", rolePage);
		model.addAttribute("dangqianye", start+1);
		model.addAttribute("next", totalPage);
		return "role";
	}
	//搜索职位
	@RequestMapping(value="roleselect",method = RequestMethod.GET)
	public String selectRole(@RequestParam("roleName")String name,Model model){
		List<Role> role = roleServiceImpl.getRole(0,10,name);
		model.addAttribute("total", role.size());
		model.addAttribute("dangqianye", 1);
		model.addAttribute("rolePage",role);
		model.addAttribute("next", 1);
		return "role";
	}
	//增加职位
	@RequestMapping(value="roleadd",method = RequestMethod.GET)
	public String addRole(@RequestParam(value="zwgn",required=false)String functionId,@RequestParam(value="zwname",required=false)String name,Model model){
		//判断是否存在此职位名称
		boolean exits = false;
		List<String> roleNames = roleServiceImpl.getRoleName();
		if(roleNames.contains(name)){
			exits = true;
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sj = sdf.format(date);
		Role role = new Role();
		role.setRoleName(name);
		role.setFunctionId(functionId);
		role.setBuildTime(sj);
		
		if(exits == true || name == null || name.isEmpty() || functionId == null || functionId.isEmpty()){
			return "redirect:/role";
		}else{
			roleServiceImpl.addRole(role);
			return "redirect:/role";
		}
		
	}
	//修改职位
		@RequestMapping(value="rolemodify",method = RequestMethod.GET)
		public String modifyRole(@RequestParam(value="zwgn",required=false)String functionId,@RequestParam(value="zwname",required=false)String name,Model model){
			
			roleServiceImpl.modifyRole(name, functionId);
			return "redirect:/role";
		}
		
	//删除
		@RequestMapping(value="roledelete",method = RequestMethod.GET)
		public String deleteRole(@RequestParam("zwid")int id,Model model){
			roleServiceImpl.deleteRole(id);
			return "redirect:/role";
		}
}
