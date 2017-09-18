package sch.com.web.wym;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.User;
import sch.com.service.wym.InfoInfoService;
import sch.com.utils.DateUtils;

@Controller
@RequestMapping("/wym")
public class InfoInfoController {
	@Autowired
	private InfoInfoService infoInfoService;
	
	//某个资源详情
	@RequestMapping("/infoInfo/lan")
	public String InfoInfo(Integer id,HttpServletRequest req){		
		HashMap<String,Object> info = new HashMap<String,Object>();
		info = infoInfoService.InfoInfoQuery(id);
		req.setAttribute("info", info);
		return "infoinfo";
	}
	
	//获得资源评论列表
	@RequestMapping("/commentQuery")
	@ResponseBody
	public List<HashMap<String,Object>> commentQuery(Integer id,Integer currPage){
		List<HashMap<String,Object>> comment = new ArrayList<HashMap<String,Object>>();
		comment = infoInfoService.CommentQuery(id,currPage);
		return comment;
	}
	
	//获得评论总数
	@RequestMapping("/CommentCountQuery")
	@ResponseBody
	public HashMap<String,Object> CommentCountQuery(Integer resourceid){
		return infoInfoService.CommentCountQuery(resourceid);
	}
	
	
	//插入评论表
	@RequestMapping("/CommentInsert")
	@ResponseBody
	public HashMap<String,Object> CommentInsert(String text,Integer id,HttpSession session){
		User user = (User) session.getAttribute("user");
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("text", text);
		m.put("resource_id", id);
		String date = DateUtils.dateToStrLong(new Date());
		m.put("date",date);
		m.put("user_id", user.getUserId());
		infoInfoService.CommentInsert(m);
		HashMap<String,Object> mm = new HashMap<String,Object>();
		mm.put("userName", "yangmeijie");
		mm.put("date", date);
		mm.put("info", text);
		return mm;
	}
	
	//查询用户是否评论过
	@RequestMapping("/IsCommentQuery")
	@ResponseBody
	public HashMap<String,Object> IsCommentQuery(Integer id,HttpSession session){
		User user = (User) session.getAttribute("user");
		return infoInfoService.IsCommentQuery(id,user.getUserId());
	}
	
	//插入收藏
	@RequestMapping("/CollectInsert")
	@ResponseBody
	public String CollectInsert(Integer id,HttpSession session){
		User user = (User) session.getAttribute("user");
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("resourceId", id);
		m.put("user_id", user.getUserId());
		m.put("date",DateUtils.dateToStrLong(new Date()));
		infoInfoService.CollectInsert(m);
		return "success";
	}
	
	
	//取消收藏
	@RequestMapping("/RemoveCollectDelete")
	@ResponseBody
	public String RemoveCollectDelete(Integer id,HttpSession session){
		User user = (User) session.getAttribute("user");
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("resourceId", id);
		m.put("user_id", user.getUserId());
		infoInfoService.RemoveCollectDelete(m);
		return "success";
	}
	
	//插入评分
	@RequestMapping("/ScoreInsert")
	@ResponseBody
	public String ScoreInsert(Integer id,Integer score,HttpSession session){
		User user = (User) session.getAttribute("user");
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("resourceId", id);
		m.put("user_id", user.getUserId());
		m.put("score", score);
		m.put("date",DateUtils.dateToStrLong(new Date()));
		infoInfoService.ScoreInsert(m);
		return "success";
	}
	
}














