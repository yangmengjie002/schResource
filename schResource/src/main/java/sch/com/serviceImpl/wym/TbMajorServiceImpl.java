package sch.com.serviceImpl.wym;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import sch.com.dao.wymm.TbMajorDao;
import sch.com.service.wym.TbMajorService;



@Service
public class TbMajorServiceImpl implements TbMajorService{
	@Autowired
	private TbMajorDao maDao;
	
	//���Ժϵ�����רҵ
	public String TbMajorDaoQuery(Integer a){
		String majorMapStr = JSON.toJSONString(maDao.TbMajorDaoQuery(a));
		return majorMapStr;
	}


	//���רҵ�ڵ���Դ����
	public Integer queryTbResourceUploadId(Integer a) {
		return maDao.queryTbResourceUploadId(a);
	}
}
