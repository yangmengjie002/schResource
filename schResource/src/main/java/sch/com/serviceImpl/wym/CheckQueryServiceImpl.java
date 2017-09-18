package sch.com.serviceImpl.wym;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sch.com.dao.wymm.CheckQueryDao;
import sch.com.utils.DateUtils;


@Service
public class CheckQueryServiceImpl implements sch.com.service.wym.CheckQueryService{
	
	@Autowired
	private CheckQueryDao checkQueryDao;
		
	@Override
	//需要审核的数据列表
	public HashMap<String,Object> checkQuery(Integer rows,Integer page) {
		List<HashMap<String,Object>> check = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("bigPage", rows*page);
		param.put("smallPage", rows*(page-1));
		check = checkQueryDao.checkQuery(param);
		Integer total = checkQueryDao.checkTotalQuery();
		HashMap<String,Object> checkMap = new HashMap<String,Object>();
		checkMap.put("total",total);
		checkMap.put("rows",check);
		return checkMap;
	}
	
	
	@Override
	//级联下拉系查询
	public List<HashMap<String, Object>> checkMajQuery(String m) {
		// TODO Auto-generated method stub
		return checkQueryDao.checkMajQuery(m);
	}
	
	
	

	@Override
	//插入审核表和更新资源上传表
	@Transactional
	public void checkInsert(Integer resourceId,String checkIdea,
			Integer checkStatuId,String major_name,Integer id) {		
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("resourceId", resourceId);
		m.put("checkIdea", checkIdea);
		m.put("checkStatuId",checkStatuId);
		m.put("check_data", DateUtils.dateToStrLong(new Date()));
		m.put("user_id", id);
		checkQueryDao.checkInsert(m);
		
		Integer major_id = checkQueryDao.checkMajIDQuery(major_name);
		System.out.println("major_id============="+major_id);
		HashMap<String,Object> mmm = new HashMap<String,Object>();
		mmm.put("resourceId", resourceId);
		mmm.put("major_id", major_id);		
		checkQueryDao.tbUploadMajUpdate(mmm);
		
		HashMap<String,Object> mm = new HashMap<String,Object>();
		mm.put("resourceId", resourceId);
		mm.put("status_id", 2);
		checkQueryDao.tbResourceUploadUpdate(mm);
	}






	

}
