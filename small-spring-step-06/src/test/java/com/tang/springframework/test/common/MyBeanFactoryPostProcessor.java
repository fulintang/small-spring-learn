package com.tang.springframework.test.common;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.PropertyValue;
import com.tang.springframework.beans.PropertyValues;
import com.tang.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.tang.springframework.beans.factory.config.BeanDefinition;
import com.tang.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：航天科工"));
    }

}
