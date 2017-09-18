package sch.com.web.wym;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.User;
import sch.com.service.wym.HelpInsertService;

@Controller
@RequestMapping("/wym")
public class HelpInsertController {
	@Autowired
	private HelpInsertService helpInsertService;
	
	@RequestMapping("/helpInsert")
	@ResponseBody
	public String helpInsert(HttpServletResponse resp,String typename,
			String requestCause,String ziname,String majorname,HttpSession session){
		resp.setContentType("text/html;charset=utf-8");
		User user = (User) session.getAttribute("user");
		helpInsertService.HelpInsert(typename, requestCause, ziname, majorname,user.getUserId());
		return "1";
	}
}
