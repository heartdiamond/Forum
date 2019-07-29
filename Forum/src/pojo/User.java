package pojo;

public class User {
	private int user_id; // 用户id
	private String user_name; // 用户姓名
	private int age; // 用户年龄
	private String sex; // 用户性别
	private String stu_num; // 用户学号
	private String province_home; // 用户所在的省份
	private int contact_id; // 用户联系方式id
	private String password; // 用户的登录密码

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getProvince_home() {
		return province_home;
	}

	public void setProvince_home(String province_home) {
		this.province_home = province_home;
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", age=" + age + ", sex=" + sex + ", stu_num="
				+ stu_num + ", province_home=" + province_home + ", contact_id=" + contact_id + ", password=" + password
				+ "]";
	}

	public User() {
		super();
	}

	public User(int user_id, String user_name, int age, String sex, String stu_num, String province_home,
			int contact_id, String password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.age = age;
		this.sex = sex;
		this.stu_num = stu_num;
		this.province_home = province_home;
		this.contact_id = contact_id;
		this.password = password;
	}
	public User(String stu_num, String password) {
		super();
		this.stu_num = stu_num;
		this.password = password;
	}

	public User(int user_id, String user_name, String stu_num, String password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.stu_num = stu_num;
		this.password = password;
	}

	public User(String user_name, int age, String sex, String stu_num, String province_home, int contact_id,
			String password) {
		super();
		this.user_name = user_name;
		this.age = age;
		this.sex = sex;
		this.stu_num = stu_num;
		this.province_home = province_home;
		this.contact_id = contact_id;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
