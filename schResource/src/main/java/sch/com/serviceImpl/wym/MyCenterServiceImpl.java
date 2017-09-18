package sch.com.serviceImpl.wym;


import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sch.com.dao.wymm.MyCenterDao;
import sch.com.service.wym.MyCenterService;

@Service
public class MyCenterServiceImpl implements MyCenterService{
	@Autowired
	private MyCenterDao myCenterDao;
	
	//�ҵ��ϴ�
	@Override
	public List<HashMap<String, Object>> MyUploadQuery(Integer currPage,Integer userid) {
		if(currPage==null){
			currPage=1;
		}
		Integer pageSzie = 3;
		HashMap<String,Object> m = new HashMap<String,Object>();		
		m.put("smallPage", (currPage-1)*pageSzie);
		m.put("bigPage", (currPage)*pageSzie);
		m.put("user_id", userid);
		return myCenterDao.MyUploadQuery(m);
	}
	
	//�ҵ�����
	@Override
	public List<HashMap<String, Object>> MyDownQuery(Integer currPage,Integer userid) {
		if(currPage==null){
			currPage=1;
		}
		Integer pageSzie = 3;
		HashMap<String,Object> m = new HashMap<String,Object>();		
		m.put("smallPage", (currPage-1)*pageSzie);
		m.put("bigPage", (currPage)*pageSzie);
		m.put("user_id", userid);
		System.out.println(myCenterDao.MyDownQuery(m));
		return myCenterDao.MyDownQuery(m);
	}
	
	//�ҵ��ղ�
	@Override
	public List<HashMap<String, Object>> MyCollectQuery(Integer currPage,Integer userid) {
		if(currPage==null){
			currPage=1;
		}
		Integer pageSzie = 3;
		HashMap<String,Object> m = new HashMap<String,Object>();		
		m.put("smallPage", (currPage-1)*pageSzie);
		m.put("bigPage", (currPage)*pageSzie);
		m.put("user_id",userid);
		return myCenterDao.MyCollectQuery(m);
	}

	//�ҵ��ϴ������ء��ղ�������
	public HashMap<String, Object> MyCountQuery(Integer userid) {
		HashMap<String,Object> m = new HashMap<String,Object>();
		Integer upload = myCenterDao.MyUploadCount(userid);
		Integer down = myCenterDao.MyDownCount(userid);
		Integer collect = myCenterDao.MyCollectCount(userid);
		Integer pageSize = 3;
		m.put("upload",Math.ceil(upload*1.0/pageSize));
		m.put("down",Math.ceil(down*1.0/pageSize));
		m.put("collect",Math.ceil(collect*1.0/pageSize));
		return m;
	}
	
	
}
