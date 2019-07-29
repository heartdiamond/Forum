package service;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import pojo.Contact;
import pojo.User;

public class UserService {
	
	private UserDao ud = new UserDaoImpl();
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user){
		return ud.getUser(user);
	}
	
	/**
	 * 根据用户名获得用户
	 * @param name
	 * @return
	 */
	public User getUserByName(String name){
		return ud.getUserByName(name);
	}
	
	/**
	 * 根据用户ID获得用户
	 * @param id
	 * @return
	 */
	public User getUserById(int id){
		return ud.getUserById(id);
	}
	
	/**
	 * 根据用户联系方式id获得用户
	 * @param id
	 * @return
	 */
	public User getUserByContactId(int id){
		return ud.getUserByContactId(id);
	}
	
	/**
	 * 根据用户ID获得联系方式
	 * @param id
	 * @return
	 */
	public Contact getContactById(int id){
		return ud.getContactById(id);
	}
	
	/**
	 * 更新用户和联系方式
	 * @param user
	 * @param contact
	 */
	public void updateUser(User user,Contact contact){
		ud.updateUser(user);
		ud.updateContact(contact);
	}
	
	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user){
		ud.updateUser(user);
	}
	
	/**
	 * 更新联系方式
	 * @param contact
	 */
	public void updateUser(Contact contact){
		ud.updateContact(contact);
	}
	
	/**
	 * 根据文章id获得作者id
	 * @param id
	 * @return
	 */
	public int getUserIdByArticleId(int id){
		return ud.getUserIdByArticleId(id);
	}
}
