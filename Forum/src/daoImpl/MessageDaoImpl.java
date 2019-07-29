package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import dao.MessageDao;
import pojo.Message;
import pojo.User;
import utils.JdbcUtilsProperties;

public class MessageDaoImpl implements MessageDao {

	/**
	 * 添加留言
	 * @param user
	 * @param message
	 * @param date
	 */
	@Override
	public void addMessage(User user, String message, Date date) {
		    Connection con = null;
		    PreparedStatement statement = null;
		    ResultSet rs = null;
		    String sql = "INSERT INTO message(user_id,message_content,message_time) VALUES(?,?,?)";
		    con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, user.getUser_id());
		    	statement.setString(2, message);
		    	statement.setObject(3, date);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("用户查询失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	/**
	 * 获得所有的留言
	 * @return
	 */
	@Override
	public List<Message> getAllMessage() {
			List<Message> list = new ArrayList<Message>();
		    Connection con = null;
		    PreparedStatement statement = null;
		    ResultSet rs = null;
		    String sql = "select * from message";
		    con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	rs = statement.executeQuery();
		    	while(rs.next()){
		    		Message message = new Message();
		    		message.setMessage_content(rs.getString("message_content"));
		    		message.setMessage_id(rs.getInt("message_id"));
		    		message.setMessage_time((Date)rs.getObject("message_time"));
		    		message.setUser_id(rs.getInt("user_id"));
		    		list.add(message);
		    	}
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("留言查询失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
		    Collections.reverse(list);
		    return list;
	}

	/**
	 * 根据用户Id找到对应的全部留言
	 * @param name
	 * @return
	 */
	@Override
	public List<Message> getMessagesByUserId(int user_id) {
		List<Message> list = new ArrayList<Message>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from message where user_id = '"+user_id+"'";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		Message message = new Message();
	    		message.setMessage_content(rs.getString("message_content"));
	    		message.setMessage_id(rs.getInt("message_id"));
	    		message.setMessage_time((Date)rs.getObject("message_time"));
	    		message.setUser_id(rs.getInt("user_id"));
	    		list.add(message);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("留言查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
	    return list;
	}
}
