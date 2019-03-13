package sbeam.action.user;

import sbeam.po.customer.Customer;
import sbeam.service.user.IUserService;

public class UserAction {
    private IUserService userService;
    private Customer loginUser;

    //用户登录
    public String login() {
        System.out.println("UserAction login");
        if (userService.login(loginUser)) {
            System.out.println("login success");
            return "loginSuccess";
        }
        System.out.println("login fail");
        return "loginFail";
    }

    //更新用户
    public String update() {
        System.out.println("user update");
        System.out.println(loginUser);
        if(userService.update(loginUser)) {
            System.out.println("update success");
            return "updateSuccess";
        }
        return "updateFail";
    }

    public String register() {
        System.out.println("user register");
        System.out.println(loginUser);
        if (userService.register(loginUser)) {
            System.out.println("register success");
            return "registerSuccess";
        }
        System.out.println("register fail");
        return "registerFail";
    }


    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public Customer getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(Customer loginUser) {
        this.loginUser = loginUser;
    }

}
