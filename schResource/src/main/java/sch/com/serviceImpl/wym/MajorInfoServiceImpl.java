package sch.com.serviceImpl.wym;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.wymm.MajorInfoDao;
import sch.com.service.wym.MajorInfoService;

@Service
public class MajorInfoServiceImpl implements MajorInfoService{
	@Autowired
	private MajorInfoDao majorInfoDao;
	
	//查询某个专业下的资源
	public HashMap<String, Object> MajorInfoQuery(Integer a,Integer currPage) {
		Integer pageSize = 2;
		if(currPage ==null){
			currPage = 1;
		}
		HashMap<String, Object> param = new HashMap<String, Object>(); //参数设置
		param.put("bigPage", currPage*pageSize);
		param.put("smallPage", (currPage-1)*pageSize);
		param.put("major_id", a);
		
		List<HashMap<String, Object>> info = new ArrayList<HashMap<String, Object>>();
		info = majorInfoDao.MajorInfoQuery(param);   //得出结果
		Integer ave = 0;
		Integer count = 0;
		for(int i=0;i<info.size();i++){  //把平均分和下载量插入结果中
			ave = majorInfoDao.aveQuery(Integer.parseInt((info.get(i).get("RESOURCE_ID")+"")));
			count = majorInfoDao.downQuery(Integer.parseInt((info.get(i).get("RESOURCE_ID")+"")));
			info.get(i).put("ave", ave);
			info.get(i).put("count", count);
		}
		
		Integer countTotal = majorInfoDao.MajorInfoTotal(a);//总条数
		HashMap<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put("total", (int)Math.ceil(countTotal*1.0/pageSize));//把总页数存入map
		infoMap.put("info", info);//把表格数据存入map
		System.out.println(infoMap);
		return infoMap;
	}
}
