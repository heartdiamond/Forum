package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ReadDao;
import pojo.Comment;
import pojo.User;
import service.UserService;
import utils.JdbcUtilsProperties;

public class ReadDaoImpl implements ReadDao{
	private UserService us = new UserService();
	@Override
	public int getReadNum(int article_id) {
		int num = -1;
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from forum.read where article_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, article_id);
	    	rs = statement.executeQuery();
	    	if(rs.next()){
	    		num = rs.getInt("read_count");
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
		return num;
	}

	@Override
	public void addReadNum(int article_id) {
		int i = getReadNum(article_id);
		String sql = "UPDATE forum.read SET read_count = ? WHERE article_id = ?";
		Connection con = null;
	     PreparedStatement statement = null;
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, i+1);
		    	statement.setInt(2, article_id);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("更新阅读表失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement);
		    }
	}

	@Override
	public void addArticle(int article_id) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     String sql = "INSERT INTO forum.read (article_id, read_count)VALUES(?, 0);";
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, article_id);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("添加帖子阅读表失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	@Override
	public void likeArticle(int article_id, int user_id) {
		String sql = "INSERT INTO forum.like (user_id, article_id) VALUES(?, ?)";
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, user_id);
		    	statement.setInt(2, article_id);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("点赞表添加失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	@Override
	public void disLikeArticle(int article_id, int user_id) {
		String sql = "DELETE FROM forum.like WHERE article_id = ? AND user_id = ?;";
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, article_id);
		    	statement.setInt(2, user_id);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("点赞表添加失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	@Override
	public int getLikeNum(int article_id) {
		int num = 0;
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from forum.like where article_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, article_id);
	    	rs = statement.executeQuery();
	    	if(rs == null){
	    		return num;
	    	}
	    	while(rs.next()){
	    		num++;
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
		return num;
	}

	@Override
	public boolean isLike(int article_id, int user_id) {
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from forum.like where article_id = ? and user_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, article_id);
	    	statement.setInt(2, user_id);
	    	rs = statement.executeQuery();
	    	if(rs == null){
	    		return false;
	    	}
	    	if(rs.next()){
	    		return true;
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("是否已经点赞查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
		return false;
	}

	@Override
	public void addComment(int article_id, int user_id, String comment_content, Date time) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     String sql = "INSERT INTO forum.comment (article_id, user_id, comment_content, comment_time)VALUES(?,?,?,?);";
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, article_id);
		    	statement.setInt(2, user_id);
		    	statement.setString(3, comment_content);
		    	statement.setObject(4, time);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("添加评论表失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
	}

	@Override
	public List<Comment> getAllComments(int article_id) {
		List<Comment> list = new ArrayList<Comment>();
		Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from forum.comment where article_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, article_id);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		Comment comment = new Comment();
	    		comment.setArticle_id(article_id);
	    		comment.setComment_content(rs.getString("comment_content"));
	    		comment.setComment_id(rs.getInt("comment_id"));
	    		comment.setComment_time((Date)rs.getObject("comment_time"));
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		comment.setUser_name(user.getUser_name());
	    		list.add(comment);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("评论查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
//	    Collections.reverse(list);
	    return list;
	}

	@Override
	public int getCommentsNum(int article_id) {
		List<Comment> list = new ArrayList<Comment>();
		Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from forum.comment where article_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, article_id);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		Comment comment = new Comment();
	    		list.add(comment);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("评论数量查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
//	    Collections.reverse(list);
	    return list.size();
	}
}
