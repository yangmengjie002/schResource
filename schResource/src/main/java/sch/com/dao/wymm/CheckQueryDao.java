package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

public interface CheckQueryDao {
	//��Ҫ��˵������б�
	public List<HashMap<String,Object>> checkQuery(HashMap<String,Object> m);
	
	//����������total
	public Integer checkTotalQuery();
	
	//��������ϵ��ѯ
	public List<HashMap<String,Object>> checkMajQuery(String m);
	
	//ͨ��רҵ���ƻ����ID
	public Integer checkMajIDQuery(String m);
	
	//������˱�
	public void checkInsert(HashMap<String,Object> m);
	
	//������Դ�ϴ���״̬
	public void tbResourceUploadUpdate(HashMap<String,Object> m);
	
	//������Դ�ϴ�����������
	public void tbUploadMajUpdate(HashMap<String,Object> m);
	
}
