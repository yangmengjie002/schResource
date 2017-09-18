package sch.com.service.wym;

import java.util.HashMap;

import sch.com.entity.ResourceParam;

public interface HuiFuDaoService {
	//已经下架的列表
	public HashMap<String,Object> HuiFu(Integer rows,Integer page,ResourceParam rp);
	
	//更新资源上传表
	public void HuiFuUpdate(String rowArr);
	
}
