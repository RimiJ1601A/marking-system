package org.rimi.marksystem.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
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
	public String getRole(@RequestParam(value="value",required=false)String name,@RequestParam(value="dangqianye",required=false)String pageNum,Model model){
		
		if (name == null || name.isEmpty()) {
			name="";
		}
		int total = roleServiceImpl.getRole(name);
		PageShow page = new PageShow(total,pageNum);
		List<Role> rolePage = roleServiceImpl.getRole(page.getStart(), ConstantClassField.COUNT, name);
		model.addAttribute("rolePage", rolePage);
		model.addAttribute("dangqianye", page.getCurrentPageNum());
		model.addAttribute("selectName", name);
		model.addAttribute("next", page.getTotalPage());
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
		
		//导出Excel表
		@RequestMapping(value="role_export",method = RequestMethod.GET)
		public String export(@RequestParam(value="name",required=false)String name,@RequestParam(value="path",required=false)String path,Model model) throws IOException, WriteException{
			if(name == null || name.isEmpty()){
				name="role.xsl";
			}
			if(path == null || path.isEmpty()){
				path = "C:/";
			}
			OutputStream os = new FileOutputStream(path+name);
			//创建工作薄
	        WritableWorkbook workbook = Workbook.createWorkbook(os);
	        //创建新的一页
	        WritableSheet sheet = workbook.createSheet("成绩表",0);
	        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
	        List<Role> roles = roleServiceImpl.getRoleAll();
	        int size = roles.size();
	        Label xuexiao = new Label(0,0,"职位名称");
	        sheet.addCell(xuexiao);
	        Label zhuanye = new Label(1,0,"功能名称");
	        sheet.addCell(zhuanye);
	        Label jingzhengli = new Label(2,0,"创建时间");
	        sheet.addCell(jingzhengli);
	     
	        for(int i=1;i<=size;i++){
	            Label a = new Label(0,i,roles.get(i-1).getRoleName());
	            sheet.addCell(a);
	            Label b = new Label(1,i,roles.get(i-1).getFunction().toString());
	            sheet.addCell(b);
	            Label c = new Label(2,i,roles.get(i-1).getBuildTime());
	            sheet.addCell(c);
	        }
	        workbook.write();
	        workbook.close();
	        os.close();
			return "redirect:/role";
		}
}
