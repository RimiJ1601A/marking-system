package org.rimi.marksystem.controller;

import java.io.File;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 头像上传
 */

@Controller
public class FileController {
	
	@Value("#{prop.root}")   //prop servlet配置下的bean的id
	private  String root;						//静态资源路径
	
	@Value("#{prop.tempPath}") 
    private String tempPath;					// 临时存储目录
	
	@Value("#{prop.savePath}") 
    private String savePath;					// 存储目录
	
	@Value("#{prop.fileName}") 
    private String fileName; 					// 文件名

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
                        fi.write(savedFile);
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
}
