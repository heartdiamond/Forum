package pojo;

public class Like {
	private int like_id;// 点赞id
	private int article_id;// 帖子id
	private int user_id;// 用户id

	public int getLike_id() {
		return like_id;
	}

	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}

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

	@Override
	public String toString() {
		return "Like [like_id=" + like_id + ", article_id=" + article_id + ", user_id=" + user_id + "]";
	}

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int like_id, int article_id, int user_id) {
		super();
		this.like_id = like_id;
		this.article_id = article_id;
		this.user_id = user_id;
	}

	public Like(int article_id, int user_id) {
		super();
		this.article_id = article_id;
		this.user_id = user_id;
	}

}
