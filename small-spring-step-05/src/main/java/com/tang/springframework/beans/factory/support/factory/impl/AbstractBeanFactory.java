package com.tang.springframework.beans.factory.support.factory.impl;

import com.tang.springframework.beans.factory.ex.BeansException;
import com.tang.springframework.beans.factory.support.factory.BeanFactory;
import com.tang.springframework.beans.factory.config.BeanDefinition;
import com.tang.springframework.beans.factory.support.registory.impl.DefaultSingletonBeanRegistry;

/**
 * AbstractBeanFactory 首先继承了 DefaultSingletonBeanRegistry，也就具备了使用单例注册类方法。
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 12:08
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) {
        return this.doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return this.doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

}
