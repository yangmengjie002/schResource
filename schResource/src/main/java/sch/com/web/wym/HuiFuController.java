package sch.com.web.wym;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.ResourceParam;
import sch.com.service.wym.HuiFuDaoService;

@Controller
@RequestMapping("/wym")
public class HuiFuController {
	@Autowired
	private HuiFuDaoService huiFuDaoService;
	
	//已经下架的列表
	@RequestMapping("/HuiFu")
	@ResponseBody
	public HashMap<String,Object> HuiFu(Integer rows,Integer page,ResourceParam rp){	
		System.out.println(rp.getUploadDate());
		System.out.println(rp.getResourceName());
		return huiFuDaoService.HuiFu(rows,page,rp);		
	}
	
	//更新资源上传表
	@RequestMapping("/HuiFuUpdate")
	public void HuiFuUpdate(HttpServletResponse resp,String rowArr){
		huiFuDaoService.HuiFuUpdate(rowArr);
		try {
			resp.getWriter().print(1);
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}






