package sch.com.web.wym;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.ResourceParam;
import sch.com.entity.User;
import sch.com.service.wym.ResourceEndService;

@Controller
@RequestMapping("/wym")
public class ResourceEndController {
	@Autowired
	private ResourceEndService resourceEndService;	
	
	//��ȡ�����¼ܵ���Դ
	@RequestMapping("/ResourceEnd")
	@ResponseBody
	public HashMap<String,Object> ResourceEnd(Integer rows,Integer page,ResourceParam rp){
		System.out.println(rp.getResourceName());
		System.out.println(rp.getUploadDate());
		HashMap<String,Object> map = resourceEndService.ResourceEnd(rows,page,rp);
		return map;		
	}
	
	
	//������Դ�¼ܱ�
	@RequestMapping("/ResourceEndInsert")
	public void ResourceEndInsert(HttpServletResponse resp,String rowArr,HttpSession session){
		User user = (User) session.getAttribute("user");
		resourceEndService.ResourceEndInsert(rowArr,user.getUserId());
		try {
			resp.getWriter().print(1);
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}








