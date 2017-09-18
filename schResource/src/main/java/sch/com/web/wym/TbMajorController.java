package sch.com.web.wym;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import sch.com.service.wym.TbMajorService;


@Controller
@RequestMapping("/wym")
public class TbMajorController {
	@Autowired
	private TbMajorService maservice;

	@RequestMapping("/TbMajorQuery")
	//���Ժϵ�����רҵ
	public void TbMajorQuery(HttpServletResponse resp,Integer institute_id){	
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("institute_id------------------"+institute_id);
		String majorStr = maservice.TbMajorDaoQuery(institute_id);
		try {
			resp.getWriter().print(majorStr);
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/queryTbResourceUploadId")
	//���רҵ�ڵ���Դ����
	public void queryTbResourceUploadId(HttpServletResponse resp,Integer major_id){
		Integer count = maservice.queryTbResourceUploadId(major_id);
		String countStr = JSON.toJSONString(count);
		try {
			resp.getWriter().print(countStr);
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
