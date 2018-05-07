package org.passenger.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.passenger.common.Constants;
import org.passenger.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登陆拦截器
 * @author Administrator
 *
 */
public class EncapsulationContext implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) request.getSession().getAttribute(Constants.CURRENT_USER);
		if (user != null && Constants.UserConstants.SYSTEM_ADMIN.equals(user.getUserType())) {
			return true;
		} else {
			//如果没有登录,就返回到登录的页面
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"
					+request.getServerPort()+path+"/login.html";
			response.sendRedirect(basePath);
			return false;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
