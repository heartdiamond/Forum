package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import dao.ArticleDao;
import pojo.ArticlePojo;
import pojo.User;
import service.ReadService;
import service.UserService;
import utils.JdbcUtilsProperties;

public class ArticleDaoImpl implements ArticleDao{
	private UserService us = new UserService();
	private ReadService readService = new ReadService();
	/**
	 *  添加帖子
	 * @param user_id 作者id
	 * @param kind	帖子类型
	 * @param title	标题
	 * @param content 正文
	 * @param time 发帖时间
	 */
	@Override
	public int addArticle(int user_id, String kind, String title, String content, Date time) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     ResultSet rs = null;
	     String sql = "INSERT INTO article(user_id,article_kind,article_title,article_content,article_time) VALUES (?,?,?,?,?);";
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, user_id);
		    	statement.setString(2, kind);
		    	statement.setString(3, title);
		    	statement.setString(4,content);
		    	statement.setObject(5, time);
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("帖子插入失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement,rs);
		    }
		    return getLastestId();
	}

	@Override
	public List<ArticlePojo> getAllActiclePojo() {
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from article";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前的阅读数
	    		pojo.setRead_num(readService.getReadNum(rs.getInt("article_id")));
	    		//设置当前评论数
	    		pojo.setComment_num(readService.getCommentsNum(rs.getInt("article_id")));
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部文章查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}
	public int getCurrentSize(){
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from article";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("文章数量查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list.size();
	}
	public int getLastestId(){
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from article";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("文章数量查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list.get(0).getArticle_id();
	}

	@Override
	public ArticlePojo getArticleById(int id) {
		ArticlePojo pojo = new ArticlePojo();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "select * from article where article_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, id);
	    	rs = statement.executeQuery();
	    	if(rs.next()){
	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前的阅读数
	    		pojo.setRead_num(readService.getReadNum(rs.getInt("article_id")));
	    		//设置当前评论数
	    		pojo.setComment_num(readService.getCommentsNum(rs.getInt("article_id")));
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("文章查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
		return pojo;
	}

	@Override
	public List<ArticlePojo> getArticlesByTitle(String title) {
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM article WHERE article_title LIKE ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setString(1, "%"+title+"%");
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前的阅读数
	    		pojo.setRead_num(readService.getReadNum(rs.getInt("article_id")));
	    		//设置当前评论数
	    		pojo.setComment_num(readService.getCommentsNum(rs.getInt("article_id")));
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部文章查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}

	@Override
	public List<ArticlePojo> searchArticlesByContent(String content) {
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM article WHERE article_content LIKE ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setString(1, '%'+content+'%');
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前的阅读数
	    		pojo.setRead_num(readService.getReadNum(rs.getInt("article_id")));
	    		//设置当前评论数
	    		pojo.setComment_num(readService.getCommentsNum(rs.getInt("article_id")));
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部文章查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}

	@Override
	public List<ArticlePojo> searchArticlesByUserName(String name) {
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
		User user = us.getUserByName(name);
		if(user.getUser_id() == 0){
			return list;
		}
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM article WHERE user_id= ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, user.getUser_id());
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前的阅读数
	    		pojo.setRead_num(readService.getReadNum(rs.getInt("article_id")));
	    		//设置当前评论数
	    		pojo.setComment_num(readService.getCommentsNum(rs.getInt("article_id")));
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		pojo.setUser_name(name);
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部文章查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}

	@Override
	public List<ArticlePojo> getArticlesByUserId(int id) {
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM article WHERE user_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, id);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
//	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前的阅读数
	    		pojo.setRead_num(readService.getReadNum(rs.getInt("article_id")));
	    		//设置当前评论数
	    		pojo.setComment_num(readService.getCommentsNum(rs.getInt("article_id")));
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部文章查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}

	@Override
	public List<ArticlePojo> getArticlesByUserIdAndKind(int id, String kind) {
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM article WHERE user_id = ? and article_kind = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, id);
	    	statement.setString(2, kind);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
