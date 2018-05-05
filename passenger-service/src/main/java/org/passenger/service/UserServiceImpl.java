package org.passenger.service;

import java.util.List;

import org.passenger.pojo.User;
import org.passenger.vo.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

	public List<User> getUser(User user) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getUserCount(UserVo userVo) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUsersByIds(String[] userIds) {
		// TODO Auto-generated method stub
		
	}

}
