package pojo;

import java.util.Date;

public class ArticlePojo {
	private int article_id;// 帖子id
	private String user_name; // 用户姓名
	private String article_title;// 帖子标题
	private String article_content;// 帖子内容
	private String article_kind;// 帖子类型
	private int read_num;// 阅读数
	private int like_num;// 点赞数
	private int comment_num;// 评论数
	private Date article_time;// 发帖时间

	public ArticlePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticlePojo(int article_id, String user_name, String article_title, String article_content,
			String article_kind, int read_num, int like_num, int comment_num, Date article_time) {
		super();
		this.article_id = article_id;
		this.user_name = user_name;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_kind = article_kind;
		this.read_num = read_num;
		this.like_num = like_num;
		this.comment_num = comment_num;
		this.article_time = article_time;
	}

	public ArticlePojo(String user_name, String article_title, String article_content, String article_kind,
			int read_num, int like_num, int comment_num, Date article_time) {
		super();
		this.user_name = user_name;
		this.article_title = article_title;
		this.article_content = article_content;
		this.article_kind = article_kind;
		this.read_num = read_num;
		this.like_num = like_num;
		this.comment_num = comment_num;
		this.article_time = article_time;
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

	public String getArticle_kind() {
		return article_kind;
	}

	public void setArticle_kind(String article_kind) {
		this.article_kind = article_kind;
	}

	public int getRead_num() {
		return read_num;
	}

	public void setRead_num(int read_num) {
		this.read_num = read_num;
	}

	public int getLike_num() {
		return like_num;
	}

	public void setLike_num(int like_num) {
		this.like_num = like_num;
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public Date getArticle_time() {
		return article_time;
	}

	public void setArticle_time(Date article_time) {
		this.article_time = article_time;
	}

	@Override
	public String toString() {
		return "ArticlePojo [article_id=" + article_id + ", user_name=" + user_name + ", article_title=" + article_title
				+ ", article_content=" + article_content + ", article_kind=" + article_kind + ", read_num=" + read_num
				+ ", like_num=" + like_num + ", comment_num=" + comment_num + ", article_time=" + article_time + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article_content == null) ? 0 : article_content.hashCode());
		result = prime * result + article_id;
		result = prime * result + ((article_kind == null) ? 0 : article_kind.hashCode());
		result = prime * result + ((article_time == null) ? 0 : article_time.hashCode());
		result = prime * result + ((article_title == null) ? 0 : article_title.hashCode());
		result = prime * result + comment_num;
		result = prime * result + like_num;
		result = prime * result + read_num;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticlePojo other = (ArticlePojo) obj;
		if (article_content == null) {
			if (other.article_content != null)
				return false;
		} else if (!article_content.equals(other.article_content))
			return false;
		if (article_id != other.article_id)
			return false;
		if (article_kind == null) {
			if (other.article_kind != null)
				return false;
		} else if (!article_kind.equals(other.article_kind))
			return false;
		if (article_time == null) {
			if (other.article_time != null)
				return false;
		} else if (!article_time.equals(other.article_time))
			return false;
		if (article_title == null) {
			if (other.article_title != null)
				return false;
		} else if (!article_title.equals(other.article_title))
			return false;
		if (comment_num != other.comment_num)
			return false;
		if (like_num != other.like_num)
			return false;
		if (read_num != other.read_num)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}
}
