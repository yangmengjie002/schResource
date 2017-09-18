package sch.com.web.zzy;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.service.zzy.Tb_majorService;
import sch.com.utils.BaseController;

@Controller
@RequestMapping("/major")
public class MajorController {
	@Autowired
	private Tb_majorService ms;
	/**
	 * 查询所有专业
	 * @param request
	 * @param response
	 * @param selectId
	 */
	@RequestMapping("/queryMajor")
	@ResponseBody
	public void queryMajor(HttpServletRequest request,HttpServletResponse response,Integer selectId){
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("selectId", selectId);
		List<HashMap<String, Object>> queryMajor = ms.queryMajor();
		request.setAttribute("queryMajor", queryMajor );
		BaseController.writeJson(response, queryMajor);
	}
	/**
	 * 查询学院下的专业
	 * @param selectId
	 * @param request
	 * @return
	 */
	@RequestMapping("/findMj")
	@ResponseBody
	public List<HashMap<String,Object>> findMj(Integer selectId,HttpServletRequest request){
		List<HashMap<String, Object>> findMj = ms.queryMajor();
		//BaseController.writeJson(response, findMj);
		request.setAttribute("findMj", findMj);
		System.out.println("*******findmj:"+findMj.toString());
		List<HashMap<String,Object>> flag = ms.findMj(selectId);
		return flag;
	}
	/**
	 * 新增专业
	 */
	@RequestMapping("/insertMj")
	@ResponseBody
	public void insertMj(HttpServletRequest request,Integer instituteId,String majorName){
		String mjName = "";
		try {
			mjName = new String(majorName.getBytes("ISO-8859-1"),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		HashMap<String, Object> mjHm = new HashMap<>();
		mjHm.put("instituteId", instituteId);
		mjHm.put("majorName", mjName);
		ms.insertMj(mjHm);
	}
	
}
