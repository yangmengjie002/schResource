package sch.com.service.wym;

import java.util.HashMap;
import java.util.List;

/**
 * ĳ����Դ����ҳ��
 * @author xiaoming
 *
 */
public interface InfoInfoService {	
	//ĳ����Դ����
	public HashMap<String,Object> InfoInfoQuery(Integer a);
	
	//�����Դ�����б�
	public List<HashMap<String,Object>> CommentQuery(Integer a,Integer currPage);
	
	//�����������
	public HashMap<String,Object> CommentCountQuery(Integer a);
	
	//�������۱�
	public void CommentInsert(HashMap<String,Object> m);
	
	//��ѯ�û��Ƿ����۹�
	public HashMap<String,Object> IsCommentQuery(Integer d,Integer useid);
	
	//�����ղ�
	public void CollectInsert(HashMap<String,Object> m);
	
	//ȡ���ղ�
	public void RemoveCollectDelete(HashMap<String,Object> m);
	
	//��������
	public void ScoreInsert(HashMap<String,Object> m);
	
	
	
	
	
	
	
}
