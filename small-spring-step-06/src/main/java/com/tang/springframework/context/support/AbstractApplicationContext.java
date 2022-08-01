package com.tang.springframework.context.support;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.tang.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.tang.springframework.beans.factory.config.BeanPostProcessor;
import com.tang.springframework.context.ConfigurableApplicationContext;
import com.tang.springframework.core.io.impl.DefaultResourceLoader;

import java.util.Map;

/**
 * 这个抽象类装饰了ConfigurableApplicationContext继承的Factory的方法，装饰者模式
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        // 1.创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();

        // 2.获取BeansFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3.在Bean实例化之前，执行BeanFactoryPostProcessor（Invoke factory processors registered as beans in the context.）
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4.BeanPostProcessors需要提前于其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);

        // 5.提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory();

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 调用BeanFactory后处理器
     *
     * @param beanFactory Bean工厂
     */
    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        // 找出所有实现类 BeanFactoryPostProcessor 的所有类
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap
                = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        // 然后将所有的类都执行类定义的方法，这就就可以实现用户自定义的方法！这些人真是聪明哦
        if (beanFactoryPostProcessorMap != null) {
            for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
                beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
            }
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory
                .getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            // 这个方法的引用简直让人眼前一亮，居然还有这种用法牛逼了
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
