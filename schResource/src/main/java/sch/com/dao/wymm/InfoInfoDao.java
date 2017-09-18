package sch.com.dao.wymm;

import java.util.HashMap;
import java.util.List;

/**
 * 某个资源详情页面
 * @author xiaoming
 *
 */
public interface InfoInfoDao {
	//某个资源详情
	public List<HashMap<String,Object>> InfoInfoQuery(Integer a);
	
	//获得资源评论列表
	public List<HashMap<String,Object>> CommentQuery(HashMap<String,Object> m);
	
	//获得评论总数
	public Integer CommentCountQuery(Integer a);
	
	//插入评论表
	public void CommentInsert(HashMap<String,Object> m);
	
	//查询用户是否评论过
	public List<HashMap<String,Object>> IsCommentQuery(HashMap<String,Object> m);
	
	//查询用户是否收藏
	public List<HashMap<String,Object>> IsCollectQuery(HashMap<String,Object> m);
	
	//插入收藏
	public void CollectInsert(HashMap<String,Object> m);
	
	//取消收藏
	public void RemoveCollectDelete(HashMap<String,Object> m);
	
	//插入评分
	public void ScoreInsert(HashMap<String,Object> m);
	
	
	
	
}
