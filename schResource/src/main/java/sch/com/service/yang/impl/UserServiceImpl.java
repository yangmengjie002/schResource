package sch.com.service.yang.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.yang.UserDao;
import sch.com.entity.User;
import sch.com.entity.UserPage;
import sch.com.service.yang.UserService;
import sch.com.utils.Md5Utils;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao ud;
	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return ud.getUser(username);
	}
	@Override
	public User getUserInfo(User u) {
		// TODO Auto-generated method stub
		return ud.getUserInfo(u);
	}
	@Override
	public Map<String,Object> selectAllUser(UserPage up) {
		// TODO Auto-generated method stub
		System.out.println(up.getUserName()+up.getPage()+";"+up.getRows());
		//��ȡ��ʼ��¼��
		int startIndex = (up.getPage()-1) * up.getRows();
		//��ȡ������¼��
		int endIndex = up.getPage() * up.getRows() + 1;
		up.setStartIndex(startIndex);
		up.setEndIndex(endIndex);
		//��ȡ�ܼ�¼��
		int total = ud.getCount(up);
		//��ȡ��¼
		List<Map<String, Object>> selectList = ud.selectAllUser(up);
		Map<String,Object> userMap = new HashMap<String,Object>();
		userMap.put("total", total);
		userMap.put("rows", selectList);
		return userMap;
		
	}
	@Override
	public String insertUser(User u) {
		if(u.getUserId() == null){
			String pwd = Md5Utils.md5(u.getUserPwd());
			u.setUserPwd(pwd);
			//�����û���
			int insertRole1 = ud.insertUser(u);
			int flag = 0;
			String[] ss = u.getArr().split(";");
			for (int i = 0; i < ss.length; i++) {
				int m = Integer.parseInt(ss[i]);
				flag += ud.insertUserRole(m);//�����û���ɫ��
			}
			if(flag == ss.length && insertRole1 == 1){
				return "success1";
			}
			return "error";
		}else{
			//�޸Ľ�ɫ��Ϣ
			ud.updateUser(u);
			System.out.println("nnnnnnnnnnnnnnnnnnnnnn");
			//ɾ���û���ɫ��Ĵ˽�ɫȨ��
			ud.deleteUserRole(u.getUserId());
			System.out.println("mmmmmmmmmmmmmmmmmmmmm");
			//���²����ɫȨ����Ϣ
			int flag = 0;
			String[] ss = u.getArr().split(";");
			for (int i = 0; i < ss.length; i++) {
				int m = Integer.parseInt(ss[i]);
				Map<String, Object> map = new HashMap<String,Object>();
				map.put("userId", u.getUserId());
				map.put("roleId", m);
				flag += ud.insertUserRoleByMap(map);//�����û���ɫ��
			}
			if(flag == ss.length){
				return "success2";
			}
			return "error";
		}
	}
	@Override
	public String deleteUser(String arr) {
		// TODO Auto-generated method stub
		String []ss = arr.split(";");
		int flag = 0;
		for (int i = 0; i < ss.length; i++) {
			flag += ud.deleteUser(Integer.parseInt(ss[i]));
		}
		if(flag == ss.length){
			return "success";
		}
		return "error";
	}
	@Override
	public String upUser(String arr) {
		// TODO Auto-generated method stub
		String []ss = arr.split(";");
		int flag = 0;
		for (int i = 0; i < ss.length; i++) {
			flag += ud.upUser(Integer.parseInt(ss[i]));
		}
		if(flag == ss.length){
			return "success";
		}
		return "error";
	}
	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return ud.updateUser(u);
	}
	@Override
	public String updatePwd(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int flag = ud.updatePwd(map);
		if(flag==1){
			return "success";
		}
		return "error";
	}
	@Override
	public List<Map<String, Object>> getUploadByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return ud.getUploadByUserId(userId);
	}
	@Override
	public List<Map<String, Object>> getDownloadByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return ud.getDownloadByUserId(userId);
	}
}
