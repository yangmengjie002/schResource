package sch.com.dao.yang;

import java.util.Date;
import java.util.List;
import java.util.Map;

import sch.com.entity.QueryEntity;

public interface QueryCountDao {
	/**
	 * 获取上传信息统计
	 * @return
	 */
	public List<Map<String,Object>> getUpInfo(QueryEntity qe);
	/**
	 * 获取上传信息总条数
	 * @return
	 */
	public int getUpCount(QueryEntity qe);
	
	/**
	 * 获取下载信息统计
	 * @return
	 */
	public List<Map<String,Object>> getDownInfo(QueryEntity qe);
	/**
	 * 获取下载信息总条数
	 * @return
	 */
	public int getDownCount(QueryEntity qe);
	/**
	 * 查询学院某段时间文件上传情况
	 * @param date
	 * @return
	 */
	public List<Map<String, Object>> QueryInstitute(Date date);
	/**
	 * 查询某学院各系文件上传情况
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryMajor(Map<String, Object> map);
	/**
	 * 查询学院某段时间文件下载情况
	 * @param date
	 * @return
	 */
	public List<Map<String, Object>> QueryInstituteDown(Date date);
	/**
	 * 查询某学院各系文件下载情况
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryMajorDown(Map<String, Object> map);
	
}
