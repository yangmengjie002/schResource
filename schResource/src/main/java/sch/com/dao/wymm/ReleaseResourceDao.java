package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;
/**
 * ��̨��Դ����
 */
public interface ReleaseResourceDao {	
	//�����Ŀ�����б�
	public List<HashMap<String,Object>> ReleaseResourceQuery(HashMap<String,Object> m);
	
	//�����Դ�����б�total
	public Integer ReleasetotalQuery();
	
	//������Դ��˱�
	public void ReleaseResourceInsert(HashMap<String,Object> m);
}
