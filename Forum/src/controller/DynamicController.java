package controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import pojo.ArticlePojo;
import pojo.Dynamic;
import pojo.User;
import service.DynamicService;

@Controller
public class DynamicController {

	// 实例化一个动态消息服务类
	private DynamicService ds = new DynamicService();

	/**
	 * 获得登录用户的所有消息
	 * 
	 * @路径 getAllDynamic.do
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/getAllDynamic")
	public void getAllArticle(HttpSession session, HttpServletResponse resp) throws IOException {
		// 获取当前的登录用户
		User user = (User) session.getAttribute("userOnline");
		// 使用消息服务类获得指定用户的所有消息
		List<Dynamic> list = ds.getDynamicsByAcceptId(user.getUser_id());
		// 将结果集进行反转
		Collections.reverse(list);
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 将用户的所有消息设置为已读
	 * 
	 * @param session
	 * @param resp
	 * @return 返回my_message.jsp进行渲染
	 * @throws IOException
	 */
	@RequestMapping("/readALLDynamic")
	public String readALLDynamic(HttpSession session, HttpServletResponse resp) throws IOException {
		// 获取当前的登录用户
		User user = (User) session.getAttribute("userOnline");
		// 使用消息服务类对指定用户的消息设置为已读
		ds.readALLDynamic(user.getUser_id());
		return "my_message";
	}

	/**
	 * 删除用户的所有消息
	 * 
	 * @param session
	 * @param resp
	 * @return 返回my_message.jsp进行渲染
	 * @throws IOException
	 */
	@RequestMapping("/deleteAllDynamics")
	public String deleteAllDynamics(HttpSession session, HttpServletResponse resp) throws IOException {
		// 获取当前的登录用户
		User user = (User) session.getAttribute("userOnline");
		// 使用消息服务类删除指定用户的所有消息
		ds.deleteAllDynamics(user.getUser_id());
		return "my_message";
	}

	/**
	 * 判断当前用户是否有新的消息
	 * 
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/newMessage")
	public void newMessage(HttpSession session, HttpServletResponse resp) throws IOException {
		// 获得当前登录的用户
		User user = (User) session.getAttribute("userOnline");
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用动态服务类获取是否有新消息
		if (ds.exitUnlooked(user.getUser_id())) {
			// 有新消息,返回yes
			resp.getWriter().write("yes");
		} else {
			// 没有新消息,返回no
			resp.getWriter().write("no");
		}
	}
}
