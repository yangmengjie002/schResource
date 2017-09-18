package sch.com.web.yang;


import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.User;
import sch.com.entity.UserPage;
import sch.com.service.yang.UserService;
import sch.com.utils.Md5Utils;

/**
 * �û��������
 * @author yang
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService ue;
	/**
	 * �ж��û��Ƿ���ڣ������û��ŵ�Principal��
	 * ��̨��¼
	 * @return
	 */
	@RequestMapping("/getUser")
	public String getUser(User u,Model model,HttpSession session){
		if("".equals(u.getUserName())||u.getUserName()==null){
			return "forward:/login.jsp";
		}
		System.out.println(u.getUserName()+u.getUserPwd());
		//��ȡ��ǰ����
		Subject subject = SecurityUtils.getSubject();//δ��֤״̬
		String password = Md5Utils.md5(u.getUserPwd());
		System.out.println(password);
		AuthenticationToken token = new UsernamePasswordToken(u.getUserName(), password);
		try{
			subject.login(token);
		}catch (UnknownAccountException e) {
			e.printStackTrace();
			//���ô�����Ϣ
			model.addAttribute("msg", "�û���������");
			return "forward:/login.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			//���ô�����Ϣ
			model.addAttribute("msg", "�û������������");
			return "forward:/login.jsp";
		}
		//��ȡ��֤��Ϣ�����д洢��User����
		User user = (User) subject.getPrincipal();
		session.setAttribute("user", user);
		return "admin/home";
	}
	
	/**
	 * �ж��û��Ƿ���ڣ������û��ŵ�Principal��
	 * ǰ�˵�¼
	 * @return
	 */
	@RequestMapping("/login")
	public String UserLogin(User u,Model model,HttpSession session){
		if("".equals(u.getUserName())||u.getUserName()==null){
			return "forward:/loginqian/index.jsp";
		}
		System.out.println(u.getUserName()+u.getUserPwd());
		//��ȡ��ǰ����
		Subject subject = SecurityUtils.getSubject();//δ��֤״̬
		String password = Md5Utils.md5(u.getUserPwd());
		AuthenticationToken token = new UsernamePasswordToken(u.getUserName(), password);
		try{
			subject.login(token);
		}catch (UnknownAccountException e) {
			e.printStackTrace();
			//���ô�����Ϣ
			model.addAttribute("msg", "�û���������");
			return "forward:/loginqian/index.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			//���ô�����Ϣ
			model.addAttribute("msg", "�û������������");
			return "forward:/loginqian/index.jsp";
		}
		//��ȡ��֤��Ϣ�����д洢��User����
		User user = (User) subject.getPrincipal();
		session.setAttribute("user", user);
		return "resourceHome";
	}
	/**
	 * ��ȡ�����û���Ϣ
	 * @param up
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/info")
	public Map<String,Object> getAllUser(UserPage up){ 
		return ue.selectAllUser(up);
	}
	
	/**
	 * ����ID�����û�
	 * @param arr
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteUser(String arr,HttpServletResponse response){
		return ue.deleteUser(arr);
	}
	/**
	 * �����û�
	 * @param arr
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("/up")
	public String upUser(String arr,HttpServletResponse response){
		return ue.upUser(arr);
	} 
	/**
	 * �޸��û��ϴ���Ϣ
	 * @param u
	 * @return
	 */
	@RequestMapping("/insertOrUpdate")
	@ResponseBody
	public String insertOrUpdateUser(User u,HttpServletRequest request){		
		try {
			request.setCharacterEncoding("utf-8");
			String name = new String(u.getUserRealName().getBytes("iso-8859-1"),"utf-8");
			u.setUserRealName(name);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u.toString());
		return ue.insertUser(u);
	}
	/**
	 * �޸ĺ�̨����
	 * @param pwd
	 * @param session
	 * @return
	 */
	@RequestMapping("/updatePwd")
	@ResponseBody
	public String updatePwd(String pwd1,HttpSession session){
		User user = (User) session.getAttribute("user");
		String pwd = Md5Utils.md5(pwd1);
		if(user == null){
			return "forward:/login.jsp";
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", user.getUserId());
		map.put("pwd", pwd);
		return ue.updatePwd(map);
	}
	
	
	/**
	 * �޸�ǰ̨����
	 * @param pwd
	 * @param session
	 * @return
	 */
	@RequestMapping("/qianPwd")
	@ResponseBody
	public String updatePwdQian(String pwd1,HttpSession session){
		User user = (User) session.getAttribute("user");
		String pwd = Md5Utils.md5(pwd1);
		if(user == null){
			return "forward:/loginQian/index.jsp";
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userId", user.getUserId());
		map.put("pwd", pwd);
		return ue.updatePwd(map);
	}
	/**
	 * �˳���̨
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/login.jsp";	
	}
	/**
	 * �˳�ǰ̨
	 * @param session
	 * @return
	 */
	@RequestMapping("/logoutQian")
	public String logoutQian(HttpSession session){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/loginqian/index.jsp";
	}
	/**
	 * ��ȡ�ϴ��ļ���Ϣ
	 * @param session
	 * @return
	 */
	@RequestMapping("/uploadInfo")
	@ResponseBody
	public List<Map<String, Object>> getUploadInfo(HttpSession session){
		User user = (User) session.getAttribute("user");
		return ue.getUploadByUserId(user.getUserId());
	}
	/**
	 * ��ȡ�����ļ���Ϣ
	 * @param session
	 * @return
	 */
	@RequestMapping("/downloadInfo")
	@ResponseBody
	public List<Map<String, Object>> getDownloadInfo(HttpSession session){
		User user = (User) session.getAttribute("user");
		return ue.getDownloadByUserId(user.getUserId());
	}
}
