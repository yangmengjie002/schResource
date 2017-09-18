package sch.com.web.yxf;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import sch.com.entity.User;
import sch.com.entity.yxf.DataGrid;
import sch.com.entity.yxf.PerRecordPageCut;
import sch.com.service.yxf.PersonRecordService;
import sch.com.utils.BaseController;

@Controller
@RequestMapping("/personRecord")
public class PersonRecordControllerr {
	@Autowired
	private PersonRecordService prs;

	public BaseController bc;

	@RequestMapping("/select")
	public void select(Integer pageNo,HttpServletRequest request,HttpServletResponse response,HttpSession session){
		//鑾峰彇鐧婚檰鑰卛d;娌℃湁鍐�
		User user = (User) session.getAttribute("user");
		PerRecordPageCut perRecordPageCut=new PerRecordPageCut();

		perRecordPageCut.setRows(2);
		System.out.println(pageNo);

		perRecordPageCut.setPage(pageNo);
		perRecordPageCut.setUserId(user.getUserId());
		DataGrid datagrid=prs.queryRequestRceord(perRecordPageCut);
		System.out.println(datagrid.getTotal());
		String jsonString = JSON.toJSONString(datagrid);
		System.out.println(jsonString);
			System.out.println(datagrid);
			bc.writeJson(response, datagrid);
		
	}
} 
