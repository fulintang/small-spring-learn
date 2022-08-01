package com.tang.springframework.beans.factory.config;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanPostProcessors接口实现类的postProcessBeforeInitialization方法
     *
     * @param existingBean 已存在的Bean
     * @param beanName     Bean名称
     * @return -
     * @throws BeansException 执行前置方法异常
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行BeanPostProcessors接口实现类的postProcessors
     *
     * @param existingBean 已存在的Bean
     * @param beanName     Bean名称
     * @return -
     * @throws BeansException 执行后置方法异常
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
