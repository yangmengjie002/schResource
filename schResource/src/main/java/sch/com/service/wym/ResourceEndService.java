package sch.com.service.wym;

import java.util.HashMap;

public interface ResourceEndService {
	//获得资源结束列表
	public HashMap<String, Object> ResourceEnd(Integer rows,Integer page);
	
	//插入资源下架表
	public void ResourceEndInsert(String s,Integer userid);
}
