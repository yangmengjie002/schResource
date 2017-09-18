package sch.com.web.zzy;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sch.com.entity.User;
import sch.com.service.zzy.Tb_userPwdService;
import sch.com.utils.Md5Utils;

@Controller
@RequestMapping("/userCheckPwd")
public class UserPwdController {
	@Autowired
	private Tb_userPwdService userPwdService;
	/**
	 * 修改用户密码
	 * @return
	 */
	@RequestMapping("/checkPwd")
	@ResponseBody
	public ModelAndView userPwd(HttpServletRequest request,HttpServletResponse response,String pswd){
		String pswd1 = Md5Utils.md5(pswd); 	//通过MD5加密用户密码
		System.out.println("pswd>>>"+pswd1);
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("userId>>>"+user.getUserId());
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("pswd", pswd1);
		hm.put("userId", user.getUserId());
		userPwdService.checkPwd(hm);
		ModelAndView mv = new ModelAndView("redirect:http://localhost:9088/schResource/loginqian/index.jsp");
		return mv;
	}
	
}
