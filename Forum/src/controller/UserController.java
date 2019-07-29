package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.dsna.util.images.ValidateCode;
import pojo.Contact;
import pojo.User;
import service.UserService;

@Controller
public class UserController {

	// 声明一个用户服务类对象
	private UserService us = new UserService();

	/**
	 * 登录
	 * 
	 * @param user 将要登录的对象
	 * @param req
	 * @param response
	 * @param inputCode 前端传过来的验证码
	 * @throws IOException
	 */
	@RequestMapping({ "/login" })
	public String login(User user, HttpServletRequest req, HttpServletResponse response, String inputCode)
			throws IOException {
		//获得验证码,并与前端传递的验证码进行比较
		String code = (String) req.getSession().getAttribute("code");
		//验证码不为空并且验证码正确
		if ((inputCode != null) && (inputCode.equalsIgnoreCase(code))) {
			User userTemp = user;
			//使用用户服务类对象进行登录
			userTemp = us.login(user);
			//如果返回的User对象不为空
			if (userTemp.getUser_name() != null) {
				//根据ID获得联系方式对象
				Contact userContact = us.getContactById(userTemp.getContact_id());
				//将联系方式和用户对象放入session域
				req.getSession().setAttribute("userOnline", userTemp);
				req.getSession().setAttribute("userContact", userContact);
				//返回到main.jsp渲染
				return "main";
			} else {
				//如果返回为User对象为空
				//将错误信息放入request域并返回到登录界面渲染
				req.setAttribute("error", "请检查用户名和密码!");
				return "forward:login2.jsp";
			}
		} else if (inputCode == null || "".equals(inputCode)) {
			//验证码没有
			//将错误信息放入request域并返回到登录界面渲染
			req.setAttribute("error", "验证码不能为空!");
			return "forward:login2.jsp";
		}
		//如果验证码不正确
		//将错误信息放入request域并返回到登录界面渲染
		req.setAttribute("error", "验证码错误!");
		return "forward:login2.jsp";
	}
	/**
	 * 前往留言板
	 * @return 返回到message.jsp
	 */
	@RequestMapping({ "/toMessage" })
	public String toMessage() {
		return "message";
	}

	/**
	 * 发帖
	 * @return 返回到publish1.jsp
	 */
	@RequestMapping({ "/toPublish" })
	public String toPublish() {
		return "publish1";
	}

	/**
	 * 我的消息
	 * @return 返回到my_message.jsp
	 */
	@RequestMapping({ "/toMyMessage" })
	public String toMyMessage() {
		return "my_message";
	}

	/**
	 * 主页
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping({ "/toMain" })
	public String toMain(HttpSession session) {
		//根据是否有用户登录决定返回的是登录之后的主页还是登录之前的主页
		User user = (User) session.getAttribute("userOnline");
		if (user == null) {
			return "forward:index.jsp";
		}
		return "main";
	}

	/**
	 * 莫提网盘
	 * @return 返回file_store.jsp
	 */
	@RequestMapping({ "/toFileStore" })
	public String toFileStore() {
		return "file_store";
	}

	/**
	 * 更改信息
	 * @return 返回alter_info.jsp
	 */
	@RequestMapping({ "/toAlterInfo" })
	public String toAlterInfo() {
		return "alter_info";
	}

	/**
	 * 更改密码
	 * @return 返回alter_password.jsp
	 */
	@RequestMapping({ "/toAlterPassword" })
	public String toAlterPassword() {
		return "alter_password";
	}

	/**
	 * 退出登录
	 * @param request
	 * @param resp
	 * @return 返回到登录前的主页
	 */
	@RequestMapping("/toLogout")
	public String toLogout(HttpServletRequest request, HttpServletResponse resp) {
		//清空整个session域
		request.getSession().invalidate();
		return "redirect:index.jsp";
	}

	/**
	 * 个人中心
	 * @param session
	 * @return 返回my_home.jsp
	 */
	@RequestMapping("/toMyHome")
	public String toMyHome(HttpSession session) {
		return "my_home";
	}
	
	/**
	 * 刷新他人的主页
	 * @param session
	 * @param req
	 * @return 返回someone_home.jsp
	 */
	@RequestMapping("/refreshOtherHome")
	public String refreshOtherHome(HttpSession session, HttpServletRequest req) {
		return "someone_home";
	}
	
	/**
	 * 前往他人主页
	 * @param session
	 * @param who 他人姓名
	 * @param req
	 * @return
	 */
	@RequestMapping("/toOtherHome")
	public String toOtherHome(HttpSession session, String who, HttpServletRequest req) {
		// 获得要访问主页作者的对象
		User user = us.getUserByName(who);
		// 获得当前正在登录的对象
		User onlineUser = (User) session.getAttribute("userOnline");
		//获得主页作者的联系方式
		Contact contact = us.getContactById(user.getUser_id());
		//如果要访问的作者正好是当前登录的用户,就返回到个人中心
		if (user.getUser_id() == onlineUser.getUser_id()) {
			return "my_home";
		} else {
			//否则将他人的对象和他人的联系方式放入session域
			session.setAttribute("userOther", user);
			session.setAttribute("userOtherContact", contact);
			// 放回到他人主页界面
			return "someone_home";
		}
	}

	/**
	 * 提交更改的密码
	 * @param session
	 * @param request
	 * @param password 新密码
	 */
	@RequestMapping("/toAlterPassword1")
	public String toAlterPassword(HttpSession session, HttpServletRequest request, String password) {
		// 获得在线用户的对象
		User onlineUser = (User) session.getAttribute("userOnline");
		//重新设置登录密码
		onlineUser.setPassword(password);
		//使用用户胡服务类对象进行用户的更新
		us.updateUser(onlineUser);
		return "main";
	}

	/**
	 * 提交更改信息
	 * @param session
	 * @param age 年龄
	 * @param sex 性别
	 * @param home 地址
	 * @param phone 手机号
	 * @param qq QQ号
	 * @param wechat 微信号
	 * @return
	 */
	@RequestMapping({ "/toAlter" })
	public String toAlter(HttpSession session, int age, String sex, String home, String phone, String qq,
			String wechat) {
		// 获得在线用户的对象
		User onlineUser = (User) session.getAttribute("userOnline");
		// 获得在线用户的联系方式
		Contact userContact = (Contact) session.getAttribute("userContact");
		// 修改年龄
		if (age > 0) {
			onlineUser.setAge(age);
		}
		// 修改地址
		if (home == null || "".equals(home)) {
		} else {
			onlineUser.setProvince_home(home);
		}
		// 修改性别
		onlineUser.setSex(sex);
		// 修改电话
		if (phone == null || "".equals(phone)) {
		} else {
			userContact.setPhone_num(phone);
		}
		// 修改QQ
		if (qq == null || "".equals(qq)) {
		} else {
			userContact.setQq_num(qq);
		}
		// 修改微信
		if (wechat == null || "".equals(wechat)) {
		} else {
			userContact.setWechat_num(wechat);
		}
		//使用用户服务对象进行用户对象的更新
		us.updateUser(onlineUser, userContact);
		return "alter_info";
	}
	
	/**
	 * 获得验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping({ "/getCode" })
	public void getCode(HttpServletRequest request, HttpServletResponse response) {
		//返回一张验证码图片给前端
		response.setContentType("image/jpeg");
		//声明一个验证码类(长,宽,字母数,干扰线)
		ValidateCode code = new ValidateCode(192, 45, 2, 10);
		//获得验证码
		String myCode = code.getCode();
		//放入request域
		request.getSession().setAttribute("code", myCode);
		try {
			code.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
