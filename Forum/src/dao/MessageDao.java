package dao;


import java.util.Date;
import java.util.List;

import pojo.Message;
import pojo.User;

public interface MessageDao {
	
	/**
	 * 添加留言
	 * @param user
	 * @param message
	 * @param date
	 */
	void addMessage(User user,String message,Date date);
	
	/**
	 * 获得所有的留言
	 * @return
	 */
	List<Message> getAllMessage();
	
	/**
	 * 根据用户Id找到对应的全部留言
	 * @param name
	 * @return
	 */
	List<Message> getMessagesByUserId(int user_id);
}
