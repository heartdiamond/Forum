package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

import dao.ArticleDao;
import dao.DynamicDao;
import dao.UserDao;
import pojo.ArticlePojo;
import pojo.Dynamic;
import pojo.User;
import utils.JdbcUtilsProperties;

public class DynamicDaoImpl implements DynamicDao {
	private ArticleDao ad = new ArticleDaoImpl();
	private UserDao ud = new UserDaoImpl();
	@Override
	public void addDynamicOfComment(Dynamic dynamic) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     String sql = "INSERT INTO forum.dynamic (accept_id, send_id, article_id, dynamic_kind, comment_content, dynamic_time) VALUES(?,?,?,?,?,?)";

	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, dynamic.getAccept_id());
		    	statement.setInt(2, dynamic.getSend_id());
		    	statement.setInt(3, dynamic.getArticle_id());
		    	statement.setInt(4, dynamic.getDynamic_kind());
		    	statement.setString(5, dynamic.getComment_content());
		    	statement.setObject(6, new Date());
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("添加评论型动态失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	@Override
	public void addDynamicOfLike(Dynamic dynamic) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     String sql = "INSERT INTO forum.dynamic (accept_id, send_id, article_id, dynamic_kind, dynamic_time) VALUES(?,?,?,?,?)";

	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, dynamic.getAccept_id());
		    	statement.setInt(2, dynamic.getSend_id());
		    	statement.setInt(3, dynamic.getArticle_id());
		    	statement.setInt(4, dynamic.getDynamic_kind());
		    	statement.setObject(5, new Date());
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("添加点赞型动态失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	@Override
	public List<Dynamic> getDynamicsByAcceptId(int accept_id) {
		List<Dynamic> list = new ArrayList<Dynamic>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from dynamic where accept_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, accept_id);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		Dynamic pojo = new Dynamic();
	    		pojo.setAccept_id(accept_id);
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		ArticlePojo articlePojo = ad.getArticleById(rs.getInt("article_id"));
	    		pojo.setArticle_title(articlePojo.getArticle_title());
	    		pojo.setComment_content(rs.getString("comment_content"));
	    		pojo.setDynamic_id(rs.getInt("dynamic_id"));
	    		pojo.setDynamic_kind(rs.getInt("dynamic_kind"));
	    		pojo.setDynamic_time((Date)rs.getObject("dynamic_time"));
	    		pojo.setIslooked(rs.getInt("islooked"));
	    		pojo.setSend_id(rs.getInt("send_id"));
	    		User user = ud.getUserById(rs.getInt("send_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部动态查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}


	@Override
	public void deleteAllDynamics(int accept_id) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     String sql = "DELETE FROM forum.dynamic WHERE accept_id = ?";

	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, accept_id);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("删除全部动态失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	@Override
	public void deleteDynamicOfLike(Dynamic dynamic) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     String sql = "DELETE FROM forum.dynamic WHERE accept_id = ? AND send_id = ? AND article_id = ? AND dynamic_kind = 1";

	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, dynamic.getAccept_id());
		    	statement.setInt(2, dynamic.getSend_id());
		    	statement.setInt(3, dynamic.getArticle_id());
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("删除点赞型动态失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	@Override
	public void readALLDynamic(int accept_id) {
		Connection con = null;
	     PreparedStatement statement = null;
	     String sql = "UPDATE forum.dynamic SET islooked = 1 WHERE accept_id = ? and islooked = 0";

	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, accept_id);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("将全部动态设置成已读状态失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement);
		    }
	}

	@Override
	public boolean exitUnlooked(int accept_id) {
		Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from dynamic where accept_id = ? and islooked = 0";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, accept_id);
	    	rs = statement.executeQuery();
	    	if(rs.next()){
	    		return true;
	    	}else{
	    		return false;
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部动态查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	}
}
