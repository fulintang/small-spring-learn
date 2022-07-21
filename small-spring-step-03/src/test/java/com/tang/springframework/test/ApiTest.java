package com.tang.springframework.test;

import com.tang.springframework.beans.factory.config.BeanDefinition;
import com.tang.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.tang.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactory() {

        // 1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService", "张三");
        userService.queryUserInfo();

    }
    
}
