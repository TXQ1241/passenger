package org.passenger.controller;

import javax.servlet.http.HttpServletRequest;

import org.passenger.common.Constants;
import org.passenger.pojo.User;
import org.passenger.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
	/**
	 * 获取用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping("getUserInfo")
	@ResponseBody
	public User getUserInfo(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Constants.CURRENT_USER);
		if (user != null) {
			user = userService.getUserByAccount(user.getAccount());
		}
		return user;
	}
	
}
