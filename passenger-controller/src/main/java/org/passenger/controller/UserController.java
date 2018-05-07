package org.passenger.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.passenger.common.Constants;
import org.passenger.pojo.User;
import org.passenger.service.IUserService;
import org.passenger.utils.StringUtils;
import org.passenger.vo.DataVo;
import org.passenger.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	IUserService userService;
	
    @RequestMapping("view")
    public String toUserList(String userType){
        String page = "admin";
        if (Constants.UserConstants.STATION.equals(userType)) {
        	page = "station";
        } else if (Constants.UserConstants.CARTRIP.equals(userType)){
            page = "carTrip";
        }
        return page;
    }
	
	@RequestMapping("getUserList")
	@ResponseBody
	public DataVo getUserList(UserVo userVo) {
        DataVo dataVo = new DataVo();
        Integer pageNum = userVo.getPageNum();
        //设置查询开始的条数(就是从哪条开始查询)
        if(pageNum != null) {
            userVo.setPageNum((pageNum-1)*userVo.getPageSize());
        }
        try {
            List<User> userList = userService.getUsers(userVo);
            dataVo.setDatalist(userList);
            dataVo.setCode(Constants.DataCode.SUCCESS);
            dataVo.setMsg("数据获取成功");
            if (userList != null) {
                dataVo.setCount(userService.getUserCount(userVo));
            } else {
                dataVo.setCount(Constants.ZERO_NUM);
            }
        } catch (Exception e) {
            dataVo.setCode(Constants.DataCode.FAIL);
            dataVo.setMsg("数据获取失败");
            e.printStackTrace();
        }
        return dataVo;
	}
	
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

	@RequestMapping("save")
    @ResponseBody
    public Map<String, String> saveUser(@RequestBody User user){

        Map<String, String> msgMap = new HashMap<String, String>();
        try {
            if (StringUtils.isNotBlank(user.getId())) {
                userService.update(user);
            } else {
                user.setId(StringUtils.getUUID());
                userService.save(user);
            }
            msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"保存车站信息成功");
        } catch (Exception e) {
            msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"保存车站信息失败");
        }
        return msgMap;

    }
	
    /**
     *  @Description: 删除用户
     *  @author lxp
     *  @method deleteUsers
     *  params  [user] 用户对象
     *  @return 操作信息
     *  @exception
     **/
    @RequestMapping("delete")
    @ResponseBody
    public Map<String, String> deleteUsers(@RequestBody UserVo userVo) {
        Map<String, String> msgMap = new HashMap<String, String>();
        String [] userIds = null;
        if(StringUtils.isNotBlank(userVo.getIds())){
            userIds = userVo.getIds().split(",");
        }
        try {
            if(userIds != null && userIds.length > 0) {
                userService.deleteUsersByIds(userIds);
            }
            msgMap.put(Constants.AjaxStatus.AJAX_SUCCESS,"删除用户信息成功");
        } catch (Exception e) {
            msgMap.put(Constants.AjaxStatus.AJAX_FAIL,"删除用户信息失败");
        }
        return msgMap;
    }
	
}
