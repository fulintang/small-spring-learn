package com.tang.springframework.beans.factory.support;

import com.tang.springframework.core.io.ResourceLoader;
import com.tang.springframework.core.io.impl.DefaultResourceLoader;

/**
 * Bean定义抽象类实现
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/27 12:05
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private final BeanDefinitionRegistry registry;

    private final ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
