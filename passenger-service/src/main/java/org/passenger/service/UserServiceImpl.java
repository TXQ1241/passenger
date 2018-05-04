package org.passenger.service;

import java.util.List;

import org.passenger.pojo.User;
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

}
