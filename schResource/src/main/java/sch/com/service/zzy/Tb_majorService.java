package sch.com.service.zzy;

import java.util.HashMap;
import java.util.List;

public interface Tb_majorService {
	/**
	 * 查询专业
	 * @return
	 */
	public List<HashMap<String, Object>> queryMajor();
	/**
	 * 
	 * @param selectId
	 * @return
	 */
	public List<HashMap<String, Object>> findMj(Integer selectId);
	/**
	 * 插入专业
	 * @param mjHm
	 */
	public void insertMj(HashMap<String, Object> mjHm);
}
