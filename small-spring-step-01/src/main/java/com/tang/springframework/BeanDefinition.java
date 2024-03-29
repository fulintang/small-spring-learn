package com.tang.springframework;

/**
 * 用于定义Bean实例化信息，现在的实现是以一个Object存放对象
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/18 14:07
 */
public class BeanDefinition {
    
    /*
    目前的 Bean 定义中，只有一个 Object 用于存放 Bean 对象。如果感兴趣可以参考 Spring 源码中这个类的信息，名称都是一样的。
    不过在后面陆续的实现中会逐步完善 BeanDefinition 相关属性的填充，
    例如：SCOPE_SINGLETON、SCOPE_PROTOTYPE、ROLE_APPLICATION、ROLE_SUPPORT、ROLE_INFRASTRUCTURE 以及 Bean Class 信息。
     */
    
    private final Object bean;
    
    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
    
}
