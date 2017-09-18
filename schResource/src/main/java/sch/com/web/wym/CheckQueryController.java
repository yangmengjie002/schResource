package sch.com.web.wym;


import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.User;
import sch.com.service.wym.CheckQueryService;

@Controller
@RequestMapping("/wym")
public class CheckQueryController {
	
	@Autowired
	private CheckQueryService checkQueryService;
	
	/**
	 *  ��ȡ����б�
	 * @param rows  ÿҳ����
	 * @param page  ��ǰҳ
	 * @return
	 */
	@RequestMapping("/checkQuery")
	@ResponseBody
	public HashMap<String, Object> checkQuery(Integer rows,Integer page){
		return checkQueryService.checkQuery(rows, page);
	}
	
	/**
	 * ������ȡרҵ
	 * @param institute_name   Ժϵ����
	 * @return
	 */
	@RequestMapping("/checkMajQuery")
	@ResponseBody
	public List<HashMap<String, Object>> checkMajQuery(String institute_name){
		return checkQueryService.checkMajQuery(institute_name);
	}
	
	/**
	 * ��˱�������Դ�ϴ������
	 * @param resourceId
	 * @param checkIdea
	 * @param checkStatuId
	 */
	@RequestMapping("/checkInsert")
	@Transactional
	public void checkInsert(Integer resourceId,String checkIdea,
			Integer checkStatuId,String major_name,HttpSession session){
		User user = (User) session.getAttribute("user");
		checkQueryService.checkInsert(resourceId,checkIdea,checkStatuId,major_name,user.getUserId());
	}
	
	
}
