package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

public interface ResourceEndDao {
	//获得资源结束列表
	public List<HashMap<String,Object>> ResourceEnd(HashMap<String,Object> m);
	
	//获得资源结束列表total
	public Integer ResourceEndTotal();
	
	//插入资源下架表
	public void ResourceEndInsert(HashMap<String,Object> m);
		
}
