package pojo;

import java.util.Date;

public class Message {
	private int message_id;// 留言ID
	private int user_id;// 用户ID
	private String message_content;// 留言内容
	private Date message_time;// 留言时间

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getMessage_content() {
		return message_content;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public Date getMessage_time() {
		return message_time;
	}

	public void setMessage_time(Date message_time) {
		this.message_time = message_time;
	}

	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", user_id=" + user_id + ", message_content=" + message_content
				+ ", message_time=" + message_time + "]";
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int message_id, int user_id, String message_content, Date message_time) {
		super();
		this.message_id = message_id;
		this.user_id = user_id;
		this.message_content = message_content;
		this.message_time = message_time;
	}

	public Message(int user_id, String message_content, Date message_time) {
		super();
		this.user_id = user_id;
		this.message_content = message_content;
		this.message_time = message_time;
	}

}
