package sch.com.serviceImpl.zzy;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.zzy.TeacherStyleDao;
import sch.com.service.zzy.Tb_teacherStyleService;
@Service
public class Tb_TeacherStyleServiceImpl implements Tb_teacherStyleService {
	@Autowired
	private TeacherStyleDao tStyleDao;
	/**
	 * ��ѯ��ʦ���
	 */
	public List<HashMap<String, Object>> findTeacher(String teacherName) {
		return tStyleDao.findTeacher(teacherName);
	}
	/**
	 * ���
	 */
	
	public void insertTeacher(HashMap<String, Object> hm) {
		tStyleDao.insertTeacher(hm);
		
	}
	/**
	 * ɾ��
	 */
	public int deleteTeacher(Integer teacher_id) {
		
		return tStyleDao.deleteTeacher(teacher_id);
	}

}
