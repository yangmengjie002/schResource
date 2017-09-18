package sch.com.serviceImpl.zzy;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sch.com.dao.zzy.Tb_majorDao;
import sch.com.service.zzy.Tb_majorService;
@Service
public class Tb_majorServiceImpl implements Tb_majorService{
	@Autowired
	private Tb_majorDao md;
	/**
	 * ��ȡרҵ
	 */
	public List<HashMap<String, Object>> queryMajor() {
			
			return md.queryMajor();
	}
	/**
	 * ͨ��ѧԺID��ȡרҵ
	 */
	public List<HashMap<String,Object>> findMj(Integer selectId) {
		return md.findMj(selectId);
	}
	/**
	 * ����רҵ
	 */
	public void insertMj(HashMap<String, Object> mjHm) {
		md.insertMj(mjHm);
	}
	
}
