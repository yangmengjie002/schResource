package sch.com.service.wym;

import java.util.HashMap;
import java.util.List;

public interface CheckQueryService {
	//��Ҫ��˵������б�
	public HashMap<String,Object> checkQuery(Integer rows,Integer page);
	
	//��������ϵ��ѯ
	public List<HashMap<String,Object>> checkMajQuery(String m);
	
	
	//������˱�͸�����Դ�ϴ���״̬
	public void checkInsert(Integer resourceId,String checkIdea,Integer checkStatuId,String major_name,Integer id);
	
}
