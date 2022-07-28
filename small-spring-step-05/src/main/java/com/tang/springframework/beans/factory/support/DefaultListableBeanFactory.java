package com.tang.springframework.beans.factory.support;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.config.BeanDefinition;
import com.tang.springframework.beans.factory.support.BeanDefinitionRegistry;
import com.tang.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心实现类
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/19 15:26
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 注册Bean定义
     *
     * @param beanName       类名称
     * @param beanDefinition bean实体类
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 获取Bean定义
     *
     * @param beanName Bean名称
     * @return Bean
     * @throws BeansException 获取异常
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null)
            throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

}
