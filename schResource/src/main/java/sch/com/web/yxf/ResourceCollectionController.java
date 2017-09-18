package sch.com.web.yxf;

import java.io.IOException;
import java.io.PrintWriter;
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
import sch.com.entity.yxf.ResourceCollection;
import sch.com.service.yxf.ResourceCollectionService;
import sch.com.utils.BaseController;

@Controller
@RequestMapping("/collection")
public class ResourceCollectionController {
	@Autowired
	private ResourceCollectionService resourceCollectionService;

	private  BaseController bc;
	//涓汉鏀惰棌鏌ヨ
	@RequestMapping("/select")
	public void select(HttpServletResponse response,HttpSession session){
		User user = (User) session.getAttribute("user");
		List<Map<String,Object>> list=resourceCollectionService.queryCollect(user.getUserId());
		//System.out.println(11);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", list.size());
		map.put("rows", list);
		bc.writeJson(response, map);
		
		/*String jsonString = JSON.toJSONString(map);
		System.out.println(list.size());
		System.out.println(jsonString);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonString);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}
	//涓汉鏀惰棌澧炲姞锛岄渶瑕佽ˉ鍏咃紝鏈畬鎴�
	@RequestMapping("/insert")
	public void insert(ResourceCollection resourceCollection,HttpServletResponse response,HttpServletRequest request){
	//	resourceCollection.setAddTime("1993-9-9");
	//	resourceCollection.setResourceId(4);
	//	resourceCollection.setUserId(3);
		
		
		
		System.out.println(resourceCollection.getResourceId());
		int flag=resourceCollectionService.insertCollect(resourceCollection);
		try {
			PrintWriter out = response.getWriter();
			if(flag==1){
				out.print("success");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//涓汉鏀惰棌鍒犻櫎
	@RequestMapping("/del")
	public void del(String resourceId,HttpServletResponse response,HttpServletRequest request){
	//	str = "4,";
		 
	//	System.out.println(resourceId);
		String [] ss=resourceId.split(",");
	//	System.out.println(ss);
		int flag = 0;
		for(int i=0;i<ss.length;i++){
			Integer res = Integer.parseInt(ss[i]);
			flag += resourceCollectionService.delCollect(res);
		//	System.out.println("1111111111111111");
		}
		try {
		//	System.out.println("aaaaaaaaaaaaaaa");
			PrintWriter out = response.getWriter();
		//	System.out.println(flag);
			if(flag==ss.length){
				out.print("success");
			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
