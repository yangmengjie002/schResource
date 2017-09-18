package sch.com.service.wym;

import java.util.HashMap;
/**
 * 后台资源发布
 */
public interface ReleaseResourceService {

	
	//获得项目发布列表
	public HashMap<String,Object> ReleaseResourceQuery(Integer rows,Integer page);
		
	//更新资源上传表状态
	public void UploadUpdate(String s,Integer userid);
		
}
