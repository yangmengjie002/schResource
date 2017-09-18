package sch.com.web.yxf;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sch.com.entity.User;
import sch.com.entity.yxf.ResourceRequest;
import sch.com.service.yxf.MajorSelectService;
import sch.com.utils.BaseController;

@Controller
@RequestMapping(value="/majorSelect")
public class MajorSelectController {
	@Autowired
	private  MajorSelectService mss;

	private BaseController bc;
	//鏌ヨ璧勬簮鐨勭鐩被鍨�
	@RequestMapping("/selectmajor")
	public void selectMajor(HttpServletResponse response){
		List<Map<String,Object>> list= mss.queryMajor();
		Map <String,Object> map =new HashMap<String,Object>();
		map.put("selectMajor", list);
		bc.writeJson(response, map);
		
	}
	
	//鏌ヨ璧勬簮鐨勭绫荤被鍨�
	@RequestMapping("/selectResourceType")
	public void selectType(HttpServletResponse response){
		List<Map<String,Object>> list= mss.queryResouceType();
		Map <String,Object> map =new HashMap<String,Object>();
		map.put("selectType", list);
		bc.writeJson(response, map);
		
	}
	//璧勬簮璇锋眰琛ㄤ腑鎻掑叆鏁版嵁
	@RequestMapping("/insert")
	public void insert(Integer majorId,Integer resourceRequestTypeId,String requestCause,String resourceRequestName, HttpServletResponse response,HttpServletRequest request,HttpSession session){
		User user = (User) session.getAttribute("user");
		//闇�鎴栧彇鐧婚檰鑰呯紪鍙�
		ResourceRequest rr=new ResourceRequest();
		rr.setMajorId(majorId);
		rr.setRequestCause(requestCause);
		rr.setResourceRequestName(resourceRequestName);
		rr.setResourceRequestTypeId(resourceRequestTypeId);
		rr.setUserId(user.getUserId());
		
		//System.out.println(111);
		//鑾峰彇褰撳墠鏃ユ湡
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date date=new java.util.Date();  
		String str=sdf.format(date); 
		
        rr.setRequestTime(str);
       // System.out.println(rr.getResourceRequestName()+"sdfsdfsdfdsf");
        
		int flag=mss.insertRequest(rr);
		bc.insertResponose(flag, response);
		
	}
	
}
