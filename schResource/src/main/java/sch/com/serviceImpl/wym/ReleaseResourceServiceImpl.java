package sch.com.serviceImpl.wym;

/**
 * ��̨��Դ����
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sch.com.dao.wymm.CheckQueryDao;
import sch.com.dao.wymm.ReleaseResourceDao;
import sch.com.service.wym.ReleaseResourceService;
import sch.com.utils.DateUtils;

@Service
public class ReleaseResourceServiceImpl implements ReleaseResourceService{
	@Autowired
	private ReleaseResourceDao releaseResourceDao;
	@Autowired
	private CheckQueryDao checkQueryDao;
	
    //�����Դ�����б�
	public HashMap<String,Object> ReleaseResourceQuery(Integer rows,Integer page) {
		List<HashMap<String,Object>> re = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("bigPage", rows*page);
		param.put("smallPage", rows*(page-1));
		re = releaseResourceDao.ReleaseResourceQuery(param);
		Integer total = releaseResourceDao.ReleasetotalQuery();
		HashMap<String,Object> reMap = new HashMap<String,Object>();
		reMap.put("rows", re);
		reMap.put("total",total);
		return reMap;
	}

	@Override
	//������Դ�ϴ���Ͳ�����Դ������
	@Transactional
	public void UploadUpdate(String s,Integer userid) {
		String[] ss=s.split(",");
		HashMap<String,Object> m = new HashMap<String,Object>();
		HashMap<String,Object> insert = new HashMap<String,Object>();
		for(int i=0;i<ss.length;i++){
			m.put("resourceId", ss[i]);
			m.put("status_id", 3);
			checkQueryDao.tbResourceUploadUpdate(m);
			
			insert.put("resourceId",ss[i]);
			insert.put("release_date", DateUtils.dateToStrLong(new Date()));
			insert.put("user_id", userid);	//�˴�Ϊ�����ID,������Ҫ����
			releaseResourceDao.ReleaseResourceInsert(insert);
		}			
	}

}
