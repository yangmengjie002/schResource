package sch.com.service.wym;

import java.util.HashMap;

import sch.com.entity.ResourceParam;

public interface HuiFuDaoService {
	//�Ѿ��¼ܵ��б�
	public HashMap<String,Object> HuiFu(Integer rows,Integer page,ResourceParam rp);
	
	//������Դ�ϴ���
	public void HuiFuUpdate(String rowArr);
	
}
