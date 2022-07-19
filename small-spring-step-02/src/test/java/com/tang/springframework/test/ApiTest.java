package com.tang.springframework.test;

import com.tang.springframework.beans.factory.config.BeanDefinition;
import com.tang.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.tang.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 15:54
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {

        // 1.初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取Bean from singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();

    }

}
