package sch.com.web.yang;
/**
 * �ļ��ϴ�����
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
	 * ��ȡ������Ϣ
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
	 * ������Դ
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
		//��ȡ�û���Ϣ
		User user = (User) session.getAttribute("user");
		List<Map<String, Object>> fileInfoList =  fs.fileDown(user.getUserId(),id);
		String filename = fileInfoList.get(0).get("UPLOAD_SITE")+"";
		//��ȡ�ļ�·��
		//String tomcaturl=System.getProperty("catalina.home");
		//String saveFilePath = tomcaturl+"\\testwebapps\\schResource\\images";
		//�����ļ�·��

		//String path = request.getServletContext().getRealPath("/images/");
		//System.out.println(path);
		System.out.println("aaaaaaaaaaaaaa"+filename+id);
		File file = new File("d:"+ filename);
		HttpHeaders headers = new HttpHeaders();  
		//������ʾ���ļ������������������������  
		String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
		//֪ͨ�������attachment�����ط�ʽ����ͼƬ
		headers.setContentDispositionFormData("attachment", downloadFielName); 
		//application/octet-stream �� �����������ݣ�������ļ����أ���
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
				headers, HttpStatus.CREATED);  
	}
	/**
	 * ����Ԥ����Ϣ
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showDown")
	public Map<String,Object> showDown(Integer id){	
		 List<Map<String, Object>> showList = fs.showDown(id);
			String show = showList.get(0).get("RESOURCE_TYPE_NAME")+"";
			if(show.equals("���ӱ��")||show.equals("�ı�")||show.equals("PPT�ļ�")){
				//��ȡ�ļ�·��
				String filename = showList.get(0).get("UPLOAD_SITE")+"";
				//����ת����DocConverter,������Ҫת�����ļ����ݸ�����Ĺ��췽��  
				DocConverter d = new DocConverter(filename);  
				//����conver������ʼת������ִ��doc2pdf()��office�ļ�ת��Ϊpdf;��ִ��pdf2swf()��pdfת��Ϊswf;  
				d.conver();  
				//����getswfPath()��������ӡת�����swf�ļ�·��  
				System.out.println(d.getswfPath());  
				//����swf���·�����Ա㴫�ݸ�flexpaper������  
				String swfpath = "/upload"+d.getswfPath().substring(d.getswfPath().lastIndexOf("/"));  
				System.out.println(swfpath);
				showList.get(0).put("swfpath", swfpath);
			}
			return showList.get(0);
	}


	/** 
	 * ��֤�ϴ��ļ�
	 */  
	@RequestMapping("/upload")
	@ResponseBody
	public Map<String,Object> oneFileUpload(ResourceYInfo resourceInfo,@RequestParam("file") CommonsMultipartFile file,  
			HttpServletRequest request, ModelMap model) {		
		CommonsMultipartResolverExt commonsMultipartResolverExt = new CommonsMultipartResolverExt();  
		commonsMultipartResolverExt.parseRequest(request); 
		// ���ԭʼ�ļ���  
		String fileName = file.getOriginalFilename();  
		System.out.println("ԭʼ�ļ���:" + fileName);  
		//��ȡ�ļ��ĺ�׺
		int m = fileName.indexOf(".");
		String postfix = fileName.substring(m+1);
		System.out.println(postfix);
		//���ݺ�׺��ȡ�ļ���������Ϣ
		List<Map<String, Object>> postfixList = fs.getResourceInfoFix(postfix);
		// ���ļ���  
		if(postfixList.size()==0){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("url", "1");
			return map;
		}
		String newFileName = UUID.randomUUID() + fileName;  

		// �����Ŀ��·��  
		ServletContext sc = request.getSession().getServletContext();  
		// �ϴ�λ��  
		//String path = sc.getRealPath("/image") + "/"; // �趨�ļ������Ŀ¼  

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
		System.out.println("�ϴ�ͼƬ��:" + path + newFileName);
		String typeString = postfixList.get(0).get("RESOURCE_TYPE_NAME")+"";
		if(typeString.equals("�ı�")||typeString.equals("���ӱ��")||typeString.equals("PPT�ļ�")){
			String lastFileName= path + newFileName;  
			//����ת����DocConverter,������Ҫת�����ļ����ݸ�����Ĺ��췽��  
			DocConverter d = new DocConverter(lastFileName);  
			//����conver������ʼת������ִ��doc2pdf()��office�ļ�ת��Ϊpdf;��ִ��pdf2swf()��pdfת��Ϊswf;  
			d.conver();  
			//����getswfPath()��������ӡת�����swf�ļ�·��  
			System.out.println(d.getswfPath());  
			//����swf���·�����Ա㴫�ݸ�flexpaper������  
			String swfpath = "/upload"+d.getswfPath().substring(d.getswfPath().lastIndexOf("/"));  
			System.out.println(swfpath);
			postfixList.get(0).put("swfpath", swfpath);
		}
		/*// �����ļ���ַ������JSPҳ�����  
		model.addAttribute("fileUrl", path + newFileName); */ 
		return postfixList.get(0);  
	}
	
	/** 
	 * process ��ȡ���� 
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
	 * �������ݿ�
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
