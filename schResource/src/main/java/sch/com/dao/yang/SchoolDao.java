package sch.com.dao.yang;

import java.util.List;
import java.util.Map;

public interface SchoolDao {
	/**
	 * ��ȡѧԺ��Ϣ
	 * @return
	 */
	public List<Map<String, Object>> getInstitute();
	/**
	 * ����ѧԺID��ȡרҵ��Ϣ
	 * @return
	 */
	public List<Map<String, Object>> getMajor(int instituteId);
	
	/**
	 * ��ȡרҵ��Ϣ
	 * @return
	 */
	public List<Map<String, Object>> getAllMajor();
}
