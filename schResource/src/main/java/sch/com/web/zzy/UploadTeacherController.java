package sch.com.web.zzy;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/uploadImage")
public class UploadTeacherController {
	/**
	 * �ϴ���ʦ��Ƭ
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/uploadTeacher")
	@ResponseBody
	public String test(MultipartFile file,HttpServletRequest request) throws IOException{
		//String path = request.getSession().getServletContext().getRealPath("images/teacherImage");
		String path = "D:/��Դ������Ŀ/9��6/sch/schResource/src/main/webapp/images/teacherImage";
		System.out.println("path>>>"+path);
		String fileName = file.getOriginalFilename();
		System.out.println("fileName>>>>"+fileName);
		File dir = new File(path,fileName);
		if(!dir.exists()){
			dir.mkdirs();
		}
		file.transferTo(dir);
		System.out.println("dir.exists>>"+dir.exists());
		return "ok";
	}
}
