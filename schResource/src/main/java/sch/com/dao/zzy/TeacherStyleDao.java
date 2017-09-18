package sch.com.dao.zzy;

import java.util.HashMap;
import java.util.List;

public interface TeacherStyleDao {
	/**
	 * ��ѯ��ʦ���
	 * @return
	 */
	public List<HashMap<String, Object>> findTeacher(String teacherName);
	/**
	 * �����ʦ���
	 */
	public void insertTeacher(HashMap<String, Object> hm);
	/**
	 * ɾ����ʦ
	 * @param teacher_id
	 * @return
	 */
	public int deleteTeacher(Integer teacher_id);
}
