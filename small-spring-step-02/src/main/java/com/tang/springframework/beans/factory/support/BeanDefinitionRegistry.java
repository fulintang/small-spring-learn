package com.tang.springframework.beans.factory.support;

import com.tang.springframework.beans.factory.config.BeanDefinition;

/**
 * 注册BeanDefinition接口
 */
public interface BeanDefinitionRegistry {

    /**
     * 想注册表中注册beanDefinition
     * 
     * @param beanName 类名称
     * @param beanDefinition bean实体类
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
    
}
