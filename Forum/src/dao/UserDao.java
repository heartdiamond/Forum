package dao;

import pojo.Contact;
import pojo.User;

public interface UserDao {
	
	/**
	 * 根据用户学号密码,获取用户
	 * @param user
	 * @return
	 */
	User getUser(User user);
	
	/**
	 * 根据用户名获取用户
	 * @param name
	 * @return
	 */
	User getUserByName(String name);
	
	/**
	 * 根据用户id获取用户
	 * @param id
	 * @return
	 */
	User getUserById(int id);
	
	/**
	 * 修改用户的信息(不能修改用户id,姓名,学号,和联系方式ID)
	 * @param user
	 */
	void updateUser(User user);
	
	
	/**
	 * 根据联系方式ID修改信息
	 * @param id
	 */
	void updateContact(Contact contact);
	
	/**
	 * 根据学号获取用户
	 * @param stu_num
	 * @return
	 */
	User getUserByStuNum(String stu_num);
	
	/**
	 * 根据联系方式的ID获取用户
	 * @param id
	 * @return
	 */
	User getUserByContactId(int id);
	
	/**
	 * 根据文章ID获取作者ID
	 * @param article_id
	 * @return
	 */
	int getUserIdByArticleId(int article_id);
	
	/**
	 * 根据用户的ID获取联系方式
	 * @param id
	 * @return
	 */
	Contact getContactById(int id);
}
