package sch.com.serviceImpl.wym;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.wymm.InfoInfoDao;
import sch.com.dao.wymm.MajorInfoDao;
import sch.com.service.wym.InfoInfoService;

/**
 * ĳ����Դ����ҳ��
 * @author xiaoming
 *
 */

@Service
public class InfoInfoServiceImpl implements InfoInfoService{
	@Autowired
	private InfoInfoDao infoInfoDao;
	@Autowired
	private MajorInfoDao  majorInfoDao;
	
	//ĳ����Դ����
	public HashMap<String, Object> InfoInfoQuery(Integer a) {
		List<HashMap<String,Object>> infoinfo = new ArrayList<HashMap<String,Object>>();
		infoinfo = infoInfoDao.InfoInfoQuery(a);
		List<HashMap<String,Object>> comment = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String,Object> m = new HashMap<String,Object>();
		Integer currPage = 1;
		Integer pageSize = 4;
		m.put("resourceid", a);	
		m.put("bigPage", currPage*pageSize);
		m.put("smallPage", (currPage-1)*pageSize);
		comment = infoInfoDao.CommentQuery(m);
		
		HashMap<String,Object> info = new HashMap<String,Object>();
		Integer ave = majorInfoDao.aveQuery(a);       //ƽ����
		Integer count = majorInfoDao.downQuery(a);    //��������
		for(int i=0;i<infoinfo.size();i++){
			infoinfo.get(i).put("ave", ave);
			infoinfo.get(i).put("count", count);
		}
		info.put("info", infoinfo);
		info.put("comment", comment);
		return info;
	}

	//�����Դ�����б�
	public List<HashMap<String, Object>> CommentQuery(Integer resourceid,Integer currPage) {
		if(currPage==null){
			currPage = 1;
		}
		Integer pageSize = 4;
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("resourceid", resourceid);	
		m.put("bigPage", currPage*pageSize);
		m.put("smallPage", (currPage-1)*pageSize);
		return infoInfoDao.CommentQuery(m);
	}
		
	//�����������
	public HashMap<String,Object> CommentCountQuery(Integer a){	
		Integer count = infoInfoDao.CommentCountQuery(a);
		Integer pageSize = 4;
		Integer totalPage = (int) Math.ceil(count*1.0/pageSize);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("totalPage", totalPage);
		map.put("count", count);
		return map;
	}

	//�������۱�
	public void CommentInsert(HashMap<String, Object> m) {
		infoInfoDao.CommentInsert(m);
	}

	//��ѯ�û��Ƿ����۹�
	public HashMap<String,Object> IsCommentQuery(Integer id,Integer userid) {
		HashMap<String,Object> m = new HashMap<String,Object>();
		m.put("user_id", userid);            //�û�ID�����ڸ���
		m.put("resourceId", id);
		HashMap<String,Object> info = new HashMap<String,Object>();
		info.put("comment", infoInfoDao.IsCommentQuery(m));
		info.put("collect", infoInfoDao.IsCollectQuery(m));
		return info;	
	}
	
	//�����ղ�
	public void CollectInsert(HashMap<String,Object> m){
		infoInfoDao.CollectInsert(m);
	}
	
	//ȡ���ղ�
	public void RemoveCollectDelete(HashMap<String,Object> m){
		infoInfoDao.RemoveCollectDelete(m);
	}
	
	//��������
	public void ScoreInsert(HashMap<String,Object> m){
		infoInfoDao.ScoreInsert(m);
	}

	
}







