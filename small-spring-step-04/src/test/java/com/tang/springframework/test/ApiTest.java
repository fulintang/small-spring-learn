package com.tang.springframework.test;

import com.tang.springframework.beans.PropertyValue;
import com.tang.springframework.beans.PropertyValues;
import com.tang.springframework.beans.factory.config.BeanDefinition;
import com.tang.springframework.beans.factory.config.BeanReference;
import com.tang.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.tang.springframework.test.bean.UserDao;
import com.tang.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 测试类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/26 10:14
 */
public class ApiTest {
    
    @Test
    public void test_BeanFactory() {
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        
        // 2.UserDao注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        
        // 3.UserService 设置属性【uId、userDao】
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "100001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        
        // 4.UserService注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        
        // 5.UserService获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
    
}
