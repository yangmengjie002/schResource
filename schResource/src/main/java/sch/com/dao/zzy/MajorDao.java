package sch.com.dao.zzy;

import java.util.HashMap;
import java.util.List;

public interface MajorDao {
	/**
	 * 查询专业
	 * @return
	 */
	public List<HashMap<String, Object>> queryMajor();
	/**
	 * 通过院系id查询专业
	 * @param selectId
	 * @return
	 */
	public List<HashMap<String, Object>> findMj(Integer selectId);
	/**
	 * 插入专业
	 * @return
	 */
	public void insertMj(HashMap<String, Object> mjHm);
}
