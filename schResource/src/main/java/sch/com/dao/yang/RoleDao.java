package sch.com.dao.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.Role;



public interface RoleDao {
	/**
	 * ��ȡ���еĽ�ɫ��Ϣ
	 * @return
	 */
	public List<Map<String, Object>> getAllRole();
	/**
	 * �����û�����ȡ��ɫ��Ϣ
	 * @param userId
	 * @return
	 */
	public List<Map<String, Object>> getRole(int userId);
	/**
	 * ���ݽ�ɫID��ȡȨ��
	 * @param roleId
	 * @return
	 */
	public List<Map<String, Object>> getUrlByRoleId(int roleId);
	/**
	 * �����ɫ
	 * @param r
	 * @return
	 */
	public int insertRole(Role r);	
	/**
	 * �޸Ľ�ɫ
	 * @param r
	 * @return
	 */
	public int updateRole(Role r);
	/**
	 * ���ý�ɫ
	 * @param roleId
	 * @return
	 */
	public int deleteRole(int roleId);
	/**
	 * ���ý�ɫ
	 * @param roleId
	 * @return
	 */
	public int reverseRole(int roleId);
	/**
	 * ���ݽ�ɫID
	 * @param roleId
	 */
	public void deleteRoleUrl(int roleId);
	
	/**
	 * �����ɫȨ�ޱ�
	 * @param m
	 * @return
	 */
	public int insertRoleUrl(int m);
	/**
	 * ���ݽ�ɫID����Ȩ��
	 * @param map
	 * @return
	 */
	public int insertRoleUrlByMap(Map<String, Object> map);
	
}
