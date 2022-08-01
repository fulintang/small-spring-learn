package com.tang.springframework.beans.factory.config;

import com.tang.springframework.beans.BeansException;

/**
 * Factory hook that allows for custom modification of new bean instances,
 * e.g. checking for marker interfaces or wrapping them with proxies.
 * 提供了修改新实例化 Bean 对象的扩展点。
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象执行初始化方法之前，执行此方法
     *
     * @param bean     对象
     * @param beanName Bean名称
     * @return -
     * @throws BeansException 前置方法异常
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     *
     * @param bean     对象
     * @param beanName Bean名称
     * @return -
     * @throws BeansException 后置方法异常
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;


}
