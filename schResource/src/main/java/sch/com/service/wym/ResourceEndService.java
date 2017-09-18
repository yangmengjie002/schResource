package sch.com.service.wym;

import java.util.HashMap;

import sch.com.entity.ResourceParam;

public interface ResourceEndService {
	//获得资源结束列表
	public HashMap<String, Object> ResourceEnd(Integer rows,Integer page,ResourceParam rp);
	
	//插入资源下架表
	public void ResourceEndInsert(String s,Integer userid);
}
