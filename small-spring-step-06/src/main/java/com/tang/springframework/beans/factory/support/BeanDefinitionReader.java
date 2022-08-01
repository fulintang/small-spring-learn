package com.tang.springframework.beans.factory.support;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.core.io.Resource;
import com.tang.springframework.core.io.ResourceLoader;

/**
 * Bean定义读取接口
 * 这里需要注意 getRegistry()、getResourceLoader()，都是用于提供给后面三个方法的工具，加载和注册，
 * 这两个方法的实现会包装到抽象类中，以免污染具体的接口实现方法。
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/27 11:55
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
    
    void loadBeanDefinitions(String... location) throws BeansException;

}
