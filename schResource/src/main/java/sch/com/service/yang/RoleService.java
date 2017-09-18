package sch.com.service.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.Power;
import sch.com.entity.Role;

public interface RoleService {
	/**
	 * ��ȡ���еĽ�ɫ��Ϣ
	 * @return
	 */
	public List<Map<String, Object>> getAllRole();
	/**
	 * ���� ��ɫ
	 * @param arr
	 * @return
	 */
	public String RoleDelete(String arr);
	/**
	 * ���ý�ɫ
	 * @param arr
	 * @return
	 */
	public String roleUp(String arr);
	/**
	 * ������޸�Ȩ��
	 * @param p
	 * @param userId 
	 * @return
	 */
	public String roleInsertOrUpdate(Role p);
	
	/**
	 * ���ݽ�ɫID��ȡȨ��
	 * @param roleId
	 * @return
	 */
	public List<Map<String, Object>> getUrlByRoleId(int roleId);
	
	
}
