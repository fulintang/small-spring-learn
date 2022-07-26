package com.tang.springframework.beans.factory.config;

public class BeanReference {

    // 属性类对象，记录被注入的类
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return this.beanName;
    }

}
