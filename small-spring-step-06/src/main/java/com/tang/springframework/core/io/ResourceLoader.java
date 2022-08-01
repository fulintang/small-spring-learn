package com.tang.springframework.core.io;

/**
 * 按照资源加载的不同方式，资源加载器可以把这些方式集中到统一的业务类下进行处理，
 * 外部用户只需要传递资源地址即可，简化使用。
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/26 17:56
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";
    
    Resource getResource(String location);
    
}
