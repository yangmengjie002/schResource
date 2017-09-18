package sch.com.web.wym;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.User;
import sch.com.service.wym.MyCenterService;

@Controller
@RequestMapping("/wym")
public class MyCenterController {
	@Autowired
	private MyCenterService myCenterService;
		
	//获取我的个人中心
	@RequestMapping("/myCenterQuery")
	public String myCenterQuery(HttpServletRequest req,HttpSession session){
		User user = (User) session.getAttribute("user");
		Integer currPage = 1;
		//获取我的上传
		List<HashMap<String, Object>> upload = new ArrayList<HashMap<String, Object>>();
		upload = myCenterService.MyUploadQuery(currPage,user.getUserId());
		//获取我的下载
		List<HashMap<String,Object>> down = new ArrayList<HashMap<String,Object>>();
		down = myCenterService.MyDownQuery(currPage,user.getUserId());		
		//获取我的收藏
		List<HashMap<String,Object>> collect = new ArrayList<HashMap<String,Object>>();		
		collect = myCenterService.MyCollectQuery(currPage,user.getUserId());
		
		req.setAttribute("upload", upload);
		req.setAttribute("down", down);
		req.setAttribute("collect", collect);
		return "MyCenterOne";
	}
	
	//获取我的上传
	@RequestMapping("/myUploadQuery")
	@ResponseBody
	public List<HashMap<String,Object>> myUploadQuery(Integer currPage,HttpSession session){
		User user = (User) session.getAttribute("user");
		return myCenterService.MyUploadQuery(currPage,user.getUserId());
	}
	
	//获取我的下载
	@RequestMapping("/myDownQuery")
	@ResponseBody
	public List<HashMap<String,Object>> myDownQuery(Integer currPage,HttpSession session){
		User user = (User) session.getAttribute("user");
		return myCenterService.MyDownQuery(currPage,user.getUserId());
	}
	
	//获取我的收藏
	@RequestMapping("/myCollectQuery")
	@ResponseBody
	public List<HashMap<String,Object>> myCollectQuery(Integer currPage,HttpSession session){
		User user = (User) session.getAttribute("user");
		return myCenterService.MyCollectQuery(currPage,user.getUserId());
	}
	
	//我的上传、下载、收藏总条数
	@RequestMapping("/MyCountQuery")
	@ResponseBody
	public HashMap<String,Object> MyCountQuery(HttpSession session){
		User user = (User) session.getAttribute("user");
		HashMap<String,Object> count = new HashMap<String,Object>();
		count = myCenterService.MyCountQuery(user.getUserId());
		return count;
	}
	
}




