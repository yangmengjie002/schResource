package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

public interface TbMajorDao {
	//���Ժ�µ�רҵ
	public List<HashMap<String, Object>> TbMajorDaoQuery(int a);
	
	
	//���רҵ�ڵ���Դ����
	public Integer queryTbResourceUploadId(int a);
}
