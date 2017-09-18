package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

/**
 * 个人中心相关操作
 * @author xiaoming
 *
 */
public interface MyCenterDao {
	//获取我的上传
	public List<HashMap<String,Object>> MyUploadQuery(HashMap<String,Object> m);
	
	//获取我的下载
	public List<HashMap<String,Object>> MyDownQuery(HashMap<String,Object> m);
	
	//获取我的收藏
	public List<HashMap<String,Object>> MyCollectQuery(HashMap<String,Object> m);
	
	//我的上传总条数
	public Integer MyUploadCount(Integer userid);
	
	//我的下载总条数
	public Integer MyDownCount(Integer userid);
	
	//我的收藏总条数
	public Integer MyCollectCount(Integer userid);
}






