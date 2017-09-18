package sch.com.service.wym;

import java.util.HashMap;
import java.util.List;

public interface MyCenterService {
	//获取我的上传
	public List<HashMap<String,Object>> MyUploadQuery(Integer currPage,Integer userid);
	
	//获取我的下载
	public List<HashMap<String,Object>> MyDownQuery(Integer currPage,Integer userid);
	
	//获取我的收藏
	public List<HashMap<String,Object>> MyCollectQuery(Integer currPage,Integer userid);
	
	//我的上传、下载、收藏总条数
	public HashMap<String,Object> MyCountQuery(Integer userid);
	
}
