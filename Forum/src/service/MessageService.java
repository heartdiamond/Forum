package service;


import java.util.Date;
import java.util.List;

import dao.MessageDao;
import dao.UserDao;
import daoImpl.MessageDaoImpl;
import daoImpl.UserDaoImpl;
import pojo.Message;
import pojo.User;

public class MessageService {
	
	MessageDao md = new MessageDaoImpl();
	
	UserDao ud = new UserDaoImpl();
	
	/**
	 * 添加留言
	 * @param user
	 * @param message
	 * @param date
	 */
	public void addMessage(User user, String message, Date date){
		md.addMessage(user, message, date);
	}
	
	/**
	 * 获得全部留言
	 * @return
	 */
	public List<Message> getAllMessage(){
		return md.getAllMessage();
	}
}
