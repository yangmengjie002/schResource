package sch.com.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class BaseController {
	/**
	 * 若参数中没有时间格式转换用此json
	 * @param response
	 * @param obj
	 */
	public void writeJson(HttpServletResponse response,Object obj){
		response.setContentType("text/html;charset=utf-8");
		String jsonString = JSON.toJSONString(obj);
		try {
			PrintWriter out = response.getWriter();
			out.print(jsonString);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 对象参数中若有日期格式，日期转换为yyyy-MM-dd hh:mm:ss格式
	 * @param response
	 * @param obj
	 */
	public void writeDateJson(HttpServletResponse response,Object obj){
		response.setContentType("text/html;charset=utf-8");
		String jsonString = JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd hh:mm:ss");
		try {
			PrintWriter out = response.getWriter();
			out.print(jsonString);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
