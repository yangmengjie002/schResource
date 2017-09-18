package sch.com.serviceImpl.wym;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.wymm.ResourceInfoDao;
import sch.com.service.wym.ResourceInfoService;

@Service
public class ResourceInfoServiceImpl implements ResourceInfoService{
	@Autowired
	private ResourceInfoDao resourceInfoDao;
	
	//����ѷ�����Ϣ�б�
	public List<HashMap<String,Object>> InfoQuery(){
		return resourceInfoDao.InfoQuery();
	}
}







