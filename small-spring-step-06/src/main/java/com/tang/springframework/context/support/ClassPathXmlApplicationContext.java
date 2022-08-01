package com.tang.springframework.context.support;

/**
 * 通过构造函数注入文件位置，同时刷新上下文，
 * 对继承抽象类中方法的调用和提供了配置文件地址信息。
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configLocation) {
        this(new String[]{configLocation});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        super.refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
