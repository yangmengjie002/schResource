package sch.com.serviceImpl.zzy;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.zzy.UserPwdDao;
import sch.com.service.zzy.Tb_userPwdService;
@Service
public class Tb_userPwdServiceImpl implements Tb_userPwdService {
	@Autowired
	private UserPwdDao userPwdDao;
	/**
	 * ÐÞ¸ÄÃÜÂë
	 */
	public void checkPwd(HashMap<String, Object> hm) {
		userPwdDao.checkPwd(hm);
	}

}
