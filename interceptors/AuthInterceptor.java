package com.atguigu.atcrowdfunding.interceptors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.manager.service.PermissionService;
import com.atguigu.atcrowdfunding.util.StringUtil;


public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private PermissionService permissionService;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		// 1）获取请求路径
		 String uri = request.getRequestURI();
		
		 // 2）判断当前路径需要不需要授权
		 // 2-1) 获取所有的授权访问路径
		 //ApplicationContext context = 
		//	WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		 
		 //PermissionService permissionService =
			// context.getBean(PermissionService.class);
		 
//		 List<Permission> permissions = permissionService.queryAll();
//		 Set<String> authPathSet = new HashSet<String>();
//		 for ( Permission permission : permissions ) {
//			 if ( StringUtil.isNotEmpty(permission.getUrl()) ) {
//				 authPathSet.add(request.getSession().getServletContext().getContextPath() + permission.getUrl());
//			 }
//		 }
		 Set<String> authPathSet =
		     (Set<String>)request.getSession().getServletContext().getAttribute("authPathSet");
		 
		 if ( authPathSet.contains(uri) ) {
			 // 4）如果需要授权，那么判断当前的用户是否具有相应的权限
			 Set<String> userAuthPathSet = (Set<String>)request.getSession().getAttribute("userAuthPathSet");
			 if ( userAuthPathSet.contains(uri) ) {
				// 5）如果有相应的权限，那么继续访问
				 return true;
			 } else {
				// 6）如果没有相应的权限，跳转到错误页面
				 response.sendRedirect(request.getSession().getServletContext().getContextPath() + "/error.htm");
				 return false;
			 }
			 
		 } else {
			// 3）如果不需要授权，那么直接访问
			 return true;
		 }
	}

}
