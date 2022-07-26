package com.tang.springframework.beans.factory.config;

import com.tang.springframework.beans.PropertyValues;

/**
 * Bean定义
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 12:09
 */
public class BeanDefinition {

    private Class<?> beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public BeanDefinition setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
        return this;
    }

}
