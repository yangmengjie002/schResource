package sch.com.service.wym;

import java.util.HashMap;

public interface MajorInfoService {
	//查询某个专业下的资源 
	public HashMap<String,Object> MajorInfoQuery(Integer a,Integer currPage);

}
