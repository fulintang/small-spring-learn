package com.tang.springframework.beans.factory.support;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.config.BeanDefinition;

/**
 * 注入Bean实现类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 15:17
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 实现Bean的实例化操作，然后有参数构造对象如何处理？
     * 
     * @param beanName -
     * @param beanDefinition -
     * @return -
     * @throws BeansException -
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        super.addSingleton(beanName, bean);
        return bean;
    }
    
}
