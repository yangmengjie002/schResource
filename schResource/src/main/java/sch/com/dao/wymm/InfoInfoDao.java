package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

/**
 * ĳ����Դ����ҳ��
 * @author xiaoming
 *
 */
public interface InfoInfoDao {
	//ĳ����Դ����
	public List<HashMap<String,Object>> InfoInfoQuery(Integer a);
	
	//�����Դ�����б�
	public List<HashMap<String,Object>> CommentQuery(HashMap<String,Object> m);
	
	//�����������
	public Integer CommentCountQuery(Integer a);
	
	//�������۱�
	public void CommentInsert(HashMap<String,Object> m);
	
	//��ѯ�û��Ƿ����۹�
	public List<HashMap<String,Object>> IsCommentQuery(HashMap<String,Object> m);
	
	//��ѯ�û��Ƿ��ղ�
	public List<HashMap<String,Object>> IsCollectQuery(HashMap<String,Object> m);
	
	//�����ղ�
	public void CollectInsert(HashMap<String,Object> m);
	
	//ȡ���ղ�
	public void RemoveCollectDelete(HashMap<String,Object> m);
	
	//��������
	public void ScoreInsert(HashMap<String,Object> m);
	
	
	
	
}
