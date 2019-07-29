package service;

import java.util.List;

import pojo.ArticlePojo;

public class SearchService {
	
	ArticleService as = new ArticleService();
	
	/**
	 * 根据标题搜索文章
	 * @param title
	 * @return
	 */
	public List<ArticlePojo> searchArticlesByTitle(String title){
		return as.searchArticlesByTitle(title);
	}
	
	/**
	 * 根据内容搜索文章
	 * @param content
	 * @return
	 */
	public List<ArticlePojo> searchArticlesByContent(String content){
		return as.searchArticlesByContent(content);
	}
	
	/**
	 * 根据作者搜索文章
	 * @param name
	 * @return
	 */
	public List<ArticlePojo> searchArticlesByUserName(String name){
		return as.searchArticlesByUserName(name);
	}
	
	/**
	 * 根据类型上搜索文章
	 * @param kind
	 * @return
	 */
	public List<ArticlePojo> searchArticlesByKind(String kind){
		return as.searchArticlesByKind(kind);
	}
}
