package sch.com.service.yang.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.yang.QueryCountDao;
import sch.com.entity.QueryEntity;
import sch.com.service.yang.QueryCountService;
@Service
public class QueryCountServiceImpl implements QueryCountService{
	@Autowired
	private QueryCountDao qd;
	@Override
	public Map<String, Object> getUpInfo(QueryEntity qe) {
		// TODO Auto-generated method stub
		int startIndex = qe.getRows()*(qe.getPage()-1);
		int endIndex = qe.getRows()*qe.getPage()+1;
		qe.setStartIndex(startIndex);
		qe.setEndIndex(endIndex);
		int upCount = qd.getUpCount(qe);
		List<Map<String, Object>> upInfo = qd.getUpInfo(qe);		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", upCount);
		map.put("rows", upInfo);
		return map;
	}

	@Override
	public Map<String, Object> getDownInfo(QueryEntity qe) {
		// TODO Auto-generated method stub
		int startIndex = qe.getRows()*(qe.getPage()-1);
		int endIndex = qe.getRows()*qe.getPage()+1;
		qe.setStartIndex(startIndex);
		qe.setEndIndex(endIndex);
		int downCount = qd.getDownCount(qe);
		List<Map<String, Object>> downInfo = qd.getDownInfo(qe);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("total", downCount);
		map.put("rows", downInfo);
		return map;
	}

	@Override
	public Map<String, Object> upPicture(Integer id) {
		// TODO Auto-generated method stub、
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		if(id==1){
			//查询过去一个月
			c.add(Calendar.MONTH, -1);
		}else if(id==2){
			//查询过去三个月
			c.add(Calendar.MONTH, -3);
		}else{
			//查询所有
			c.add(Calendar.YEAR, -10);
		}
		Date date = c.getTime();
		//获取学院上传情况
		List<Map<String,Object>> instList = qd.QueryInstitute(date);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("date", date);
		int instSum = 0;
		for (int i = 0; i < instList.size(); i++) {
			String m = instList.get(i).get("INCOUNT")+"";
			instSum += Integer.parseInt(m);
		}
		List<Map<String,Object>> treeList1 = new ArrayList<Map<String,Object>>();//学院上传
		List<Map<String,Object>> treeList2 = new ArrayList<Map<String,Object>>();//专业上传
		for(int i=0;i<instList.size();i++){
			Map<String,Object> insMap = new HashMap<String,Object>();
			insMap.put("name", instList.get(i).get("INSTITUTE_NAME"));
			String m = instList.get(i).get("INCOUNT")+"";
			int f = Integer.parseInt(m);
			BigDecimal   b   =   new   BigDecimal(f*1.0/instSum);  //格式化double，留两位有效数字
			double   f1   =   b.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			insMap.put("y", f1*100);
			insMap.put("drilldown", instList.get(i).get("INSTITUTE_NAME"));
			treeList1.add(insMap);
			
			map.put("instituteId", instList.get(i).get("INSTITUTE_ID"));
			List<Map<String,Object>> majorList = qd.queryMajor(map);//获取某一学院的上传情况
			Map<String,Object> maMap = new HashMap<String,Object>();
			int maSum = 0;//
			maMap.put("name", instList.get(i).get("INSTITUTE_NAME"));
			maMap.put("id", instList.get(i).get("INSTITUTE_NAME"));
			List<List> list1 = new ArrayList<List>();
			for (int j = 0; j < majorList.size(); j++) {
				List list2  = new ArrayList<>();
				String n = majorList.get(j).get("MACOUNT")+"";
				int f4 = 0;
				try{
					f4 = Integer.parseInt(n);
				}catch(Exception e){
					
				}
				double   f3 = 0;
				if(f4 !=0){
					BigDecimal d = new   BigDecimal(f4*1.0/f);
					f3   =   d.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();
				}
				list2.add(majorList.get(j).get("MAJOR_NAME"));
				list2.add(f3*100);
				list1.add(list2);
			}
			maMap.put("data", list1);
			treeList2.add(maMap);		
		}
		Map<String,Object> upMap = new HashMap<String,Object>();
		upMap.put("institute", treeList1);
		upMap.put("major", treeList2);
		return upMap;
	}

	@Override
	public Map<String, Object> downPicture(Integer id) {
		// TODO Auto-generated method stub、
				Calendar c = Calendar.getInstance();
				c.setTime(new Date());
				if(id==1){
					//查询过去一个月
					c.add(Calendar.MONTH, -1);
				}else if(id==2){
					//查询过去三个月
					c.add(Calendar.MONTH, -3);
				}else{
					//查询所有
					c.add(Calendar.YEAR, -10);
				}
				Date date = c.getTime();
				//获取学院上传情况
				List<Map<String,Object>> instList = qd.QueryInstituteDown(date);
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("date", date);
				int instSum = 0;
				for (int i = 0; i < instList.size(); i++) {
					String m = instList.get(i).get("DOWNINSTCOUNT")+"";
					instSum += Integer.parseInt(m);
				}
				List<Map<String,Object>> treeList1 = new ArrayList<Map<String,Object>>();//学院上传
				List<Map<String,Object>> treeList2 = new ArrayList<Map<String,Object>>();//专业上传
				for(int i=0;i<instList.size();i++){
					Map<String,Object> insMap = new HashMap<String,Object>();
					insMap.put("name", instList.get(i).get("INSTITUTE_NAME"));
					String m = instList.get(i).get("DOWNINSTCOUNT")+"";
					int f = Integer.parseInt(m);
					BigDecimal   b   =   new   BigDecimal(f*1.0/instSum);  //格式化double，留两位有效数字
					double   f1   =   b.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					insMap.put("y", f1*100);
					insMap.put("drilldown", instList.get(i).get("INSTITUTE_NAME"));
					treeList1.add(insMap);
					
					map.put("instituteId", instList.get(i).get("INSTITUTE_ID"));
					List<Map<String,Object>> majorList = qd.queryMajorDown(map);//获取某一学院的上传情况
					Map<String,Object> maMap = new HashMap<String,Object>();
					int maSum = 0;//
					maMap.put("name", instList.get(i).get("INSTITUTE_NAME"));
					maMap.put("id", instList.get(i).get("INSTITUTE_NAME"));
					List<List> list1 = new ArrayList<List>();
					for (int j = 0; j < majorList.size(); j++) {
						List list2  = new ArrayList<>();
						String n = majorList.get(j).get("DOWNMACOUNT")+"";
						int f4 = 0;
						try{
							f4 = Integer.parseInt(n);
						}catch(Exception e){
							
						}
						double   f3 = 0;
						if(f4 !=0){
							BigDecimal d = new   BigDecimal(f4*1.0/f);
							f3   =   d.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();
						}
						list2.add(majorList.get(j).get("MAJOR_NAME"));
						list2.add(f3*100);
						list1.add(list2);
					}
					maMap.put("data", list1);
					treeList2.add(maMap);		
				}
				Map<String,Object> upMap = new HashMap<String,Object>();
				upMap.put("institute", treeList1);
				upMap.put("major", treeList2);
				return upMap;
	}

}
