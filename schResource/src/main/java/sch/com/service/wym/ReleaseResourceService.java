package sch.com.service.wym;

import java.util.HashMap;
/**
 * ��̨��Դ����
 */
public interface ReleaseResourceService {

	
	//�����Ŀ�����б�
	public HashMap<String,Object> ReleaseResourceQuery(Integer rows,Integer page);
		
	//������Դ�ϴ���״̬
	public void UploadUpdate(String s,Integer userid);
		
}
