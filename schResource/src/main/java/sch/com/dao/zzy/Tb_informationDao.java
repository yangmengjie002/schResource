package sch.com.dao.zzy;

import java.util.HashMap;
import java.util.List;

import sch.com.entity.Tb_information;

public interface Tb_informationDao {
	/**
	 * 获取资讯表内容
	 * @return
	 */
	public List<Tb_information> getList();
	/**
	 * 插入资讯信息
	 * @param tbInfo
	 * @return
	 */
	public void insertInfo(HashMap<String, Object> hm);
	
	/**
	 * 删除资讯
	 * @param informationID
	 * @return
	 */
	public int deleteInfo(Integer informationID);
	/**
	 * 修改资讯
	 * @param hsm
	 */
	public void updateInfo(HashMap<String, Object> hsm);
	
	
}
