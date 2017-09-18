package sch.com.web.zzy;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sch.com.service.zzy.Tb_teacherStyleService;
import sch.com.utils.BaseController;

@Controller
@RequestMapping("/teacherStyle")
public class TeacherStyleController {
	String fPath = "";      //老师照片路径
	@Autowired
	private Tb_teacherStyleService tss;
	/**
	 * 获取名师风采
	 * @param req
	 * @param resp
	 */
	@RequestMapping("/findTeacher")
	public void findTeacher(HttpServletRequest req,HttpServletResponse resp,String teacherName){
		if(teacherName!=null){
			try {
				req.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		System.out.println("teacherName>>>>"+teacherName);
		List<HashMap<String, Object>> findTeacher = tss.findTeacher(teacherName);
		req.setAttribute("findTeacher", findTeacher);
		BaseController.writeJson(resp, findTeacher);
	}
	/**
	 * 上传图片
	 */
	@RequestMapping("/uploadImg")
	@ResponseBody
	public String test(MultipartFile file,HttpServletRequest request) throws IOException{
		//String path = request.getSession().getServletContext().getRealPath("images/teacherImage");
		String path = "C:/Users/yang/workspace/schResource/src/main/webapp/images/teacherImage";
		
		String fileName = file.getOriginalFilename();
		File dir = new File(path,fileName);
		if(!dir.exists()){
			dir.mkdirs();
		}
		file.transferTo(dir);
		fPath = path + "/" + fileName;
		System.out.println("fPath>>>>>"+fPath);
		System.out.println("dir.exists>>"+dir.exists());
		return "ok";
	}
	/**
	 * 添加名师风采
	 * @return
	 */
	@RequestMapping("/insertTeacher")
	@ResponseBody
	public ModelAndView insertTeacher(HttpServletRequest request,String teacher_name,Integer teacher_age,String teacher_six,
				String entry_date,String teacher_info,String teacher_image){
		String strname = "";
		String strimage = "";
		String strinfo = "";
		String strsix = "";
		System.out.println("<<<<imagePath"+fPath);
		teacher_image = fPath;
		try {
			strname = new String(teacher_name.getBytes("ISO-8859-1"), "utf-8");
			strinfo = new String(teacher_info.getBytes("ISO-8859-1"), "utf-8");
			strsix = new String(teacher_six.getBytes("ISO-8859-1"), "utf-8");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		HashMap<String, Object> hm = new HashMap<>();
		System.out.println(strname);
		hm.put("teacher_name", strname);
		hm.put("teacher_age", teacher_age);
		hm.put("teacher_image", teacher_image);
		hm.put("teacher_info", strinfo);
		hm.put("teacher_six", strsix);
		hm.put("entry_date", entry_date);
		tss.insertTeacher(hm);
		ModelAndView mv = new ModelAndView("forward:/jsp/teacherStyle.jsp");
		return mv;
	}
	/**
	 * 删除名师风采
	 * @param teacher_id
	 * @return
	 */
	@RequestMapping("/deleteTeacher")
	@ResponseBody
	public int deleteTeacher(Integer teacher_id){
		int flag = tss.deleteTeacher(teacher_id);
		return flag;
	}
}
