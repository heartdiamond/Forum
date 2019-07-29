package intercepter;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import pojo.User;
/**
 * 实现登录拦截器
 * 放过的请求:
 * getAllArticle.do
 * login.do
 * toReadTemp.do
 * toMain.do
 * 其他请求全部拦截,并返回到登录界面
 * @author 37367
 *
 */
public class LoginIntercepter implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		//获得url地址
		StringBuffer url = req.getRequestURL();
		if(url.indexOf("login.do")>= 0||url.indexOf("getAllArticle.do")>= 0||url.indexOf("toReadTemp.do")>= 0||url.indexOf("toMain.do")>= 0){
			return true;
		}
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("userOnline");
		if(user != null){
			return true;
		}
		req.getRequestDispatcher("login2.jsp").forward(req, resp);
		return false;
	}
}
