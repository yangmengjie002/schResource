package sch.com.dao.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.ResourceYType;
/**
 * ��Դ���͹���
 * @author yang
 *
 */
public interface ResourceTypeYDao {
	/**
	 * ��ȡ��Դ������Ϣ
	 * @return
	 */
	public List<Map<String,Object>> getResourceType();
	/**
	 * ��ȡ��Դ��׺��Ϣ
	 * @return
	 */
	public List<Map<String,Object>> getResourcePostfix(int id);
	/**
	 * ������Դ��Ϣ��
	 * @param r
	 * @return
	 */
	public int insertResourceType(ResourceYType r);
	/**
	 * �����׺��
	 * @param ss
	 * @return
	 */
	public int insertResourcePostfix(String ss);
	/**
	 * �������ͱ�
	 * @param r
	 * @return
	 */
	public int updateResourceType(ResourceYType r);
	/**
	 * ɾ�������͵ĺ�׺
	 * @param resourceTypeId
	 */
	public void deleteRolePostfix(Integer resourceTypeId);
	/**
	 * ɾ����Դ����
	 * @param parseInt
	 * @return
	 */
	public int deleteResourceType(int id);
	/**
	 * ��ȡ��Դ��������Ϣ
	 * @return
	 */
	public List<Map<String, Object>> getResourceInfo();
	/**
	 * ��ȡ��������
	 * @return
	 */
	public List<Map<String, Object>> getResourceCount();
	/**
	 * ��ȡ��������
	 * @return
	 */
	public List<Map<String, Object>> getResourceScore();
	/**
	 * �޸Ĳ�����Դ���ͱ�
	 * @param map
	 * @return
	 */
	public int insertResourcePostfixByMap(Map<String, Object> map);
}
