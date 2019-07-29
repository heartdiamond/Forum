package pojo;

public class Collect {
	private int collect_id;// 收藏ID
	private int article_id;// 帖子ID
	private int user_id;// 用户ID

	public int getCollect_id() {
		return collect_id;
	}

	public void setCollect_id(int collect_id) {
		this.collect_id = collect_id;
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
		return "Collect [collect_id=" + collect_id + ", article_id=" + article_id + ", user_id=" + user_id + "]";
	}

	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collect(int collect_id, int article_id, int user_id) {
		super();
		this.collect_id = collect_id;
		this.article_id = article_id;
		this.user_id = user_id;
	}

	public Collect(int article_id, int user_id) {
		super();
		this.article_id = article_id;
		this.user_id = user_id;
	}

}
