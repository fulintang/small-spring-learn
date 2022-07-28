package com.tang.springframework.beans.factory.support;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.config.BeanDefinition;
import com.tang.springframework.beans.factory.support.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK实例化类实现
 *
 * @author Tang
 * @since 2022-07-21
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {


    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException {
        Class<?> clazz = beanDefinition.getBeanClass();
        try {
            if (null != constructor) {
                return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }

}
