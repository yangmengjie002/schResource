package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

/**
 * ��ѯĳ��רҵ�µ���Դҳ��
 * @author xiaoming
 *
 */
public interface MajorInfoDao {
	//��ѯĳ��רҵ�µ���Դ 
	public List<HashMap<String,Object>> MajorInfoQuery(HashMap<String,Object> a);
	
	//��ѯĳ��רҵ�µ���Դ total
	public Integer MajorInfoTotal(Integer a);
	
	//��ѯĳ����Դ��ƽ����
	public Integer aveQuery(Integer a);
	
	//��ѯĳ����Դ��������
	public Integer downQuery(Integer a);
	
	
	
	
	
	
}
