package sch.com.service.yang;

import java.util.List;
import java.util.Map;

import sch.com.entity.User;
import sch.com.entity.UserPage;

public interface UserService {
	/**
	 * �������ֲ����û�
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
	public Map<String,Object> selectAllUser(UserPage up);
	/**
	 * �����û���Ϣ
	 * @param u
	 * @return
	 */
	public String insertUser(User u);
	/**
	 * �����û�
	 * @param arr
	 * @return
	 */
	public String deleteUser(String arr);
	/**
	 * �����û�
	 * @param arr
	 * @return
	 */
	public String upUser(String arr);
	/**
	 * �޸��û�
	 * @param u
	 * @return
	 */
	public int updateUser(User u);
	/**
	 * �޸�����
	 * @param map
	 * @return
	 */
	public String updatePwd(Map<String, Object> map);
	
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
