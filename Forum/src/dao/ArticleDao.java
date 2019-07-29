package dao;


import java.util.Date;
import java.util.List;

import pojo.ArticlePojo;

public interface ArticleDao {
	
	/**
	 *  添加帖子
	 * @param user_id 作者id
	 * @param kind	帖子类型
	 * @param title	标题
	 * @param content 正文
	 * @param time 发帖时间
	 */
	int addArticle(int user_id,String kind,String title,String content,Date time);
	
	/**
	 * 获得所有帖子
	 * @return
	 */
	List<ArticlePojo> getAllActiclePojo();
	
	/**
	 * 根据文章ID获得文章
	 * @param id
	 * @return
	 */
	ArticlePojo getArticleById(int id);
	
	/**
	 * 根据文章标题查找
	 * @param title
	 * @return
	 */
	List<ArticlePojo> getArticlesByTitle(String title);
	
	/**
	 * 根据文章内容
	 * @param title
	 * @return
	 */
	List<ArticlePojo> searchArticlesByContent(String content);
	
	/**
	 * 根据文章作者
	 * @param name
	 * @return
	 */
	List<ArticlePojo> searchArticlesByUserName(String name);
	
	/**
	 * 根据文章类别
	 * @param name
	 * @return
	 */
	List<ArticlePojo> searchArticlesByKind(String kind);
	
	/**
	 * 根据用户ID获取该用户的全部文章
	 * @param id
	 * @return
	 */
	List<ArticlePojo> getArticlesByUserId(int id);
	
	/**
	 * 根据用户ID及类别获取该用户的文章
	 * @param id
	 * @return
	 */
	List<ArticlePojo> getArticlesByUserIdAndKind(int id,String kind);
	
	/**
	 * 所得用户点赞的所有文章ID
	 * @param id
	 * @return
	 */
	List<Integer> getArticlesIdByUserIdFromLike(int id);
	
	/**
	 * 所得用户评论的所有文章ID
	 * @param id
	 * @return
	 */
	List<Integer> getArticlesIdByUserIdFromComment(int id);
	
	/**
	 * 更新文章
	 * 标题,内容,类型
	 * @param pojo
	 */
	void upDateArticle(ArticlePojo pojo);
	
	/**
	 * 删除文章
	 * @param pojo
	 */
	void deleteArticle(ArticlePojo pojo);
	
	/**
	 * 删除文章阅读表
	 * @param pojo
	 */
	void deleteRead(ArticlePojo pojo);
	
	/**
	 * 删除文章点赞表
	 * @param pojo
	 */
	void deleteLike(ArticlePojo pojo);
	
	/**
	 * 删除文章评论表
	 * @param pojo
	 */
	void deleteComment(ArticlePojo pojo);
}
