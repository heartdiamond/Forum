package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import pojo.Article;
import pojo.ArticlePojo;
import pojo.Comment;
import pojo.Dynamic;
import pojo.User;
import service.ArticleService;
import service.DynamicService;
import service.ReadService;
import service.SearchService;
import service.UserService;

@Controller
public class ArticleController {

	// 实例化一个用户服务类
	private UserService us = new UserService();
	// 实例化一个文章服务类
	private ArticleService as = new ArticleService();
	// 实例化一个阅读服务类
	private ReadService rs = new ReadService();
	// 实例化一个查找服务类
	private SearchService ss = new SearchService();
	// 实例化一个动态消息服务类
	private DynamicService ds = new DynamicService();

	/**
	 * 发布帖子
	 * 
	 * @请求路径 publish.do
	 * @param req HttpServletRequest对象
	 * @param article 文章实体类
	 * @return 返回到main.jsp进行渲染
	 */
	@RequestMapping("/publish")
	public String publish(HttpServletRequest req, Article article) {
		// 在Session中获得当前在线的用户对象
		User user = (User) req.getSession().getAttribute("userOnline");
		// 为文章对象设置作者
		article.setUser_id(user.getUser_id());
		// 实例化当前的日期并设置给文章对象
		Date date = new Date();
		article.setArticle_time(date);
		// 判断前端提交的文章类型并重新赋值给文章对象
		if (article.getArticle_kind().equals("1")) {
			article.setArticle_kind("学习类");
		} else if (article.getArticle_kind().equals("2")) {
			article.setArticle_kind("技术类");
		} else {
			article.setArticle_kind("生活类");
		}
		// 使用文章服务类对象发布文章,并获取文章的发布后的ID
		int article_id = as.publish(article.getUser_id(), article.getArticle_kind(), article.getArticle_title(),
				article.getArticle_content(), article.getArticle_time());
		// 使用阅读服务类为当前文章添加阅读表(和阅读次数相关)
		rs.addArticle(article_id);
		return "main";
	}

	/**
	 * 重新发布文章
	 * 
	 * @请求路径 rePublish.do
	 * @param session HttpSession对象
	 * @param req HttpServletRequest对象
	 * @param article  文章实体类对象
	 * @return 返回到my_home.jsp进行渲染
	 */
	@RequestMapping("/rePublish")
	public String rePublish(HttpSession session, HttpServletRequest req, Article article) {
		// 在Session域中获取当前需要重新发布的文章ArticlePojo实体类
		ArticlePojo pojo = (ArticlePojo) session.getAttribute("editArticle");
		// 为ArticlePojo对象重新设置由前端传递过来的文章标题,文章内容
		pojo.setArticle_title(article.getArticle_title());
		pojo.setArticle_content(article.getArticle_content());
		// 判断前端传递的文章类别并设置给ArticlePojo对象
		if (article.getArticle_kind().equals("1")) {
			pojo.setArticle_kind("学习类");
		} else if (article.getArticle_kind().equals("2")) {
			pojo.setArticle_kind("技术类");
		} else {
			pojo.setArticle_kind("生活类");
		}
		// 使用文章服务类对象重新发布文章
		as.rePublish(pojo);
		return "my_home";
	}

