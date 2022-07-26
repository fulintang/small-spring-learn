package com.tang.springframework.test.bean;

/**
 * 账户业务测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/26 10:11
 */
public class UserService {
    
    private String uId;
    
    private UserDao userDao;
    
    public void queryUserInfo() {
        System.out.println("查询用户信息 " + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
}
