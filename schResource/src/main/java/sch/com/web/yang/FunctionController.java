package sch.com.web.yang;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.PageBean;
import sch.com.entity.Power;
import sch.com.entity.User;
import sch.com.service.yang.FunctionService;

@Controller
@RequestMapping("/power")
@ResponseBody
public class FunctionController {
	@Autowired
	private FunctionService ft;
	/**
	 * ��ȡ�û�Ȩ��
	 */
	@RequestMapping("/url")
	public List<Map<String,Object>> getFunction(String id,HttpSession session){
		User user = (User) session.getAttribute("user");
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("id", id);
		m.put("userId", user.getUserId());
		return ft.functionQueryByUserMap(m);	
	}
	/**
	 * �����û�ID��ȡ�û�Ȩ��
	 * @return
	 */
	@RequestMapping("/getFunction")
	public List<Map<String,Object>> getFunctionByUserId(HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Map<String, Object>> urlList = ft.functionQueryByUserId(user.getUserId());
		for (int i = 0; i < urlList.size(); i++) {
			urlList.get(i).put("id", urlList.get(i).get("POWER_ID"));
			urlList.get(i).put("pid", urlList.get(i).get("POWER_PID"));
		}
		return urlList;
	}
	/**
	 * ��ȡ����Ȩ��
	 * @return
	 */
	@RequestMapping("/allUrl1")
	public List<Map<String, Object>> getAllUrl1(){
		return ft.functionQueryAll();
	}
	
	/**
	 * ��ҳ��ȡ����Ȩ����Ϣ
	 * @param response
	 */
	@RequestMapping("/allUrl")
	public Map<String, Object> getAllUrl(PageBean pb){
		System.out.println(pb.getPage()+":"+pb.getRows());
		return  ft.functionQuery(pb);
	}
	/**
	 * ����ID����Ȩ��
	 * @param arr
	 * @param response
	 */
	@RequestMapping("/delete")
	public String deleteFunction(String arr){
		return ft.functionDelete(arr);
	}
	/**
	 * ����Ȩ��
	 * @param arr
	 * @param response
	 */
	@RequestMapping("/up")
	public String upFunction(String arr){
		return  ft.functionUp(arr);
	}
	@RequestMapping("/insertOrUpdate")//������޸�Ȩ��
	public String insertOrUpdateFunction(Power p,HttpServletRequest request){
		try {
			request.setCharacterEncoding("utf-8");
			String name = new String(p.getPowerName().getBytes("iso-8859-1"),"utf-8");
			p.setPowerName(name);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(p.getPowerId()+";"+p.getPowerView()+";"+p.getPowerPriority()+";"+p.getPowerRoad()+";"+p.getPowerName());
		return ft.functionInsert(p);
	}
}
