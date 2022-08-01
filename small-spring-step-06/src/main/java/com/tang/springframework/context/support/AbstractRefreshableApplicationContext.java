package com.tang.springframework.context.support;

import com.tang.springframework.beans.BeansException;
import com.tang.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.tang.springframework.beans.factory.support.DefaultListableBeanFactory;

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        /*if (beanFactory == null) {
            refreshBeanFactory();
        }*/
        return beanFactory;
    }

}
