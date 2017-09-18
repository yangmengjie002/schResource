package sch.com.web.wym;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import sch.com.entity.TbInstitute;
import sch.com.service.wym.Tb_InstituteService;

@Controller
@RequestMapping("/wym")
public class Tb_InstituteController {
	@Autowired 
	private Tb_InstituteService service;
	
	@RequestMapping("/instituteAllQuery")
	public void Tb_InstituteAllQuery( HttpServletResponse resp){
		resp.setContentType("text/html;charset=utf-8");
		List<TbInstitute> aa = new ArrayList<TbInstitute>();		
		aa = service.Tb_InstituteAllQuery();
		String aaStr = JSON.toJSONString(aa);
		System.out.println(aaStr);
		try {
			resp.getWriter().print(aaStr);
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
