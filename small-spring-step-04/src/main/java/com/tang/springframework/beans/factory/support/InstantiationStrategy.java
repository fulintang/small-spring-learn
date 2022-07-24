package com.tang.springframework.beans.factory.support;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 */
public interface InstantiationStrategy {
    
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException;
    
}
