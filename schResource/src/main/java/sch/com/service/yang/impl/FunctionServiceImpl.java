package sch.com.service.yang.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sch.com.dao.yang.FunctionDao;
import sch.com.entity.PageBean;
import sch.com.entity.Power;
import sch.com.service.yang.FunctionService;
import sch.com.utils.BaseController;
@Service
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private FunctionDao fd;
	@Override
	public Map<String, Object> functionQuery(PageBean pb) {
		// TODO Auto-generated method stub
		int startIndex = (pb.getPage()-1)*pb.getRows();
		int endIndex = pb.getPage()*pb.getRows()+1;
		pb.setStartIndex(startIndex);
		pb.setEndIndex(endIndex);
		List<Map<String, Object>> list = fd.functionQuery(pb);
		int total = fd.getCountUrl();
		Map<String, Object> urlMap = new HashMap<String, Object>();
		urlMap.put("rows", list);
		urlMap.put("total", total);
		return urlMap;
	}

	@Override
	public List<Map<String, Object>> functionQueryByUserId(int userId) {
		// TODO Auto-generated method stub
		return fd.functionQueryByUserId(userId);
	}


	@Override
	public String functionInsert(Power p) {
		// TODO Auto-generated method stub
		if(p.getPowerId()!=null){
			int flag = fd.functionUpdate(p);
			if(flag==1){
				return "success2";
			}
			return "error";
		}else{
			int flag1 = fd.functionInsert(p);
			if(flag1 == 1){
				return "success1";
			}
			return "error";
		}

	}
	@Transactional
	@Override
	public String functionDelete(String arr) {
		// TODO Auto-generated method stub
		String []ss = arr.split(";");
		int flag = 0;
		for (int i = 0; i < ss.length; i++) {
			flag += fd.functionDelete(Integer.parseInt(ss[i]));
		}
		if(flag == ss.length){
			return "success";
		}
		return "error";
	}

	@Override
	public String functionUp(String arr) {
		// TODO Auto-generated method stub
		String []ss = arr.split(";");
		int flag = 0;
		for (int i = 0; i < ss.length; i++) {
			flag += fd.functionUp(Integer.parseInt(ss[i]));
		}
		if(flag == ss.length){
			return "success";
		}
		return "error";
	}

	@Override
	public int functionUpdate(Power p) {
		// TODO Auto-generated method stub
		return fd.functionUpdate(p);
	}

	@Override
	public List<Map<String, Object>> functionQueryByUserMap(int userId, Integer id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userId", userId);
		map.put("id", id);
		System.out.println(map.get("id"));
		return fd.functionQueryByUserMap(map);
	}

	@Override
	public List<Map<String, Object>> functionQueryByUserMap(Map<String, Object> m) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = fd.functionQueryByUserMap(m);
		List<Map<String, Object>> treeList = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", list.get(i).get("POWER_ID"));
			map.put("text", list.get(i).get("POWER_NAME"));
			Map attributes = new HashMap();
			attributes.put("url", list.get(i).get("POWER_ROAD"));
			map.put("attributes", attributes);
			String s = list.get(i).get("POWER_ID")+"";
			System.out.println(s);
			m.put("id", s);
			if(fd.functionQueryByUserMap(m).size()>0){
				map.put("state", "closed");	
			}
			treeList.add(map);
		}
		return treeList;
	}

	@Override
	public List<Map<String, Object>> functionQueryByPowerMap(Map<String, Object> m) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = fd.functionQueryByPowerId(m);
		List<Map<String, Object>> treeList = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", list.get(i).get("POWER_ID"));
			map.put("text", list.get(i).get("POWER_NAME"));
			Map attributes = new HashMap();
			attributes.put("url", list.get(i).get("POWER_ROAD"));
			map.put("attributes", attributes);
			String s = list.get(i).get("POWER_ID")+"";
			m.put("id", s);
			if(fd.functionQueryByPowerId(m).size()>0){
				map.put("state", "closed");	//������Ӽ������ļ�����ʾ��
			}else{
				if(m.get("roleId")!=null){
					Integer roleId = (Integer) m.get("roleId");
					List<Map<String, Object>> roleUrlList = fd.queryUrlByRoleId(roleId);
					for (int j = 0; j < roleUrlList.size(); j++) {
						if(roleUrlList.get(j).get("POWER_ID").equals(list.get(i).get("POWER_ID"))){
							map.put("checked", true);
							break;
						}
					}
				}
			}
			treeList.add(map);
		}
		return treeList;
	}

	@Override
	public List<Map<String, Object>> functionQueryAll() {
		// TODO Auto-generated method stub
		return fd.functionQueryAll();
	}	
}
