package pojo;

import java.util.Date;

public class Comment {
	private int comment_id;// 评论ID
	private int article_id;// 帖子ID
	private String user_name;// 用户名
	private String comment_content;// 评论内容
	private Date comment_time;// 评论时间

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}

	public Comment(int comment_id, int article_id, String user_name, String comment_content, Date comment_time) {
		super();
		this.comment_id = comment_id;
		this.article_id = article_id;
		this.user_name = user_name;
		this.comment_content = comment_content;
		this.comment_time = comment_time;
	}

	public Comment(int article_id, String user_name, String comment_content, Date comment_time) {
		super();
		this.article_id = article_id;
		this.user_name = user_name;
		this.comment_content = comment_content;
		this.comment_time = comment_time;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", article_id=" + article_id + ", user_name=" + user_name
				+ ", comment_content=" + comment_content + ", comment_time=" + comment_time + "]";
	}

}
