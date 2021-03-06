package org.passenger.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.passenger.common.Constants;
import org.passenger.pojo.User;
import org.passenger.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login/")
public class LoginController {
    @Autowired
    @Qualifier("userService")
    IUserService userService;

    /**
     * 提交测试
     *
     * @return
     * @throws
     * @Description: 跳转到登录页面
     * @author admin
     * @Date 17:21 2018/2/23
     * @method handlerLogin
     * params
     **/
    @RequestMapping("loginHandler")
    public String loginHandler() {

        return "login";
    }

    /**
     *  @Description:
     *  @author admin
     *  @Date 2018/4/12
     *  @method executeLogin
     *  params  [User]用户对象，帐号，密码
     *  @return Map 用户登录信息
     *  @exception
     **/
    @RequestMapping("login")
    @ResponseBody
    public Map<String, String> executeLogin(HttpServletRequest request,@RequestBody User user) {
        //登录状态
        String status;
        //登录信息
        String message;
        Map<String, String> msgMap = new HashMap<String, String>();
        User userInfo = null;
        try{
            List<User> userList = userService.getUser(user);
            if(userList!=null && userList.size() > 0) {
                userInfo = userList.get(0);
            }
            if (userInfo != null) {
                if (user.getPassword().equals(userInfo.getPassword())){
                    status = Constants.AjaxStatus.AJAX_SUCCESS;
                    message = "登录成功";
                    //将用户信息放入session域中                    
                    request.getSession().setAttribute(Constants.CURRENT_USER, userInfo);
                    msgMap.put("userType", userInfo.getUserType());
                } else {
                    status = Constants.AjaxStatus.AJAX_FAIL;
                    message = "密码错误";
                }
            } else {
                status = Constants.AjaxStatus.AJAX_FAIL;
                message = "当前用户不存在";
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = Constants.AjaxStatus.AJAX_FAIL;
            message = "登录异常，请联系管理员";
        }

        msgMap.put("status",status);
        msgMap.put("msg",message);

        return msgMap;

    }

    /**
     *  @Description: 注销/退出
     *  @author admin
     *  @Date 2018/4/13
     *  @method logout
     *  params  [request]
     *  @return String 登录页面
     *  @exception
     **/
    @RequestMapping("logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        //将session中用户的登录信息设置为空
        request.getSession().setAttribute(Constants.CURRENT_USER,null);
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"
                +request.getServerPort()+path+"/login.html";
        try {
            response.sendRedirect(basePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  @Description: 跳转到主页
     *  @author admin
     *  @Date 2018/4/13
     *  @method goToIndex
     *  params  []
     *  @return String
     *  @exception
     **/
    @RequestMapping("home")
    public String goToIndex() {
        return "index";
    }
    
    @RequestMapping("loginStatus")
    @ResponseBody
    public Map<String, String> getLoginStatus (HttpServletRequest request) {
    	Map<String, String> msgMap = new HashMap<String, String>();
    	User user = (User) request.getSession().getAttribute(Constants.CURRENT_USER);
    	String userName = "";
    	if (user != null) {
    		userName = user.getUserName();
    	}
    	msgMap.put("userName", userName);
    	return msgMap;
    }
}
