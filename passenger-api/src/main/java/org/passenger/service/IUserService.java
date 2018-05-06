package org.passenger.service;

import java.util.List;

import org.passenger.pojo.User;
import org.passenger.vo.UserVo;

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
	
	/**
	 * 获取用户数据
	 * @param userVo
	 * @return
	 */
	List<User> getUsers(UserVo userVo);
	
	/**
	 * 获取用户记录数
	 * @param userVo
	 * @return
	 */
	Integer getUserCount(UserVo userVo);
	
	/**
	 * 批量删除用户
	 * @param userIds
	 */
	void deleteUsersByIds(String[] userIds);

}
