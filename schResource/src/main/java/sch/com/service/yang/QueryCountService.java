package sch.com.service.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.QueryEntity;

public interface QueryCountService {
	/**
	 * ��ȡ�ϴ���Ϣͳ��
	 * @return
	 */
	public Map<String,Object> getUpInfo(QueryEntity qe);
	
	/**
	 * ��ȡ������Ϣͳ��
	 * @return
	 */
	public Map<String,Object> getDownInfo(QueryEntity qe);
	/**
	 * �ϴ���״ͼͳ��
	 * @param id
	 * @return
	 */
	public Map<String, Object> upPicture(Integer id);
	/**
	 * ������״ͼͳ��
	 * @param id
	 * @return
	 */
	public Map<String, Object> downPicture(Integer id);
}
