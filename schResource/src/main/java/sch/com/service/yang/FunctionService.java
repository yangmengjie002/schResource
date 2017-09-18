package sch.com.service.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.PageBean;
import sch.com.entity.Power;

public interface FunctionService {
	/**
	 * ��ȡ���е�Ȩ��
	 * @param pb 
	 * @return
	 */
	public Map<String, Object> functionQuery(PageBean pb);
	/**
	 * �����û�ID�����û���Ȩ��
	 * @param userId
	 * @return
	 */
	public List<Map<String , Object>> functionQueryByUserId(int userId);
	
	/**
	 * ����Ȩ��
	 * @param p
	 * @return
	 */
	public String functionInsert(Power p);
	/**
	 * �����û�IDɾ��Ȩ��
	 * @param arr
	 * @return
	 */
	public String functionDelete(String arr);
	/**
	 * �޸��û���Ȩ�� 
	 * @param p
	 * @return
	 */
	public int functionUpdate(Power p);
	/**
	 * ����ID���û�ID��ȡȨ��
	 * @param userId
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> functionQueryByUserMap(int userId, Integer id);
	/**
	 * ��ȡȨ��
	 * @param m
	 * @return
	 */
	public List<Map<String, Object>> functionQueryByUserMap(Map<String, Object> m);
	/**
	 * ����Ȩ��
	 * @param arr
	 * @return
	 */
	public String functionUp(String arr);
	/**
	 * ����Ȩ��pID ��ȡȨ��
	 * @param id
	 * @return
	 */
	public List<Map<String, Object>> functionQueryByPowerMap(Map<String, Object> m);
	/**
	 * ��ȡ����Ȩ��
	 * @return
	 */
	public List<Map<String, Object>> functionQueryAll();
}
