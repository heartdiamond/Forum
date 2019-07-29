package pojo;

public class Attention {
	private int attention_id;// 关注ID
	private int user_id;// 用户ID
	private int target_id;// 目标 ID

	public int getAttention_id() {
		return attention_id;
	}

	public void setAttention_id(int attention_id) {
		this.attention_id = attention_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTarget_id() {
		return target_id;
	}

	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}

	@Override
	public String toString() {
		return "Attention [attention_id=" + attention_id + ", user_id=" + user_id + ", target_id=" + target_id + "]";
	}

	public Attention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attention(int attention_id, int user_id, int target_id) {
		super();
		this.attention_id = attention_id;
		this.user_id = user_id;
		this.target_id = target_id;
	}

	public Attention(int user_id, int target_id) {
		super();
		this.user_id = user_id;
		this.target_id = target_id;
	}

}
