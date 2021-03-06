package sch.com.serviceImpl.zzy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.zzy.InformationDao;
import sch.com.entity.Tb_information;
import sch.com.service.zzy.Tb_informationService;
@Service
public class Tb_informationServiceImpl implements Tb_informationService{
	@Autowired
	private InformationDao tb_informationDao;
	/**
	 * 获取资讯
	 */
	public List<Tb_information> getList() {
		return tb_informationDao.getList();
	}
	/**
	 * 插入资讯
	 */
	@Override
	public void insertInfo(HashMap<String, Object> hm) {
		tb_informationDao.insertInfo(hm);
		
	}
	/**
	 * 删除资讯
	 */
	@Override
	public int deleteInfo(Integer informationID) {
		return tb_informationDao.deleteInfo(informationID);
	}
	/**
	 * 修改资讯
	 */
	@Override
	public void updateInfo(HashMap<String, Object> hsm) {
		tb_informationDao.updateInfo(hsm);
	}
	
	
	
	

}
