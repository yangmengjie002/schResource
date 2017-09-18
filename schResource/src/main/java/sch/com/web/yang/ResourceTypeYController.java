package sch.com.web.yang;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sch.com.entity.ResourceYType;
import sch.com.entity.Role;
import sch.com.service.yang.ResourceTypeYService;

@Controller
@RequestMapping("/resourceType")
@ResponseBody
public class ResourceTypeYController {
	@Autowired
	private ResourceTypeYService rt;
	/**
	 * ��ȡ��Դ������ϸ��Ϣ
	 * @return
	 */
	@RequestMapping("/typeInfo")
	public List<Map<String,Object>> getResourceTypeInfo(){
		return rt.getResourceTypeInfo();
	}
	
	/**
	 * ������޸Ľ�ɫ
	 * @param p
	 * @param response
	 */
	@RequestMapping("/insertOrUpdate")
	public String insertOrUpdateResourceType(ResourceYType r){
		return rt.insertOrUpdateResourceType(r);
	}
	/**
	 * ����ID���ý�ɫ
	 * @param arr
	 * @param response
	 */
	@RequestMapping("/delete")
	public String deleteRole(String arr){
		int flag = rt.DeleteResourceType(arr);
		if(flag==1){
			return "success";
		}else{
			return "error";
		}		
	}
	/**
	 * ��ȡ�ѷ�������Դ����
	 * @return
	 */
	@RequestMapping("/resourceInfo")
	public List<Map<String,Object>> getResourceInfo(){
		return rt.getResourceInfo();
	}
	/**
	 * ��Դ����
	 * @return
	 */
	@RequestMapping("/order")
	@ResponseBody
	public Map<String,Object> getResourceOrder(){
		 return rt.getResourceOrder();
	}
	
}
