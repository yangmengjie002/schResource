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
import sch.com.service.wym.ReleaseResourceService;
/**
 * ��̨��Դ����
 */
@Controller
@RequestMapping("/wym")
public class ReleaseController {
	@Autowired
	private ReleaseResourceService releaseResourceService;
	
	//�����Ŀ�����б�
	@RequestMapping("/ReleaseResourceQuery")
	@ResponseBody
	public HashMap<String,Object> ReleaseResourceQuery(Integer rows,Integer page,ResourceParam rp){
		System.out.println(rp.getResourceName());
		System.out.println(rp.getUploadDate());
		return releaseResourceService.ReleaseResourceQuery(rows,page,rp);
	}
	
	
	//������Դ�ϴ���״̬
	@RequestMapping("/ReleaseResourceUPdate")
	public void ReleaseResourceUPdate(HttpServletResponse resp,String rowArr,HttpSession session){
		User user = (User) session.getAttribute("user");
		releaseResourceService.UploadUpdate(rowArr,user.getUserId());
		try {
			resp.getWriter().print(1);
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}







