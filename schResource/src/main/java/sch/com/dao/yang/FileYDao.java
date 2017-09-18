package sch.com.dao.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.ResourceYInfo;
/**
 * 文件下载
 * @author yang
 *
 */
public interface FileYDao {
	/**
	 * 根据上传ID获取文件存储信息
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getFileInfo(Integer id);
	/**
	 * 插入下载资源表
	 * @param map
	 * @return
	 */
	public int insertDownload(Map<String,Object> map);
	/**
	 * 根据后缀获取与后缀有关的文件信息
	 * @param postfix
	 * @return
	 */
	public List<Map<String, Object>> getResourceInfoFix(String postfix);
	/**
	 * 上传文件
	 * @param resourceInfo
	 * @return
	 */
	public int fileUploadAll(ResourceYInfo resourceInfo);
	/**
	 * 查询用户的下载情况
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectDown(Map<String, Object> map);
	/**
	 * 根据用户id获取预览资源信息
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> showDown(Integer id);
}
