package com.tang.springframework.beans.factory.support.registory.impl;

import com.tang.springframework.beans.factory.support.registory.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例Bean注册获取实现类
 * 在 DefaultSingletonBeanRegistry 中主要实现 getSingleton 方法，同时实现了一个受保护的 addSingleton 方法，
 * 这个方法可以被继承此类的其他类调用。包括：AbstractBeanFactory 以及继承的 DefaultListableBeanFactory 调用
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 12:19
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    
    private final Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 这个方法可以被继承此类的其他类调用
     *
     * @param beanName        类名称
     * @param singletonObject 类
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
