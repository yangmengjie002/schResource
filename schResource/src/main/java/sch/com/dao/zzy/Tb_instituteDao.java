package sch.com.dao.zzy;

import java.util.HashMap;
import java.util.List;

public interface Tb_instituteDao {
	/**
	 * ��ѯѧԺ
	 */
	public List<HashMap<String, Object>> queryInst();
	/**
	 * ����ѧԺ
	 * @param hm
	 */
	public void insertInst(HashMap<String, Object> hm);
	
	
}
