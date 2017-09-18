package sch.com.dao.yang;

import java.util.Date;
import java.util.List;
import java.util.Map;

import sch.com.entity.QueryEntity;

public interface QueryCountDao {
	/**
	 * ��ȡ�ϴ���Ϣͳ��
	 * @return
	 */
	public List<Map<String,Object>> getUpInfo(QueryEntity qe);
	/**
	 * ��ȡ�ϴ���Ϣ������
	 * @return
	 */
	public int getUpCount(QueryEntity qe);
	
	/**
	 * ��ȡ������Ϣͳ��
	 * @return
	 */
	public List<Map<String,Object>> getDownInfo(QueryEntity qe);
	/**
	 * ��ȡ������Ϣ������
	 * @return
	 */
	public int getDownCount(QueryEntity qe);
	/**
	 * ��ѯѧԺĳ��ʱ���ļ��ϴ����
	 * @param date
	 * @return
	 */
	public List<Map<String, Object>> QueryInstitute(Date date);
	/**
	 * ��ѯĳѧԺ��ϵ�ļ��ϴ����
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryMajor(Map<String, Object> map);
	/**
	 * ��ѯѧԺĳ��ʱ���ļ��������
	 * @param date
	 * @return
	 */
	public List<Map<String, Object>> QueryInstituteDown(Date date);
	/**
	 * ��ѯĳѧԺ��ϵ�ļ��������
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryMajorDown(Map<String, Object> map);
	
}
