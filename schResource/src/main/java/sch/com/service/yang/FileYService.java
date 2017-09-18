package sch.com.service.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.ResourceYInfo;

public interface FileYService {
	/**
	 * 根据ID查询下载文件信息
	 * @param userId
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> fileDown(Integer userId, Integer id);
	/**
	 * 根据后缀获取与后缀有关的文件信息
	 * @param postfix
	 * @return
	 */
	List<Map<String, Object>> getResourceInfoFix(String postfix);
	/**
	 * 上传文件信息
	 * @param resourceInfo
	 * @return
	 */
	int fileUploadAll(ResourceYInfo resourceInfo);
	/**
	 * 查询用户是否下载。
	 * @param id
	 * @return
	 */
	String selectDown(Map<String, Object> map);
	/**
	 * 根据ID获取资源信息
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> showDown(Integer id);

}
