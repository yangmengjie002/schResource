package sch.com.web.zzy;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import oracle.jdbc.Const;
import sch.com.entity.Tb_information;
import sch.com.service.zzy.Tb_informationService;
import sch.com.utils.BaseController;

@Controller
public class InformQueryController {
	@Autowired
	private Tb_informationService tb_informationService;

	/**
	 * ��ȡ��Ѷ������
	 * 
	 * @param response
	 */
	@RequestMapping("/queryInformation")
	public void queryInformation(HttpServletRequest request,HttpServletResponse response) {
		List<Tb_information> getList = tb_informationService.getList();
		request.setAttribute("getList", getList);
		BaseController.writeJson(response, getList);
	}
	/**
	 * ��ȡ��̨��Ѷ
	 * @param response
	 */
	@RequestMapping("/informationManage")
	public void InformationManage(HttpServletResponse response) {
		List<Tb_information> getList = tb_informationService.getList();
		BaseController.writeJson(response, getList);

	}
	/**
	 * ������Ѷ
	 * @param informationTitles
	 * @param informationContents
	 * @param req
	 * @return
	 */
	@RequestMapping("/insertInfo")
	@ResponseBody
	public ModelAndView insertInfo(String informationTitles, String informationContents, HttpServletRequest req) {
		String strTitles="";
		String strContents="";
		try {
			req.setCharacterEncoding("utf-8");
			strTitles = new String(informationTitles.getBytes("ISO-8859-1"), "utf-8");
			strContents = new String(informationContents.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("informationTitle", strTitles);
		hm.put("informationContent", strContents);
		hm.put("user_id", 1);
		tb_informationService.insertInfo(hm);
		System.out.println(hm.toString());
		ModelAndView mv = new ModelAndView("forward:jsp/InformationManage.jsp");//������ͼ����
		return mv;
	}
	/**
	 * ɾ��һ����Ѷ
	 * @param response
	 * @param informationID
	 */
	@RequestMapping("/deleteInfo")
	public void deleteInfo(HttpServletResponse response,Integer informationID){
		tb_informationService.deleteInfo(informationID);
		
	}
	/**
	 * �޸���Ѷ��Ϣ
	 */
	@RequestMapping("/updateInfo")
	@ResponseBody
	public void updateInfo(String informationTitle,String informationContent,Integer informationId,HttpServletRequest request){
		String titStr = "";
		String ConStr = "";
		try {
			request.setCharacterEncoding("utf-8");
			titStr = new String(informationTitle.getBytes("ISO-8859-1"),"utf-8");
			ConStr = new String(informationContent.getBytes("ISO-8859-1"),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(titStr);
		HashMap<String, Object> hsm = new HashMap<>();
		hsm.put("informationTitle", titStr);
		hsm.put("informationContent", ConStr);
		hsm.put("informationId", informationId);
		tb_informationService.updateInfo(hsm);
	}
	
}
