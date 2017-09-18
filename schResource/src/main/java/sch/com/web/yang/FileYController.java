package sch.com.web.yang;
/**
 * 文件上传下载
 * @author yang
 *
 */

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import sch.com.entity.ResourceYInfo;
import sch.com.entity.User;
import sch.com.service.yang.FileYService;
import sch.com.utils.DocConverter;

@Controller
@RequestMapping("/file")
public class FileYController {
	@Autowired
	private FileYService fs;
	
	/**
	 * 获取下载信息
	 * @param id
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectDown")
	public String selectDown(Integer id,HttpSession session){
		User user = (User) session.getAttribute("user");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("resourceId", id);
		map.put("userId", user.getUserId());
		return fs.selectDown(map);
	}
	/**
	 * 下载资源
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> download(Integer id,HttpServletRequest request,Model model)throws Exception {
		//String filename = "timg.jpg";
		HttpSession session = request.getSession();
		//获取用户信息
		User user = (User) session.getAttribute("user");
		List<Map<String, Object>> fileInfoList =  fs.fileDown(user.getUserId(),id);
		String filename = fileInfoList.get(0).get("UPLOAD_SITE")+"";
		//获取文件路径
		//String tomcaturl=System.getProperty("catalina.home");
		//String saveFilePath = tomcaturl+"\\testwebapps\\schResource\\images";
		//下载文件路径

		//String path = request.getServletContext().getRealPath("/images/");
		//System.out.println(path);
		System.out.println("aaaaaaaaaaaaaa"+filename+id);
		File file = new File("d:"+ filename);
		HttpHeaders headers = new HttpHeaders();  
		//下载显示的文件名，解决中文名称乱码问题  
		String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
		//通知浏览器以attachment（下载方式）打开图片
		headers.setContentDispositionFormData("attachment", downloadFielName); 
		//application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
				headers, HttpStatus.CREATED);  
	}
	/**
	 * 下载预览信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showDown")
	public Map<String,Object> showDown(Integer id){	
		 List<Map<String, Object>> showList = fs.showDown(id);
			String show = showList.get(0).get("RESOURCE_TYPE_NAME")+"";
			if(show.equals("电子表格")||show.equals("文本")||show.equals("PPT文件")){
				//获取文件路径
				String filename = showList.get(0).get("UPLOAD_SITE")+"";
				//调用转换类DocConverter,并将需要转换的文件传递给该类的构造方法  
				DocConverter d = new DocConverter(filename);  
				//调用conver方法开始转换，先执行doc2pdf()将office文件转换为pdf;再执行pdf2swf()将pdf转换为swf;  
				d.conver();  
				//调用getswfPath()方法，打印转换后的swf文件路径  
				System.out.println(d.getswfPath());  
				//生成swf相对路径，以便传递给flexpaper播放器  
				String swfpath = "/upload"+d.getswfPath().substring(d.getswfPath().lastIndexOf("/"));  
				System.out.println(swfpath);
				showList.get(0).put("swfpath", swfpath);
			}
			return showList.get(0);
	}


	/** 
	 * 验证上传文件
	 */  
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String,Object> oneFileUpload(ResourceYInfo resourceInfo,@RequestParam("file") CommonsMultipartFile file,  
			HttpServletRequest request, ModelMap model) {		
		CommonsMultipartResolverExt commonsMultipartResolverExt = new CommonsMultipartResolverExt();  
		commonsMultipartResolverExt.parseRequest(request); 
		// 获得原始文件名  
		String fileName = file.getOriginalFilename();  
		System.out.println("原始文件名:" + fileName);  
		//获取文件的后缀
		int m = fileName.indexOf(".");
		String postfix = fileName.substring(m+1);
		System.out.println(postfix);
		//根据后缀获取文件的所有信息
		List<Map<String, Object>> postfixList = fs.getResourceInfoFix(postfix);
		// 新文件名  
		if(postfixList.size()==0){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("url", "1");
			return map;
		}
		String newFileName = UUID.randomUUID() + fileName;  

		// 获得项目的路径  
		ServletContext sc = request.getSession().getServletContext();  
		// 上传位置  
		//String path = sc.getRealPath("/image") + "/"; // 设定文件保存的目录  

		String path = "/upload/";
		File f = new File(path);  
		if (!f.exists())  
			f.mkdirs();  
		if (!file.isEmpty()) {  
			try {  
				File fos = new File(path + newFileName);  
				InputStream in = file.getInputStream();  
				FileUtils.copyInputStreamToFile(in, fos);   
			} catch (Exception e) {  
				e.printStackTrace();  
			}  
		}  
		postfixList.get(0).put("url", path+newFileName);
		System.out.println("上传图片到:" + path + newFileName);
		String typeString = postfixList.get(0).get("RESOURCE_TYPE_NAME")+"";
		if(typeString.equals("文本")||typeString.equals("电子表格")||typeString.equals("PPT文件")){
			String lastFileName= path + newFileName;  
			//调用转换类DocConverter,并将需要转换的文件传递给该类的构造方法  
			DocConverter d = new DocConverter(lastFileName);  
			//调用conver方法开始转换，先执行doc2pdf()将office文件转换为pdf;再执行pdf2swf()将pdf转换为swf;  
			d.conver();  
			//调用getswfPath()方法，打印转换后的swf文件路径  
			System.out.println(d.getswfPath());  
			//生成swf相对路径，以便传递给flexpaper播放器  
			String swfpath = "/upload"+d.getswfPath().substring(d.getswfPath().lastIndexOf("/"));  
			System.out.println(swfpath);
			postfixList.get(0).put("swfpath", swfpath);
		}
		/*// 保存文件地址，用于JSP页面回显  
		model.addAttribute("fileUrl", path + newFileName); */ 
		return postfixList.get(0);  
	}
	
	/** 
	 * process 获取进度 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */  
	@RequestMapping(value = "/process", method = RequestMethod.GET)  
	@ResponseBody  
	public Map<String,Object> process(HttpServletRequest request,  
	                              HttpServletResponse response) throws Exception {  	  
	    Map<String,Object> map = new HashMap<>();  	  	  
	    FileUploadListener.ProcessInfo processInfo =  (FileUploadListener.ProcessInfo)request.getSession().getAttribute("proInfo");  
	    map.put("rate", processInfo.rate);  
	    return map;  
	}  
	
	
	
	/**
	 * 插入数据库
	 * @param resourceInfo
	 * @return
	 */
	@RequestMapping("/uploadAll")
	@ResponseBody
	public int  fileUploadAll(ResourceYInfo resourceInfo,HttpSession session){
		User user = (User) session.getAttribute("user");
		resourceInfo.setUserId(user.getUserId());
		System.out.println(resourceInfo.toString());
		return fs.fileUploadAll(resourceInfo);
	}

}
