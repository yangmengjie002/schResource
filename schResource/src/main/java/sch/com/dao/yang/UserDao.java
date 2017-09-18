package sch.com.dao.yang;


import java.util.List;
import java.util.Map;

import sch.com.entity.User;
import sch.com.entity.UserPage;

public interface UserDao {
	/**
	 * �����û�����ȡ�û���Ϣ
	 * @param username
	 * @return
	 */
	public User getUser(String username);
	/**
	 * ��ȡ�û���Ϣ
	 * @param u
	 * @return
	 */
	public User getUserInfo(User u);
	/**
	 * ��ѯ�û���Ϣ
	 * @param up 
	 * @param up
	 * @return
	 */
	public List<Map<String, Object>> selectAllUser(UserPage up);
	/**
	 * �����û���Ϣ
	 * @param u
	 * @return
	 */
	public int insertUser(User u);
	/**
	 * ��ȡ���еļ�¼
	 * @param up 
	 * @return
	 */
	public int getCount(UserPage up);
	/**
	 * �����û�
	 * @param userId
	 * @return
	 */
	public int deleteUser(int userId);
	/**
	 * �����û�
	 * @param userId
	 * @return
	 */
	public int upUser(int userId);
	/**
	 * �޸��û�
	 * @param u
	 * @return
	 */
	public int updateUser(User u);
	/**
	 * �����û���ɫ��
	 * @param m
	 * @return
	 */
	public int insertUserRole(int m);
	/**
	 * �����û�IDɾ�����ɫ
	 * @param userId
	 */
	public void deleteUserRole(Integer userId);
	/**
	 * �޸��û�����
	 * @param map
	 * @return
	 */
	public int updatePwd(Map<String, Object> map);
	/**
	 * �����ɫ�û���
	 * @param map
	 * @return
	 */
	public int insertUserRoleByMap(Map<String, Object> map);
	/**
	 * �����û��������ϴ���Ϣ
	 * @return
	 */
	public List<Map<String, Object>> getUploadByUserId(Integer userId);
	
	/**
	 * �����û�������������Ϣ
	 * @return
	 */
	public List<Map<String, Object>> getDownloadByUserId(Integer userId);
}
