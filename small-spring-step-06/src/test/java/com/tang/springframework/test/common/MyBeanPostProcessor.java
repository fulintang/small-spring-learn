package com.tang.springframework.test.common;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.config.BeanPostProcessor;
import com.tang.springframework.test.bean.UserService;

public class MyBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：成都");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
    
}
