package com.open.blog.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.open.blog.config.Global;
import com.open.blog.entity.AdminUser;
import com.open.blog.entity.Secqurity;

public class SpringInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		HttpSession session = request.getSession();
		AdminUser adminUser = (AdminUser) session.getAttribute(Global.USER_INFO);
		List<Secqurity> secqurities = (List<Secqurity>) session.getAttribute(Global.SECQURITIES);
		//是否登录验证,先判断是不是login请求，然后在判断是否登录过
		if(url.indexOf("login") >= 0) {
			return true;
		}
		if(adminUser == null) {
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return false;
		}
		return true;
	}

}
