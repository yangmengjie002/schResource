package sch.com.service.wym;

import java.util.HashMap;

import sch.com.entity.ResourceParam;
/**
 * ��̨��Դ����
 */
public interface ReleaseResourceService {

	
	//�����Ŀ�����б�
	public HashMap<String,Object> ReleaseResourceQuery(Integer rows,Integer page,ResourceParam rp);
		
	//������Դ�ϴ���״̬
	public void UploadUpdate(String s,Integer userid);
		
}
