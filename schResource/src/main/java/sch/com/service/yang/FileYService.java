package sch.com.service.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.ResourceYInfo;

public interface FileYService {
	/**
	 * ����ID��ѯ�����ļ���Ϣ
	 * @param userId
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> fileDown(Integer userId, Integer id);
	/**
	 * ���ݺ�׺��ȡ���׺�йص��ļ���Ϣ
	 * @param postfix
	 * @return
	 */
	List<Map<String, Object>> getResourceInfoFix(String postfix);
	/**
	 * �ϴ��ļ���Ϣ
	 * @param resourceInfo
	 * @return
	 */
	int fileUploadAll(ResourceYInfo resourceInfo);
	/**
	 * ��ѯ�û��Ƿ����ء�
	 * @param id
	 * @return
	 */
	String selectDown(Map<String, Object> map);
	/**
	 * ����ID��ȡ��Դ��Ϣ
	 * @param id
	 * @return
	 */
	List<Map<String, Object>> showDown(Integer id);

}
