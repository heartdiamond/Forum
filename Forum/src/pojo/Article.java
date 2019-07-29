package pojo;

import java.util.Date;

public class Article {
	private int article_id;// 帖子id
	private int user_id;// 用户id
	private String article_title;// 帖子标题
	private String article_content;// 帖子内容
	private Date article_time;// 发帖时间
	private String article_kind;// 帖子类型

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getArticle_content() {
		return article_content;
	}

	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	public Date getArticle_time() {
		return article_time;
	}

	public void setArticle_time(Date article_time) {
		this.article_time = article_time;
	}

	public String getArticle_kind() {
		return article_kind;
	}

	public void setArticle_kind(String article_kind) {
		this.article_kind = article_kind;
	}

	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", user_id=" + user_id + ", article_title=" + article_title
				+ ", article_content=" + article_content + ", article_time=" + article_time + ", article_kind="
				+ article_kind + "]";
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(int article_id, int user_id, String article_title, String article_content, Date article_time,
			String article_kind) {
		super();
		this.article_id = article_id;
		this.user_id = user_id;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_time = article_time;
		this.article_kind = article_kind;
	}

	public Article(int user_id, String article_title, String article_content, Date article_time,
			String article_kind) {
		super();
		this.user_id = user_id;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_time = article_time;
		this.article_kind = article_kind;
	}
}
