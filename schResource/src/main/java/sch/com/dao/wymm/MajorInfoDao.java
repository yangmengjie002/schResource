package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

/**
 * 查询某个专业下的资源页面
 * @author xiaoming
 *
 */
public interface MajorInfoDao {
	//查询某个专业下的资源 
	public List<HashMap<String,Object>> MajorInfoQuery(HashMap<String,Object> a);
	
	//查询某个专业下的资源 total
	public Integer MajorInfoTotal(Integer a);
	
	//查询某个资源的平均分
	public Integer aveQuery(Integer a);
	
	//查询某个资源的下载量
	public Integer downQuery(Integer a);
	
	
	
	
	
	
}
