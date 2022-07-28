package com.tang.springframework.beans.factory.config;

/**
 * 单例注册接口
 */
public interface SingletonBeanRegistry {

    /**
     * 定义一个获取单例对象的接口
     *
     * @param beanName 对象名
     * @return 单例对象
     */
    Object getSingleton(String beanName);

}