	/**
	 * 获取所有的ArticlePojo文章实体类对象
	 * 
	 * @请求路径 getAllArticle.do
	 * @param resp HttpServletResponse对象
	 * @throws IOException 在进行resp.getWriter().write(result)时会抛出异常
	 */
	@RequestMapping("/getAllArticle")
	public void getAllArticle(HttpServletResponse resp) throws IOException {
		// 使用文章服务类获得所有的ArticlePojo文章实体类对象
		List<ArticlePojo> list = as.getAllArticlePojo();
		// 将list对象的元素进行倒序
		Collections.reverse(list);
		// 为了方便前端简略渲染,对ArticlePojo文章实体类对象的文章内容进行80字符的切割
		for (ArticlePojo pojo : list) {
			if (pojo.getArticle_content().length() >= 80) {
				pojo.setArticle_content(pojo.getArticle_content().substring(0, 80));
			}
		}
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 跳转到文章阅读界面(当前有用户登录的情况)
	 * 
	 * @请求路径 toRead.do
	 * @param request HttpServletRequest对象
	 * @param id 所需读的文章ID
	 * @return 返回到read.jsp进行渲染
	 */
	@RequestMapping({ "/toRead" })
	public String toRead(HttpServletRequest request, int id) {
		// 使用阅读服务类对指定文章进行读操作(阅读次数+1)
		rs.read(id);
		// 根据文章ID获取ArticlePojo对象,并放到Request域中
		ArticlePojo pojo = as.getArticleById(id);
		request.setAttribute("article", pojo);
		return "read";
	}

	/**
	 * 跳转到文章阅读界面(没有用户登录的情况)
	 * 
	 * @请求路径 toReadTemp.do
	 * @param request HttpServletRequest对象
	 * @param id 所需读的文章ID
	 * @return 返回到read_temp.jsp进行渲染
	 */
	@RequestMapping({ "/toReadTemp" })
	public String toReadTemp(HttpServletRequest request, int id) {
		// 使用阅读服务类对指定文章进行读操作(阅读次数+1)
		rs.read(id);
		// 根据文章ID获取ArticlePojo对象,并放到Request域中
		ArticlePojo pojo = as.getArticleById(id);
		request.setAttribute("article", pojo);
		return "read_temp";
	}

	/**
	 * 文章点赞
	 * 
	 * @请求路径 like.do
	 * 
	 * @param request HttpServletRequest对象
	 * @param article_id 所喜欢的文章ID
	 * @param who 当前登录的用户
	 */
	@RequestMapping({ "/like" })
	public void like(HttpServletRequest request, int article_id, int who) {
		// 使用阅读服务类对文章进行点赞
		rs.like(article_id, who);
		// 根据文章ID获取作者ID
		int accept_id = us.getUserIdByArticleId(article_id);
		// 如果是作者正好是点赞者就不进行消息相关操作
		if (accept_id != who) {
			Dynamic dynamic = new Dynamic(accept_id, who, article_id, 1);
			// 使用消息工具类给文章作者添加点赞的消息
			ds.addDynamicOfLike(dynamic);
		}
	}

	/**
	 * 文章取消点赞
	 * 
	 * @请求路径 dislike.do
	 * @param request HttpServletRequest对象
	 * @param article_id 所喜欢的文章ID
	 * @param who 当前登录的用户
	 */
	@RequestMapping({ "/dislike" })
	public void dislike(HttpServletRequest request, int article_id, int who) {
		// 使用阅读服务类对文章进行取消点赞
		rs.unlike(article_id, who);
		// 根据文章ID获取作者ID
		int accept_id = us.getUserIdByArticleId(article_id);
		// 如果是作者正好是点赞者就不进行消息相关操作
		if (accept_id != who) {
			Dynamic dynamic = new Dynamic(accept_id, who, article_id, 1);
			// 使用消息工具类删除相关点赞的消息
			ds.deleteDynamicOfLike(dynamic);
		}
	}

	/**
	 * 为文章添加评论
	 * 
	 * @请求路径 addComment.do
	 * @param request HttpServletRequest对象
	 * @param article_id 添加评论的文章ID
	 * @param user_id 发表评论的用户的ID
	 * @param content 评论内容
	 */
	@RequestMapping({ "/addComment" })
	public void addComment(HttpServletRequest request, int article_id, int user_id, String content) {
		// 实例化当前时间
		Date date = new Date();
		// 使用阅读服务类向数据库添加评论
		rs.addComment(article_id, user_id, content, date);
		// 根据文章ID获取作者ID
		int accept_id = us.getUserIdByArticleId(article_id);
		// 如果是作者正好是点赞者就不进行消息相关操作
		if (accept_id != user_id) {
			Dynamic dynamic = new Dynamic(accept_id, user_id, article_id, 2, content);
			// 使用消息工具类为文章作者添加评论的消息
			ds.addDynamicOfComment(dynamic);
		}
	}

	/**
	 * 判断当前文章用户是不是已经点赞
	 * 
	 * @请求路径 isLike.do
	 * @param resp
	 * @param article_id 文章ID
	 * @param who 当前登录用户的ID
	 * @throws IOException
	 */
	@RequestMapping("isLike")
	public void isLike(HttpServletResponse resp, int article_id, int who) throws IOException {
		resp.setContentType("text/html;charset=UTF-8");
		// 使用阅读服务类对象进行判断
		if (rs.isLike(article_id, who)) {
			// 如果已经点赞,返回yes结果
			resp.getWriter().write("yes");
		} else {
			// 如果没有点赞,返回no结果
			resp.getWriter().write("no");
		}
	}

	/**
	 * 获得文章所有的评论
	 * 
	 * @请求路径 getAllComments.do
	 * @param resp
	 * @param article_id 文章ID
	 * @throws IOException
	 */
	@RequestMapping("/getAllComments")
	public void getAllComments(HttpServletResponse resp, int article_id) throws IOException {
		// 使用阅读服务类对象获得指定文章的所有评论
		List<Comment> list = rs.getAllComments(article_id);
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 搜索指定内容并返回前端渲染
	 * 
	 * @路径 toSearch.do
	 * @param content
	 * @param req
	 * @return 返回到search.jsp进行渲染
	 * @throws IOException
	 */
	@RequestMapping({ "/toSearch" })
	public String toSearch(String content, HttpServletRequest req) throws IOException {
		// 使用阅读服务类对象根据标题获取搜索结果
		List<ArticlePojo> list1 = ss.searchArticlesByTitle(content);
		// 使用阅读服务类对象根据类别获取搜索结果
		List<ArticlePojo> list2 = ss.searchArticlesByKind(content);
		// 使用阅读服务类对象根据作者获取搜索结果
		List<ArticlePojo> list3 = ss.searchArticlesByUserName(content);
		// 将3个list中的元素合体到一个list
		list1.addAll(list2);
		list1.addAll(list3);
		for (ArticlePojo pojo : list1) {
			pojo.setArticle_content("");
		}
		// 利用set集合对list进行去重
		Set set = new HashSet(list1);
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(set);
		System.out.println(result);
		// 将结果放到request域中
		req.setAttribute("search_result", result);
		return "search";
	}

	/**
	 * 根据类别搜索文章
	 * 
	 * @路径 toSearchKind.do
	 * @param kind 指定的类别
	 * @param req
	 * @return 返回到search.jsp进行渲染
	 * @throws IOException
	 */
	@RequestMapping({ "/toSearchKind" })
	public String toSearchKind(String kind, HttpServletRequest req) throws IOException {
		// 使用阅读服务类根据类别获取文章
		List<ArticlePojo> list = as.searchArticlesByKind(kind);
		// 处理返回结果集合中元素的getArticle_content属性,为了方便更好的在前端渲染,将文章内容的长度控制在80个字符以内
		for (ArticlePojo pojo : list) {
			pojo.setArticle_content("");
		}
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将结果放到request域中
		req.setAttribute("search_result", result);
		return "search";
	}

	/**
	 * 获取当前登录用户的所有文章
	 * 
	 * @路径 getArticlesByUserId.do
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping({ "/getArticlesByUserId" })
	public void getArticlesByUserId(HttpSession session, HttpServletResponse resp) throws IOException {
		// 获取当前的登录用户
		User user = (User) session.getAttribute("userOnline");
		// 根据阅读服务类对象获得指定用户的所有的文章
		List<ArticlePojo> list = as.getArticlesByUserId(user.getUser_id());
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 获取目标用户的所有文章
	 * 
	 * @路径 getArticlesByOtherId.do
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping({ "/getArticlesByOtherId" })
	public void getArticlesByOtherId(HttpSession session, HttpServletResponse resp) throws IOException {
		// 获取想要访问用户的对象
		User user = (User) session.getAttribute("userOther");
		// 根据阅读服务类对象获得指定用户的所有的文章
		List<ArticlePojo> list = as.getArticlesByUserId(user.getUser_id());
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 根据类别获得当前用户的所有文章
	 * 
	 * @路径 getArticlesByKind
	 * @param session
	 * @param resp
	 * @param kind 指定类别
	 * @throws IOException
	 */
	@RequestMapping({ "/getArticlesByKind" })
	public void getArticlesByKind(HttpSession session, HttpServletResponse resp, String kind) throws IOException {
		// 获取当前的登录用户
		User user = (User) session.getAttribute("userOnline");
		// 使用阅读服务类对象,获得指定对象,指定类别的所有文章
		List<ArticlePojo> list = as.getArticlesByUserIdAndKind(user.getUser_id(), kind);
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 根据类别获得要访问的对象的所有文章
	 * 
	 * @路径 getArticlesByOtherKind.do
	 * @param session
	 * @param resp
	 * @param kind 指定类别
	 * @throws IOException
	 */
	@RequestMapping({ "/getArticlesByOtherKind" })
	public void getArticlesByOtherKind(HttpSession session, HttpServletResponse resp, String kind) throws IOException {
		// 获得要访问主页的对象
		User user = (User) session.getAttribute("userOther");
		// 使用阅读服务类对象,获得指定对象,指定类别的所有文章
		List<ArticlePojo> list = as.getArticlesByUserIdAndKind(user.getUser_id(), kind);
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 获得当前用户点赞的所有文章
	 * 
	 * @路径 getArticlesByLike.do
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping({ "/getArticlesByLike" })
	public void getArticlesByLike(HttpSession session, HttpServletResponse resp) throws IOException {
		// 获得当前登录的对象
		User user = (User) session.getAttribute("userOnline");
		// 使用阅读服务类获得指定文章
		List<ArticlePojo> list = as.getArticlesByLike(user.getUser_id());
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 获得当前用户参与评论的文章
	 * 
	 * @路径 getArticlesByComment.do
	 * @param session
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping({ "/getArticlesByComment" })
	public void getArticlesByComment(HttpSession session, HttpServletResponse resp) throws IOException {
		// 获得当前登录的用户
		User user = (User) session.getAttribute("userOnline");
		// 使用阅读服务类获得指定文章
		List<ArticlePojo> list = as.getArticlesByComment(user.getUser_id());
		// 使用set进行去重
		Set<ArticlePojo> set = new HashSet<ArticlePojo>(list);
		// 解决response返回的数据中文乱码问题
		resp.setContentType("text/html;charset=UTF-8");
		// 使用工具类JSON将集合转为json字符串,方便前端调取
		String result = JSON.toJSONString(list);
		// 将转换好的json字符串返回给前端进行渲染
		resp.getWriter().write(result);
	}

	/**
	 * 获得重新编辑的文章,并返回到前端渲染
	 * 
	 * @路径 toEdit.do
	 * @param id 文章id
	 * @param session
	 * @return 返回到edit1.jsp进行渲染
	 * @throws IOException
	 */
	@RequestMapping({ "/toEdit" })
	public String toEdit(int id, HttpSession session) throws IOException {
		// 根据指定文章Id获得指定文章
		ArticlePojo pojo = as.getArticleById(id);
		// 将文章放到session域中
		session.setAttribute("editArticle", pojo);
		return "edit1";
	}

	/**
	 * 删除文章
	 * 
	 * @路径 toDelete.do
	 * @param id 指定文章ID
	 * @return 回到my_home.jsp
	 * @throws IOException
	 */
	@RequestMapping({ "/toDelete" })
	public String toDelete(int id) throws IOException {
		// 根据文章ID获得指定文章对象
		ArticlePojo pojo = as.getArticleById(id);
		// 使用文章服务类对文章进行删除
		as.deleteArticle(pojo);
		return "my_home";
	}
}
