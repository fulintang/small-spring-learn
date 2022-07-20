package com.tang.springframework.test;

import com.tang.springframework.BeanDefinition;
import com.tang.springframework.BeanFactory;
import com.tang.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 业务测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/18 14:08
 */
public class ApiTest {
    
    @Test
    public void test_BeanFactory() {
        // 1.初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        
        // 2.注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        
        // 3.获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
    
}
