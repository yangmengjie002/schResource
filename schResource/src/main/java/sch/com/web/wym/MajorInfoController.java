package sch.com.web.wym;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.service.wym.MajorInfoService;

@Controller
@RequestMapping("/wym")
public class MajorInfoController {
	@Autowired
	private  MajorInfoService majorInfoService;
	
	
	//查询某个专业下的资源
	@RequestMapping("/MajorInfo")
	public String MajorInfo(Integer id,HttpServletRequest req,Integer currPage){
		System.out.println(currPage);
		HashMap<String,Object> info = new HashMap<String,Object>();
		info = majorInfoService.MajorInfoQuery(id,currPage);
		req.setAttribute("info", info);
		System.out.println(info);
		return "majorInfoList";
	}
	
	@RequestMapping("/MajorInfoAjax")
	@ResponseBody
	public HashMap<String,Object> MajorInfoAjax(Integer id,Integer currPage){
		System.out.println(currPage);
		HashMap<String,Object> info = new HashMap<String,Object>();
		info = majorInfoService.MajorInfoQuery(id,currPage);
		return info;
	}
		
}














