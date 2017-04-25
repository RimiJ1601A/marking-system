package org.rimi.marksystem.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.rimi.marksystem.eneity.User;
import org.rimi.marksystem.service.RoleService;
import org.rimi.marksystem.service.UserService;
import org.rimi.marksystem.util.CommonMap;
import org.rimi.marksystem.util.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@Controller
public class UserController {
	
	@Value("#{prop.root}")   //prop servlet配置下的bean的id
	private  String root;						//静态资源路径
	
	@Value("#{prop.tempPath}") 
    private String tempPath;					// 临时存储目录
	
	@Value("#{prop.savePath}") 
    private String savePath;					// 存储目录
	
	@Value("#{prop.fileName}") 
    private String fileName; 					// 文件名
	
	
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private RoleService roleServiceImpl;
	private final int account = 10; // 每页显示的数据

	// 登陆页面
	@RequestMapping("/loginPage")
	public String loginPage(Model model) {
		return "login";
	}

	// 登陆判断逻辑
	@RequestMapping("/login")
	public String login(@RequestParam("userAccount") String userAccount, @RequestParam("password") String password,
			Model model, HttpServletRequest request) {
		User user = new User();
		user = userServiceImpl.getUserByUserAccountAndPassword(userAccount, password);
		if (user == null) {
			model.addAttribute("error", "用户名密码错误");
			return "login";
		} else {
			request.getSession().setAttribute("user", user);
			String roleName = CommonMap.roleNameMap.get(user.getRoleId());
			String functionName = CommonMap.roleFunctionMap.get(user.getRoleId()); 
			request.getSession().setAttribute("functions", functionName);
			request.getSession().setAttribute("roleName", roleName);
			return "redirect:/index";
		}
	}

