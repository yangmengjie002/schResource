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
	 *  获取审核列表
	 * @param rows  每页几条
	 * @param page  当前页
	 * @return
	 */
	@RequestMapping("/checkQuery")
	@ResponseBody
	public HashMap<String, Object> checkQuery(Integer rows,Integer page){
		return checkQueryService.checkQuery(rows, page);
	}
	
	/**
	 * 级联获取专业
	 * @param institute_name   院系名称
	 * @return
	 */
	@RequestMapping("/checkMajQuery")
	@ResponseBody
	public List<HashMap<String, Object>> checkMajQuery(String institute_name){
		return checkQueryService.checkMajQuery(institute_name);
	}
	
	/**
	 * 审核表插入和资源上传表更新
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
