package sch.com.service.wym;

import java.util.HashMap;

public interface HuiFuDaoService {
	//�Ѿ��¼ܵ��б�
	public HashMap<String,Object> HuiFu(Integer rows,Integer page);
	
	//������Դ�ϴ���
	public void HuiFuUpdate(String rowArr);
	
}
