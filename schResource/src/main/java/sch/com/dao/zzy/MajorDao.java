package sch.com.dao.zzy;

import java.util.HashMap;
import java.util.List;

public interface MajorDao {
	/**
	 * ��ѯרҵ
	 * @return
	 */
	public List<HashMap<String, Object>> queryMajor();
	/**
	 * ͨ��Ժϵid��ѯרҵ
	 * @param selectId
	 * @return
	 */
	public List<HashMap<String, Object>> findMj(Integer selectId);
	/**
	 * ����רҵ
	 * @return
	 */
	public void insertMj(HashMap<String, Object> mjHm);
}
