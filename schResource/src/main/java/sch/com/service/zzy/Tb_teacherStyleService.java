package sch.com.service.zzy;

import java.util.HashMap;
import java.util.List;

public interface Tb_teacherStyleService {
	/**
	 * ��ѯ��ʦ���
	 * @return
	 */
	public List<HashMap<String,Object>> findTeacher();
	/**
	 * �����ʦ���
	 */
	public void insertTeacher(HashMap<String, Object> hm);
	/**
	 * ɾ��
	 * @param teacher_id
	 * @return
	 */
	public int deleteTeacher(Integer teacher_id);
}
