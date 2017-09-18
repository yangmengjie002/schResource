package sch.com.web.yang;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.QueryEntity;
import sch.com.service.yang.QueryCountService;

/**
 * 查询统计类
 * @author yang
 *
 */
@RequestMapping("/query")
@ResponseBody
@Controller
public class QueryCountController {
	@Autowired
	private QueryCountService qs;
	/**
	 * 上传统计
	 * @param qe
	 * @return
	 */
	@RequestMapping("/upcount")
	public Map<String,Object> queryUpload(QueryEntity qe){
		System.out.println(qe.toString());
		return qs.getUpInfo(qe);
	}
	/**
	 * 上传柱状图统计
	 * @param id
	 * @return
	 */
	@RequestMapping("/upPicture")
	public Map<String,Object> upPicture(Integer id){
		return qs.upPicture(id);
	}
	
	/**
	 * 上传统计
	 * @param qe
	 * @return
	 */
	@RequestMapping("/downcount")
	public Map<String,Object> queryDown(QueryEntity qe){
		System.out.println(qe.toString());
		return qs.getDownInfo(qe);
	}
	
	/**
	 * 下载柱状图统计
	 * @param id
	 * @return
	 */
	@RequestMapping("/downPicture")
	public Map<String,Object> downPicture(Integer id){
		return qs.downPicture(id);
	}
}
