package sch.com.service.yang.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.wymm.ResourceInfoDao;
import sch.com.dao.yang.ResourceTypeYDao;
import sch.com.entity.ResourceYType;
import sch.com.service.yang.ResourceTypeYService;
@Service
public class ResourceTypeYServiceImpl implements ResourceTypeYService{
	@Autowired
	private ResourceTypeYDao rd;
	@Override
	public List<Map<String, Object>> getResourceTypeInfo() {
		// TODO Auto-generated method stub
		//��ȡ��������
		List<Map<String, Object>> resourceTypeList = rd.getResourceType();
		for (int i = 0; i < resourceTypeList.size(); i++) {
			int id = Integer.parseInt(resourceTypeList.get(i).get("RESOURCE_TYPE_ID")+"");
			System.out.println(id);
			//��ȡĳһ���͵����к�׺
			List<Map<String, Object>> resourcePostfix = rd.getResourcePostfix(id);
			String s = "";	
			for (int j = 0; j < resourcePostfix.size(); j++) {
				s += resourcePostfix.get(j).get("POSTFIX_NAME") + ",";
			}
			System.out.println(s);
			resourceTypeList.get(i).put("resourcePostfix", s);
		}
		
		return resourceTypeList;
	}
	@Override
	public String insertOrUpdateResourceType(ResourceYType r) {
		// TODO Auto-generated method stub
		if(r.getResourceTypeId() == null){
			//�����ɫ��
			int insertRole1 = rd.insertResourceType(r);
			int flag = 0;
			String[] ss = r.getResourcePostfix().split(",");
			for (int i = 0; i < ss.length; i++) {
				flag += rd.insertResourcePostfix(ss[i]);//�����׺��
			}
			if(flag == ss.length && insertRole1 == 1){
				return "success1";
			}
			return "error";
		}else{
			//�޸���Դ������Ϣ
			int updateRole = rd.updateResourceType(r);
			//ɾ����׺Ȩ�ޱ�����͵ĺ�׺
			rd.deleteRolePostfix(r.getResourceTypeId());
			//���²����ɫȨ����Ϣ
			int flag = 0;
			String[] ss = r.getResourcePostfix().split(",");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resourceTypeId", r.getResourceTypeId());
			for (int i = 0; i < ss.length; i++) {
				map.put("ss", ss[i]);
				flag += rd.insertResourcePostfixByMap(map);//�����׺��
			}
			if(flag == ss.length && updateRole == 1){
				return "success2";
			}
			return "error";
		}
	}
	@Override
	public int DeleteResourceType(String arr) {
		String []ss = arr.split(";");
		int flag = 0;
		for (int i = 0; i < ss.length; i++) {
			flag += rd.deleteResourceType(Integer.parseInt(ss[i]));
		}
		if(flag == ss.length){
			return 1;
		}
		return 0;
	}
	@Override
	public List<Map<String, Object>> getResourceInfo() {
		// TODO Auto-generated method stub
		
		List<Map<String, Object>> resourceInfo = rd.getResourceInfo();
		List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < resourceInfo.size(); i++) {
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("value", resourceInfo.get(i).get("RESOURCE_NAME"));
			map.put("label", resourceInfo.get(i).get("RESOURCE_NAME"));
			map.put("id", resourceInfo.get(i).get("RESOURCE_ID"));
			treeList.add(map);
		}
		return treeList;
	}
	@Override
	public Map<String, Object> getResourceOrder() {
		// TODO Auto-generated method stub
		//��ȡ��Դ������
		List<Map<String, Object>> downInfoList = rd.getResourceCount();
		//��ȡ�������а�
		List<Map<String, Object>> scoreList = rd.getResourceScore();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("down", downInfoList);
		map.put("score", scoreList);
		return map;
	}

}
