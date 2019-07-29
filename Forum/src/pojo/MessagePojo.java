package pojo;

import java.util.Date;

public class MessagePojo {
	private String stu_num;	//用户学号
	private String user_name;// 用户姓名
	private String message_content;// 留言内容
	private Date message_time;// 留言时间
	
	public MessagePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessagePojo(String stu_num, String user_name, String message_content, Date message_time) {
		super();
		this.stu_num = stu_num;
		this.user_name = user_name;
		this.message_content = message_content;
		this.message_time = message_time;
	}

	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
		return "MessagePojo [stu_num=" + stu_num + ", user_name=" + user_name + ", message_content=" + message_content
				+ ", message_time=" + message_time + "]";
	}
	
}
