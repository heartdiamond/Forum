package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import pojo.Message;
import pojo.MessagePojo;
import pojo.User;
import service.MessageService;
import service.UserService;
@Controller
public class MessageController {
	
	// 实例化一个用户服务类
	private UserService us = new UserService();
	// 实例化一个留言服务类	
	private MessageService ms = new MessageService();
		
	/**
	 * 添加留言	
	 * 
	 * @param message 留言内容
	 * @param who 留言者
	 */
	@RequestMapping("/addMessage")
	public void addMessage(String message,String who){
	  //获得留言者对象
	  User user = us.getUserByName(who);
	  //使用留言服务类进行留言
	  ms.addMessage(user, message, new Date());
	}
	
	/**
	 * 获得所有的留言
	 * 
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping("/getAllMesssage")
	public void ageAllMessage(HttpServletResponse resp) throws IOException{
	  // 使用留言服务类获得所有的留言
	  List<MessagePojo> list = MessageConvert(ms.getAllMessage());
	  // 将结果集进行反转
	  Collections.reverse(list);
	  //返回前端进行渲染
	  resp.setContentType("text/html;charset=UTF-8");
	  String result = JSON.toJSONString(list);
	  resp.getWriter().write(result);
	}
	
	/**
	 * 将Message实体类转换为MessagePojo
	 * @param listTemp
	 * @return
	 */
	private List<MessagePojo> MessageConvert(List<Message> listTemp){
	  //声明结果集
	  List<MessagePojo> list = new ArrayList<MessagePojo>();
	  //遍历赋值
	  for (Message message : listTemp) {
		  MessagePojo pojo = new MessagePojo();
		  pojo.setMessage_content(message.getMessage_content());
		  pojo.setMessage_time(message.getMessage_time());
		  User user = us.getUserById(message.getUser_id());
		  pojo.setUser_name(user.getUser_name());
		  pojo.setStu_num(user.getStu_num());
		  list.add(pojo);	
	  }
	  return list;
	}
}
