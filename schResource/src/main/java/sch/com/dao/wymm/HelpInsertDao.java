package sch.com.dao.wymm;

import java.util.HashMap;

public interface HelpInsertDao {
	//������Դ������
	public void HelpInsert(HashMap<String,Object> m);
	
	//������������name��ѯid
	public Integer marIdQuery(String s);
	
	//������Դ����name��ѯid
	public Integer typeIdQuery(String s);
}
