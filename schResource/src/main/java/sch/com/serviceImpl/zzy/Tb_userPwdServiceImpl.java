package sch.com.serviceImpl.zzy;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.zzy.Tb_userPwdDao;
import sch.com.service.zzy.Tb_userPwdService;
@Service
public class Tb_userPwdServiceImpl implements Tb_userPwdService {
	@Autowired
	private Tb_userPwdDao userPwdDao;
	/**
	 * ÐÞ¸ÄÃÜÂë
	 */
	public void checkPwd(HashMap<String, Object> hm) {
		userPwdDao.checkPwd(hm);
	}

}
