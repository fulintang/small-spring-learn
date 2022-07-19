package com.tang.springframework.beans.factory.config;

/**
 * Bean定义
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 12:09
 */
public class BeanDefinition {
    
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
    
}
