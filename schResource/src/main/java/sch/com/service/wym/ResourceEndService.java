package sch.com.service.wym;

import java.util.HashMap;

import sch.com.entity.ResourceParam;

public interface ResourceEndService {
	//�����Դ�����б�
	public HashMap<String, Object> ResourceEnd(Integer rows,Integer page,ResourceParam rp);
	
	//������Դ�¼ܱ�
	public void ResourceEndInsert(String s,Integer userid);
}
