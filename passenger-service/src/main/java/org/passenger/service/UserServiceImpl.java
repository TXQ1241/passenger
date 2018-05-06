package org.passenger.service;

import java.util.List;

import org.passenger.dao.UserMapper;
import org.passenger.pojo.User;
import org.passenger.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier("userMapper")
	UserMapper userMapper;

	public List<User> getUser(User user) {
		return userMapper.getUser(user);
	}

	public User getUserByAccount(String account) {
		User user = new User();
		user.setAccount(account);
		List<User> userList = this.getUser(user);
		if(userList != null && userList.size() > 0) {
			user = userList.get(0);
		}
		return user;
	}

	public List<User> getUsers(UserVo userVo) {
		return userMapper.getUserList(userVo);
	}

	public Integer getUserCount(UserVo userVo) {
		return userMapper.getUserCount(userVo);
	}

	public void deleteUsersByIds(String[] userIds) {
		userMapper.deleteUserByIds(userIds);
	}

}
