package sch.com.dao.zzy;

import java.util.HashMap;
import java.util.List;

import sch.com.entity.Tb_information;

public interface InformationDao {
	/**
	 * ��ȡ��Ѷ������
	 * @return
	 */
	public List<Tb_information> getList();
	/**
	 * ������Ѷ��Ϣ
	 * @param tbInfo
	 * @return
	 */
	public void insertInfo(HashMap<String, Object> hm);
	
	/**
	 * ɾ����Ѷ
	 * @param informationID
	 * @return
	 */
	public int deleteInfo(Integer informationID);
	/**
	 * �޸���Ѷ
	 * @param hsm
	 */
	public void updateInfo(HashMap<String, Object> hsm);
	
	
}
