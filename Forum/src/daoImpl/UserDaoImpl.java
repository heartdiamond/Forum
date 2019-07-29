package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import pojo.Contact;
import pojo.User;
import utils.JdbcUtilsProperties;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(User user) {
		   Connection con = null;
		    Statement statement = null;
		    ResultSet rs = null;
		    String sql = "select * from user where stu_num ='"+user.getStu_num()+"'and password ='"+user.getPassword()+"'";
		    con = JdbcUtilsProperties.getConnection();
		    try
		    {
		      statement = con.createStatement();
		      rs = statement.executeQuery(sql);
		      if (rs.next())
		      {
		    	  user.setAge(rs.getInt("age"));
		    	  user.setContact_id(rs.getInt("contact_id"));
		    	  user.setProvince_home(rs.getString("province_home"));
		    	  user.setSex(rs.getString("sex"));
		    	  user.setUser_id(rs.getInt("user_id"));
		    	  user.setUser_name(rs.getString("user_name"));
		      }
		    }
		    catch (SQLException e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("用户查询失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement, rs);
		    }
		return user;
	}

	@Override
	public User getUserByName(String name) {
			User user = new User();
		    Connection con = null;
		    Statement statement = null;
		    ResultSet rs = null;
		    String sql = "select * from user where user_name ='"+name+"'";
		    con = JdbcUtilsProperties.getConnection();
		    try
		    {
		      statement = con.createStatement();
		      rs = statement.executeQuery(sql);
		      if (rs.next())
		      {
		    	  user.setAge(rs.getInt("age"));
		    	  user.setContact_id(rs.getInt("contact_id"));
		    	  user.setProvince_home(rs.getString("province_home"));
		    	  user.setSex(rs.getString("sex"));
		    	  user.setUser_id(rs.getInt("user_id"));
		    	  user.setUser_name(rs.getString("user_name"));
		    	  user.setStu_num(rs.getString("stu_num"));
		    	  user.setPassword(rs.getString("password"));
		      }
		    }
		    catch (SQLException e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("用户查询失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement, rs);
		    }
		return user;
	}

	@Override
	public User getUserById(int id) {
		User user = new User();
	    Connection con = null;
	    Statement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from user where user_id ='"+id+"'";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	      statement = con.createStatement();
	      rs = statement.executeQuery(sql);
	      if (rs.next())
	      {
	    	  user.setAge(rs.getInt("user_id"));
	    	  user.setContact_id(rs.getInt("contact_id"));
	    	  user.setProvince_home(rs.getString("province_home"));
	    	  user.setSex(rs.getString("sex"));
	    	  user.setUser_id(rs.getInt("user_id"));
	    	  user.setUser_name(rs.getString("user_name"));
	    	  user.setStu_num(rs.getString("stu_num"));
	    	  user.setPassword(rs.getString("password"));
	      }
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("用户查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement, rs);
	    }
	    return user;
	}



	@Override
	public User getUserByStuNum(String stu_num) {
		User user = new User();
	    Connection con = null;
	    Statement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from user where stu_num ='"+stu_num+"'";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	      statement = con.createStatement();
	      rs = statement.executeQuery(sql);
	      if (rs.next())
	      {
	    	  user.setAge(rs.getInt("user_id"));
	    	  user.setContact_id(rs.getInt("contact_id"));
	    	  user.setProvince_home(rs.getString("province_home"));
	    	  user.setSex(rs.getString("sex"));
	    	  user.setUser_id(rs.getInt("user_id"));
	    	  user.setUser_name(rs.getString("user_name"));
	    	  user.setStu_num(rs.getString("stu_num"));
	    	  user.setPassword(rs.getString("password"));
	      }
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("用户查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement, rs);
	    }
	    return user;
	}

	@Override
	public User getUserByContactId(int id) {
		User user = new User();
	    Connection con = null;
	    Statement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from user where contact_id ='"+id+"'";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	      statement = con.createStatement();
	      rs = statement.executeQuery(sql);
	      if (rs.next())
	      {
	    	  user.setAge(rs.getInt("user_id"));
	    	  user.setContact_id(rs.getInt("contact_id"));
	    	  user.setProvince_home(rs.getString("province_home"));
	    	  user.setSex(rs.getString("sex"));
	    	  user.setUser_id(rs.getInt("user_id"));
	    	  user.setUser_name(rs.getString("user_name"));
	    	  user.setStu_num(rs.getString("stu_num"));
	    	  user.setPassword(rs.getString("password"));
	      }
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("用户查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement, rs);
	    }
	    return user;
	}

	@Override
	public Contact getContactById(int id) {
		Contact contact = new Contact();
	    Connection con = null;
	    Statement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from contact where contact_id ='"+id+"'";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	      statement = con.createStatement();
	      rs = statement.executeQuery(sql);
	      if (rs.next())
	      {
	    	  contact.setContact_id(id);
	    	  contact.setPhone_num(rs.getString("phone_num"));
	    	  contact.setQq_num(rs.getString("qq_num"));
	    	  contact.setWechat_num(rs.getString("wechat_num"));
	      }
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("联系方式查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement, rs);
	    }
	    return contact;
	}
	@Override
	public void updateUser(User user) {
		Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "UPDATE forum.user SET age = ?, sex = ?, province_home = ?, password=? WHERE user_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, user.getAge());
	    	statement.setString(2, user.getSex());
	    	statement.setString(3, user.getProvince_home());
	    	statement.setString(4, user.getPassword());
	    	statement.setInt(5, user.getUser_id());
	    	int result = statement.executeUpdate();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("修改用户信息失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	}

	@Override
	public void updateContact(Contact contact) {
		Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "UPDATE forum.contact SET phone_num =?, qq_num =?, wechat_num =? WHERE contact_id =?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setString(1, contact.getPhone_num());
	    	statement.setString(2, contact.getQq_num());
	    	statement.setString(3, contact.getWechat_num());
	    	statement.setInt(4, contact.getContact_id());
	    	int result = statement.executeUpdate();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("修改用户信息失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	}

	@Override
	public int getUserIdByArticleId(int article_id) {
		int id = -1;
		Connection con = null;
	    Statement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from article where article_id ='"+article_id+"'";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	      statement = con.createStatement();
	      rs = statement.executeQuery(sql);
	      if (rs.next())
	      {
	    	 id = rs.getInt("user_id");
	      }
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("用户查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement, rs);
	    }
	    return id;
	}
}
