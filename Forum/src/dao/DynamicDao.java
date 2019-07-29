package dao;

import java.util.Date;
import java.util.List;

import pojo.Dynamic;

public interface DynamicDao {
	/**
	 * 添加评论消息
	 * 
	 * @param dynamic 消息动态对象
	 */
	void addDynamicOfComment(Dynamic dynamic);
	
	/**
	 * 添加点赞消息
	 * 
	 * @param dynamic 消息动态对象
	 */
	void addDynamicOfLike(Dynamic dynamic);
	
	/**
	 * 获得接收方的全部动态
	 * @param accept_id 接收方id
	 * @return
	 */
	List<Dynamic> getDynamicsByAcceptId(int accept_id);
	
	/**
	 * 将所有动态设置为已读
	 * 
	 * @param accept_id 接收方ID
	 */
	void readALLDynamic(int accept_id);
	
	/**
	 * 删除接收方接收的全部动态
	 * 
	 * @param accept_id
	 */
	void deleteAllDynamics(int accept_id);
	
	/**
	 * 删除点赞型动态
	 * 
	 * @param dynamic 消息动态对象
	 */
	void deleteDynamicOfLike(Dynamic dynamic);
	
	/**
	 * 判断是不存在新消息
	 * 
	 * @param accept_id 接收方ID
	 * @return
	 */
	boolean exitUnlooked(int accept_id);
}
