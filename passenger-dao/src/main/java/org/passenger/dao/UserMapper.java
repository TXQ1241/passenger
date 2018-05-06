package org.passenger.dao;

import org.passenger.pojo.User;
import org.passenger.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userMapper")
public interface UserMapper {
	
	List<User> getUserList(UserVo userVo);

    int getUserCount(UserVo userVo);

	List<User> getUser(User user);

    int insert(User user);

    void deleteUserByIds(String [] ids);

}