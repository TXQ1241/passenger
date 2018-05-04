package org.passenger.service;

import java.util.List;

import org.passenger.pojo.User;

/**
 * 用户接口管理
 * @author Administrator
 *
 */
public interface IUserService {
	
	/**
	 * 通过用户对象获取用户
	 * @param user
	 * @return
	 */
	List<User> getUser(User user);
	
	/**
	 * 通过账号获取用户
	 * @param account
	 * @return
	 */
	User getUserByAccount(String account);

}
