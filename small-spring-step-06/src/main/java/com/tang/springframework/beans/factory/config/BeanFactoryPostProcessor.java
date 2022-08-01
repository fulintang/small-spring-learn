package com.tang.springframework.beans.factory.config;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    /**
     * Allows for custom modification of an application context's bean definitions,
     * adapting the bean property values of the context's underlying bean factory.
     * 翻译：
     * 在所有的 BeanDefinition 加载完成后，实例化Bean对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory 工厂
     * @throws BeansException 修改 BeanDefinition 属性异常
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
