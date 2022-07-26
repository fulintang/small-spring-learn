package com.tang.springframework.test.bean;

/**
 * 测试用Bean
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 15:53
 */
public class UserService {

    private final String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息" + name);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("").append(name);
        return stringBuilder.toString();
    }
}
