package sch.com.service.zzy;

import java.util.HashMap;
import java.util.List;

public interface Tb_instituteService {
	/**
	 * ��ѯѧԺ
	 * @return
	 */
	public List<HashMap<String, Object>> queryInst();
	/**
	 * ���ѧԺ
	 */
	public void insertInst(HashMap<String, Object> hm);
}
