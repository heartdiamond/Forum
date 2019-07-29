package dao;


import java.util.Date;
import java.util.List;

import pojo.Comment;

public interface ReadDao {
	/**
	 * 获得阅读次数
	 * @param article_id
	 * @return
	 */
	int getReadNum(int article_id);
	
	/**
	 * 阅读次数+1
	 * @param article_id
	 */
	void addReadNum(int article_id);
	
	/**
	 * 添加新的文章
	 * @param article_id
	 */
	void addArticle(int article_id);
	
	/**
	 * 点赞文章
	 * @param article_id
	 * @param user_id
	 */
	void likeArticle(int article_id,int user_id);
	
	/**
	 * 取消点赞
	 * @param article_id
	 * @param user_id
	 */
	void disLikeArticle(int article_id,int user_id);
	
	/**
	 * 获得总的点赞数
	 * @param article_id
	 * @return
	 */
	int getLikeNum(int article_id);
	
	/**
	 * 判断是不是已经点赞
	 * @param article_id
	 * @param user_id
	 * @return
	 */
	boolean isLike(int article_id,int user_id);
	
	/**
	 * 添加评论
	 * @param article_id
	 * @param user_id
	 * @param comment_content
	 * @param time
	 */
	void addComment(int article_id,int user_id,String comment_content,Date time);
	
	/**
	 * 获得文章的所有评论
	 * @param article_id
	 * @return
	 */
	List<Comment> getAllComments(int article_id);
	
	/**
	 * 获得评论数
	 * @param article_id
	 * @return
	 */
	int getCommentsNum(int article_id);
}
