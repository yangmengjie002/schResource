package sch.com.service.wym;

import java.util.HashMap;

public interface ResourceEndService {
	//�����Դ�����б�
	public HashMap<String, Object> ResourceEnd(Integer rows,Integer page);
	
	//������Դ�¼ܱ�
	public void ResourceEndInsert(String s,Integer userid);
}
