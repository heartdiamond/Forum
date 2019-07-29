package service;

import java.util.Date;
import java.util.List;

import dao.ReadDao;
import daoImpl.ReadDaoImpl;
import pojo.Comment;

public class ReadService {
	
	 private ReadDao rd = new ReadDaoImpl();
	 
	 /**
	  * 为新文章添加阅读表
	  * @param id
	  */
	 public void addArticle(int id){
		 rd.addArticle(id);
	 }
	 
	 /**
	  * 阅读文章,阅读次数+1
	  * @param id
	  */
	 public void read(int id){
		 rd.addReadNum(id);
	 }
	 
	 /**
	  * 获得指定文章的阅读次数
	  * @param id
	  * @return
	  */
	 public int getReadNum(int id){
		 return rd.getReadNum(id);
	 }
	 
	 /**
	  * 获得指定文章的点赞数
	  * @param id
	  * @return
	  */
	 public int getLikeNum(int id){
		 return rd.getLikeNum(id);
	 }
	 
	 /**
	  * 点赞
	  * @param article_id
	  * @param user_id
	  */
	 public void like(int article_id,int user_id){
		 rd.likeArticle(article_id, user_id);
	 }
	 
	 /**
	  * 取消点赞
	  * @param article_id
	  * @param user_id
	  */
	 public void unlike(int article_id,int user_id){
		 rd.disLikeArticle(article_id, user_id);
	 }
	 
	 /**
	  * 判断是不是已经点赞
	  * @param article_id
	  * @param user_id
	  * @return
	  */
	 public boolean isLike(int article_id,int user_id){
		 return rd.isLike(article_id, user_id);
	 }
	 
	 /**
	  * 添加评论
	  * @param article_id
	  * @param user_id
	  * @param comment_content
	  * @param time
	  */
	 public void addComment(int article_id, int user_id, String comment_content, Date time){
		 rd.addComment(article_id, user_id, comment_content, time);
	 }
	 
	 /**
	  * 获得所有评论
	  * @param article_id
	  * @return
	  */
	 public List<Comment> getAllComments(int article_id){
		 return rd.getAllComments(article_id);
	 }
	 
	 /**
	  * 获得评论数
	  * @param article_id
	  * @return
	  */
	 public int getCommentsNum(int article_id){
		 return rd.getCommentsNum(article_id);
	 }
}
