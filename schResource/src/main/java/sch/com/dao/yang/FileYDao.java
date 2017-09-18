package sch.com.dao.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.ResourceYInfo;
/**
 * �ļ�����
 * @author yang
 *
 */
public interface FileYDao {
	/**
	 * �����ϴ�ID��ȡ�ļ��洢��Ϣ
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> getFileInfo(Integer id);
	/**
	 * ����������Դ��
	 * @param map
	 * @return
	 */
	public int insertDownload(Map<String,Object> map);
	/**
	 * ���ݺ�׺��ȡ���׺�йص��ļ���Ϣ
	 * @param postfix
	 * @return
	 */
	public List<Map<String, Object>> getResourceInfoFix(String postfix);
	/**
	 * �ϴ��ļ�
	 * @param resourceInfo
	 * @return
	 */
	public int fileUploadAll(ResourceYInfo resourceInfo);
	/**
	 * ��ѯ�û����������
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectDown(Map<String, Object> map);
	/**
	 * �����û�id��ȡԤ����Դ��Ϣ
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> showDown(Integer id);
}
