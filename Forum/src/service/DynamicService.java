package service;

import java.util.List;

import dao.DynamicDao;
import daoImpl.DynamicDaoImpl;
import pojo.Dynamic;

public class DynamicService {
	
	private DynamicDao dd = new DynamicDaoImpl();
	
	/**
	 * 添加评论动态
	 * @param dynamic
	 */
	public void addDynamicOfComment(Dynamic dynamic){
		dd.addDynamicOfComment(dynamic);
	}
	
	/**
	 * 添加点赞动态
	 * @param dynamic
	 */
	public void addDynamicOfLike(Dynamic dynamic){
		dd.addDynamicOfLike(dynamic);
	}
	
	/**
	 * 删除点赞动态
	 * @param dynamic
	 */
	public void deleteDynamicOfLike(Dynamic dynamic){
		dd.deleteDynamicOfLike(dynamic);
	}
	
	/**
	 * 获得用户的所有消息
	 * @param accept_id
	 * @return
	 */
	public List<Dynamic> getDynamicsByAcceptId(int accept_id){
		return dd.getDynamicsByAcceptId(accept_id);
	}
	
	/**
	 * 将用户所有消息设置为已读
	 * @param accept_id
	 */
	public void readALLDynamic(int accept_id){
		dd.readALLDynamic(accept_id);
	}
	
	/**
	 * 删除用户所有消息
	 * @param accept_id
	 */
	public void deleteAllDynamics(int accept_id){
		dd.deleteAllDynamics(accept_id);
	}
	
	/**
	 * 判断是否存在未读消息
	 * @param accept_id
	 * @return
	 */
	public boolean exitUnlooked(int accept_id){
		return dd.exitUnlooked(accept_id);
	}
}