	@RequestMapping(value = "/user")
	public String getUser(Model model, HttpServletRequest request) {
		int totalPage;// 总页数
		String obj = request.getParameter("dangqianye");
		// 当前页
		int dqy;
		if (obj == null || obj.isEmpty()) {
			dqy = 1;
		} else {
			dqy = Integer.parseInt(obj);
		}
		model.addAttribute("dangqianye", dqy);
		List<String> userAllnum = userServiceImpl.getAllUserAccount();
		model.addAttribute("userAllnum", userAllnum.size());
		totalPage = (userAllnum.size() + 10 - 1) / 10;
		int page = 0;
		if (obj != null) {
			try {
				page = Integer.valueOf(obj) - 1;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		page = page * 10;
		if ((page + account) > userAllnum.size()) {
			page = 0;
		}
		List<User> userlist = new ArrayList<User>();
		userlist = userServiceImpl.getUsersByPage(page, account);
		model.addAttribute("userlist", userlist);
		model.addAttribute("totalPage", totalPage);
		// 返回职位名称
		List<String> rolenames = roleServiceImpl.getRoleName();
		model.addAttribute("rolename", rolenames);
		return "user";
	}

	@RequestMapping("/signOut")
	public String signOut(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "redirect:/loginPage";
	}
	
	/***
	 * 修改密码
	 * @param oldPassword
	 * @param newPassword
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/changePassword")
	public String changePassword(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword, HttpServletRequest request, Model model) {
		User user = (User) request.getSession().getAttribute("user");
		String msg = "";
		boolean isTrue = userServiceImpl.checkPassWordIsTrue(user.getUserAccount(), oldPassword);
		if (isTrue == false) {
			msg = "密码错误";
			model.addAttribute("msg", msg);
			return "profile";
		} else {
			userServiceImpl.updatePassword(user.getUserAccount(), newPassword);
			msg = "修改成功";
			model.addAttribute("msg", msg);
			return "profile";
		}
	}

	// 修改用户
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam("srzh") String account, @RequestParam("srxm") String name,
			@RequestParam("srnl") String age, @RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "role", required = false) String roleName) {

		if (account == null || account.isEmpty() || name == null || name.isEmpty() || age == null || age.isEmpty()
				|| sex == null || sex.isEmpty() || roleName == null || roleName.isEmpty()) {
			return "redirect:/user";
		} else {
			User user = new User();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sj = sdf.format(date);
			user.setUserAccount(account);
			user.setPassword("123456");
			user.setUserName(name);
			int nl = Integer.parseInt(age);
			user.setAge(nl);
			user.setSex(Sex.getSexByString(sex));
			user.setBulidTime(sj);
			user.setHeadPhotoUrl("/images/defaultHeadPhoto.png");
			user.setRoleId(roleServiceImpl.getRoleId(roleName));
			userServiceImpl.updateUser(account, user);
			return "redirect:/user";
		}
	}

	@RequestMapping("/updatePassword")
	public String updatePassword(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {

		userServiceImpl.updatePassword(account, password);

		return "redirect:/index";
	}

	@RequestMapping("/updateUserRole")
	public String updateUserRole(@RequestParam("role_id") int role_id, @RequestParam("account") String account,
			HttpServletRequest request, Model model) {

		userServiceImpl.updateUserRole(account, role_id);

		return "redirect:/index";
	}

	// 插入
	@RequestMapping("/insertUser")
	public String insertUser(@RequestParam("srzh") String account, @RequestParam("srxm") String name,
			@RequestParam("srnl") String age, @RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "role", required = false) String roleName) {

		if (account == null || account.isEmpty() || name == null || name.isEmpty() || age == null || age.isEmpty()
				|| sex == null || sex.isEmpty() || roleName == null || roleName.isEmpty()) {
			return "redirect:/user";
		} else {
			User user = new User();
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sj = sdf.format(date);
			user.setUserAccount(account);
			user.setPassword("123456");
			user.setUserName(name);
			int nl = Integer.parseInt(age);
			user.setAge(nl);
			user.setSex(Sex.getSexByString(sex));
			user.setBulidTime(sj);
			user.setHeadPhotoUrl("/images/defaultHeadPhoto.png");
			user.setRoleId(roleServiceImpl.getRoleId(roleName));
			userServiceImpl.insertUser(user);
			return "redirect:/user";
		}

	}

	@RequestMapping("/resetPassword")
	public String resetPassword(@RequestParam("account") String account, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {

		userServiceImpl.resetPassword(account, password);

		return "redirect:/index";
	}

	@RequestMapping("/selectUser")
	public String selectUser(@RequestParam("value") String name, Model model) {

		if (name == null || name.isEmpty()) {
			return "redirect:/profile";
		} else {
			List<User> users = userServiceImpl.getUser(name);
			model.addAttribute("userlist", users);
			model.addAttribute("totalPage", 1);
			model.addAttribute("dangqianye", 1);
			// 返回职位名称
			List<String> rolenames = roleServiceImpl.getRoleName();
			model.addAttribute("rolename", rolenames);
			return "user";
		}
	}

	// 删除
	@RequestMapping("/deleteUser")
	public String dropUser(@RequestParam("userAccount") String account) {
		userServiceImpl.deleteUser(account);
		return "redirect:/user";
	}

	// 导出Excel表
	@RequestMapping(value = "user_export", method = RequestMethod.GET)
	public String export(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "path", required = false) String path, Model model)
			throws IOException, WriteException {
		if (name == null || name.isEmpty()) {
			name = "user.xsl";
		}
		if (path == null || path.isEmpty()) {
			path = "C:/";
		}
		OutputStream os = new FileOutputStream(path + name);
		// 创建工作薄
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		// 创建新的一页
		WritableSheet sheet = workbook.createSheet("人员信息", 0);
		List<User> users = userServiceImpl.getAllUser();
		int size = users.size();
		Label zh = new Label(0, 0, "账号");
		sheet.addCell(zh);
		Label rymc = new Label(1, 0, "人员名称");
		sheet.addCell(rymc);
		Label nl = new Label(2, 0, "年龄");
		sheet.addCell(nl);
		Label xb = new Label(3, 0, "性别");
		sheet.addCell(xb);
		Label zw = new Label(4, 0, "职位");
		sheet.addCell(zw);
		Label cjrq = new Label(5, 0, "创建日期");
		sheet.addCell(cjrq);
		// 创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
		for(int i=1;i<=size;i++){
            Label a = new Label(0,i,users.get(i-1).getUserAccount());
            sheet.addCell(a);
            Label b = new Label(1,i,users.get(i-1).getUserName());
            sheet.addCell(b);
            Label c = new Label(2,i,users.get(i-1).getAge()+"");
            sheet.addCell(c);
            Label d = new Label(3,i,users.get(i-1).getSex().getSex());
            sheet.addCell(d);
            Label e = new Label(4,i,users.get(i-1).getRoleName());
            sheet.addCell(e);
            Label f = new Label(5,i,users.get(i-1).getBulidTime());
            sheet.addCell(f);
        }
        workbook.write();
        workbook.close();
        os.close();
		return "redirect:/user";
	}

	/***
	 * 上传头像
	 * @param request
	 * @return
	 */
    @RequestMapping(value="/uploadphoto")
    @ResponseBody
    public Map<String, String> uploadImage(HttpServletRequest request) {
    	Map<String, String> map = new HashMap<String, String>();
        try {
            // 获取临时目录
            String tempPathDir = root + tempPath;
            File tempPathDirFile = new File(tempPathDir);
            if (!tempPathDirFile.exists()) {
                tempPathDirFile.mkdirs();
            }

            // 存储目录
            String realDir = root+savePath;
            File realDirFile = new File(realDir);
            if (!realDirFile.exists()) {
                realDirFile.mkdirs();
            }

            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Set factory constraints
            factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
            factory.setRepository(tempPathDirFile);// 设置缓冲区目录

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB

            List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
            Iterator<FileItem> i = items.iterator();
            if (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                String fileName = fi.getName();
                if (fileName != null) {
                    // 这里加一个限制，如果不是图片格式，则提示错误. (gif,jpg,jpeg,bmp,png)
                    String suffixName = FilenameUtils.getExtension(fileName);
                    if ("gif".equalsIgnoreCase(suffixName) || "jpg".equalsIgnoreCase(suffixName)
                            || "jpeg".equalsIgnoreCase(suffixName) || "bmp".equalsIgnoreCase(suffixName)
                            || "png".equalsIgnoreCase(suffixName)) {
                        // 文件名
                        this.fileName = new Date().getTime() + "." + FilenameUtils.getExtension(fileName);
                        File savedFile = new File(realDir, this.fileName);
                        User user=(User)request.getSession().getAttribute("user");
                        fi.write(savedFile);
                        String imgUrl = savePath +"/"+this.fileName ;
                        user.setHeadPhotoUrl(imgUrl);
                        userServiceImpl.changeUserHeadPhoto(imgUrl, user.getUserAccount());
                    } else {
                    	map.put("msg", "图片格式不对");
                    }
                }
            }
            map.put("msg", "上传成功");

        } catch (Exception e) {
        	map.put("msg", "上传失败");
        }
        return map;
    }
	
    /***
     * 修改个人信息
     * @param userName
     * @param age
     * @param sex
     * @param request
     * @return
     */
    @RequestMapping("/changeInfo")
    public String changeMyIngo(@RequestParam("userName")String userName,@RequestParam("age")String age,@RequestParam("sex")String sex,HttpServletRequest request){   	
		User user = (User)request.getSession().getAttribute("user");
		user.setUserName(userName);
		user.setAge(Integer.valueOf(age));
		user.setSex(Sex.getSexByValue(Integer.valueOf(sex)));
		userServiceImpl.updateUser(user.getUserAccount(), user);
		return "redirect:/profile";
    }
    
}
