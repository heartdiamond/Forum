package pojo;

import java.util.Date;

public class Dynamic {
	private int dynamic_id;//动态id
	private int accept_id;//接收方id
	private int send_id;//发送方id
	private String user_name;//发送方用户名
	private int article_id;//文章id
	private String article_title;//文章标题
	private int dynamic_kind;//动态类型
	private String comment_content;//评论内容
	private Date dynamic_time;//动态时间
	private int islooked;//是否已读

	public Dynamic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dynamic(int dynamic_id, int accept_id, int send_id, int article_id, int dynamic_kind, String comment_content,
			Date dynamic_time, int islooked) {
		super();
		this.dynamic_id = dynamic_id;
		this.accept_id = accept_id;
		this.send_id = send_id;
		this.article_id = article_id;
		this.dynamic_kind = dynamic_kind;
		this.comment_content = comment_content;
		this.dynamic_time = dynamic_time;
		this.islooked = islooked;
	}

	public Dynamic(int accept_id, int send_id, int article_id, int dynamic_kind, String comment_content,
			Date dynamic_time, int islooked) {
		super();
		this.accept_id = accept_id;
		this.send_id = send_id;
		this.article_id = article_id;
		this.dynamic_kind = dynamic_kind;
		this.comment_content = comment_content;
		this.dynamic_time = dynamic_time;
		this.islooked = islooked;
	}
	
	public Dynamic(int accept_id, int send_id, int article_id, int dynamic_kind, String comment_content) {
		super();
		this.accept_id = accept_id;
		this.send_id = send_id;
		this.article_id = article_id;
		this.dynamic_kind = dynamic_kind;
		this.comment_content = comment_content;
	}

	public Dynamic(int accept_id, int send_id, int article_id, int dynamic_kind) {
		super();
		this.accept_id = accept_id;
		this.send_id = send_id;
		this.article_id = article_id;
		this.dynamic_kind = dynamic_kind;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public int getDynamic_id() {
		return dynamic_id;
	}

	public void setDynamic_id(int dynamic_id) {
		this.dynamic_id = dynamic_id;
	}

	public int getAccept_id() {
		return accept_id;
	}

	public void setAccept_id(int accept_id) {
		this.accept_id = accept_id;
	}

	public int getSend_id() {
		return send_id;
	}

	public void setSend_id(int send_id) {
		this.send_id = send_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public int getDynamic_kind() {
		return dynamic_kind;
	}

	public void setDynamic_kind(int dynamic_kind) {
		this.dynamic_kind = dynamic_kind;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public Date getDynamic_time() {
		return dynamic_time;
	}

	public void setDynamic_time(Date dynamic_time) {
		this.dynamic_time = dynamic_time;
	}

	public int getIslooked() {
		return islooked;
	}

	public void setIslooked(int islooked) {
		this.islooked = islooked;
	}

	@Override
	public String toString() {
		return "Dynamic [dynamic_id=" + dynamic_id + ", accept_id=" + accept_id + ", send_id=" + send_id
				+ ", article_id=" + article_id + ", dynamic_kind=" + dynamic_kind + ", comment_content="
				+ comment_content + ", dynamic_time=" + dynamic_time + ", islooked=" + islooked + "]";
	}

}
