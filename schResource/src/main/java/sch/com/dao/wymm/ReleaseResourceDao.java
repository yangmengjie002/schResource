package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;
/**
 * 后台资源发布
 */
public interface ReleaseResourceDao {	
	//获得项目发布列表
	public List<HashMap<String,Object>> ReleaseResourceQuery(HashMap<String,Object> m);
	
	//获得资源发布列表total
	public Integer ReleasetotalQuery();
	
	//插入资源审核表
	public void ReleaseResourceInsert(HashMap<String,Object> m);
}