//	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前的阅读数
	    		pojo.setRead_num(readService.getReadNum(rs.getInt("article_id")));
	    		//设置当前评论数
	    		pojo.setComment_num(readService.getCommentsNum(rs.getInt("article_id")));
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部文章查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}

	@Override
	public List<Integer> getArticlesIdByUserIdFromLike(int id) {
		List<Integer> list = new ArrayList<Integer>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM forum.like WHERE user_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, id);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		list.add(rs.getInt("article_id"));
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部点赞查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}

	@Override
	public List<Integer> getArticlesIdByUserIdFromComment(int id) {
		List<Integer> list = new ArrayList<Integer>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM forum.comment WHERE user_id = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setInt(1, id);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		list.add(rs.getInt("article_id"));
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部点赞查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
	    Collections.reverse(list);
		return list;
	}

	@Override
	public void upDateArticle(ArticlePojo pojo) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     String sql = "UPDATE forum.article SET article_kind =?, article_title =?, article_content =? WHERE article_id =?";
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setString(1, pojo.getArticle_kind());
		    	statement.setString(2, pojo.getArticle_title());
		    	statement.setString(3, pojo.getArticle_content());
		    	statement.setInt(4, pojo.getArticle_id());
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("文章更新失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement);
		    }
	}

	@Override
	public void deleteArticle(ArticlePojo pojo) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     String sql = "DELETE FROM forum.article WHERE article_id = ?";
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, pojo.getArticle_id());
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("文章删除失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement);
		    }
	}

	@Override
	public void deleteRead(ArticlePojo pojo) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     String sql = "DELETE FROM forum.read WHERE article_id = ?";
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, pojo.getArticle_id());
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("阅读数据删除失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement);
		    }
	}

	@Override
	public void deleteLike(ArticlePojo pojo) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     String sql = "DELETE FROM forum.like WHERE article_id = ?";
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, pojo.getArticle_id());
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("点赞数据失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement);
		    }
	}

	@Override
	public void deleteComment(ArticlePojo pojo) {
		 Connection con = null;
	     PreparedStatement statement = null;
	     String sql = "DELETE FROM forum.comment WHERE article_id = ?";
	     con = JdbcUtilsProperties.getConnection();
		    try
		    {
		    	statement =con.prepareStatement(sql);
		    	statement.setInt(1, pojo.getArticle_id());
		    	int result = statement.executeUpdate();
		    }
		    catch (Exception e)
		    {
		      e.printStackTrace();
		      throw new RuntimeException("文章更新失败!");
		    }
		    finally
		    {
		      JdbcUtilsProperties.close(con, statement);
		    }
	}

	@Override
	public List<ArticlePojo> searchArticlesByKind(String kind) {
		List<ArticlePojo> list = new ArrayList<ArticlePojo>();
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    String sql = "SELECT * FROM article WHERE article_kind = ?";
	    con = JdbcUtilsProperties.getConnection();
	    try
	    {
	    	statement =con.prepareStatement(sql);
	    	statement.setString(1, kind);
	    	rs = statement.executeQuery();
	    	while(rs.next()){
	    		ArticlePojo pojo = new ArticlePojo();
	    		pojo.setArticle_content(rs.getString("article_content").trim());
	    		pojo.setArticle_id(rs.getInt("article_id"));
	    		pojo.setArticle_kind(rs.getString("article_kind"));
	    		pojo.setArticle_time((Date)rs.getObject("article_time"));
	    		pojo.setArticle_title(rs.getString("article_title").trim());
	    		//设置当前的阅读数
	    		pojo.setRead_num(readService.getReadNum(rs.getInt("article_id")));
	    		//设置当前评论数
	    		pojo.setComment_num(readService.getCommentsNum(rs.getInt("article_id")));
	    		//设置当前点赞数
	    		pojo.setLike_num(readService.getLikeNum(rs.getInt("article_id")));
	    		//设置用户名
	    		User user = us.getUserById(rs.getInt("user_id"));
	    		pojo.setUser_name(user.getUser_name());
	    		
	    		list.add(pojo);
	    	}
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      throw new RuntimeException("全部文章查询失败!");
	    }
	    finally
	    {
	      JdbcUtilsProperties.close(con, statement,rs);
	    }
		return list;
	}
}
