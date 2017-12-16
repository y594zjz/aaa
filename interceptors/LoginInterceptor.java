package com.atguigu.atcrowdfunding.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.atguigu.atcrowdfunding.bean.User;

/**
 * 登陆拦截器
 * 框架的拦截器体现了一种设计模式（适配器模式）
 * 1）实现接口 HandlerInterceptor
 * 2）继承父类 HandlerInterceptorAdapter
 * 
 * a)判断用户是否登陆
 * b)如果登陆，继续访问
 * c)如果没有登陆，跳转回到登陆页面。
 * @author 18801
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 在控制器执行之前进行拦截和处理
	 * 请求可以根据方法的返回结果来确定是否需要继续执行，true,继续执行，false，请求结束
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
				
		HttpSession session = request.getSession();
		// 请求路径 /test/test.jsp
//		String uri = request.getRequestURI();
//		// url 包含资源的服务器的定位信息： http://192.168.11.11:80/test/test.jsp
//		//StringBuffer url = request.getRequestURL();
//		
//		//System.out.println( "uri = " + uri );
//		// whiteList
//		// blackList
//		List<String> whiteList = new ArrayList<String>();
//		whiteList.add(session.getServletContext().getContextPath() + "/login.htm");
//		whiteList.add(session.getServletContext().getContextPath() + "/doLogin.do");
//		
//		if ( whiteList.contains(uri) ) {
//			return true;
//		} else {

			//判断用户是否登陆
			
			User loginUser = (User)session.getAttribute("loginUser");
			
			if ( loginUser == null ) {
				//如果没有登陆，跳转回到登陆页面。 
				response.sendRedirect(session.getServletContext().getContextPath() + "/login.htm");
				return false;
			} else {
				//如果登陆，继续访问	
				return true;
			}
//		}
	}

	/**
	 * 此方法在处理器完成之后执行
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 此方法在请求结束时（视图渲染完毕）执行
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}


}
