package sch.com.service.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.QueryEntity;

public interface QueryCountService {
	/**
	 * 获取上传信息统计
	 * @return
	 */
	public Map<String,Object> getUpInfo(QueryEntity qe);
	
	/**
	 * 获取下载信息统计
	 * @return
	 */
	public Map<String,Object> getDownInfo(QueryEntity qe);
	/**
	 * 上传柱状图统计
	 * @param id
	 * @return
	 */
	public Map<String, Object> upPicture(Integer id);
	/**
	 * 下载柱状图统计
	 * @param id
	 * @return
	 */
	public Map<String, Object> downPicture(Integer id);
}
