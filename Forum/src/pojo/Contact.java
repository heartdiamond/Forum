package pojo;

public class Contact {
	private int contact_id;// 联系id
	private String phone_num;// 手机号
	private String qq_num;// QQ号
	private String wechat_num;// 微信号

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getQq_num() {
		return qq_num;
	}

	public void setQq_num(String qq_num) {
		this.qq_num = qq_num;
	}

	public String getWechat_num() {
		return wechat_num;
	}

	public void setWechat_num(String wechat_num) {
		this.wechat_num = wechat_num;
	}

	@Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", phone_num=" + phone_num + ", qq_num=" + qq_num + ", wechat_num="
				+ wechat_num + "]";
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int contact_id, String phone_num, String qq_num, String wechat_num) {
		super();
		this.contact_id = contact_id;
		this.phone_num = phone_num;
		this.qq_num = qq_num;
		this.wechat_num = wechat_num;
	}

	public Contact(String phone_num, String qq_num, String wechat_num) {
		super();
		this.phone_num = phone_num;
		this.qq_num = qq_num;
		this.wechat_num = wechat_num;
	}

}
