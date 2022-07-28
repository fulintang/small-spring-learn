package com.tang.springframework.beans.factory.support;

import com.tang.springframework.beans.factory.config.BeanDefinition;
import com.tang.springframework.beans.BeansException;

public interface BeanDefinitionRegistry {

    /**
     * 想注册表中注册beanDefinition
     * 
     * @param beanName 类名称
     * @param beanDefinition bean实体类
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    
    /**
     * 判断是否包含指定名称的Bean定义
     * 
     * @param beanName Bean名称
     * @return 存在返回true，否则返回false
     */
    boolean containsBeanDefinition(String beanName);
    
}
