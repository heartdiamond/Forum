package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ArticleDao;
import daoImpl.ArticleDaoImpl;
import pojo.ArticlePojo;

public class ArticleService {
	
	ArticleDao ad = new ArticleDaoImpl();
	
	/**
	 * 发表文章
	 * @param user_id
	 * @param kind
	 * @param title
	 * @param content
	 * @param time
	 * @return
	 */
	public int publish(int user_id, String kind, String title, String content, Date time){
		return ad.addArticle(user_id, kind, title, content, time);
	}
	
	/**
	 * 重新发表
	 * @param pojo
	 */
	public void rePublish(ArticlePojo pojo){
		ad.upDateArticle(pojo);
	}
	
	/**
	 * 删除文章
	 * @param pojo
	 */
	public void deleteArticle(ArticlePojo pojo){
		ad.deleteArticle(pojo);
		ad.deleteRead(pojo);
		ad.deleteLike(pojo);
		ad.deleteComment(pojo);
	}
	
	/**
	 * 获得所有文章
	 * @return
	 */
	public List<ArticlePojo> getAllArticlePojo(){
		return ad.getAllActiclePojo();
	}
	
	/**
	 * 根据id获得文章
	 * @param id
	 * @return
	 */
	public ArticlePojo getArticleById(int id){
		return ad.getArticleById(id);
	}
	
	/**
	 * 根据标题搜索文章
	 * @param title
	 * @return
	 */
	public List<ArticlePojo> searchArticlesByTitle(String title){
		return ad.getArticlesByTitle(title);
	}
	
	/**
	 * 根据内容搜索文章
	 * @param content
	 * @return
	 */
	public List<ArticlePojo> searchArticlesByContent(String content){
		return ad.searchArticlesByContent(content);
	}
	
	/**
	 * 根据类型搜索文章
	 * @param Kind
	 * @return
	 */
	public List<ArticlePojo> searchArticlesByKind(String Kind){
		return ad.searchArticlesByKind(Kind);
	}
	
	/**
	 * 根据作者搜索文章
	 * @param name
	 * @return
	 */
	public List<ArticlePojo> searchArticlesByUserName(String name){
		return ad.searchArticlesByUserName(name);
	}
	
	/**
	 * 得到用户的所有文章
	 * @param id
	 * @return
	 */
	public List<ArticlePojo> getArticlesByUserId(int id){
		return ad.getArticlesByUserId(id);
	}
	
	/**
	 * 得到指定用户指定类型的所有文章
	 * @param id
	 * @param kind
	 * @return
	 */
	public List<ArticlePojo> getArticlesByUserIdAndKind(int id,String kind){
		return ad.getArticlesByUserIdAndKind(id, kind);
	}
	
	/**
	 * 得到用户点赞的所有文章
	 * @param id
	 * @return
	 */
	public List<ArticlePojo> getArticlesByLike(int id){
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
		List<Integer> list_temp = ad.getArticlesIdByUserIdFromLike(id);
		for (Integer integer : list_temp) {
			ArticlePojo pojo = ad.getArticleById(integer);
			list.add(pojo);
		}
		return list;
	}
	
	/**
	 * 得到用户参与评论的所有文章
	 * @param id
	 * @return
	 */
	public List<ArticlePojo> getArticlesByComment(int id){
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
		List<Integer> list_temp = ad.getArticlesIdByUserIdFromComment(id);
		for (Integer integer : list_temp) {
			ArticlePojo pojo = ad.getArticleById(integer);
			list.add(pojo);
		}
		return list;
	}
	
}
