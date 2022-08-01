package com.tang.springframework.beans.factory;

import com.tang.springframework.beans.BeansException;

import java.util.Map;

/**
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their bean instances, rather than attempting bean lookup
 * by name one by one as requested by clients. BeanFactory implementations that
 * preload all their bean definitions (such as XML-base factories) may implement
 * this interface.
 * 译：
 * 扩充 {@link BeanFactory} 接口，扩充了得到所有Bean名称方法，不需要一个个的获取。
 * 预加载所有 bean 定义的 BeanFactory 实现（例如基于 XML 的工厂）可以实现此接口
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回Bean示例
     *
     * @param type 类class
     * @param <T>  待返回泛型
     * @return 名称加示例的Map
     * @throws BeansException 出错抛出Bean定义异常
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry
     * 译：
     * 返回注册表中的所有bean名称
     *
     * @return 注册表中的所有bean名称
     */
    String[] getBeanDefinitionNames();

}
