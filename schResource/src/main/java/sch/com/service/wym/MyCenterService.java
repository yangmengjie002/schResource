package sch.com.service.wym;

import java.util.HashMap;
import java.util.List;

public interface MyCenterService {
	//��ȡ�ҵ��ϴ�
	public List<HashMap<String,Object>> MyUploadQuery(Integer currPage,Integer userid);
	
	//��ȡ�ҵ�����
	public List<HashMap<String,Object>> MyDownQuery(Integer currPage,Integer userid);
	
	//��ȡ�ҵ��ղ�
	public List<HashMap<String,Object>> MyCollectQuery(Integer currPage,Integer userid);
	
	//�ҵ��ϴ������ء��ղ�������
	public HashMap<String,Object> MyCountQuery(Integer userid);
	
}
