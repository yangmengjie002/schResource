package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

/**
 * ����������ز���
 * @author xiaoming
 *
 */
public interface MyCenterDao {
	//��ȡ�ҵ��ϴ�
	public List<HashMap<String,Object>> MyUploadQuery(HashMap<String,Object> m);
	
	//��ȡ�ҵ�����
	public List<HashMap<String,Object>> MyDownQuery(HashMap<String,Object> m);
	
	//��ȡ�ҵ��ղ�
	public List<HashMap<String,Object>> MyCollectQuery(HashMap<String,Object> m);
	
	//�ҵ��ϴ�������
	public Integer MyUploadCount(Integer userid);
	
	//�ҵ�����������
	public Integer MyDownCount(Integer userid);
	
	//�ҵ��ղ�������
	public Integer MyCollectCount(Integer userid);
}






