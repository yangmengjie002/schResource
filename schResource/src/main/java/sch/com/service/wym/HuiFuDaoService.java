package sch.com.service.wym;

import java.util.HashMap;

public interface HuiFuDaoService {
	//已经下架的列表
	public HashMap<String,Object> HuiFu(Integer rows,Integer page);
	
	//更新资源上传表
	public void HuiFuUpdate(String rowArr);
	
}
