package sch.com.serviceImpl.wym;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.wymm.InfoQueryDao;
import sch.com.service.wym.InfoQueryService;
/**
 *  ��ѯͳ��
 * @author xiaoming
 *
 */

@Service
public class InfoQueryServiceImpl implements InfoQueryService{
	
	@Autowired
	private InfoQueryDao infoQueryDao;
	
	//��ѯͳ��
	@Override
	public List<HashMap<String, Object>> InfoListQuery() {
		List<HashMap<String,Object>> info = new ArrayList<HashMap<String,Object>>();
		info = infoQueryDao.InfoListQuery();
		for(int i=0;i<info.size();i++){
			if((info.get(i).get("STATUS_ID")+"").equals("2")){
				info.get(i).put("STATUS_NAME", "�����");
			}else if((info.get(i).get("STATUS_ID")+"").equals("3")){
				info.get(i).put("STATUS_NAME", "�ѷ���");
			}else if((info.get(i).get("STATUS_ID")+"").equals("4")){
				info.get(i).put("STATUS_NAME", "���¼�");
			}
		}
		return info;
	}

}









